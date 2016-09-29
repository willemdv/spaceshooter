/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractpart.pilot;

/**
 *
 * @author wdevoogd
 */
public class ConcretePilotForward extends AbstractPilot {

    public ConcretePilotForward() {
    }

    public ConcretePilotForward(float accelerate, float brake, float turnRate, float maxSpeed) {
        this.accelerate = accelerate;
        this.brake = brake;
        this.turnRate = turnRate;
        this.maxSpeed = maxSpeed;
    }

    public ConcretePilotForward(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
