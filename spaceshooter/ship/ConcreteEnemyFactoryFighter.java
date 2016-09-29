/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;

/**
 *
 * @author willem
 */
public class ConcreteEnemyFactoryFighter implements AbstractFactoryShip {
   
    @Override
    public AbstractPilot createPilot(){
        return new ConcretePilotStrafe(Math.random()*0.03+0.08,1250,Math.random()*500+50); //speed,x,y
    }

    @Override
    public AbstractShape createShape() {
        return new ConcreteShapeArrow(1);
    }

    @Override
    public AbstractTurret[] createTurrets() {
        AbstractTurret[] turrets = new AbstractTurret[2];
        turrets[0] = new ConcreteTurretForward(-10,-5,4,1600,false);
        turrets[1] = new ConcreteTurretForward(-10,5,4,1600,false);
        return turrets;
    }
    
}
