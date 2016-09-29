/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import spaceshooter.effects.AbstractEffect;
import spaceshooter.effects.ConcreteEffectExplosion;
import spaceshooter.effects.Effects;

/**
 *
 * @author wdevoogd
 */
public class Bullets{
    private long lastUpdate;
    private long now;
    private int enemyInterval;
    private ArrayList<Bullet> bulletList;
    private Effects effects;
   
    public Bullets(Effects effects){
        lastUpdate = System.currentTimeMillis(); 
        bulletList = new ArrayList();
        this.effects = effects;
    }
    
    public void update(){     
        for(Bullet bullet:bulletList){
            bullet.update();
        } 
        //remove dead bullets
        clean();
    }
    
    public void clean(){
       ArrayList<Bullet> removeList = new ArrayList();
       for(Bullet bullet:bulletList){
            if(!bullet.isAlive()){
                removeList.add(bullet);
            }
       }   
       bulletList.removeAll(removeList);
       removeList.clear();
    }
    
    public void add(Bullet bullet){  
        AbstractEffect effect = (AbstractEffect) new ConcreteEffectExplosion(bullet.getX(), bullet.getY(), bullet.getSize(), bullet.getSize()/500f, 1000);
        effects.add(effect);
        bulletList.add(bullet);
    } 
    
    public void draw(Graphics2D g){
        for(Bullet bullet:bulletList){
            bullet.draw(g);            
       }  
    }

    public ArrayList<Bullet> getBulletList() {
        return bulletList;
    }
    
    
    
}
