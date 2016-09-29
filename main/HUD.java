/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gameobject.main.Drawable;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

/**
 *
 * @author willem
 */
public class HUD implements Drawable {

    private Engine engine;

    public HUD(Engine engine) {
        this.engine = engine;
    }

    public void draw(Graphics2D g) {
        g.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
        Font font = new Font("IMPACT", Font.PLAIN, 20);
        g.setFont(font);
        g.drawString("Score : " + engine.getGameInfo().getScore(), 20, 70);
        g.drawString("lives : " + engine.getGameInfo().getLives(), 20, 100);
        g.drawString("fps : " + engine.getGameInfo().getFps(), 20, 130);
        
        int x = 30;
        int y = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-50;
        
        g.drawImage(engine.getRecources().getImage(5), x, y, null);
        
        float perc = engine.getPlayer().getHealth()/100f;
        if (perc>0.01f){       
            BufferedImage health = engine.getRecources().getImage(4);
            health = health.getSubimage(0, 0, (int)(health.getWidth()*perc), health.getHeight());
            g.drawImage(health, x, y, null);
        }
    
    }
}
