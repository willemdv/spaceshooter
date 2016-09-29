package generators;

import abstractfactory.ship.AbstractFactoryShip;
import abstractfactory.ship.ConcreteEnemyFactoryBomber;
import abstractfactory.ship.ConcreteEnemyFactoryBoss;
import abstractfactory.ship.ConcreteEnemyFactoryCruiser;
import abstractfactory.ship.ConcreteEnemyFactoryFighter;
import gameobject.entity.Enemy;
import gameobject.main.GameObjectCollection;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import main.Engine;

public class EnemyGenerator extends ObjectGenerator {

    private float maxY;
    private float maxX;
    private AbstractFactoryShip[] EnemyFactorys;
    private Engine engine;

    public EnemyGenerator(int interval, GameObjectCollection objectList, Engine engine) {
        super(interval, objectList);

        this.engine = engine;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        maxY = screen.height;
        maxX = screen.width;

        EnemyFactorys = new AbstractFactoryShip[4];
        EnemyFactorys[0] = new ConcreteEnemyFactoryFighter();
        EnemyFactorys[1] = new ConcreteEnemyFactoryBomber();
        EnemyFactorys[2] = new ConcreteEnemyFactoryCruiser();
        EnemyFactorys[3] = new ConcreteEnemyFactoryBoss();
    }

    @Override
    public void addObject() {

        int enemyType;
        int rInt;
        Random r = new Random();
        rInt = r.nextInt(100);

        if (rInt < 50) {
            enemyType = 0;
        } else if (rInt < 92) {
            enemyType = 1;
        } else if (rInt < 98) {
            enemyType = 2;
        } else {
            enemyType = 3;
        }

        Enemy enemy = new Enemy(maxX + 50f, (float) (Math.random() * maxY), EnemyFactorys[enemyType], engine);
        objectList.add(enemy);
    }
}