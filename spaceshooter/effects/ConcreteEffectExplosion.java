/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.effects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author wdevoogd
 */
public class ConcreteEffectExplosion extends AbstractEffect{
    
    private double x;            
    private double y;        
    private double size;
    private double grow;
    private int life;
    private boolean active;  
    private boolean growing;
    private long lastUpdate;
    private long start;
    private long now;
    private float alpha;   
            
    public ConcreteEffectExplosion(double x, double y, double size, double grow, int life) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.grow = grow;
        this.life = life;
        this.active = true;
        lastUpdate = System.currentTimeMillis(); 
        start = lastUpdate;
        alpha = 0.0f;
        growing = true;        
    }
    
    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void update() {
        now = System.currentTimeMillis(); 
        if(now-start>life){
            active = false;
        }
        if(now-start>life*0.1 && growing){
            growing = false;
        }        
        if(growing){
            size += grow * (now-lastUpdate) * 16;  
            alpha += 0.002 * (now-lastUpdate);
            if(alpha>1){
                alpha = 1;
            }
        }      
        else{
            size -= grow * (now-lastUpdate);  
            alpha -= 0.001 * (now-lastUpdate);
            if(alpha<0){
                alpha = 0;
            }            
        }
        lastUpdate = now;        
    }

    @Override
    public void draw(Graphics2D g) {         
         g.setColor(new Color(1.0f,1.0f,1.0f,alpha));
         g.fill(new Ellipse2D.Double(x-(size/2), y-(size/2), size, size));
    }
    
}
