/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.main;

import gameobject.effect.Smoke;
import gameobject.effect.Textfade;
import gameobject.entity.Enemy;
import gameobject.entity.Player;
import java.awt.Color;
import main.Engine;

/**
 *
 * @author wdevoogd
 */
public class CollisionHandler {

    private Engine engine;

    public CollisionHandler(Engine engine) {
        this.engine = engine;
    }

    public void update() {

        for (GameObject o1 : engine.getProjectiles().getObjectList()) {
            if (o1 instanceof Projectile && o1.isFriendly() && o1.getActive()) {
                Projectile projectile = (Projectile) o1;
                for (GameObject o2 : engine.getEnemys().getObjectList()) {
                    if (o2 instanceof Enemy && o2.getActive()) {
                        Enemy enemy = (Enemy) o2;
                        if (enemy.getPolygon().contains(projectile.getX(), projectile.getY())) {
                            enemy.addHealth((int) projectile.getDamage() * -1);
                            o1.setActive(false);
                            engine.getFrontEffects().add(new Textfade(projectile.getX(), projectile.getY(), 0.10f, (float) (Math.random() * 360), Color.RED, 600, (int)(20+projectile.getDamage()/4), (int) projectile.getDamage()));
                            engine.getFrontEffects().add(new Smoke(projectile.getX(), projectile.getY(),500,projectile.getDamage(),0.4f));                        
                              
                        }
                    }
                }
            } else if (o1 instanceof Projectile && !o1.isFriendly() && o1.getActive()) {
                Projectile projectile = (Projectile) o1;
                Player player = engine.getPlayer();
                if (player.getPolygon().contains(projectile.getX(), projectile.getY())) {
                    player.addHealth((int) projectile.getDamage() * -1);
                    o1.setActive(false);
                    engine.getFrontEffects().add(new Textfade(projectile.getX(), projectile.getY(), 0.10f, (float) (Math.random() * 360), Color.RED, 600, (int)(20+projectile.getDamage()/4), (int) projectile.getDamage()));
                    engine.getFrontEffects().add(new Smoke(projectile.getX(), projectile.getY(),500,projectile.getDamage(),0.4f));                      
                }
            }

        }
    }
}
