/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.entity;

import gameobject.effect.Smoke;
import gameobject.main.Drawable;
import gameobject.main.GameObject;
import gameobject.main.Projectile;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import main.Engine;

/**
 *
 * @author wdevoogd
 */
public class Missile extends GameObject implements Drawable,Projectile{

    private float damage;
    private Polygon shape;
    private Engine engine;
    private GameObject target;
    private float turnRate;

    public Missile(float x, float y, boolean friendly, float angle, float speed, float damage, int imageId, Engine engine) {
        this.friendly = friendly;
        this.angle = angle;
        this.speed = speed;
        this.damage = damage;
        this.engine = engine;
        int[] xPoints = new int[]{-4,0,-4,15};
        int[] yPoints = new int[]{3,0,-3,0};     
        shape = new Polygon(xPoints,yPoints,4);
        this.x = x;
        this.y = y;
        turnRate = 0.5f;
    }

    @Override
    public void draw(Graphics2D g) {
        AffineTransform at = new AffineTransform();        
        at.translate(x, y);
        at.rotate(Math.toRadians(angle));
        Shape shape2 = at.createTransformedShape(shape);       
        g.setColor(Color.GRAY);
        g.fill(shape2);
    }
    
    @Override
    public void update() {
        now = System.currentTimeMillis();
        time = now - lastUpdate;   
        engine.getBackEffects().add(new Smoke(x,y,100,2,0.3f));
        if (!withinBounds()) {
            active = false;
        }
        if (active) {
            if(target==null || !target.getActive()){
                target = target();
            }
            if(target!=null){
                aim(target);
            }
            move();
        }
        lastUpdate = System.currentTimeMillis();
    }
    
    public GameObject target(){
        double distanceS = 99999;
        double distance;    
        Point2D.Float missilePoint = new Point2D.Float(x,y);
        Point2D.Float targetPoint;  
        GameObject target = null;
        if(engine.getEnemys().getObjectList().size()>0){
            for(GameObject gameObject:engine.getEnemys().getObjectList()){                
                targetPoint = new Point2D.Float(gameObject.getX(),gameObject.getY()); 
                distance = missilePoint.distance(targetPoint);
                if(distance < distanceS){
                    distanceS = distance;
                    target = gameObject;
                }            
            }           
        }  
        return target;
    }
    
    public void aim(GameObject target){
        double aimDirection = Math.atan2(target.getY()-y, target.getX()-x)*180 / Math.PI;
        
        if(Math.abs(angle+360-aimDirection)<Math.abs(angle-aimDirection)){
            if(angle+360<aimDirection){
                angle+=turnRate;
            }
            else if(angle+360>aimDirection){
                angle-=turnRate;                    
            } 
            if(Math.abs(angle+360-aimDirection)>5){
                if(speed>0.2){
                    speed -= 0.001;
                }
            }
            else{
                if(speed<0.7){
                    speed += 0.01;
                }
            }
        }
        else{
            if(angle<aimDirection){
                angle+=turnRate;
            }
            else if(angle>aimDirection){
                angle-=turnRate;                    
            }  
            if(Math.abs(angle-aimDirection)>5){
                if(speed>0.2){
                    speed -= 0.001;
                }
            }
            else{
                if(speed<0.7){
                    speed += 0.01;
                }
            }
        }
        
    }

    @Override
    public float getDamage() {
        return damage;
    }
}
