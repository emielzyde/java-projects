import java.util.*;
import java.lang.*;

public class Player {
    
    private String name;
    private String surname;
    private int goals_for = 0;
    private int goals_against = 0;
    private int wins = 0;
    private int games = 0;
    private int draws = 0;

    public Player(){
        name = "";
        surname = "";
    }
     
    public Player(String first_name, String surname){
        this.name = first_name;
        this.surname = surname;
    }
   
    public void setName(String first_name){
        this.name = first_name;
    }
    
    public void setSurname(String surname){
        this.surname = surname;
    }
   
           
   public void setGoalsFor(int goals_for){
       this.goals_for = goals_for;
   }
    
    public void setGoalsAgainst(int goals_against){
       this.goals_against = goals_against;
   }
   
    public void setWins(int wins){
        this.wins = wins;
    }
    
    public void setGames(int games){
        this.games = games;
    }
    
    public void setDraws(int draws){
        this.draws = draws;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public int getGoalsFor(){
        return goals_for;
    }
    
    public int getGoalsAgainst(){
        return goals_against;
    }
    
    public int getWins(){
        return wins;
    }
    
    public int getGames(){
        return games;
    }
    
    public int getDraws(){
        return draws;
    }
   
    public int calculateGoalDiff(){
        int goal_dif = goals_for - goals_against;
        return goal_dif;
    }
    
    public int calculatePoints(){
        int points = (draws * 1) + (wins * 3);
        return points;
    }
    
    public void addResult(int goals_for, int goals_against){
        games += 1;
        this.goals_for += goals_for;
        this.goals_against += goals_against;
        if (goals_for > goals_against)
            wins += 1;
        if (goals_for == goals_against)
            draws += 1;
    }
 
}
