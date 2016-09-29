/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.ship;

import abstractfactory.turret.AbstractTurret;
import abstractpart.pilot.AbstractPilot;
import abstractpart.shape.AbstractShape;
import gameobject.main.GameObject;
import main.Engine;

/**
 *
 * @author willem
 */
public interface AbstractFactoryShip {

    AbstractPilot createPilot();

    AbstractShape createShape();

    AbstractTurret[] createTurrets(GameObject parent, Engine engine);
    
    int getHealth();
}
