/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractpart.shape;

import java.awt.Polygon;

/**
 *
 * @author wdevoogd
 */
public abstract class AbstractShape {

    protected int[][] xyPoints;
    protected double size;

    public Polygon getShape(double x, double y) {
        Polygon shape = new Polygon();
        for (int i = 0; i < xyPoints.length; i++) {
            shape.addPoint((int) (xyPoints[i][0] * size + x), (int) (xyPoints[i][1] * size + y));
        }
        return shape;
    }
}
