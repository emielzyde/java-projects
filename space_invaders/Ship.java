import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.*;

public class Ship extends Sprite {
    
    private final int MOVING_SPEED = 4;
    private boolean missileAway = false;
    private Missile missile; 
    private int dx;
    private int missile_speed;
    
    
    public Ship(int x, int y){
        super(x,y);
        initShip();
       
    }
    
    public void initShip(){
        loadImage("/Users/emielzyde/NetbeansProjects/SpaceInvaders/apple.png");
        getDimensions();
    }
    
    public void moveShip(){
        
        x = x + dx;
        
    }
    
    public void setMovement(int x){
        dx = x * MOVING_SPEED;
    }
    
    public void releaseMissile(){
        if (!missileAway){
            int x1 = getX();
            int y1 = getY() - 1;
            
            missile = new Missile(x1,y1, missile_speed);
            missileAway = true;
        }
    }
    
    public Missile getMissile(){
        return missile; 
    }
    
    public boolean getMissileStatus(){
        return missileAway;
    }
    
    public void setMissileStatus(boolean status){
        missileAway = status;
    }
    
    public void setMissileSpeed(String difficulty){
        if (difficulty.equalsIgnoreCase("hard") || difficulty.equalsIgnoreCase("extreme"))
            missile_speed = 2;  
        
        else
            missile_speed = 1;
    }
}
