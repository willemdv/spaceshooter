/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.ship;

import abstractfactory.turret.AbstractTurret;
import abstractfactory.turret.ConcreteTurretAtTarget;
import abstractfactory.turret.ConcreteTurretAtTarget;
import abstractpart.pilot.ConcretePilotCenter;
import abstractpart.shape.ConcreteShapeBoss;
import gameobject.main.GameObject;
import java.awt.Toolkit;
import main.Engine;

/**
 *
 * @author willem
 */
public class ConcreteEnemyFactoryBoss implements AbstractFactoryShip {

    @Override
    public abstractpart.pilot.AbstractPilot createPilot() {
        return new ConcretePilotCenter((float) (Math.random() * 0.01 + 0.01),(float)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2f));
    }

    @Override
    public abstractpart.shape.AbstractShape createShape() {
        return new ConcreteShapeBoss(10);
    }

    @Override
    public AbstractTurret[] createTurrets(GameObject parent, Engine engine) {
        AbstractTurret[] turrets = new AbstractTurret[8];
        turrets[0] = new ConcreteTurretAtTarget(parent, engine, 30, -80, 1000, 5, 15, 0.1f, 9);
        turrets[1] = new ConcreteTurretAtTarget(parent, engine, 15, -60, 1100, 5, 15, 0.1f, 9);
        turrets[2] = new ConcreteTurretAtTarget(parent, engine, 0, -40, 1200, 5, 15, 0.1f, 9);
        turrets[3] = new ConcreteTurretAtTarget(parent, engine, -15, -20, 1300, 5, 15, 0.1f, 9);
        turrets[4] = new ConcreteTurretAtTarget(parent, engine, -15, 20, 1300, 5, 15, 0.1f, 9);
        turrets[5] = new ConcreteTurretAtTarget(parent, engine, 0, 40, 1200, 5, 15, 0.1f, 9);
        turrets[6] = new ConcreteTurretAtTarget(parent, engine, 15, 60, 1100, 5, 15, 0.1f, 9);
        turrets[7] = new ConcreteTurretAtTarget(parent, engine, 30, 80, 1000, 5, 15, 0.1f, 9);
        
        return turrets;
    }
    
    @Override
    public int getHealth() {
        return 2000;
    }
}
