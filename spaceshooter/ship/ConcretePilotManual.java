/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;

/**
 *
 * @author wdevoogd
 */
public class ConcretePilotManual implements AbstractPilot{
    
    private long lastUpdate;
    private long now;
   
    private double angle;
    private double speed;
    private double x;
    private double y; 
    
    private final double GradenNaarRad = Math.PI / 180.0;
    
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private int[] direction;

    public ConcretePilotManual(double x, double y) {        
        this.x     = x;
        this.y     = y;
        lastUpdate = System.currentTimeMillis();     
        
        this.up=false;
        this.down=false;
        this.left=false;
        this.right=false;
        direction = new int[2];

    }    
    
    public void move() {           
        if(!up && !down && !left && !right){
            if(speed>0){
                speed -= 0.007;  
            }else{
                speed = 0;
            }  
        }
        else{
            if(speed<0.2){
                speed += 0.007;  
            }else{
                speed = 0.2;
            } 
            direction[0]=0;
            direction[1]=0;
            if(up){
               direction[1]-=1;
            }
            if(down){
               direction[1]+=1;
            }
            if(left){
               direction[0]-=1;
            }
            if(right){
               direction[0]+=1;
            } 
            angle = Math.atan2(direction[1], direction[0])*180/Math.PI;
        } 
        
        now = System.currentTimeMillis();        
        x += (Math.cos(angle * GradenNaarRad) * speed * (now-lastUpdate));
        y += (Math.sin(angle * GradenNaarRad) * speed * (now-lastUpdate));         
        lastUpdate = now;
    }
    
    public void setSpeed(double speed){
        this.speed = speed;        
    }
    
    public void setAngle(double angle){
        this.angle = angle;        
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

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
    
    
}
