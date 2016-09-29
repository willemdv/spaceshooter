/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractpart.shape;

/**
 *
 * @author wdevoogd
 */
public class ConcreteShapeArrow extends AbstractShape {

    public ConcreteShapeArrow(double size) {
        this.size = size;
        this.xyPoints = new int[][]{{-30, 0}, {0, -10}, {4, 0}, {0, 10}};
    }
}
