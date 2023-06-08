import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button that, when clicked, starts the Endless mode.
 * 
 * author Rafael Haruo Nakagawa Hoshino
 * version 1.0
 */
public class EndlessModeButton extends Actor
{

    /**
     * Sets the image of the button to "ModoInfinito.png" and checks for mouse clicks.
     * If the button is clicked, sets the world to a new instance of Endless Mode.
     */
    public void act()
    {
        GreenfootImage endlessMode = new GreenfootImage("endlessmode.png");
        setImage(endlessMode);  
        
        if(Greenfoot.mouseClicked(this)){
           Greenfoot.setWorld(new Endless()); 
        }
    }
}
