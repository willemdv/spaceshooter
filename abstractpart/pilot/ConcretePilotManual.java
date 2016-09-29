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
public class ConcretePilotManual extends AbstractPilot {

    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private int[] direction;

    public ConcretePilotManual() {
        this.up = false;
        this.down = false;
        this.left = false;
        this.right = false;
        direction = new int[2];
        this.maxSpeed = 0.2f;
        this.brake = 0.001f;
    }

    @Override
    public void getDirections(GameObject object) {
        now = System.currentTimeMillis();
        speed = object.getSpeed();

        if (up || down || left || right) {
            direction[0] = 0;
            direction[1] = 0;
            if (up) {
                direction[1] -= 1;
            }
            if (down) {
                direction[1] += 1;
            }
            if (left) {
                direction[0] -= 1;
            }
            if (right) {
                direction[0] += 1;
            }
            heading = (float) (Math.atan2(direction[1], direction[0]) * 180 / Math.PI);
            move = true;
        } else {
            move = false;
        }

        setSpeeds();
        object.setSpeed(speed);
        object.setAngle(heading);
        lastUpdate = now;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
