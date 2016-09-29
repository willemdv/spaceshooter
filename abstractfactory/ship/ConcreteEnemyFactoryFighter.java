/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.ship;

import abstractfactory.turret.AbstractTurret;
import abstractfactory.turret.ConcreteTurretForward;
import abstractpart.pilot.AbstractPilot;
import abstractpart.pilot.ConcretePilotStrafe;
import abstractpart.shape.AbstractShape;
import abstractpart.shape.ConcreteShapeArrow;
import gameobject.main.GameObject;
import main.Engine;

/**
 *
 * @author willem
 */
public class ConcreteEnemyFactoryFighter implements AbstractFactoryShip {

    @Override
    public AbstractPilot createPilot() {
        return new ConcretePilotStrafe((float) (Math.random() * 0.04 + 0.08));
    }

    @Override
    public AbstractShape createShape() {
        return new ConcreteShapeArrow(1);
    }

    @Override
    public AbstractTurret[] createTurrets(GameObject parent, Engine engine) {
        AbstractTurret[] turrets = new AbstractTurret[1];
        turrets[0] = new ConcreteTurretForward(parent, engine, -15, 0, 1000, 5, 10, 0.1f, 6);
        return turrets;
    }
    
    @Override
    public int getHealth() {
        return 80;
    }
}
