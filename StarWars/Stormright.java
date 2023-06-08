import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Stormleft class represents a Stormtrooper that moves left
 * and shoots when it reaches its destination.
 * This class extends the Stormtrooper class and overrides the walk() method to implement its own movement behavior.
 * 
 * @author Felipe Bertoli Oliveira
 * @version 1.0
 */
public class Stormright extends Stormtrooper
{
        /**
     * The class constructor sets the Stormtrooper's initial images, scales them, and sets its initial position and direction values.
     * */
    public Stormright(int gameMode) {
        super(gameMode);
        stand = new GreenfootImage("stormstand.png");
        walk = new GreenfootImage("stormwalk.png");
        damaged = new GreenfootImage("stormdano.png");
        
        stand.scale(stand.getWidth()+140, stand.getHeight()+140);
        walk.scale(walk.getWidth()+140, walk.getHeight()+140);
        damaged.scale(damaged.getWidth()+140, damaged.getHeight()+140);
        setImage(walk);
        
        destination = 914;
        direction = -3;
        position = 999;
        fireDirection = -8;
        firePosition = 839;
    }
    
      /**
     * The walk() method moves the Stormtrooper to the left until it reaches its destination. When it reaches the destination,
     * it changes the Stormtrooper's image to its standing position and sets the readyToShoot flag to true.
     * If readyToShoot is true, the Stormtrooper calls the fire() method to shoot.
     */
    public void walk() {
        if(getX() > destination) {
            move(direction);

            if(getX() <= destination){
                setImage(stand);   
                readyToShoot = true;

            }
        }

        if(readyToShoot) {
            fire();
        }
    }
}
