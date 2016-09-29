/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;

/**
 *
 * @author willem
 */
public abstract class GameObject {

    protected boolean active;
    protected boolean friendly = false;
    protected float x;
    protected float y;
    protected float size;
    protected float speed;
    protected long lastUpdate;
    protected long now;
    protected long time;
    protected float angle;
    protected Color color;
    protected final double GradenNaarRad = Math.PI / 180.0;

    public GameObject(float x, float y, float speed, float angle) {
        active = true;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.angle = angle;
        now = System.currentTimeMillis();
        lastUpdate = now;
    }

    public GameObject(float x, float y) {
        active = true;
        this.x = x;
        this.y = y;
        this.speed = 0.05f;
        this.angle = 180;
        now = System.currentTimeMillis();
        lastUpdate = now;
    }

    public GameObject() {
        active = true;
        this.x = 0;
        this.y = 0;
        this.speed = 0.05f;
        this.angle = 180;
        now = System.currentTimeMillis();
        lastUpdate = now;
    }

    public abstract void draw(Graphics2D g);

    public void update() {
        now = System.currentTimeMillis();
        time = now - lastUpdate;        
        if (!withinBounds()) {
            active = false;
        }
        if (active) {
            move();
        }
        lastUpdate = System.currentTimeMillis();
    }

    public void move() {
        now = System.currentTimeMillis();
        x += (Math.cos(angle * GradenNaarRad) * speed * time);
        y += (Math.sin(angle * GradenNaarRad) * speed * time);        
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean withinBounds() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        if (x < 0 || x > screen.width + 100 || y < 0 || y > screen.height) {
            return false;
        } else {
            return true;
        }
    }

    public void returnToBounds() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        if (x < 20) {
            x = 20;
        }
        if (x > screen.width - 20) {
            x = screen.width - 20;
        }
        if (y < 20) {
            y = 20;
        }
        if (y > screen.height - 20) {
            y = screen.height - 20;
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public boolean isFriendly() {
        return friendly;
    }

    public void setFriendly(boolean friendly) {
        this.friendly = friendly;
    }
}
