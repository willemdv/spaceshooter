/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;

import spaceshooter.main.Engine;
import spaceshooter.player.Player;

/**
 *
 * @author willem
 */
public class ConcreteTurretForward implements AbstractTurret{
    
    private long lastUpdate;
    private long now;
    private int rateOfFire;    
    private double x;
    private double y;
    private double angle;
    private int size;
    private AbstractPilot pilot;
    private Engine engine;    
    private boolean friendly;
    
    public ConcreteTurretForward(double x, double y, int size, int rateOfFire,boolean friendly) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.rateOfFire = rateOfFire;
        lastUpdate = System.currentTimeMillis();
        this.friendly = friendly;
    }       
    

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setPilot(AbstractPilot pilot) {
        this.pilot = pilot;
    }
    
    @Override
    public void update() {
        now = System.currentTimeMillis();   
        if(now-lastUpdate>=rateOfFire){
            aim();
            fire();
            lastUpdate = now;
        }
    }
    
    @Override
    public void aim() {
        this.angle=180;
    } 
    
    @Override
    public void fire() {        
        engine.getBullets().add(new Bullet(size,angle,0.25,pilot.getX()+x,pilot.getY()+y, friendly));        
    }
        
}
