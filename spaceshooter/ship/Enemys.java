/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
import spaceshooter.main.Engine;
import spaceshooter.player.Player;
/**
 *
 * @author wdevoogd
 */
public class Enemys{
    private long lastUpdate;
    private long now;
    private int enemyInterval;
    private ArrayList<Enemy> enemyList;    
    private AbstractFactoryShip[] EnemyFactorys;   
    private Engine engine;
    
    public Enemys(int enemyInterval, Engine engine) {
        lastUpdate = System.currentTimeMillis()-10000;
        enemyList = new ArrayList();
        this.enemyInterval=enemyInterval;     
       
        this.engine = engine;
        
        EnemyFactorys = new AbstractFactoryShip[4];
        EnemyFactorys[0] = new ConcreteEnemyFactoryFighter();  
        EnemyFactorys[1] = new ConcreteEnemyFactoryBomber(); 
        EnemyFactorys[2] = new ConcreteEnemyFactoryCruiser();         
        EnemyFactorys[3] = new ConcreteEnemyFactoryBoss();   
    }
    
    public void update(){          
        //add new enemys
        add();
        //update enemys
        for(Enemy enemy:enemyList){
            enemy.update();
        } 
        //remove dead enemys
        clean();
    }
    
    public void clean(){
       ArrayList<Enemy> removeList = new ArrayList();
       for(Enemy enemy:enemyList){
            if(!enemy.isAlive()){
                removeList.add(enemy);
            }
       }   
       enemyList.removeAll(removeList);
       removeList.clear();
    }
    
    public void add(){        
        now = System.currentTimeMillis();
        
        if(now-lastUpdate>enemyInterval){
            Random r = new Random();      
            int random = r.nextInt(1000);
            
            if(random<10){
               enemyList.add(new Enemy(EnemyFactorys[3],engine, 800)); 
            }
            else if(random<100){
               enemyList.add(new Enemy(EnemyFactorys[2],engine, 300));  
            }
            else if(random<400){
               enemyList.add(new Enemy(EnemyFactorys[1],engine, 50));  
            }
            else if(random<1000){
               enemyList.add(new Enemy(EnemyFactorys[0],engine, 20));  
            }
             
            lastUpdate=now;
        }
    } 

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }
    
    
    public void draw(Graphics2D g){
        for(Enemy enemy:enemyList){
            if(enemy.isAlive()){
                enemy.draw(g);
            }
       }  
    }
    
}
