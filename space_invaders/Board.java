import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.*;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.lang.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener {
    
    private final int BOARD_WIDTH = 600;
    private final int BOARD_HEIGHT = 600;
    private int ship_x = BOARD_WIDTH / 2;
    private int ship_y = BOARD_HEIGHT  - 52;
    private Ship ship;
    private boolean inGame = false;
    private boolean gameWon; 
    private boolean gameLost;
    private boolean isPaused;
    
    private final int DELAY = 15;
    private Timer timer; 
    
    private  int aliens_to_kill;
    private int aliens_killed = 0;
    private int aliens_remaining;
    
    private ArrayList<Alien> alien_list;
    
    
    private final int ALIEN_X = 100;
    private final int ALIEN_Y = 30;
    
    private String difficulty_level;
    
    
    public Board(String difficulty){
        difficulty_level = difficulty;
        initBoard();
    }
    
    public void initBoard(){
        
        addKeyListener(new LAdapter());
        
        setBackground(Color.black);
        setFocusable(true);
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        repaint();
        
        ship = new Ship(ship_x, ship_y);
        ship.setMissileSpeed(difficulty_level);
        initAliens();
        timer = new Timer(DELAY, this);
        timer.start(); 
        
    }
    
    @Override 
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       
       doPaint(g);
       
       Toolkit.getDefaultToolkit().sync(); 
    }
    
    public void doPaint(Graphics g){
        if (inGame){
            
            if (!isPaused){
                Graphics2D g2d = (Graphics2D) g;
            
                g2d.setColor(Color.WHITE);
                g2d.drawLine(0, BOARD_HEIGHT - 40, BOARD_WIDTH, BOARD_HEIGHT - 40);
            
                g2d.drawString("There are " + Integer.toString(aliens_remaining) + " aliens remaining!", 20, BOARD_HEIGHT - 15);
                g2d.drawString("Click P to pause", BOARD_WIDTH - 130, BOARD_HEIGHT - 15);
                g2d.setColor(Color.BLACK);
            
                g2d.drawImage(ship.getImage(), ship.getX(), ship.getY(), this);
            
                if (ship.getMissileStatus() == true){
                 g2d.drawImage(ship.getMissile().getImage(), ship.getMissile().getX(), ship.getMissile().getY(), this);
                }
            
                for (Alien alien : alien_list){
                    if (alien.getDestroyed() == false)
                        g2d.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
                    if (alien.getBombStatus() == true){
                        g2d.drawImage(alien.getBomb().getImage(), alien.getBomb().getX(), alien.getBomb().getY(), this);
                    }
                }
            }
            
            if(isPaused){
                String message = "Paused!";
                Font font = new Font ("Helvetica", Font.BOLD, 14);
                FontMetrics metric = getFontMetrics(font);
        
                g.setColor(Color.WHITE);
                g.setFont(font);
                g.drawString(message, (BOARD_WIDTH - metric.stringWidth(message))/2, BOARD_HEIGHT/2);  
                }

        }
        
        else {
            
            if (!gameLost && !gameWon){
                Font font = new Font ("Helvetica", Font.BOLD, 14);
                FontMetrics metric = getFontMetrics(font);
                
                String line1 = "You must destroy all the aliens by shooting missiles.";
                String line2 = "You can only have one missile in play at any given time!";
                String line3 = "If the aliens hit you with their bombs, you lose.";
                String line4 = "If they reach the white line, they invade the earth and you lose!";
                String line5 = "Save our planet!";
                String line6 = "Press any key to continue";
                
                String maxline = line4;

                
                g.setColor(Color.WHITE);
                g.setFont(font);
                g.drawString(line1, (BOARD_WIDTH - metric.stringWidth(maxline))/2, (BOARD_HEIGHT)/2 - 80);  
                g.drawString(line2, (BOARD_WIDTH - metric.stringWidth(maxline))/2, (BOARD_HEIGHT )/2 - 60);  
                g.drawString(line3, (BOARD_WIDTH - metric.stringWidth(maxline))/2, (BOARD_HEIGHT)/2 - 40);  
                g.drawString(line4, (BOARD_WIDTH - metric.stringWidth(maxline))/2, (BOARD_HEIGHT) / 2 - 20);  
                g.drawString(line5, (BOARD_WIDTH - metric.stringWidth(maxline))/2, (BOARD_HEIGHT)/2);  
                g.drawString(line6, (BOARD_WIDTH - metric.stringWidth(maxline))/2, (BOARD_HEIGHT)/2 + 40);  
                
            }
            if (gameLost){
                gameOver(g);
            }
            
            else if (gameWon){
                gameWon(g);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        if (inGame){
            moveShip();
            updateMissiles();
            updateAliens();
            updateBombs();
            checkAlienDestructions();
            checkShipDestroyed();
            checkGameOver();
            repaint();
        }
        
        else if (!inGame && !gameWon && !gameLost){
        }
        
        else if ((!inGame && gameWon) || (!inGame && gameLost)){
            timer.stop();
        }
    }
    
    public void gameOver(Graphics g){
        
        String message = "Game over";
        Font font = new Font ("Helvetica", Font.BOLD, 14);
        FontMetrics metric = getFontMetrics(font);
        
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(message, (BOARD_WIDTH - metric.stringWidth(message))/2, BOARD_HEIGHT/2);        
    }
    
    public void gameWon(Graphics g){
        String message = "You won! Well done!";
        Font font = new Font ("Helvetica", Font.BOLD, 14);
        FontMetrics metric = getFontMetrics(font);
        
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(message, (BOARD_WIDTH - metric.stringWidth(message))/2, BOARD_HEIGHT/2);        
    }
    
    public void initAliens(){
        
        int alien_num = 0;
        if (difficulty_level.equalsIgnoreCase("easy"))
            alien_num = 4;
        if (difficulty_level.equalsIgnoreCase("medium"))
            alien_num = 5;
        if (difficulty_level.equalsIgnoreCase("hard"))
            alien_num = 6;
        if (difficulty_level.equalsIgnoreCase("extreme"))
            alien_num = 8;
        
        
        aliens_to_kill = alien_num * 5;
        aliens_remaining = aliens_to_kill;

        alien_list = new ArrayList<>();
        
        for (int i = 0; i < alien_num; i++ ){
            for (int j = 0; j < 5; j ++){
                
                Alien alien = new Alien(ALIEN_X + 60 * j, ALIEN_Y + 20 * i);
                alien_list.add(alien);
            }
        }
        
        for (Alien alien: alien_list){
            alien.setBombRate(difficulty_level);
            alien.setMovingSpeed(difficulty_level);
        }
    }
    
    public void moveShip(){
        
        if (ship.getX() > 0 && ship.getX() < BOARD_WIDTH - 5){
            ship.moveShip();
        } 
        
        else if (ship.getX() <= 0){
            ship.setX(1);
        }
        
        else if (ship.getX() >= BOARD_WIDTH - 5){
            ship.setX(BOARD_WIDTH - 6);
        }        
    }
   
    public void updateMissiles(){
        
        
        if (ship.getMissileStatus() == true){
            if (ship.getMissile().getY() < 0){
                ship.setMissileStatus(false);
            }
            else{
                ship.getMissile().moveMissile();
            }  
        }
    }
    
    public void updateAliens(){
        
        for (Alien alien : alien_list){
            
            if (alien.getX() < 3){
                alien.setMovingStatus();
                alien.moveDown();
                alien.moveRight();
                
            }
            
            else if (alien.getX() > BOARD_WIDTH - 3){
                alien.setMovingStatus();
                alien.moveDown();
                alien.moveLeft();
            }
            
            else if (alien.getMovingStatus()){
                alien.moveRight();
            }
            
            else{
                alien.moveLeft();
            }
        }
    }
   
    
    public void updateBombs(){
        
        for (Alien alien : alien_list){
            if (alien.getBombStatus() == false){
                alien.releaseBomb();
            }
            
            else{
                alien.getBomb().moveBomb();
            }
        }
        
        for (Alien alien : alien_list){
            if (alien.getBombStatus() == true){
                if (alien.getBomb().getY() > BOARD_HEIGHT){
                    alien.setBombStatus(false);
                }
            }
        }
    }
    
    public void checkAlienDestructions(){
        
        if (ship.getMissileStatus() == true){
            Missile missile = ship.getMissile();
            Rectangle r1 = missile.getBounds();
           
            for (int i = 0; i < alien_list.size(); i ++){
                Rectangle r2 = alien_list.get(i).getBounds();
                if (r1.intersects(r2)){
                    alien_list.get(i).setDestroyed();
                    ship.setMissileStatus(false);
                    aliens_killed += 1;
                    aliens_remaining = aliens_remaining - 1;
                    alien_list.remove(i);
                }
            } 
        } 
    }
       
    public void checkShipDestroyed(){
        
        Rectangle r1 = ship.getBounds();
        
        for (Alien alien : alien_list){
            
            if (alien.getBombStatus() == true){
                Bomb bomb = alien.getBomb();
                Rectangle r2 = bomb.getBounds();
                
                if (r2.intersects(r1)){
                    inGame = false;
                    gameLost = true;
                }        
            }
        }
    }
    
    public void checkGameOver(){
        
        for (Alien alien : alien_list){
            if (alien.getY() >= BOARD_HEIGHT - 30){
                inGame = false;
                gameLost = true;
            }
        }
        
        if (aliens_killed == aliens_to_kill){
            inGame = false;
            gameWon = true;
        }
    }
    
    public void pause(){
        
        isPaused = !isPaused;
        if (isPaused){
            timer.stop();   
        }
        
        else{
            timer.start();
        }
        
        repaint(); 
    }
  

    private class LAdapter extends KeyAdapter{
        
        @Override 
        public void keyPressed(KeyEvent e){
            if (!inGame){
                inGame = true;
            }
            
            else{
                int key = e.getKeyCode();
        
                if (key == KeyEvent.VK_LEFT){
                    ship.setMovement(-1);
                }
        
                if (key == KeyEvent.VK_RIGHT){
                    ship.setMovement(1);
                }
        
                if (key == KeyEvent.VK_SPACE){
                    ship.releaseMissile();
                }
            
                if (key == KeyEvent.VK_P)
                    pause();
                }
        }
        
        @Override
        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
        
            if (key == KeyEvent.VK_LEFT){
                ship.setMovement(0);
            }
        
            if (key == KeyEvent.VK_RIGHT){
                ship.setMovement(0);
            }
        }
    }
    
}