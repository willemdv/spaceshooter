/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.ship;

import abstractfactory.turret.AbstractTurret;
import abstractfactory.turret.ConcreteTurretManual;
import abstractfactory.turret.ConcreteTurretManualMissile;
import abstractpart.pilot.AbstractPilot;
import abstractpart.pilot.ConcretePilotManual;
import abstractpart.shape.AbstractShape;
import abstractpart.shape.ConcreteShapePlayer;
import gameobject.main.GameObject;
import main.Engine;

/**
 *
 * @author willem
 */
public class ConcreteFactoryPlayer implements AbstractFactoryShip {

    @Override
    public AbstractPilot createPilot() {
        return new ConcretePilotManual();
    }

    @Override
    public AbstractShape createShape() {
        return new ConcreteShapePlayer(3);
    }

    @Override
    public AbstractTurret[] createTurrets(GameObject parent, Engine engine) {
        AbstractTurret[] turrets = new AbstractTurret[4];
        turrets[0] = new ConcreteTurretManualMissile(parent, engine, -10, 10, 150, 2, 4, 0.1f, 3, -60);
        turrets[1] = new ConcreteTurretManual(parent, engine, 0, 5, 150, 10, 30, 0.1f, 3);
        turrets[2] = new ConcreteTurretManual(parent, engine, 0, -5, 150, 10, 30, 0.1f, 3);
        turrets[3] = new ConcreteTurretManualMissile(parent, engine, -10, -10, 150, 2, 4, 0.1f, 3, 60);
        return turrets;
    }
    
    @Override
    public int getHealth() {
        return 100;
    }
}
