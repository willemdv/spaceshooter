/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.effect;

import gameobject.main.GameObject;
import java.awt.Graphics2D;

/**
 *
 * @author willem
 */
public class Spark extends GameObject {
    private int life;
    private Sparklet[] sparks;
    
    public Spark(float x, float y, int life) {
        super(x, y);
        this.life = life;
        sparks = new Sparklet[100];
        for(int i=0;i<100;i++){
            sparks[i]=(new Sparklet(x,y,(float)(Math.random()*0.2f)+0.1f,(float)(Math.random()*360),life));            
        }
    }
    
    @Override
    public void update() {
        now = System.currentTimeMillis();
        time = now - lastUpdate;
        if (!withinBounds() || life < 0) {
            active = false;
        }
        if (active) {
            for(Sparklet spark:sparks){
                spark.update();
            }
            life -= time;
        }
        lastUpdate = System.currentTimeMillis();
    }
    
    @Override
    public void draw(Graphics2D g) {
        for(Sparklet spark:sparks){
            spark.draw(g);
        }
    }
    
}
