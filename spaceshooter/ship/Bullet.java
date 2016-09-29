/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *
 * @author wdevoogd
 */
public class Bullet {
    private int size;
    private double angle;
    private double speed;
    private double x;
    private double y;
    private boolean alive;
    private long lastUpdate;
    private long now;
    private final double GradenNaarRad = Math.PI / 180.0;
    private boolean friendly;
    
    public Bullet(int size, double angle, double speed, double x, double y, boolean friendly) {
        this.size = size;
        this.angle = angle;
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.alive = true;
        this.friendly = friendly;
        lastUpdate = System.currentTimeMillis();      
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }    

    public void update(){
        now = System.currentTimeMillis();
        x += (Math.cos(angle * GradenNaarRad) * speed * (now-lastUpdate));
        y += (Math.sin(angle * GradenNaarRad) * speed * (now-lastUpdate));
        if(x<0 || x>1200 || y<0 || y>600){
            alive=false;
        } 
        lastUpdate = now;        
    }      

    public boolean isFriendly() {
        return friendly;
    }    
    
    public void draw(Graphics2D g){  
        /*Point2D center = new Point2D.Double(x, y);
        float radius = size;
        
        float[] dist = {0.0f,1.00f};
        Color[] colors = {new Color(1.0f,0.0f,0.0f,1.0f),new Color(1.0f,0.0f,0.0f,0.0f)};        
        
        //float[] dist = {0.0f,0.15f,0.25f,0.5f,1.00f};
        //Color[] colors = {new Color(1.0f,1.0f,1.0f,1.0f),new Color(1.0f,1.0f,1.0f,1.0f),new Color(0.0f,1.0f,1.0f,0.8f),new Color(0.0f,1.0f,1.0f,0.0f),new Color(0.0f,0.0f,0.0f,0.0f)};        
        
        
        RadialGradientPaint gradient =  new RadialGradientPaint(center, radius, dist, colors);          
        g.setPaint(gradient);        
        g.fill(new Ellipse2D.Double(x-(size/2), y-(size/2), size, size));*/
        
        
        //Er moet een plaatje gemaakt worden voor de kogels. Dit is te traag
        if(!friendly){
            Point2D center = new Point2D.Double(x, y);
            float radius = size;        
            float[] dist = {0.0f,1.00f};
            Color[] colors = {new Color(1.0f,0.0f,0.0f,0.4f),new Color(1.0f,0.0f,0.0f,0.0f)};          
            RadialGradientPaint gradient =  new RadialGradientPaint(center, radius, dist, colors);          
            g.setPaint(gradient);         
            g.fill(new Ellipse2D.Double(x-(size), y-(size), size*2, size*2));

            radius = size/2;        
            dist = new float[]{0.0f,1.00f};
            colors = new Color[]{new Color(1.0f,0.0f,0.0f,1.0f),new Color(1.0f,0.0f,0.0f,0.0f)};          
            gradient =  new RadialGradientPaint(center, radius, dist, colors);          
            g.setPaint(gradient);         
            g.fill(new Ellipse2D.Double(x-(size/2), y-(size/2), size, size));

            g.setColor(Color.white);
            g.fill(new Ellipse2D.Double(x-(size/4), y-(size/4), size/2, size/2));
        }
        else{
            Point2D center = new Point2D.Double(x, y);
            float radius = size;        
            float[] dist = {0.0f,1.00f};
            Color[] colors = {new Color(0.0f,1.0f,0.0f,0.4f),new Color(0.0f,1.0f,0.0f,0.0f)};          
            RadialGradientPaint gradient =  new RadialGradientPaint(center, radius, dist, colors);          
            g.setPaint(gradient);         
            g.fill(new Ellipse2D.Double(x-(size), y-(size), size*2, size*2));

            radius = size/2;        
            dist = new float[]{0.0f,1.00f};
            colors = new Color[]{new Color(0.0f,1.0f,0.0f,1.0f),new Color(0.0f,1.0f,0.0f,0.0f)};          
            gradient =  new RadialGradientPaint(center, radius, dist, colors);          
            g.setPaint(gradient);         
            g.fill(new Ellipse2D.Double(x-(size/2), y-(size/2), size, size));

            g.setColor(Color.white);
            g.fill(new Ellipse2D.Double(x-(size/4), y-(size/4), size/2, size/2));            
        }
        
    }   
}
