import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main menu screen for the game.
 * 
 * @author Rafael Haruo Nakagawa Hoshino
 * @version 1.0
 */
public class MainScreen extends World
{
    private ButtonPlay play = new ButtonPlay();
    private ButtonControl control = new ButtonControl();

    /**
     * Creates a new MainScreen world.
     * Sets the background image to "LogoStarWars.png".
     * Adds buttons for starting the game and accessing the controls.
     */
    public MainScreen()
    {    
        super(1000, 626, 1); 

        GreenfootImage img = new GreenfootImage("LogoStarWars.png");
        setBackground(img);
        addObject(play, 368 , 525);
        addObject(control, 635, 520);
    }
}
