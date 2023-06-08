import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button that, when clicked, returns the user to the main screen.
 * 
 * author Rafael Haruo Nakagawa Hoshino
 * version 1.0
 */
public class ButtonBack extends Actor
{
    /**
     * Sets the image of the button to "buttonback.png" and checks for mouse clicks.
     * If the button is clicked, sets the world to a new instance of MainScreen.
     */
    public void act()
    {
        GreenfootImage playButton = new GreenfootImage("buttonback.png");
        setImage(playButton);

        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new MainScreen()); 
        }
    }
}
