/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;

/**
 *
 * @author willem
 */
public class ConcreteEnemyFactoryBomber implements AbstractFactoryShip {
   
    @Override
    public AbstractPilot createPilot(){
        return new ConcretePilotForward(180,Math.random()*0.02+0.04,1250,Math.random()*500+50); //starting angle,speed,x,y
    }

    @Override
    public AbstractShape createShape() {
        return new ConcreteShapeDisc(1);
    }

    @Override
    public AbstractTurret[] createTurrets() {
        AbstractTurret[] turrets = new AbstractTurret[1];
        turrets[0] = new ConcreteTurretForward(-15,0,15,5000,false);
        return turrets;
    }
    
}
