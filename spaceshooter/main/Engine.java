/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.main;

import spaceshooter.player.*;
import spaceshooter.effects.Effects;
import spaceshooter.ship.Bullets;
import spaceshooter.ship.Enemys;

import java.awt.*;
import spaceshooter.effects.ConcreteEffectExplosion;
import spaceshooter.ship.Bullet;
import spaceshooter.ship.Enemy;
/**
 *
 * @author wdevoogd
 */
public class Engine {
    
    private HUD hud;
    private Bullets bullets;
    private Enemys enemys;
    private Effects effects;
    private Player player;
    private GUI gui;
    
    public Engine(GUI gui){           
        this.gui = gui;
        player = new Player(this);
        effects = new Effects();  
        bullets = new Bullets(effects);
        enemys = new Enemys(3000, this); 
        hud = new HUD(this);
        
    }
    
    public void update(){
        bullets.update();
        enemys.update(); 
        effects.update();
        player.update();
        collisionDetection();
    }
    
    public void draw(Graphics2D g){        
        effects.draw(g);         
        enemys.draw(g);  
        bullets.draw(g);  
        player.draw(g); 
        hud.draw(g);
    }

    public Bullets getBullets() {
        return bullets;
    }

    public void setBullets(Bullets bullets) {
        this.bullets = bullets;
    }

    public Enemys getEnemys() {
        return enemys;
    }

    public void setEnemys(Enemys enemys) {
        this.enemys = enemys;
    }

    public Effects getEffects() {
        return effects;
    }

    public void setEffects(Effects effects) {
        this.effects = effects;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public GUI getGui() {
        return gui;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    } 
    
    public void collisionDetection(){
        for(Bullet bullet:bullets.getBulletList()){
            if(bullet.isFriendly() && bullet.isAlive()){
                for(Enemy enemy:enemys.getEnemyList()){
                    if(enemy.getShape().getShape(enemy.getPilot().getX(), enemy.getPilot().getY()).contains(bullet.getX(), bullet.getY())){
                        bullet.setAlive(false);   
                        enemy.addHealth(bullet.getSize()*-1);
                        effects.add(new ConcreteEffectExplosion(bullet.getX(), bullet.getY(), bullet.getSize()*2, bullet.getSize()/500f, 1000));
                        hud.addScore(10);
                    }                        
                }
            }
            if(!bullet.isFriendly() && bullet.isAlive()){               
                if(player.getShape().getShape(player.getPilot().getX(), player.getPilot().getY()).contains(bullet.getX(), bullet.getY())){
                    bullet.setAlive(false);   
                    player.addHealth(bullet.getSize()*-1);
                    effects.add(new ConcreteEffectExplosion(bullet.getX(), bullet.getY(), bullet.getSize()*2, bullet.getSize()/500f, 1000));
                }   
            }
        }
    }
    
        
}
