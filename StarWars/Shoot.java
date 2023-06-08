import greenfoot.*;  

/**
 *This class it's called everytime that Stormtroopers actors fire.
 *
 * @author Felipe Bertoli Oliveira
 * @version 1.0
 */
public class Shoot extends Actor
{
    private GreenfootImage bullet =  new GreenfootImage("bullet.png");        
    private GreenfootImage bulletReady = new GreenfootImage("bulletready.png");
    private int timer = 30; 
    private int damage = 10;
    private int direction;
    private boolean readyToMove = false; 
    
    /**
     *Constructs a new Shoot object with the given direction and resizes the images
     *@param direction The direction the bullet will travel.
     */
    public Shoot(int direction){
        this.direction = direction;

        bullet.scale(bullet.getWidth()/15, bullet.getHeight()/15);
        bulletReady.scale(bulletReady.getWidth()/15, bulletReady.getHeight()/15);

        setImage(bulletReady);
    }

    /**
     * Act method for the Shoot class. The bullet will countdown a timer before being fired.
     * Once fired, it will travel in the specified direction and damage any enemies it comes in contact with.
     */
    public void act() { 

        if (timer > 0) {
            timer--;
            if (timer == 0) {
                setImage(bullet);
                readyToMove = true;
            }
        }

        if (readyToMove) { 
            travel();
            fire();
        }

    }

    /**
     * Method that moves the bullet in the specified direction.
     */
    public void travel(){
        move(direction);
    }

    /**
     * Inflicts damage on any enemies the bullet comes in contact with. Can hit the player, also other Stormtroopers
     * Removes the bullet object from the world if it reaches the edge of the screen.
     */
    public void fire(){
        Luke luke = (Luke) getOneIntersectingObject(Luke.class);
        Stormright stormright = (Stormright ) getOneIntersectingObject(Stormright.class);
        Stormleft stormleft = (Stormleft) getOneIntersectingObject(Stormleft.class);

        if(isAtEdge()) {
            getWorld().removeObject(this);      
        }

        if (luke != null) {
            getWorld().removeObject(this);
            luke.takeDamage(damage);
        }

        if (direction == 8) {
            if (stormright != null) {
                getWorld().removeObject(this);
                stormright.takeDamage(damage);
            }
        }

        if (direction == -8) {
            if (stormleft != null) {
                getWorld().removeObject(this);
                stormleft.takeDamage(damage);
            }
        }
    }
}
