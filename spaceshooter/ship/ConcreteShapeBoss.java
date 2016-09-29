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
public class ConcreteShapeBoss implements AbstractShape{
    
    private int[][] xyPoints; 
    private double size;
    
    public ConcreteShapeBoss(double size){  
        this.size = size;
        xyPoints = new int[][] {{0,3},{-2,2},{-2,5},{5,15},{10,10},{7,5},{9,0},{7,-5},{10,-10},{5,-15},{-2,-5},{-2,-2},{0,-4}};          
    }

    public Polygon getShape(double x, double y) {
        Polygon shape = new Polygon();
        for(int i=0;i<xyPoints.length;i++){
            shape.addPoint((int)(xyPoints[i][0]*size+x),(int)(xyPoints[i][1]*size+y));           
        }
        return shape;
    }
    
}
