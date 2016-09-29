/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import gameobject.main.GameObjectCollection;

/**
 *
 * @author willem
 */
public abstract class ObjectGenerator {

    protected long lastUpdate;
    protected long now;
    protected int interval;
    protected GameObjectCollection objectList;

    public ObjectGenerator(int interval, GameObjectCollection objectList) {
        this.interval = interval;
        this.objectList = objectList;
        now = System.currentTimeMillis();
        lastUpdate = now - interval;
    }

    public void update() {
        now = System.currentTimeMillis();
        if (now - lastUpdate > interval) {
            addObject();
            lastUpdate = now;
        }
    }

    public abstract void addObject();
}
