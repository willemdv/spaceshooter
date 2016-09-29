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
public class ConcreteTurretForward extends AbstractTurret {

    public ConcreteTurretForward(GameObject parent, Engine engine, float x, float y, int fireRate, int dmgMin, int dmgMax, float critChance, int imageId) {
        super(parent, engine, x, y, fireRate, dmgMin, dmgMax, critChance, imageId);
        if(parent.isFriendly()){
            angle = 0;
        }
        else{
            angle = 180;
        }
    
    }
}
