import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *The EnemyBar class represents a graphical bar that displays the current level
 *of health of actor Palpatine in the game.
 *
 * @Felipe Bertoli Oliveira
 * @version 1.0
 */
public class EnemyBar extends Actor
{

    private int maxLife;
    private int currentLife;
    private int length;

    /**

     *Constructs a new HealthBar object with the specified maximum life, current life and length.
     *@param maxLife the maximum amount of life that the bar can display
     *@param currentLife the current amount of life to display
     *@param length the length of the bar in pixels
     */
    public EnemyBar(int maxLife, int currentLife, int length){
        this.maxLife = maxLife;
        this.currentLife = currentLife;
        this.length = length;
    }

    /**
     *Updates the current life value of the HealthBar and displays it graphically.
     **It's updated when actor Palpatine takes damage in the world.
     *@param newLife the new value of the life to display
     */
    public void updateHealthBar(int newLife){
        currentLife = newLife;
        int newLength = (int) ((currentLife / (double) maxLife) * length);
        GreenfootImage img = new GreenfootImage(length, 30);
        img.setColor(Color.RED);
        img.fillRect(length - newLength, 0, newLength, 30);
        setImage(img);
    }
}
