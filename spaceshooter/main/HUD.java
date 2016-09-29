/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;

/**
 *
 * @author willem
 */
public class HUD {
    
    private int score;
    private int lives;
    private Engine engine;
    
    public HUD(Engine engine){
        this.score = 0;
        this.lives = 3; 
        this.engine = engine;
    }
    
    public void draw(Graphics2D g){
        g.setColor(new Color(1.0f,1.0f,1.0f,0.8f));
        Font font = new Font("IMPACT", Font.PLAIN, 26);
        g.setFont(font);
        g.drawString("Score : "+score, 20, 70);  
        g.drawString("lives : "+lives, 20, 100); 
        
        font = new Font("IMPACT", Font.PLAIN, 15);   
        g.setFont(font);
        g.fillRect(0, 550, 300, 75);
        g.setColor(Color.BLACK);
        g.drawString("Health",20,575);
        g.fillRect(75,555,200,25);
        
        GradientPaint gradient1 = new GradientPaint(0,580,Color.red,0,555,new Color(165,0,0),true);
        g.setPaint(gradient1);
        g.fillRect(75,555,(int)(200*(engine.getPlayer().getHealth()/100f)),25);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score){
        this.score+=score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    
    public void addLives(int lives){
        this.lives += lives;
    }
    
    
    
}
