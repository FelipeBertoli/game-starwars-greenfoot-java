import greenfoot.*; 
import java.io.FileWriter;  
import java.io.IOException; 

/**

 *This class represents the game mode 'Endless', and contains the game logic and elements.
 *In this mode, the player fights against an endless wave of stormtroopers until they are defeated.
 *The game ends when the player's health reaches zero.
 *It contains the player, enemy, and various UI elements such as health bars and icons. Also adds a background music
 *
 *@author Felipe Bertoli Oliveira 
 *@version 1.0
 */
public class Endless extends World
{
    private GreenfootImage label;
    private GreenfootImage img;
    private GreenfootImage space;
    private GreenfootSound music;
    private Luke luke;
    private Stormleft stormleft;
    private Stormright stormright;
    private HealthBar hp;
    private Icon icon;
    private int counter;
    private int killCount;
    private int gameMode = 2;

    /**
     * Constructor for objects of class Endless.
     * Sets the size of the game world and initializes the game objects, user interface elements and music.
     */
    public Endless()
    {    
        super(1000, 625, 1); 

        img = new GreenfootImage("background.png");
        space = new GreenfootImage("space.png");
        music = new GreenfootSound("theme.mp3");
        
        setBackground(img);
        music.playLoop();

        stormright  = new Stormright(gameMode);
        addObject(stormright, 999, 493);

        stormleft = new Stormleft(gameMode);
        addObject(stormleft, 3, 493);

        icon = new Icon();
        addObject(icon, 46, 63);

        luke = new Luke(100);
        addObject(luke, 525, 477);

        hp = new HealthBar(200, luke.getLife(), 200);
        addObject(hp, 191, 62);
    }

    /**
     * Act method for the Endless class.
     * Performs various actions every act() cycle, including updating the health bar and the kill count.
     * If the player's health reaches zero, the game ends and the player's score is written to a file.
     */
    public void act() {
        hp.updateHealthBar(luke.getLife()); 
        label = new GreenfootImage("Stormtroopers derrotados:" + killCount, 20, Color.WHITE, new Color(2, 2, 2, 2)); 
        getBackground().drawImage(label, 750, 62);
        killCount = stormleft.getSpawn() + stormright.getSpawn();

        if(luke.getLife() == 0) {
            setBackground(space);
            GreenfootImage label = new GreenfootImage("Stormtroopers derrotados:" + killCount, 50, Color.WHITE, new Color(2, 2, 2, 2));
            getBackground().drawImage(label, (getWidth()-label.getWidth())/2, (getHeight()-label.getHeight())/3);
            removeObject(icon);
            removeObject(stormleft);
            removeObject(stormright);
            music.pause();

            ButtonBack buttonBack = new ButtonBack();
            addObject(buttonBack , 500 ,520);

            try
            {
                FileWriter file = new FileWriter("score-" + 1 + ".txt");
                file.write("Stormtroopers derrotados:" + killCount);
                file.close();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }

        }
    } 
    
    public int getGameMode(){
        return gameMode;
    } 
    
    private int getKillCount(){
        return killCount;
    }
    
}

