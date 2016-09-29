/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractpart.shape;

/**
 *
 * @author wdevoogd
 */
public class ConcreteShapeCruiser extends AbstractShape {

    public ConcreteShapeCruiser(double size) {
        this.size = size;
        xyPoints = new int[][]{
            {-10, 2}, {0, 3}, {2, 5}, {2, 3}, {12, 4}, {12, 6}, {7, 6}, {7, 8}, {24, 8}, {24, 6}, {14, 6}, {14, 4}, {24, 5}, {24, -5}, {14, -4}, {14, -6}, {24, -6}, {24, -8}, {7, -8}, {7, -6}, {12, -6}, {12, -4}, {2, -3}, {2, -5}, {0, -3}, {-10, -2}
        };
    }
}
