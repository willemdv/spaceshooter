/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractpart.pilot;

import gameobject.main.GameObject;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author wdevoogd
 */
public class ConcretePilotStrafe extends AbstractPilot {

    private float x;
    private float y;

    public ConcretePilotStrafe() {
    }

    public ConcretePilotStrafe(float accelerate, float brake, float turnRate, float maxSpeed) {
        this.accelerate = accelerate;
        this.brake = brake;
        this.turnRate = turnRate;
        this.maxSpeed = maxSpeed;
    }

    public ConcretePilotStrafe(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void getDirections(GameObject object) {
        now = System.currentTimeMillis();
        speed = object.getSpeed();
        heading = normalizeAngle(object.getAngle());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        x = object.getX();
        y = object.getY();
        
        if(heading == 180){
            if(Math.random()<0.5){
                heading = 150; 
            }
            else{
                heading = -150;
            }
        }
        if (heading > 180 && y < 50) {
            heading *= -1;
        }
        if (heading <= 180 && y > screenSize.height - 50) {
            heading *= -1;
        }
        setSpeeds();
        object.setSpeed(speed);
        object.setAngle(heading);
        lastUpdate = now;
    }

    public float normalizeAngle(float angle) {
        while (angle < 0) {
            angle += 360;
        }
        while (angle > 360) {
            angle %= 360;
        }
        return angle;
    }
}
