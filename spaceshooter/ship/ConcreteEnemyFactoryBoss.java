/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;

/**
 *
 * @author willem
 */
public class ConcreteEnemyFactoryBoss implements AbstractFactoryShip {
   
    @Override
    public AbstractPilot createPilot(){
        return new ConcretePilotCenter(180,Math.random()*0.01+0.01,1250,300); //starting angle,speed,x,y
    }

    @Override
    public AbstractShape createShape() {
        return new ConcreteShapeBoss(10);
    }

    @Override
    public AbstractTurret[] createTurrets() {
        AbstractTurret[] turrets = new AbstractTurret[8];
        turrets[0] = new ConcreteTurretAtTarget(45,-105,12,1600,false);
        turrets[1] = new ConcreteTurretAtTarget(30,-75,12,1600,false);
        turrets[2] = new ConcreteTurretAtTarget(15,-45,12,1600,false);
        turrets[3] = new ConcreteTurretAtTarget(0,-15,12,1600,false);
        turrets[4] = new ConcreteTurretAtTarget(0,15,12,1600,false);
        turrets[5] = new ConcreteTurretAtTarget(15,45,12,1600,false);
        turrets[6] = new ConcreteTurretAtTarget(30,75,12,1600,false);        
        turrets[7] = new ConcreteTurretAtTarget(45,105,12,1600,false);
        return turrets;
    }
    
}
