import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * That class sets the image icon for actor Palpatine
 * 
 * @author Felipe Bertoli Oliveira
 * @version 1.0
 */
public class EnemyIcon extends Actor
{
    /**
     * Constructs a new EnemyIcon object with an image of the character Palpatine's icon.
     * The image is scaled to be larger than its original size.
     */
    public EnemyIcon(){
        GreenfootImage image = new GreenfootImage("palpicon.png");
        image.scale(image.getWidth()+30, image.getHeight()+40);
        setImage(image);
    }
}
