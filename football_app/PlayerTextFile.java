import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import static java.util.Comparator.comparing;
import java.util.List;

public class PlayerTextFile {
    
    private ArrayList<Player> players;
    private Path playerPath;
    private File playerFile;
    private final String FIELD_SEP = "\t";
    private final int NAME_SIZE = 15;
    private final int SURNAME_SIZE = 15;
    private final int NUMBER_SIZE = 5;
    
    public PlayerTextFile(){
       
        playerPath = Paths.get("players.txt");
        playerFile = playerPath.toFile();
        players = this.getPlayers();
        
    }
    
    public Player getPlayer(String name){
        for (Player p : players){
            if (p.getName().equals(name))
                return p;
        }
        
        return null;
    }
    
    
    public ArrayList<Player> getPlayers(){
        
        players = new ArrayList<>();
        Player player = null;
        
        // open the input stream
        
        if (Files.exists(playerPath)){
            try (BufferedReader in = new BufferedReader (new FileReader(playerFile))){
                String line = in.readLine();

                while (line != null){
                    player = new Player();
                    String[] data = line.split(FIELD_SEP);
                    String first_name = data[0];
                    String surname = data[1];
                    int games = Integer.parseInt(data[2]);
                    int wins = Integer.parseInt(data[3]);
                    int draws = Integer.parseInt(data[4]);
                    int goals_for = Integer.parseInt(data[5]);
                    int goals_against = Integer.parseInt(data[6]);

                    player.setName(first_name);
                    player.setSurname(surname);
                    player.setGames(games);
                    player.setWins(wins);
                    player.setDraws(draws);
                    player.setGoalsFor(goals_for);
                    player.setGoalsAgainst(goals_against);

                    players.add(player); 

                    line = in.readLine();
                    }
            }
        
            catch (IOException e){
                System.out.println(e);
            }
            }
        return players;
    }
    
    public boolean addPlayer(String first_name, String surname){
        Player player = new Player(first_name, surname);
        players.add(player);
        return savePlayers();
        
    }
    
