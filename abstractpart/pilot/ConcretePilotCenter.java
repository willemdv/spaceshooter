/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractpart.pilot;

import gameobject.main.GameObject;

/**
 *
 * @author wdevoogd
 */
public class ConcretePilotCenter extends AbstractPilot {

    private float xLine;
    private float x;

    public ConcretePilotCenter(float accelerate, float brake, float turnRate, float maxSpeed, float xLine) {
        this.accelerate = accelerate;
        this.brake = brake;
        this.turnRate = turnRate;
        this.maxSpeed = maxSpeed;
        this.xLine = xLine;
    }

    public ConcretePilotCenter(float maxSpeed, float xLine) {
        this.maxSpeed = maxSpeed;
        this.xLine = xLine;
    }

    public void getDirections(GameObject object) {
        now = System.currentTimeMillis();
        speed = object.getSpeed();
        heading = object.getAngle();
        x = object.getX();
        if (move && x < xLine) {
            move = false;
        }
        setSpeeds();
        object.setSpeed(speed);
        lastUpdate = now;
    }
}
