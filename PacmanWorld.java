import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanWorld extends World implements ScoreManager
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public PacmanWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 600, 1); 

        prepare();
        
        this.addObject(new Pacman(this), 50, 50);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new Wall(),337,57);
        addObject(new Wall(),337,165);
        addObject(new Wall(),339,376);
        addObject(new Wall(),340,482);

        for(int x = 100; x < 230; x+=50)
            for(int y = 85; y < 550 ; y+=40)
                addObject(new SmallBall(),x,y);

        addObject(new Cherry(),460,103);
        addObject(new Cherry(),465,475);
        addObject(new Cherry(),583,278);
        addObject(new Cherry(),35,269);

        addObject(new BigBall(),342,272);
        addObject(new BigBall(),605,103);
        addObject(new BigBall(),606,507);
        
        updateScore(0);
    }
    
    public void updateScore(int pacmanScore){
        this.showText("Puntaje: " + pacmanScore, 532,35);
    }
}
