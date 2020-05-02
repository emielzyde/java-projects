
public class Bomb extends Sprite {
    
    private final int MOVING_SPEED = 1;
    private boolean isDestroyed = false;
    
    
    public Bomb(int x, int y){
        
        super(x,y);
        initBomb();
        
    }
    
    public void initBomb(){
        loadImage("/Users/emielzyde/NetbeansProjects/SpaceInvaders/dot.png");
        getDimensions();
    }
    
    public void moveBomb(){
        
        if (!isDestroyed){
            
            y = y + MOVING_SPEED;
        
        } 
    }
   
  
}
