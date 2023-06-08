import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Stormtrooper class represents the famous Star Wars Empire soldiers
 * in a game that can walk, shoot, take damage, and die. 
 * The Stormtrooper is designed to be used in two different game modes: 
 * In mode 1 - BossBattle -, the Stormtrooper can only respawn a certain number of times 
 * before being removed from the world permanently. 
 * In mode 2 - Endless -, the Stormtrooper can respawn an unlimited number of times.
 * *
 * @author Felipe Bertoli Oliveira
 * @version 1.0
 */
public class Stormtrooper extends Actor
{
    /**The image of the Stormtrooper walking.*/
    protected GreenfootImage walk; 
    /** The image of the Stormtrooper standing.*/ 
    protected GreenfootImage stand;
    /**The image of the Stormtrooper when damaged.*/
    protected GreenfootImage damaged;

    /**The game mode the Stormtrooper is in.*/
    protected int gameMode;
    /**The amount of life the Stormtrooper has.*/
    protected int life = 30;
    /**The amount of time the Stormtrooper has been dead.*/
    protected int dead = 0;
    /**The amount of time the Stormtrooper is damaged.*/
    protected int damageTime;
    /**The delay between shots for the Stormtrooper.*/
    protected int shotDelay; 
    /**The current shot delay counter for the Stormtrooper.*/
    protected int shotDelayCounter; 
    /**Indicates whether the Stormtrooper is ready to shoot.*/
    protected boolean readyToShoot = false; 
    /**The amount of time the Stormtrooper has been dead for.*/
    protected int deadTime = 0;
    /**Indicates whether the Stormtrooper is dead.*/
    protected boolean isDead = false;
    /**The number of times the Stormtrooper has died.*/
    protected int deathCount = 0;
    /**The destination the Stormtrooper is walking towards.*/
    protected int destination;
    /**The direction the Stormtrooper is walking in.*/
    protected int direction;
    /**The position the Stormtrooper is in.*/
    protected int position;
    /**The direction the Stormtrooper is shooting in.*/
    protected int fireDirection;
    /**The position the Stormtrooper is shooting from.*/
    protected int firePosition;

    /**
     *Constructor for the Stormtrooper class. 
     *Iniatiate the shotDelay to Stormtrooper shoots in random times
     *@param gameMode The game mode to be played (1 or 2).
     */
    public Stormtrooper (int gameMode) {
        this.gameMode = gameMode;
        setImage(walk);
        shotDelay = Greenfoot.getRandomNumber(200) + 100; 
        shotDelayCounter = 0; 
    }

    /**
     *Act method for the Stormtrooper class.
     *If the Stormtrooper is not dead, it calls the walk() method. 
     *If the Stormtrooper is dead, it decrements the deadTime variable 
     *and calls the respawn() method if the deadTime has reached 0.
     */
    public void act()
    {
        if (damageTime > 0) {
            damageTime--;
            if (damageTime == 0) {
                setImage(stand);
            }
        }

        if(!isDead) {
            walk();

        } else { 
            deadTime--;
            if (deadTime <= 0) {
                if(gameMode == 1) { 
                    respawnQuantity(5);
                }
                
                if(gameMode == 2) {
                    respawn();
                }
            }
        }
    }

    /**
    Getter method for the deathCount attribute.
    @return The number of times the Stormtrooper has died.
     */
    public int getSpawn(){
        return deathCount;
    }

    /**

    Method for the Stormtrooper to walk in a certain direction.
    The rest of the code is overwrited by this class's sons (Stormleft and Stormright).
     */
    public void walk(){
    }

    /**
     *Fires a shot if the shot delay counter has expired.
     *Uses a random number generator to determine if a shot should be fired.
     *Creates a new Shoot object with the specified fire direction and adds it to the world.
     *Sets the shot delay counter to the shot delay.
     *Removes the shot object from the world if the actor is dead.
     */
    public void fire(){
        if (shotDelayCounter > 0) { 
            shotDelayCounter--;
        } else {
            int chance = Greenfoot.getRandomNumber(200);
            if (chance < 2) { 
                Shoot shoot = new Shoot(fireDirection);
                shoot.setRotation(getRotation());
                getWorld().addObject(shoot, firePosition, 480);
                shotDelayCounter = shotDelay; 

                if(isDead){
                    getWorld().removeObject(shoot);
                }
            }
        }

    }

    /**
     *Reduces the actor's life by the specified damage amount and sets 
     *the image to the damaged state.
     *Sets the damage time to 10.
     *Calls the die() method if the actor's life is less than or equal to 0.
     *@param damage the amount of damage to take
     */
    public void takeDamage(int damage) {
        life -= damage;
        setImage(damaged);
        damageTime = 10;

        if (life <= 0) {
            die();
        }
    }

    /**

     *Sets the actor's isDead flag to true, increments the deathCount by 1, 
     *and sets the location to (-100,-100).
     *Sets the image's transparency to 0.
     *Sets the deadTime to 500 if the gameMode is 1 and 150 if the gameMode is 2.
     */

    public void die(){
        isDead = true;
        deathCount += 1;
        setLocation(-100, -100); 
        getImage().setTransparency(0);

        if(gameMode == 1) { 
            deadTime = 500;
        }

        else if(gameMode == 2) {
            deadTime = 250;
        }
    }

    /**
     *Resets the actor's life to 30, sets the isDead flag to false, 
     *sets the location to (position, 493),
     *adds the actor to the world at the specified position and 
     *sets the image to the walk image.
     *Sets the image's transparency to 255 and the damaged image's transparency to 255.
     */
    public void respawn(){
        life = 30;
        isDead = false;
        setLocation(position, 493);
        getWorld().addObject(this, position, 493);
        setImage(walk);
        getImage().setTransparency(255);
        damaged.setTransparency(255);
    }

    /**
     * Recursively respawns the Stormtrooper a specified number of times.
     * @param quantity The number of times the Stormtrooper will be respawned.
     */
    public void respawnQuantity(int quantity){
        if (quantity == 0) {
            return;
        } else {
            respawn();
            respawnQuantity(quantity - 1);
        }

    }
}
