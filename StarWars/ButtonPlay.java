import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button that, when clicked, starts the game mode.
 *  
 * author Rafael Haruo Nakagawa Hoshino
 * version 1.0
 */
public class ButtonPlay extends Actor
{
    /**
     * Sets the image of the button to "buttonplay.png" and checks for mouse clicks.
     * If the button is clicked, sets the world to a new instance of GameMode.
     */
    public void act()
    {
        GreenfootImage playButton = new GreenfootImage("buttonplay.png");
        setImage(playButton);

        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new GameMode()); 
        }
    }
}