    public boolean savePlayers(){
        
        // this method will write to the text file 
        try (PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter(playerFile)))){
            for (Player p : players){
                out.print(p.getName() + FIELD_SEP);
                out.print(p.getSurname() + FIELD_SEP);
                out.print(p.getGames() + FIELD_SEP);
                out.print(p.getWins() + FIELD_SEP);
                out.print(p.getDraws() + FIELD_SEP);
                out.print(p.getGoalsFor() + FIELD_SEP);
                out.println(p.getGoalsAgainst());
            }
            
            return true;
        }
        
        catch (IOException e){
                System.out.println(e);
                return false;
        }
                
    }
    
    public boolean processResult(String player_1, String player_2, int goals_1, int goals_2){
        Player player1 = getPlayer(player_1);
        Player player2 = getPlayer(player_2);
        
        player1.addResult(goals_1, goals_2);
        player2.addResult(goals_2, goals_1);
        
        return savePlayers();
    }
    
    public void sortResultsOnPoints(){
        
        int num_players = players.size();
        
        int[][] results = new int[num_players][2];
        
        for (int i = 0; i < players.size(); i++){
            results[i][0] = i;
            results[i][1] = players.get(i).calculatePoints();
            }   

          
        Arrays.sort(results, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });

        ArrayList<Player> interim = new ArrayList<>();
        for (int i = 0; i < players.size(); i ++){
            Player ad_int = players.get(results[i][0]);
            interim.add(ad_int);
        }
        
        players = interim;
        
    }
    
    public void sortResultsOnGoalDiff(){
        
        ArrayList<Integer> points = new ArrayList<>();
        
       
        for (int i = 0; i < players.size(); i ++){
            int point1 = players.get(i).calculatePoints();
            
            for (int j = i + 1; j < players.size(); j++){
                int point2 = players.get(j).calculatePoints();
                if (point2 == point1 && !points.contains(point1))
                    points.add(point1);
            }
        }
        
        for (int p:points){
            System.out.println(p);
        }
        
        for (int point:points){
            
            HashMap<String, Integer> map = new HashMap<>();
            for (Player p: players){
                if (p.calculatePoints() == point)
                    map.put(p.getName(), p.calculateGoalDiff());
            }
            
            Map<String, Integer> hm = sortByValue(map);
            
            for (Map.Entry ins : hm.entrySet()){
                System.out.println(ins.getKey() + " " + ins.getValue());
            }
            
            ArrayList<Player> interim = new ArrayList<>();
            for (int i = 0; i < players.size(); i++){
                if (!hm.containsKey(players.get(i).getName())){
                    interim.add(players.get(i));
                }
                
                else{
                    
                }
            }
            
            
  

        }         
       
    }
    
    public HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
        
    
    public ArrayList<String> formatResults(){
       
        players.sort(Comparator.comparing(Player :: calculatePoints).reversed().thenComparing(Player :: getGames).thenComparing(Player :: calculateGoalDiff).thenComparing(Player :: getGoalsFor));
        
        ArrayList<String> unsortedResults = new ArrayList<>();
        
        unsortedResults.add(formatLine());
        
        for (Player p : players){
            StringBuilder s = new StringBuilder(0);
            String name = padWithSpaces(p.getName(), NAME_SIZE);
            String surname = padWithSpaces(p.getSurname(), SURNAME_SIZE);
            
            String games = padWithSpaces(Integer.toString(p.getGames()), NUMBER_SIZE);
            String wins = padWithSpaces(Integer.toString(p.getWins()), NUMBER_SIZE);
            String draws = padWithSpaces(Integer.toString(p.getDraws()), NUMBER_SIZE);
            String goals_for = padWithSpaces(Integer.toString(p.getGoalsFor()), NUMBER_SIZE);
            String goals_against = padWithSpaces(Integer.toString(p.getGoalsAgainst()), NUMBER_SIZE);
            String goal_dif = padWithSpaces(Integer.toString(p.calculateGoalDiff()), NUMBER_SIZE);
            
            int games2 = p.getGames();
            int wins2 = p.getWins();
            int draws2 = p.getDraws();
            int losses = games2 - wins2 - draws2;
            String losses2 = padWithSpaces(Integer.toString(losses), NUMBER_SIZE);
            
            int points = p.calculatePoints();
            String points2 = padWithSpaces(Integer.toString(points), NUMBER_SIZE);
           
            s.append(name);
            s.append(surname);
            s.append(games);
            s.append(wins);
            s.append(draws);
            s.append(losses2);
            s.append(goals_for);
            s.append(goals_against);
            s.append(goal_dif);
            s.append(points2);

            String result = s.toString();
            unsortedResults.add(result);
            
        }
        return unsortedResults;   
    }

    
    public String formatLine(){
        
        String n1 = padWithSpaces("NAME", NAME_SIZE);
        String n2 = padWithSpaces("SURNAME", SURNAME_SIZE);
        String n3 = padWithSpaces("P", NUMBER_SIZE);
        String n4 = padWithSpaces("W", NUMBER_SIZE);
        String n5 = padWithSpaces("D", NUMBER_SIZE);
        String n6 = padWithSpaces("L", NUMBER_SIZE);
        String n7 = padWithSpaces("GF", NUMBER_SIZE);
        String n8 = padWithSpaces("GA", NUMBER_SIZE);
        String n9 = padWithSpaces("GD", NUMBER_SIZE);
        String n10 = padWithSpaces("PTS", NUMBER_SIZE);
        
        StringBuilder d = new StringBuilder(0);
        d.append(n1);
        d.append(n2);
        d.append(n3);
        d.append(n4);
        d.append(n5);
        d.append(n6);
        d.append(n7);
        d.append(n8);
        d.append(n9);
        d.append(n10);
        
        return d.toString();
                
    }
    public String padWithSpaces(String s, int length){
        if (s.length() < length){
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() < length){
                sb.append(" ");
            }
            
            return sb.toString();
        }
        
        else
            return s.substring(0,length);
    }

}
