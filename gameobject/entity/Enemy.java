/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.entity;

import abstractfactory.ship.AbstractFactoryShip;
import abstractfactory.turret.AbstractTurret;
import abstractpart.pilot.AbstractPilot;
import abstractpart.shape.AbstractShape;
import gameobject.effect.Ring;
import gameobject.effect.Spark;
import gameobject.effect.Textfade;
import gameobject.main.GameObject;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import main.Engine;

/**
 *
 * @author wdevoogd
 */
public class Enemy extends GameObject {

    private AbstractShape shape;
    private AbstractPilot pilot;
    private AbstractTurret[] turrets;
    private int health;
    private int score;
    private Engine engine;
    
    public Enemy(float x, float y, AbstractFactoryShip factory, Engine engine) {
        super(x, y);
        shape = factory.createShape();
        pilot = factory.createPilot();
        turrets = factory.createTurrets(this, engine);
        health = factory.getHealth();
        score = 100;
        this.engine = engine;
    }

    @Override
    public void update() {
        now = System.currentTimeMillis();
        time = now - lastUpdate;   
        if (health<=0 && active){
            engine.getGameInfo().addScore(score);
            active = false;
            engine.getFrontEffects().add(new Textfade(x,y, 0.10f, -90f, Color.GREEN, 900, 25, score));
            engine.getBackEffects().add(new Spark(x,y,300));
            engine.getBackEffects().add(new Ring(x,y,400));
        }
        if (!withinBounds()) {
            active = false;            
        }     
        if (active) {
            move();
            pilot.getDirections(this);
            for (AbstractTurret turret : turrets) {
                turret.Update();
            }     
        }
        lastUpdate = System.currentTimeMillis();
    }

    @Override
    public void draw(Graphics2D g) {
        Polygon polygons = shape.getShape(x, y);
        g.setColor(new Color(0.5f, 0.5f, 0.5f, 1f));
        g.fill(polygons);
        g.setStroke(new BasicStroke(2f));
        g.setColor(new Color(1.0f, 1.0f, 1.0f, 0.5f));
        g.draw(polygons);
    }

    public Polygon getPolygon() {
        return shape.getShape(x, y);
    }
    
    public void addHealth(int health){
        this.health += health;
    }

    public int getScore() {
        return score;
    }   
    
    
}
