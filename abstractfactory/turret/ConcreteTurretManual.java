/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.turret;

import gameobject.main.GameObject;
import main.Engine;

/**
 *
 * @author wdevoogd
 */
public class ConcreteTurretManual extends AbstractTurret {

    private boolean fire;

    public ConcreteTurretManual(GameObject parent, Engine engine, float x, float y, int fireRate, int dmgMin, int dmgMax, float critChance, int imageId) {
        super(parent, engine, x, y, fireRate, dmgMin, dmgMax, critChance, imageId);
        fire = false;
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
        angle = 0;
    }
    
}
