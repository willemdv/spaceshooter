/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import spaceshooter.main.Engine;

/**
 *
 * @author willem
 */
public class Enemy{       
    private AbstractPilot pilot;
    private AbstractShape shape;
    private AbstractTurret[] turrets;            
    private boolean alive;
    private Engine engine;    
    private int health;

    public Enemy(AbstractFactoryShip factory, Engine engine, int health){
        alive = true;       
        this.health = health;
        pilot = factory.createPilot();
        shape = factory.createShape();
        turrets = factory.createTurrets();
        
        this.engine=engine;        
        
        for(AbstractTurret turret:turrets){
            turret.setPilot(pilot);
            turret.setEngine(engine);
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public void update(){        
        pilot.move();   
        if(!pilot.withinBounds() || health<0){
            alive = false;
        }
        for(AbstractTurret turret:turrets){
            turret.update();
        }
    }

    public AbstractPilot getPilot() {
        return pilot;
    }

    public AbstractShape getShape() {
        return shape;
    }

    public AbstractTurret[] getTurrets() {
        return turrets;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void addHealth(int health){
        this.health += health;
    }
    
    public void draw(Graphics2D g){
        Polygon polygons = shape.getShape(pilot.getX(), pilot.getY()); //create polyon with shape at location                
        g.setColor(new Color(0.5f,0.5f,0.5f,1f));
        g.fill(polygons);
        
        g.setStroke(new BasicStroke(2f));
        g.setColor(new Color(1.0f,1.0f,1.0f,0.5f));
        g.draw(polygons);        
        
    }
    
}
