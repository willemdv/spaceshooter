/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.effects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author wdevoogd
 */
public class Effects{
    private ArrayList<AbstractEffect> effectList;
    private long lastUpdate;
    private long now;

   
    public Effects(){
        effectList = new ArrayList();
        lastUpdate = System.currentTimeMillis();
        generateStars();
    }
    
    public void update(){  
        addStar();
        for(AbstractEffect effect:effectList){
            effect.update();
        } 
        clean();
    }
    
    public void clean(){
       ArrayList<AbstractEffect> removeList = new ArrayList();
       for(AbstractEffect effect:effectList){
            if(!effect.isActive()){
                removeList.add(effect);
            }
       }   
       effectList.removeAll(removeList);
       removeList.clear();
    }
    
    public void add(AbstractEffect effect){        
        effectList.add(effect);
    } 
    
    public void addStar(){
        if(System.currentTimeMillis()-lastUpdate>50){
            effectList.add(new ConcreteEffectStar(1205, Math.random()*600, 1));
            lastUpdate=System.currentTimeMillis();
        }
    }
    
    public void generateStars(){
        while(effectList.size()<500){
            effectList.add(new ConcreteEffectStar(Math.random()*1200, Math.random()*600, 1));
        }
    }
    
    public void draw(Graphics2D g){        
        for(AbstractEffect effect:effectList){
            effect.draw(g);            
       }  
    }
    
}
