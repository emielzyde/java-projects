import java.util.*;
import java.lang.*;

public class Validator {
    
    public static boolean checkPlayerExists(ArrayList<Player> player_list, String name){
        
        for (Player p: player_list){
            if (p.getName().equals(name))
                return true;
       
        }
        return false;  
    }
    
    public static boolean checkValidNumber(String number1){
        
        try {
            int score = Integer.parseInt(number1);
            return true;
            
        }
        
        catch (NumberFormatException e){
            return false;
        }
        
    }
    
    
}
