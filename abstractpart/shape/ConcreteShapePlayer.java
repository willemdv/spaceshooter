/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractpart.shape;

/**
 *
 * @author wdevoogd
 */
public class ConcreteShapePlayer extends AbstractShape {

    public ConcreteShapePlayer(double size) {
        this.size = size;
        xyPoints = new int[][]{
            {6, 0}, {5, 1}, {3, 2}, {0, 2}, {-2, 3}, {-3, 5}, {-4, 6}, {-4, 5}, {-6, 3}, {-6, 1}, {-5, 1}, {-4, 1}, {-4, -1}, {-6, -1}, {-6, -3}, {-4, -5}, {-4, -6}, {-3, -5}, {-2, -3}, {0, -2}, {3, -2}, {5, -1}
        };
    }
}
