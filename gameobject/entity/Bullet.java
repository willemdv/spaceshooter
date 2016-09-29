/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.entity;

import gameobject.main.Drawable;
import gameobject.main.GameObject;
import gameobject.main.Projectile;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.Engine;

/**
 *
 * @author wdevoogd
 */
public class Bullet extends GameObject implements Drawable,Projectile{

    private float damage;
    private BufferedImage image;
    private Engine engine;

    public Bullet(float x, float y, boolean friendly, float angle, float speed, float damage, int imageId, Engine engine) {
        this.friendly = friendly;
        this.angle = angle;
        this.speed = speed;
        this.damage = damage;
        this.engine = engine;
        this.image = engine.getRecources().getImage(imageId);
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(image, (int) (x - (image.getWidth() / 2f)), (int) (y - (image.getHeight() / 2f)), null);
    }

    @Override
    public float getDamage() {
        return damage;
    }
}
