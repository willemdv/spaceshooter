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
public class ConcreteEffectStar extends AbstractEffect{
    
    private double x;            
    private double y;        
    private double size;    
    private boolean active;  
    private long lastUpdate;
    private long now;
    private double speed;
    private final double GradenNaarRad = Math.PI / 180.0;
    
    public ConcreteEffectStar(double x, double y, double size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.active = true;
        lastUpdate = System.currentTimeMillis(); 
        speed = Math.random()*0.16+0.005;
    }
    
    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void update() {
        if(!withinBounds()){
            active = false;
        }
        now = System.currentTimeMillis();        
        x += (Math.cos(180 * GradenNaarRad) * speed * (now-lastUpdate));
        y += (Math.sin(180 * GradenNaarRad) * speed * (now-lastUpdate));         
        lastUpdate = now;     
    }
    
    public boolean withinBounds(){        
        if(x<0 || x>1300 || y<0 || y>600){
            return false;
        } 
        else{
            return true;
        }
    }

    @Override
    public void draw(Graphics2D g) {         
         g.setColor(new Color(0.5f,1.0f,1.0f,(float)Math.abs(Math.sin(x/200+y))));
         g.fill(new Ellipse2D.Double(x-(size/2), y-(size/2), size, size));
    }
    
}
