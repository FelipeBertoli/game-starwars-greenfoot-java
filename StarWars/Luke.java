import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Luke is an actor class that represents the character Luke Skywalker from Star Wars.
 * Actor class controlled by the player by mouse and keyboard.
 * Contains methods of walking, jumping, attacking, defending, 
 * taking damage and interacting with other actors.
 * 
 * @Felipe Bertoli Oliveira
 * @version 1.0
 */

public class Luke extends Actor
{   
    private GreenfootImage stand = new GreenfootImage("lukestand.png"); 
    private GreenfootImage rightRun = new GreenfootImage("lukeright.png");
    private GreenfootImage leftRun = new GreenfootImage("lukeleft.png");
    private GreenfootImage rightAttack = new GreenfootImage("lukeattack.png");
    private GreenfootImage leftAttack = new GreenfootImage("lukeattackleft.png");
    private GreenfootImage rightDefense = new GreenfootImage("lukedefendright.png");
    private GreenfootImage leftDefense = new GreenfootImage("lukedefendleft.png");
    private GreenfootImage attackImage; 

    private int life;
    private int jumpSpeed;
    private int damageAmount = 10;
    private int waitTime = 60; 
    private int delayTime = 10;
    private int attackCounter = 0;
    private int attackTime = 0;
    private boolean isAttacking = false;
    private boolean isDefending = false;

    /**
     * Creates the character with an initial life and resizes the stored images
     * @param life the number of life points the actor will have
     */

    public Luke(int life) {
        this.life = life; 

        stand.scale(stand.getWidth()+120, stand.getHeight()+140);
        rightRun.scale(rightRun.getWidth()+180, rightRun.getHeight()+140);
        leftRun.scale(leftRun.getWidth()+180, leftRun.getHeight()+140);
        rightAttack.scale(rightAttack.getWidth()+180, rightAttack.getHeight()+140);
        leftAttack.scale(leftAttack.getWidth()+180, leftAttack.getHeight()+140);
        rightDefense.scale(rightDefense.getWidth()+120, rightDefense.getHeight()+180);
        leftDefense.scale(leftDefense.getWidth()+120, leftDefense.getHeight()+180);

        setImage(stand);

    }

    /**
     * Contains all functions and methods that the actor needs to perform.
     */
    public void act()
    {
        checkTurn();
        checkMove();
        jump();
        attack();
        defend();
        animateAttack(attackImage);

    }

    /**
     * Get the actor's life points
     * @return the life points
     */
    public int getLife(){
        return life;
    }

    /**
     * Checks if the "a" or "d" key is being pressed.
     * @return true if the "a" or "d" key is being pressed, false otherwise.
     */
    public static boolean checkTurn(){
        if(Greenfoot.isKeyDown("a") || (Greenfoot.isKeyDown("d")))
        {
            return true;

        } else {
            return false;
        }

    }

    /**
     * Checks the direction keys pressed and moves the character accordingly.
     * If "a" or "d" key is being pressed, Luke will move left or right respectively.
     * If no direction keys are pressed, Luke will remain static.
     */

    public void checkMove()
    {
        int walk = 0; 
        if((checkTurn()== true)) {
            while (walk == 0) {
                if(Greenfoot.isKeyDown("a"))
                {
                    move(-7);
                    setImage(leftRun);
                    walk += 1;

                }

                if(Greenfoot.isKeyDown("d")){
                    setImage(rightRun);
                    move(7);
                    walk += 1;

                }
            }
        }
        else if (checkTurn()== false) {
            setImage(stand);
        }

    }

    /**
     * Allows Luke to jump. Will only jump if it is on the ground level.
     * The jump is executed when the "space" key is pressed.
     */
    public void jump(){
        int groundLevel = 500;
        boolean onGround = (getY() == groundLevel);
        if (!onGround)
        {
            jumpSpeed++; 
            setLocation(getX(), getY()+ jumpSpeed); 
            if (getY()>=groundLevel) 
            {
                setLocation(getX(), groundLevel); 
                Greenfoot.getKey(); 
            }
        }
        else 
        {
            if ("space".equals(Greenfoot.getKey()))
            {
                jumpSpeed = -24;
                setLocation(getX(), getY()+ jumpSpeed); 
            }
        }
    }

    /**
     * Lukes performs an powerful lighsaber attack when the mouse is clicked. The attack is executed when the left mouse button is clicked.
     * The attack inflicts damage in Stormtroopers or Palpatine in the hitbox of the attack.
     * The direction of the attack image is determined based on the position of the mouse;.
     */
    private void attack() {
        attackCounter++;
        MouseInfo mi = Greenfoot.getMouseInfo();

        if (mi != null && attackCounter >= waitTime) {
            int buttonNumber = mi.getButton();
            Stormright stormright = (Stormright ) getOneIntersectingObject(Stormright .class);
            Stormleft stormleft = (Stormleft) getOneIntersectingObject(Stormleft .class);
            Palpatine palpatine = (Palpatine) getOneIntersectingObject(Palpatine.class);

            if (buttonNumber == 1)
            {
                if (stormright != null) {
                    stormright.takeDamage(damageAmount);
                }

                if (stormleft != null) {
                    stormleft.takeDamage(damageAmount);
                }

                if (palpatine != null) {
                    palpatine.takeDamage(damageAmount);
                } 

                if (Greenfoot.getMouseInfo() != null) {
                    int mouseX = Greenfoot.getMouseInfo().getX();
                    int characterX = getX();
                    if (mouseX > characterX) {
                        attackImage = rightAttack;
                    } else {
                        attackImage = leftAttack;
                    }

                    isAttacking = true;
                    attackTime = 0;
                }
            }
        }
    }

    /**
     * Lukes initiates a defensive stance with his lightsaber when the 'e' key is pressed. While in defensive stance, Luke's image changes
     * to a defensive posture and the object becomes invulnerable to damage. The direction of the defensive image is
     * determined based on the position of the mouse.
     */
    private void defend(){
        if(Greenfoot.isKeyDown("e")){
            isDefending = true;
            if (Greenfoot.getMouseInfo() != null) {
                int mouseX = Greenfoot.getMouseInfo().getX();
                int characterX = getX();
                if (mouseX > characterX) {
                    setImage(rightDefense);
                } else {
                    setImage(leftDefense);
                }
            }
        } 

        else {
            isDefending = false;
        }
    }

    /**
     * Changes the image of Luke to the specified attack image and animates his lightsaber attack. 
     * The attack animation lasts for 10 frames before returning the image to the standing posture.  
     * 
     * @param image the attack image to display during the attack animation
     */
    private void animateAttack(GreenfootImage image)
    {
        if (isAttacking) {
            setImage(image);
            attackCounter = 0;
            if (attackTime >= 10) {
                setImage(stand);
                isAttacking = false;

            }
            attackTime++; 
        }
    }

    /**
     * Reduces the life of the object by the specified amount of damage. If the object is not defending, 
     * the life is reduced by the amount of damage. If the life of the object is less than or equal to zero,
     * the object is removed from the world.
     * 
     * @param damage the amount of damage to be inflicted on the object
     */
    public void takeDamage(int damage) {
        if(isDefending == false) {
            life -= damage;

            if (life <= 0) {
                getWorld().removeObject(this);
            }
        }
    }
    
}
