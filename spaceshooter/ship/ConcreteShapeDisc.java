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
public class ConcreteShapeDisc implements AbstractShape{
    
    private int[][] xyPoints; 
    private double size;
    
    public ConcreteShapeDisc(double size){  
        this.size = size;
        xyPoints = new int[][] {{-18,-6},{-12,-12},{-6,-18},{0,-12},{0,12},{-6,18},{-12,12},{-18,6}};            
    }

    public Polygon getShape(double x, double y) {
        Polygon shape = new Polygon();
        for(int i=0;i<xyPoints.length;i++){
            shape.addPoint((int)(xyPoints[i][0]*size+x),(int)(xyPoints[i][1]*size+y));           
        }
        return shape;
    }
    
}
