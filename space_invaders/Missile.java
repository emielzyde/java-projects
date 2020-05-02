public class Missile extends Sprite {
    
    private final int MOVING_SPEED = 3;
    private boolean isDestroyed = false;
    private int moving_speed_adjuster = 1;
    
    public Missile(int x, int y, int z){
        super(x,y);
        initMissile();
        moving_speed_adjuster = z;
    }
    
    public void initMissile(){
        loadImage("/Users/emielzyde/NetbeansProjects/SpaceInvaders/apple.png");
        getDimensions();
    }
    
    public void moveMissile(){
        
        if (!isDestroyed){
            y = y - MOVING_SPEED * moving_speed_adjuster;
        }
    }
}


