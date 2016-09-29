/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;

import java.awt.Polygon;
/**
 *
 * @author wdevoogd
 */
public interface AbstractShape {
    public Polygon getShape(double x, double y);
}
