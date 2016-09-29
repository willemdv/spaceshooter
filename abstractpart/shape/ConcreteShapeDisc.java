/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractpart.shape;

/**
 *
 * @author wdevoogd
 */
public class ConcreteShapeDisc extends AbstractShape {

    public ConcreteShapeDisc(double size) {
        this.size = size;
        xyPoints = new int[][]{{-18, -6}, {-12, -12}, {-6, -18}, {0, -12}, {0, 12}, {-6, 18}, {-12, 12}, {-18, 6}};
    }
}
