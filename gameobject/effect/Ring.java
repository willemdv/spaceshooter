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

/**
 *
 * @author willem
 */
public class Ring extends GameObject{
    
    private int life;
    private int startLife;
    private float alpha;
    
    public Ring(float x, float y, int life) {
        super(x, y);
        this.life = life; 
        this.startLife = life;
        this.size = 0.01f;
        this.alpha = 1f;        
    }
    
    @Override
    public void update() {
        now = System.currentTimeMillis();
        time = now - lastUpdate;        
        if (!withinBounds() || life<=0) {
            active = false;
        }
        if (active) {
            size += ((float) time / (float) startLife) * 60f;
            life -= time;
        }
        lastUpdate = System.currentTimeMillis();
    } 
    

    @Override
    public void draw(Graphics2D g) {
        Point2D center = new Point2D.Float(x, y);
        float radius = size;        
        float[] dist = {0.0f,0.39f,0.4f,1.0f};
        Color[] colors = {new Color(0.8f,1.0f,1.0f,0.0f),new Color(0.8f,1.0f,1.0f,0.0f),new Color(0.8f,1.0f,1.0f,0.0f),new Color(0.8f,1.0f,1.0f,0.7f)};          
        RadialGradientPaint gradient =  new RadialGradientPaint(center, radius, dist, colors);          
        g.setPaint(gradient);         
        g.fill(new Ellipse2D.Float(x-(size), y-(size), size*2, size*2));
    }
    
}
