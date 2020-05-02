
public class Alien extends Sprite {
    
    private boolean isDestroyed = false;
    private boolean bombAway = false;
    private Bomb bomb;
    private final int MOVING_SPEED = 1;
    private boolean moveRight = true; 
    private double bombGenerationRate;
    private int downMoveSpeed;
    private int speed;
    
   
    
    public Alien(int x, int y){
        
        super(x,y);
        initAlien();
    }
    
    public void initAlien(){
        
        loadImage("/Users/emielzyde/NetbeansProjects/SpaceInvaders/head.png");
        getDimensions();
    }
    
    public void releaseBomb(){
       
        if (!bombAway){
            double bombrate = bombGenerationRate;
            double rand = Math.random();
            if (rand < bombrate){
                int x = getX();
                int y = getY() + 1;
                bomb = new Bomb(x,y);
                bombAway = true; 
            }
            
        }  
    }
    
    public void setDestroyed(){
        isDestroyed = true; 
    }
    
    public boolean getDestroyed(){
        return isDestroyed;
    }
    
    public boolean getBombStatus(){
        return bombAway;
    }
    
    public Bomb getBomb(){
        return bomb;

    }
    
    public void setBombStatus(boolean status){
        bombAway = status;
    }
    
    public void moveLeft(){
        x = x - MOVING_SPEED * speed;
    }
    
    public void moveRight(){
        x = x + MOVING_SPEED * speed;
    }
    
    public void moveDown(){
        y = y + MOVING_SPEED * downMoveSpeed;
    }
    
    public void setMovingStatus(){
        moveRight = !moveRight; 
    }
    
    public boolean getMovingStatus(){
        return moveRight;
    }
    
    public void setBombRate(String difficulty){
        if (difficulty.equalsIgnoreCase("hard"))
            bombGenerationRate = 0.001;
        
        if (difficulty.equalsIgnoreCase("medium"))
            bombGenerationRate = 0.0005;
        
        if (difficulty.equalsIgnoreCase("easy"))
            bombGenerationRate = 0.0001;
        
        if (difficulty.equalsIgnoreCase("extreme"))
            bombGenerationRate = 0.0025;
    }
    
    public void setMovingSpeed(String difficulty){
        if (difficulty.equalsIgnoreCase("hard")){
            downMoveSpeed = 20;
            speed = 3;
        }

        if (difficulty.equalsIgnoreCase("medium")){
            downMoveSpeed = 10;
            speed = 2;
        }
        
        if (difficulty.equalsIgnoreCase("easy")){
            downMoveSpeed = 5;
            speed = 2;
        }
        
        if (difficulty.equalsIgnoreCase("extreme")){
            downMoveSpeed = 20;
            speed = 4;
        }
    }
}
