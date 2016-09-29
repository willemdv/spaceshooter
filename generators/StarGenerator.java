/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import gameobject.effect.Star;
import gameobject.main.GameObjectCollection;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author willem
 */
public class StarGenerator extends ObjectGenerator {

    public StarGenerator(int interval, GameObjectCollection objectList) {
        super(interval, objectList);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        for (int i = 0; i < 200; i++) {
            addObject((float) (Math.random() * screen.width), (float) (Math.random() * screen.height));
        }

    }

    @Override
    public void addObject() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        objectList.add(new Star(screen.width, (float) (Math.random() * screen.height), 0.01f + (float) (Math.random() * 0.1), 180f));
    }

    public void addObject(float x, float y) {
        objectList.add(new Star(x, y, 0.01f + (float) (Math.random() * 0.1), 180f));
    }
}
