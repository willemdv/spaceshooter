/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.effect;

import gameobject.main.GameObject;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 *
 * @author willem
 */
public class Shield extends GameObject{
    
    private int period;
    private GameObject parent;
            
    public Shield(float size, int period, GameObject parent) {
        this.size = size;
        this.period = period;    
        this.parent = parent;
    }
    
    @Override
    public void update() {
        this.x = parent.getX();
        this.y = parent.getY();
    } 
    

    @Override
    public void draw(Graphics2D g) {
        Point2D center = new Point2D.Float(x, y);
        float radius = size;        
        
        
        
        float[] dist = {0.0f,0.25f,0.5f,0.75f,1f};
        Color[] colors = {new Color(0.5f,1.0f,1.0f,0)
                ,new Color(0.6f,1.0f,1.0f,0)
                ,new Color(0.7f,1.0f,1.0f,0)
                ,new Color(0.8f,1.0f,1.0f,getAlpha(0.3f)/3f)
                ,new Color(1f,1.0f,1.0f,0.7f)
        };          
        RadialGradientPaint gradient =  new RadialGradientPaint(center, radius, dist, colors);          
        g.setPaint(gradient);         
        g.fill(new Ellipse2D.Float(x-(size), y-(size), size*2, size*2));
    }
    
    public float getAlpha(float offset){
        float sin = (int)(System.currentTimeMillis()%100000)/(float)period * (float)Math.PI;
        sin += (float)period*offset;
        sin = (float)Math.sin(sin);
        sin +=1;
        sin /=2; 
        return sin;
    }
    
}
