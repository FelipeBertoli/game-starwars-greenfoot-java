import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * This class represents the game mode 'Final Battle', and contains the game logic and elements.
 * This gamemode is the battle of Luke Skywalker against the Emperor Palpatine and his stormtroopers.
 * The player constrols actor Luke, with attack, defend, jump and walk methods. The main target is to defeat Palpatine and ten stormtroopers to win the game. 
 * Otherwise, Luke gets defeated. 
 * It contains the player, enemy, and various UI elements such as health bars and icons. Also adds a background music
 * 
 * @author Felipe Bertoli 
* @version 1.0
 */
public class EmperorBattle extends World
{
    private GreenfootImage img;
    private GreenfootImage space;
    private GreenfootSound music;
    private Stormright stormright;
    private Stormleft stormleft;
    private Luke luke;
    private Palpatine palpatine;
    private HealthBar hp;
    private EnemyBar eHp;
    private ButtonBack buttonBack = new ButtonBack();
    private Icon icon = new Icon();
    private EnemyIcon eIcon = new EnemyIcon();
    private int killCount;

    /**
     * Constructor for the EmperorBattle class. 
     * Sets the size of the game world and initializes the game objects, user interface elements and music.
     */
    public EmperorBattle()
    {    
        super(1000, 625, 1); 

        img = new GreenfootImage("emperorthrone.png");
        space = new GreenfootImage("space.png");
        music = new GreenfootSound("imperialmarch.mp3");

        setBackground(img);
        music.playLoop();

        stormright = new Stormright(1);
        addObject(stormright, 999, 493);

        stormleft = new Stormleft(1);
        addObject(stormleft, 3, 493);

        palpatine = new Palpatine(400);
        addObject(palpatine, 507, 433);

        luke = new Luke(120);
        addObject(luke, 525, 500);

        hp = new HealthBar(200, luke.getLife(), 300);
        addObject(hp, 241, 22);

        eHp = new EnemyBar(400, palpatine.getLife(), 300);
        addObject(eHp, 759, 22);

        addObject(icon, 46, 63);
        addObject(eIcon, 954, 63);
    }

    /**
     * Act method is called by the Greenfoot framework to perform actions in the game world.
     * This method updates the user interface elements, like kill counts and actors health bars. Also close the music and checks for win or lose conditions.
     */
    public void act() {
        showText("Stormtroopers derrotados:" + killCount + "/10", 850, 152);
        killCount = stormleft.getSpawn() + stormright.getSpawn();
        hp.updateHealthBar(luke.getLife()); 
        eHp.updateHealthBar(palpatine.getLife());

        if(stormright.getSpawn() == 5 && stormleft.getSpawn() == 5 && palpatine.getLife() == 0) {
            removeObject(eIcon);
            removeObject(icon);
            removeObject(hp);
            removeObject(eHp);
            removeObject(luke);
            music.pause();

            GreenfootImage space = new GreenfootImage("spacewin.png");
            setBackground(space);
            addObject(buttonBack , 500 ,520);
        }

        else if(luke.getLife() == 0) {
            removeObject(eIcon);
            removeObject(icon);
            removeObject(hp);
            removeObject(eHp);
            removeObject(palpatine);
            removeObject(stormleft);
            removeObject(stormright);
            music.pause();

            GreenfootImage space = new GreenfootImage("spacelose.png");
            setBackground(space);
            addObject(buttonBack , 500 ,520);

        }
    }
}
