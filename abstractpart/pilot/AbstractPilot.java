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
public abstract class AbstractPilot {

    protected float accelerate = 0.01f;
    protected float brake = 0.01f;
    protected float turnRate = 1f;
    protected float maxSpeed = 0.05f;
    protected final double GradenNaarRad = Math.PI / 180.0;
    protected long now = System.currentTimeMillis();
    protected long lastUpdate = now;
    protected boolean move = true;
    protected float speed;
    protected float heading;

    public void getDirections(GameObject object) {
        now = System.currentTimeMillis();
        speed = object.getSpeed();
        heading = object.getAngle();
        setSpeeds();
        object.setSpeed(speed);
        lastUpdate = now;
    }

    public void setSpeeds() {
        if (move) {
            speedUp();
        } else {
            slowDown();
        }
    }

    public void speedUp() {
        if (speed == maxSpeed) {
        } else if (speed + (accelerate * (now - lastUpdate)) < maxSpeed) {
            speed += accelerate * (now - lastUpdate);
        } else if (speed < maxSpeed) {
            speed = maxSpeed;
        }
    }

    public void slowDown() {
        if (speed == 0) {
        } else if (speed - (brake * (now - lastUpdate)) > 0) {
            speed -= brake * (now - lastUpdate);
        } else if (speed > 0) {
            speed = 0;
        }
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }
}
