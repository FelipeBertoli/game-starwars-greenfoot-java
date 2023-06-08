import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button that, when clicked, displays the control screen.
 * 
 * author Rafael Haruo Nakagawa Hoshino
 * version 1.0
 */
public class ButtonControl extends Actor
{
    /**
     * Sets the image of the button to "buttoncontrols.png" and checks for mouse clicks.
     * If the button is clicked, sets the world to a new instance of ControlScreen.
     */
    public void act()
    {
        GreenfootImage controls = new GreenfootImage("buttoncontrols.png");
        setImage(controls);  
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new ControlScreen()); 
        }
    }
}
