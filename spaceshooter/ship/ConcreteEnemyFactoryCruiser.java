/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;

/**
 *
 * @author willem
 */
public class ConcreteEnemyFactoryCruiser implements AbstractFactoryShip {
   
    @Override
    public AbstractPilot createPilot(){
        return new ConcretePilotForward(180,Math.random()*0.01+0.02,1250,Math.random()*500+50); //starting angle,speed,x,y
    }

    @Override
    public AbstractShape createShape() {
        return new ConcreteShapeCruiser(2.5);
    }

    @Override
    public AbstractTurret[] createTurrets() {
        AbstractTurret[] turrets = new AbstractTurret[3];
        turrets[0] = new ConcreteTurretAtTarget(-10,0,8,3600,false);
        turrets[1] = new ConcreteTurretAtTarget(0,0,8,3600,false);
        turrets[2] = new ConcreteTurretAtTarget(10,0,8,3600,false);
        return turrets;
    }
    
}
