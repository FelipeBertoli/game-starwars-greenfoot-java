import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *The ForceLightning class represents a lightning bolt projectile that can be fired by 
 *actor Palpatine The lightning bolt can be fired in three different directions and 
 *can cause different amounts of damage depending on its rotation, 
 * when is collised with actor Luke.
 *  *@author Felipe Bertoli Oliveira
 *@version 1.0
 */
public class ForceLightning extends Actor
{
    GreenfootImage lightning = new GreenfootImage("lightningside.png");
    GreenfootImage lightningDown = new GreenfootImage("lightningdown.png");
    Luke luke;

    private boolean isHit = false;
    private int direction;
    private int damage;

    /**
     * Constructs a new ForceLightning object with a specified direction and rotation.
     * The image of the lightning bolt is scaled based on its direction.
     * The amount of damage the lightning bolt causes is determined by its rotation.
     * 
     * @param direction the direction of the lightning bolt (either 1 or -1)
     * @param rotation the rotation of the lightning bolt in degrees (positive or negative)
     */
    public ForceLightning(int direction, int rotation){
        this.direction = direction;
        setRotation(rotation);    

        lightning.scale(lightning.getWidth()*3, lightning.getHeight()*3);
        lightningDown.scale(lightningDown.getWidth()*2 + 10, lightningDown.getHeight()*2 + 10);

        if (rotation == 15 || rotation == -40) {
            setImage(lightning);
            damage = 20;
        }
        else if(rotation == -15 || rotation == 40) {
            lightning.mirrorHorizontally();
            setImage(lightning);
            damage = 20;
        } 
        else if(rotation == -90) {
            setImage(lightningDown);
            damage = 40;
        }

    }

    /**
     * Calls the movement method.
     */
    public void act()
    {
        movement();
    }

    /**
     * Returns whether or not the lightning bolt has hit an object.
     * 
     * @return true if the lightning bolt has hit an object, false otherwise
     */
    public boolean getHit(){
        if(isHit == true) {
            return true;
        }

        return false;
    }

    /**
     * Moves the lightning bolt in its specified direction.
     * If the lightning bolt reaches the edge of the world, it is removed.
     * If the lightning bolt intersects with the character Luke, the lightning bolt is removed and the character takes damage.
     */

    public void movement() {
        move(direction);   

        luke = (Luke) getOneIntersectingObject(Luke.class);

        if(isAtEdge()) {
            getWorld().removeObject(this); 
            isHit = true;
        }

        if (luke != null) {
            getWorld().removeObject(this);
            luke.takeDamage(damage);
            isHit = true;
        }
    }
}
