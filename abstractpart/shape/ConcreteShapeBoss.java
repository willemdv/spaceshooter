/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractpart.shape;

/**
 *
 * @author wdevoogd
 */
public class ConcreteShapeBoss extends AbstractShape {

    public ConcreteShapeBoss(double size) {
        this.size = size;
        xyPoints = new int[][]{{0, 3}, {-2, 2}, {-2, 5}, {5, 15}, {10, 10}, {7, 5}, {9, 0}, {7, -5}, {10, -10}, {5, -15}, {-2, -5}, {-2, -2}, {0, -4}};
    }
}
