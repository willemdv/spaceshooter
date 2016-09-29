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
public class ConcreteShapeArrow implements AbstractShape{
    
    private int[][] xyPoints; 
    private double size;
        
    public ConcreteShapeArrow(double size){  
        this.size = size;
        xyPoints = new int[][] {{-30,0},{0,-10},{4,0},{0,10}};       
    }

    public Polygon getShape(double x, double y) {
        Polygon shape = new Polygon();
        for(int i=0;i<xyPoints.length;i++){
            shape.addPoint((int)(xyPoints[i][0]*size+x),(int)(xyPoints[i][1]*size+y));           
        }
        return shape;
    }
    
}
