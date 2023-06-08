import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world for selecting the game mode.
 * 
 * @author Rafael Haruo Nakagawa Hoshino
 * @version 1.0
 */
public class GameMode extends World
{
    EndlessModeButton endlessbutton = new EndlessModeButton() ;
    NormalMode normalButton = new NormalMode() ;
    ButtonBack buttonBack = new ButtonBack () ;
    
    /**
     * Creates a new GameMode world.
     * Sets the background image to "space.png".
     * Adds buttons for the normal and endless modes, as well as a button to go back.
     */
    public GameMode()
    {    
        super(1000, 625, 1); 
        GreenfootImage img = new GreenfootImage("space.png");
        setBackground(img);
        
        addObject(normalButton, 297, 300);
        addObject(endlessbutton, 715, 300);
        addObject(buttonBack, 500, 520);
    }
}

