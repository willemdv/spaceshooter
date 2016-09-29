/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.turret;

import gameobject.entity.Missile;
import gameobject.main.GameObject;
import java.util.Random;
import main.Engine;

/**
 *
 * @author wdevoogd
 */
public class ConcreteTurretManualMissile extends AbstractTurret {

    private boolean fire;
    private float angleOffSet;

    public ConcreteTurretManualMissile(GameObject parent, Engine engine, float x, float y, int fireRate, int dmgMin, int dmgMax, float critChance, int imageId, float angleOffSet) {
        super(parent, engine, x, y, fireRate, dmgMin, dmgMax, critChance, imageId);
        fire = false;
        this.angleOffSet = angleOffSet; 
    }

    @Override
    public void Update() {
        if (fire) {
            now = System.currentTimeMillis();
            if (now - lastFire >= fireRate) {
                aim();
                fire();
                lastFire = now;
            }
        }
    }

    @Override
    public void setFire(boolean fire) {
        this.fire = fire;
    }

    @Override
    public void aim() {
        angle = 0+angleOffSet;
    }
    
    @Override
    public void fire() {
        int damage;
        Random rgen = new Random();
        if (Math.random() < critChance) {
            damage = (rgen.nextInt(dmgMax - dmgMin) + dmgMin) * 3;
        } else {
            damage = rgen.nextInt(dmgMax - dmgMin) + dmgMin;
        }
        
        Missile missile = new Missile(x + parent.getX(), y + parent.getY(), parent.isFriendly(), angle-5f+(float)(Math.random()*10), 0.3f, (float) damage, imageId, engine);
        engine.getProjectiles().add(missile);
    }
}
