/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;

/**
 *
 * @author wdevoogd
 */
public class ConcretePilotCenter implements AbstractPilot{
    
    private long lastUpdate;
    private long now;
   
    private double angle;
    private double speed;
    private double x;
    private double y; 
    
    private final double GradenNaarRad = Math.PI / 180.0;

    public ConcretePilotCenter(double angle, double speed, double x, double y) {
        this.angle = angle;
        this.speed = speed;
        this.x     = x;
        this.y     = y;
        lastUpdate = System.currentTimeMillis();           
    }    
    
    public void move() {
        now = System.currentTimeMillis();   
        if(x>850){
            x += (Math.cos(angle * GradenNaarRad) * speed * (now-lastUpdate));
            y += (Math.sin(angle * GradenNaarRad) * speed * (now-lastUpdate));    
        }
        lastUpdate = now;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
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
    public double getHeading() {
        return this.angle;
    }
    
}
