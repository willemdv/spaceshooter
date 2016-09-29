/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;

/**
 *
 * @author wdevoogd
 */
public interface AbstractPilot {
    public void move();
    public double getX();
    public double getY();
    public boolean withinBounds();
    public double getHeading();
}
