import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    private static final int OFFSET = 5; 
    private static final int DELAY_OPEN_CLOSE_MOUTH = 10;
    
    private int currentImage = 0;
    private String []images;
    private int delayMovement = 0;
    
    private int score = 0;
    
    private ScoreManager scoreManager;
    
    Pacman(ScoreManager scoreManager){
        images = new String[]{
            "images/pacman-1.png",
            "images/pacman-2.png"
        };
        this.setImage(images[0]);
        this.scoreManager = scoreManager;
    }
    
    /**
     * Act - do whatever the Pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        handleKeys();
        
        openCloseMouth();
        
        eatItems();
        
    }
    
    private void eatItems(){
        Item item = (Item)getOneIntersectingObject(Item.class);
        
        if(item != null){
            score += item.getScoreValue();
            
            World world = getWorld();
            
            world.removeObject(item);
            scoreManager.updateScore(score);
            
        }
    }
    
    private void openCloseMouth(){
        delayMovement++;
        
        if(delayMovement == DELAY_OPEN_CLOSE_MOUTH){
            this.setImage(images[currentImage]);
            currentImage = (++currentImage) % images.length;
            delayMovement = 0;
        }
    }
    
    private void handleKeys(){
        int x = getX();
        int y = getY();
        
        if(Greenfoot.isKeyDown("right") && getOneObjectAtOffset​(OFFSET, 0, Wall.class) == null){
            setLocation(x + OFFSET, y);
        } else if(Greenfoot.isKeyDown("down") && getOneObjectAtOffset​(0, OFFSET, Wall.class) == null){
            setLocation(x, y + OFFSET);
        } else if(Greenfoot.isKeyDown("left") && getOneObjectAtOffset​(-OFFSET, 0, Wall.class) == null ){
            setLocation(x - OFFSET, y);
        } else if(Greenfoot.isKeyDown("up") && getOneObjectAtOffset​(0, -OFFSET, Wall.class) == null){
            setLocation(x, y - OFFSET);
        }
    }
}

