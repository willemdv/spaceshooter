/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.effects;

import java.awt.Graphics2D;

/**
 *
 * @author wdevoogd
 */
public abstract class AbstractEffect{
    abstract boolean isActive();
    abstract void update();
    abstract void draw(Graphics2D g);
}
