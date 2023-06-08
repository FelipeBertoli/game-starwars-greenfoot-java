import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button that, when clicked, starts the Normal Mode.
 * 
 * author Rafael Haruo Nakagawa Hoshino
 * version 1.0
 */
public class NormalMode extends Actor
{
    /**
     * Sets the image of the button to "normalMode.png" and checks for mouse clicks.
     * If the button is clicked, sets the world to a new instance of EmperorBattle.
     */
    public void act()
    {
        GreenfootImage normalMode = new GreenfootImage("normalmode.png");
        setImage(normalMode);

        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new EmperorBattle()); 
        }
    }
}
