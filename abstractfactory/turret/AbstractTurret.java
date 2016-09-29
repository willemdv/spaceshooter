/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.turret;

import gameobject.effect.Smoke;
import gameobject.entity.Bullet;
import gameobject.entity.Missile;
import gameobject.main.GameObject;
import java.util.Random;
import main.Engine;

/**
 *
 * @author wdevoogd
 */
public abstract class AbstractTurret {

    protected GameObject parent;
    protected Engine engine;
    protected float x;
    protected float y;
    protected int fireRate;
    protected long lastFire;
    protected long now;
    protected int dmgMin;
    protected int dmgMax;
    protected float critChance;
    protected float angle;
    protected int imageId;

    public AbstractTurret(GameObject parent, Engine engine, float x, float y, int fireRate, int dmgMin, int dmgMax, float critChance, int imageId) {
        this.parent = parent;
        this.engine = engine;
        this.x = x;
        this.y = y;
        this.fireRate = fireRate;
        this.dmgMin = dmgMin;
        this.dmgMax = dmgMax;
        this.critChance = critChance;
        this.now = System.currentTimeMillis();
        this.lastFire = now;
        this.imageId = imageId;
    }

    public void Update() {
        now = System.currentTimeMillis();
        if (now - lastFire >= fireRate) {
            aim();
            fire();
            lastFire = now;
        }
    }

    public void fire() {
        int damage;
        Random rgen = new Random();
        if (Math.random() < critChance) {
            damage = (rgen.nextInt(dmgMax - dmgMin) + dmgMin) * 3;
        } else {
            damage = rgen.nextInt(dmgMax - dmgMin) + dmgMin;
        }
        engine.getFrontEffects().add(new Smoke(x + parent.getX(), y + parent.getY(), 50, 15, 0.2f));
        Bullet bullet = new Bullet(x + parent.getX(), y + parent.getY(), parent.isFriendly(), angle, 0.5f, (float) damage, imageId, engine);
        engine.getProjectiles().add(bullet);
    }

    public void aim() {
        
    }
    
    public void setFire(boolean bool){        
    }
}
