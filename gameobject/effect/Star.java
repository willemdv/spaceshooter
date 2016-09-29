/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.effect;

import gameobject.main.GameObject;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author wdevoogd
 */
public class Star extends GameObject {

    public Star(float x, float y, float speed, float angle) {
        super(x, y, speed, angle);
    }

    @Override
    public void draw(Graphics2D g) {
        color = new Color(0.5f, 1.0f, 1.0f, (float) Math.abs(Math.sin(x / 100 + y)));
        g.setColor(color);
        g.drawLine((int) x, (int) y, (int) x, (int) y);
    }
}
