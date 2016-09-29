/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gameobject.entity.Player;
import gameobject.main.CollisionHandler;
import gameobject.main.Drawable;
import gameobject.main.GameObjectCollection;
import gameobject.main.Recources;
import generators.EnemyGenerator;
import generators.ObjectGenerator;
import generators.StarGenerator;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author willem
 */
public class Engine {

    private ArrayList<ObjectGenerator> generators;
    private ArrayList<GameObjectCollection> collections;
    private TreeMap<Integer, Drawable> drawTree;
    private GUI GUI;
    private HUD HUD;
    private Player player;
    private GameInfo gameInfo;
    private Recources recources;
    private GameObjectCollection backEffects;
    private GameObjectCollection frontEffects;
    private GameObjectCollection enemys;
    private GameObjectCollection projectiles;
    private CollisionHandler collisionHandler;
    
    public Engine() {

        recources = new Recources();
        GUI.setDefaultLookAndFeelDecorated(true);
        GUI = new GUI(this);

        gameInfo = new GameInfo();
        HUD = new HUD(this);
        player = new Player(this);

        //set collections
        collections = new ArrayList();  //all groups of objects
        generators = new ArrayList();   //all generators of objects
        drawTree = new TreeMap();       //ordered list of drawable opbjects or collections         
        
        backEffects = new GameObjectCollection();
        frontEffects = new GameObjectCollection();
        enemys = new GameObjectCollection();
        projectiles = new GameObjectCollection();
        
        
        drawTree.put(0, backEffects);
        drawTree.put(1, enemys);
        drawTree.put(2, projectiles);
        drawTree.put(3, player);
        drawTree.put(9, frontEffects);
        drawTree.put(10, HUD);

        collections.add(backEffects);
        collections.add(frontEffects);
        collections.add(enemys);
        collections.add(projectiles);

        //set generators
        generators.add(new StarGenerator(100, backEffects));
        generators.add(new EnemyGenerator(1500, enemys, this));
        
        collisionHandler = new CollisionHandler(this);
        
        //start loop
        GUI.loop();
    }

    public void update() {
        for (GameObjectCollection col : collections) {
            col.update();
        }
        for (ObjectGenerator gen : generators) {
            gen.update();
        }
        player.update();
        collisionHandler.update();
        gameInfo.update();

    }

    public void draw(Graphics2D g) {
        for (Map.Entry<Integer, Drawable> entry : drawTree.entrySet()) {
            entry.getValue().draw(g);
        }
    }

    public GUI getGUI() {
        return GUI;
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public Player getPlayer() {
        return player;
    }

    public Recources getRecources() {
        return recources;
    }

    public GameObjectCollection getProjectiles() {
        return projectiles;
    }

    public GameObjectCollection getEnemys() {
        return enemys;
    }

    public GameObjectCollection getBackEffects() {
        return backEffects;
    }

    public GameObjectCollection getFrontEffects() {
        return frontEffects;
    }
    
    
    
    
}
