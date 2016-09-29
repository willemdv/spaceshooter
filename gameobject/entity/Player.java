/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.entity;

import abstractfactory.ship.AbstractFactoryShip;
import abstractfactory.ship.ConcreteFactoryPlayer;
import abstractfactory.turret.AbstractTurret;
import abstractfactory.turret.ConcreteTurretManual;
import abstractfactory.turret.ConcreteTurretManualMissile;
import abstractpart.pilot.ConcretePilotManual;
import abstractpart.shape.AbstractShape;
import gameobject.effect.Shield;
import gameobject.effect.Smoke;
import gameobject.main.Drawable;
import gameobject.main.GameObject;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import main.Engine;
import main.Observer;

/**
 *
 * @author willem
 */
public class Player extends GameObject implements Drawable, Observer {

    private AbstractShape shape;
    private ConcretePilotManual pilot;
    private Dimension screenSize;
    private AbstractTurret[] turrets;
    private int health;
    private Engine engine;
    private Shield shield;
    
    public Player(Engine engine) {
        friendly = true;
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        AbstractFactoryShip factory = new ConcreteFactoryPlayer();
        shape = factory.createShape();
        pilot = (ConcretePilotManual) factory.createPilot();
        turrets = factory.createTurrets(this, engine);
        shield = new Shield(40,800,this);
        this.engine = engine;
        engine.getGUI().addObserver((Observer) this);
        angle = 0;
        speed = 0;
        pilot.setMove(false);
        reset();
    }

    @Override
    public void update() {
        now = System.currentTimeMillis();
        time = now - lastUpdate;    
        pilot.getDirections(this);
        for (AbstractTurret turret : turrets) {
            turret.Update();
        }
        shield.update();
        returnToBounds();

        if (active) {
            engine.getBackEffects().add(new Smoke(x-15,y-5,100,6,0.5f,0.75f,180f));
            engine.getBackEffects().add(new Smoke(x-15,y+5,100,6,0.5f,0.75f,180f));
            move();
        }
        if (health<0) {
            reset();
            engine.getGameInfo().addlives(-1);
        }
        lastUpdate = System.currentTimeMillis();
    }

    @Override
    public void draw(Graphics2D g) {
        shield.draw(g);
        Polygon polygons = shape.getShape(x, y);
        g.setColor(new Color(0.5f, 0.5f, 0.5f, 1f));
        g.fill(polygons);
        g.setStroke(new BasicStroke(2f));
        g.setColor(new Color(1.0f, 1.0f, 1.0f, 0.5f));
        g.draw(polygons);        
    }

    public void reset() {
        x = 100;
        y = screenSize.height / 2;
        health = 100;
    }

    @Override
    public void update(KeyEvent e, Boolean bool) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pilot.setUp(bool);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pilot.setDown(bool);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pilot.setRight(bool);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pilot.setLeft(bool);
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            for (AbstractTurret turret : turrets) {
                turret.setFire(bool);
            }
        }

    }
    
    public Polygon getPolygon() {
        return shape.getShape(x, y);
    }
    
    public void addHealth(int health){
        this.health += health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    
    
}
