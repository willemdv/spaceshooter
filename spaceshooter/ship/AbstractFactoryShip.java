/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;


/**
 *
 * @author willem
 */
public interface AbstractFactoryShip {
    AbstractPilot createPilot();
    AbstractShape createShape();
    AbstractTurret[] createTurrets();
}
