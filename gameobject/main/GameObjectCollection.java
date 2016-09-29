/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.main;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author willem
 */
public class GameObjectCollection implements Drawable {

    private ArrayList<GameObject> objectList;

    public GameObjectCollection() {
        objectList = new ArrayList();
    }

    public void clean() {
        ArrayList<GameObject> removeList = new ArrayList();
        for (GameObject object : objectList) {
            if (!object.getActive()) {
                removeList.add(object);
            }
        }
        objectList.removeAll(removeList);
        removeList.clear();
    }

    public void update() {
        for (GameObject object : objectList) {
            if (object.getActive()) {
                object.update();
            }
        }
        clean();
    }

    public void draw(Graphics2D g) {
        for (GameObject object : objectList) {
            if (object.getActive()) {
                object.draw(g);
            }
        }
    }

    public ArrayList<GameObject> getObjectList() {
        return objectList;
    }

    public void add(GameObject object) {
        objectList.add(object);
    }
}
