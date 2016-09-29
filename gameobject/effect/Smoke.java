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
import java.awt.image.BufferedImage;
import main.Engine;

/**
 *
 * @author willem
 */
public class Smoke extends GameObject{
    
    private int life;
    private int startLife;
    private float startSize;
    private float startAlpha;
    private float alpha;
    
    public Smoke(float x, float y, int life, float size) {
        super(x, y);
        this.life = life; 
        this.startLife = life;
        this.size = size;
        this.startSize = size;
        this.alpha = 1f;  
        this.startAlpha = alpha;
    }
    
    public Smoke(float x, float y, int life, float size, float alpha) {
        super(x, y);
        this.life = life; 
        this.startLife = life;
        this.size = size;
        this.startSize = size;
        this.alpha = alpha;
        this.startAlpha = alpha;
    }
    
    public Smoke(float x, float y, int life, float size, float alpha, float speed, float angle) {
        super(x, y, speed, angle);
        this.life = life; 
        this.startLife = life;
        this.size = size;
        this.startSize = size;
        this.alpha = alpha;
        this.startAlpha = alpha;        
    }
    
    
    @Override
    public void update() {
        now = System.currentTimeMillis();
        time = now - lastUpdate;         
        if (active) {
            alpha -= (float)time/(float)startLife*startAlpha;
            size -= (float)time/(float)startLife*startSize;
            life -= time;
        }
        if (!withinBounds() || life<=0 || size<=0 || alpha<=0) {
            active = false;
        }
        move();
        lastUpdate = System.currentTimeMillis();
    } 
    

    @Override
    public void draw(Graphics2D g) {
        /*
        Point2D center = new Point2D.Float(x, y);
        float radius = size;        
        float[] dist = {0.0f,1.0f};
        Color[] colors = {new Color(1.0f,1.0f,1.0f,alpha),new Color(1.0f,1.0f,1.0f,alpha)};          
        RadialGradientPaint gradient =  new RadialGradientPaint(center, radius, dist, colors);          
        g.setPaint(gradient);         
        g.fill(new Ellipse2D.Float(x-(size), y-(size), size*2, size*2));
        */
        g.setColor(new Color(1.0f,1.0f,1.0f,alpha));
        g.fill(new Ellipse2D.Float(x-(size), y-(size), size*2, size*2));
    }
    
}
