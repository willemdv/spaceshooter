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
public class ConcreteTurretAtTarget implements AbstractTurret{
    
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

    public ConcreteTurretAtTarget(double x, double y, int size, int rateOfFire, boolean friendly) {
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
        this.angle = Math.atan2(engine.getPlayer().getPilot().getY()-(pilot.getY()+y), engine.getPlayer().getPilot().getX()-(pilot.getX()+x))*180/Math.PI;
        
    } 
    
    @Override
    public void fire() {        
        engine.getBullets().add(new Bullet(size,angle,0.25,pilot.getX()+x,pilot.getY()+y,friendly));        
    }
        
}
