import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A screen that displays the game controls.
 * 
 * @author Rafael Haruo Nakagawa Hoshino
 * @version 1.0
 */
public class ControlScreen extends World
{
    ButtonBack buttonBack = new ButtonBack () ;

    /**
     * Creates a new ControlScreen world.
     * Sets the background image to "controlscreen.png".
     * Adds a button for returning to the main menu.
     */
    public ControlScreen()
    {    
        super(1000, 626, 1); 
        GreenfootImage img = new GreenfootImage("controlscreen.png");
        setBackground(img);
        addObject(buttonBack , 500 ,585);
    }
}
