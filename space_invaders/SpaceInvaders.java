import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SpaceInvaders extends JFrame {
    
    public SpaceInvaders(){
       initUI();
        
    }
    
    public void initUI(){
        
        String[] model = {"Easy", "Medium", "Hard", "Extreme"};
        String input = (String) JOptionPane.showInputDialog(this, "Select the difficulty level: ", "Difficulty", JOptionPane.QUESTION_MESSAGE, null, model, model[0]);
        
        if (input != null){
            add(new Board(input));
            setResizable(false);
            pack();
        
            setTitle("Space Invaders");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
        else{
            System.exit(0);
        }
        

    }
    
    public static void main (String[] args){
        
        EventQueue.invokeLater(() -> {
            JFrame si = new SpaceInvaders();
            si.setVisible(true);
        
        });
    }
}
