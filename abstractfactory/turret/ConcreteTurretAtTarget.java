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
public class ConcreteTurretAtTarget extends AbstractTurret {

    public ConcreteTurretAtTarget(GameObject parent, Engine engine, float x, float y, int fireRate, int dmgMin, int dmgMax, float critChance, int imageId) {
        super(parent, engine, x, y, fireRate, dmgMin, dmgMax, critChance, imageId);
        if(parent.isFriendly()){
            angle = 0;
        }
        else{
            angle = 180;
        }
    
    }

    @Override
    public void aim() {
        this.angle = (float)(Math.atan2(engine.getPlayer().getY()-(parent.getY()+y), engine.getPlayer().getX()-(parent.getX()+x))*180/Math.PI);
    }
    
    
}
