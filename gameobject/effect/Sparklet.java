/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.effect;

import gameobject.main.GameObject;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author willem
 */
public class Sparklet extends GameObject{
    private float alpha;
    private int life;
    
    public Sparklet(float x, float y, float speed, float angle, int life) {
        super(x, y, speed, angle);     
        alpha = 1f;
        this.life = life;
        this.size = 4f;
    }    
    
    @Override
    public void update() {
        now = System.currentTimeMillis();
        time = now - lastUpdate;        
        if (!withinBounds()) {
            active = false;
        }
        if (active) {
            speed -= ((float) time / (float) life) * speed;
            alpha -= ((float) time / (float) life) * alpha;
            move();
        }
        lastUpdate = System.currentTimeMillis();
    }    
    
    @Override
    public void draw(Graphics2D g) {
        color = new Color(0.8f, 1.0f, 1.0f, alpha);
        g.setColor(color);
        g.fill(new Ellipse2D.Double(x-(size/2), y-(size/2), size, size));
    }
    
}
