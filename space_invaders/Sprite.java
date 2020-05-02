import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Sprite {
    
    protected int x;
    protected int y;
    
    protected boolean isVisible;
    protected Image image;
    
    protected int width;
    protected int height; 
    
    public Sprite(int x, int y){
        this.x = x;
        this.y = y;
        
        isVisible = true;
        
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void loadImage(String image_name){
        ImageIcon icon = new ImageIcon(image_name);
        Image img = icon.getImage();
        image = img;
    }
    
    public void getDimensions(){
        height = image.getHeight(null);
        width = image.getWidth(null);
        
    }
    
    public void setVisible(boolean visibility){
        isVisible = visibility;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }
    
    public Image getImage(){
        return image;
    }
    
}
