/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.ship;

import abstractfactory.turret.AbstractTurret;
import abstractfactory.turret.ConcreteTurretForward;
import abstractpart.pilot.AbstractPilot;
import abstractpart.pilot.ConcretePilotForward;
import abstractpart.shape.AbstractShape;
import abstractpart.shape.ConcreteShapeDisc;
import gameobject.main.GameObject;
import java.awt.Dimension;
import java.awt.Toolkit;
import main.Engine;

/**
 *
 * @author willem
 */
public class ConcreteEnemyFactoryBomber implements AbstractFactoryShip {

    @Override
    public AbstractPilot createPilot() {
        return new ConcretePilotForward((float) (Math.random() * 0.01 + 0.02));
    }

    @Override
    public AbstractShape createShape() {
        return new ConcreteShapeDisc(1);
    }

    @Override
    public AbstractTurret[] createTurrets(GameObject parent, Engine engine) {
        AbstractTurret[] turrets = new AbstractTurret[1];
        turrets[0] = new ConcreteTurretForward(parent, engine, -15, 0, 1500, 10, 20, 0.3f, 1);
        return turrets;
    }

    @Override
    public int getHealth() {
        return 100;
    }
}
