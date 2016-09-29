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
public class ConcreteShapePlayer implements AbstractShape{
    
    private int[][] xyPoints; 
    private double size;
        
    public ConcreteShapePlayer(double size){  
        this.size = size;
        xyPoints = new int[][] {
        {6,0}
        ,{5,1}
        ,{3,2}
        ,{0,2}
        ,{-2,3}
        ,{-3,5}
        ,{-4,6}
        ,{-4,5}
        ,{-6,3}
        ,{-6,1}
        ,{-5,1}
        ,{-4,1}
        ,{-4,-1}
        ,{-6,-1}
        ,{-6,-3}
        ,{-4,-5}
        ,{-4,-6}
        ,{-3,-5}
        ,{-2,-3}
        ,{0,-2}
        ,{3,-2}
        ,{5,-1}
        };       
    }

    public Polygon getShape(double x, double y) {
        Polygon shape = new Polygon();
        for(int i=0;i<xyPoints.length;i++){
            shape.addPoint((int)(xyPoints[i][0]*size+x),(int)(xyPoints[i][1]*size+y));           
        }
        return shape;
    }
    
}
