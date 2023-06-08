import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * That class sets the image icon for actor Luke
 * 
 * @author Felipe Bertoli Oliveira
 * @version 1.0
 */
public class Icon extends Actor
{
    /**
     * Constructs a new Icon object with an image of the character Luke's icon.
     * The image is scaled to be larger than its original size.
     */
    public Icon(){
        GreenfootImage image = new GreenfootImage("icon.png");
        image.scale(image.getWidth()+30, image.getHeight()+40);
        setImage(image);
    }
}
