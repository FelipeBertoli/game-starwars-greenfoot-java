import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *Palpatine is an actor class that represents the character Emperor Palpatine of Star Wars
 *Palpatine has the ability to charge up and unleash a powerful force lightning attack.
 *
 *@author Felipe Bertoli Oliveira
 *@version 1.0
 */
public class Palpatine extends Actor
{
    GreenfootImage stand = new GreenfootImage("palpatine.png");
    GreenfootImage attacking = new GreenfootImage("palpattack.png");
    GreenfootImage upAttacking = new GreenfootImage("palpattackup.png");
    GreenfootImage charging = new GreenfootImage("palpower.png");

    private int life;
    private int shotDelay; 
    private int shotDelayCounter; 
    private int chargingTime = 60;
    private boolean isCharged;
    private int chance = 0;
    private int attackTime = 80;
    private boolean isAttacking = false;
    private boolean isAbove = false;

    /**
     * Constructs a new instance of Palpatine with a specified life amount.
     * Also scales the images to a larger size. 
     * 
     * @param life The initial amount of life for Palpatine.
     */
    public Palpatine(int life){
        this.life = life;

        stand.scale(stand.getWidth()+150, stand.getHeight()+150);
        attacking.scale(attacking.getWidth()+150, attacking.getHeight()+150);
        upAttacking.scale(upAttacking.getWidth()+150, upAttacking.getHeight()+150);
        charging.scale(charging.getWidth()+150, charging.getHeight()+150);

        setImage(stand);  

        shotDelay = Greenfoot.getRandomNumber(200) + 50; 
        shotDelayCounter = 0; 

    }

    /**
     * Calls charging() and handles the animation of Palpatine's attack. 
     */
    public void act()
    {
        charging();

        if(isAttacking) {
            if (attackTime > 0) {
                attackTime--;
            }  else {  
                setImage(stand); 
                setLocation(getX(), 433);
                isAttacking = false;
                attackTime = 80;
                isAbove = false;
            }
        }
    }

    /**
     * Gets the current life amount of Palpatine.
     * 
     * @return The current life amount of Palpatine.
     */
    public int getLife(){
        return life;
    }

    /**
     * Decreases Palpatine's life by a specified amount. 
     * 
     * @param damage The amount of damage to subtract from Palpatine's life.
     */
    public void takeDamage(int damage) {
        life -= damage;

        if (life == 0) {
            getWorld().removeObject(this);

        } 
    }

    /**
     * Handles the animation of Palpatine's attack. 
     */

    public void animateAttack(){

        if (isAttacking) {
            if (isAbove == false) {
                setImage(attacking);
            } else if (isAbove == true) {
                setImage(upAttacking);
            }
        }
    }

    /**
     * Handles the charging mechanic of Palpatine's attack. 
     */
    public void charging(){

        if (shotDelayCounter > 0) { 
            shotDelayCounter--;
        } else {
            chance = Greenfoot.getRandomNumber(200);
            if (chance < 2) {
                isCharged = true;
                setImage(charging); 
            }
        }

        if (isCharged) {
            attack();
        } 
    }

    /**
     * Performs an attack with Force Lightning. 
     * If the charging time is greater than 0, decrease it by 1. 
     * If the charging time reaches 0, check if Palpatine intersects with Luke. 
     * If there is no intersection, create four instances of ForceLightning objects 
     * and add them to the world. Otherwise, move Palpatine to the top of the screen, 
     * change the boolean variable isAbove to true, create a ForceLightning object 
     * and add it to the world. 
     * Then, set the shotDelayCounter to shotDelay, 
     * set the chargingTime to 50 and set isCharged to false. 
     */
    public void attack(){
        Luke luke = (Luke) getOneIntersectingObject(Luke.class);
        if (chargingTime > 0) {
            chargingTime--;
            if (chargingTime == 0) {
                if(luke == null) {
                    isAttacking = true;
                    animateAttack();

                    ForceLightning lightside1 = new ForceLightning(-5, 15);
                    getWorld().addObject(lightside1, 332, 320);

                    ForceLightning lightside2 = new ForceLightning(5, -15);
                    getWorld().addObject(lightside2, 658, 320);

                    ForceLightning lightdiag1 = new ForceLightning(-5, -40);
                    getWorld().addObject(lightdiag1, 332, 391);

                    ForceLightning lightdiag2 = new ForceLightning(5, 40);
                    getWorld().addObject(lightdiag2, 658, 391);

                    shotDelayCounter = shotDelay; 
                    chargingTime = 50;
                    isCharged = false;

                }

                if (luke != null) {
                    setLocation(getX(), 113); 
                    isAbove = true;
                    isAttacking = true;
                    animateAttack();

                    ForceLightning lightdown = new ForceLightning(-4, -90);
                    getWorld().addObject(lightdown, 507, 206);

                    shotDelayCounter = shotDelay; 
                    chargingTime = 50;
                    isCharged = false;
                }
            }   
        }
    }
}

