/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;

/**
 *
 * @author wdevoogd
 */
public class ConcretePilotStrafe implements AbstractPilot{
    
    private long lastUpdate;
    private long now;
   
    private double angle;
    private double speed;
    private double x;
    private double y; 
    
    private int up;
    
    private final double GradenNaarRad = Math.PI / 180.0;

    public ConcretePilotStrafe(double speed, double x, double y) {
        this.angle = angle;
        this.speed = speed;
        this.x     = x;
        this.y     = y;
        lastUpdate = System.currentTimeMillis();  
        this.angle = 150;
        if(Math.random()<0.5){
            up=-1;
        }
        else{
            up=1;
        }
    }    
    
    public void move() {
        if(y<40 && up==-1){
            up=1;
        }
        if(y>580 && up==1){
            up=-1;
        }
        
        now = System.currentTimeMillis();        
        x += (Math.cos(angle * up * GradenNaarRad) * speed * (now-lastUpdate));
        y += (Math.sin(angle * up * GradenNaarRad) * speed * (now-lastUpdate));         
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
