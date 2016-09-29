/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.ship;

import abstractfactory.turret.AbstractTurret;
import abstractfactory.turret.ConcreteTurretAtTarget;
import abstractfactory.turret.ConcreteTurretForward;
import abstractpart.pilot.AbstractPilot;
import abstractpart.pilot.ConcretePilotForward;
import abstractpart.shape.AbstractShape;
import abstractpart.shape.ConcreteShapeCruiser;
import gameobject.main.GameObject;
import java.awt.Dimension;
import java.awt.Toolkit;
import main.Engine;

/**
 *
 * @author willem
 */
public class ConcreteEnemyFactoryCruiser implements AbstractFactoryShip {

    @Override
    public AbstractPilot createPilot() {
        return new ConcretePilotForward((float) (Math.random() * 0.01 + 0.01));
    }

    @Override
    public AbstractShape createShape() {
        return new ConcreteShapeCruiser(2.5);
    }

    @Override
    public AbstractTurret[] createTurrets(GameObject parent, Engine engine) {
        AbstractTurret[] turrets = new AbstractTurret[3];
        turrets[0] = new ConcreteTurretAtTarget(parent, engine, -20, 0, 3000, 3, 8, 0.1f,7);
        turrets[1] = new ConcreteTurretAtTarget(parent, engine, 10, 0, 3000, 3, 8, 0.1f, 7);
        turrets[2] = new ConcreteTurretAtTarget(parent, engine, 40, 0, 3000, 3, 8, 0.1f, 7);
        return turrets;
    }
    
    @Override
    public int getHealth() {
        return 300;
    }
}
