/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.effect;

import gameobject.main.GameObject;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author wdevoogd
 */
public class Textfade extends GameObject {

    private int life;
    private float red;
    private float green;
    private float blue;
    private float alpha;
    private String string;
    private int size;

    public Textfade(float x, float y, float speed, float angle, Color color, int life, int size, String string) {
        super(x, y, speed, angle);
        this.life = life;
        red = color.getRed() / 255f;
        green = color.getGreen() / 255f;
        blue = color.getBlue() / 255f;
        alpha = color.getAlpha() / 255f;
        this.string = string;
        this.size = size;
    }

    public Textfade(float x, float y, float speed, float angle, Color color, int life, int size, int string) {
        super(x, y, speed, angle);
        this.life = life;
        red = color.getRed();
        green = color.getGreen();
        blue = color.getBlue();
        alpha = color.getAlpha();
        this.string = Integer.toString(string);
        this.size = size;
    }

    @Override
    public void update() {
        now = System.currentTimeMillis();
        time = now - lastUpdate;
        if (!withinBounds() || life < 0) {
            active = false;
        }
        if (active) {
            move();
            alpha -= ((float) time / (float) life) * alpha;
            if (alpha < 0) {
                alpha = 0;
            }
            life -= time;
        }
        lastUpdate = System.currentTimeMillis();
    }

    @Override
    public void draw(Graphics2D g) {
        Font font = new Font("IMPACT", Font.PLAIN, size);
        g.setFont(font);

        g.setColor(new Color(0,0,0,(int)alpha));
        g.drawString(string, x - 1, y - 1);
        g.drawString(string, x + 1, y - 1);
        g.drawString(string, x - 1, y + 1);
        g.drawString(string, x + 1, y + 1);

        color = new Color((int) red, (int) green, (int) blue, (int) alpha);
        g.setColor(color);
        g.drawString(string, x, y);
    }
}
