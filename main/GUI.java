package main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JFrame;

public class GUI extends JFrame implements KeyListener, Observable {

    private Toolkit toolkit;
    private long lastUpdate;
    private URL url;
    private Image background;
    private Engine engine;
    private ArrayList<Observer> obsList;

    public GUI(Engine engine) {
        this.engine = engine;
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createBufferStrategy(2);
        this.addKeyListener(this);

        toolkit = Toolkit.getDefaultToolkit();
        url = getClass().getResource("/sky.png");
        background = toolkit.getImage(url);
        obsList = new ArrayList();
    }

    public void loop() {
        while (true) {
            //if (System.currentTimeMillis() - lastUpdate > 1) {
                update();
            //    lastUpdate = System.currentTimeMillis();
            //}
        }
    }

    public void update() {
        engine.update();
        paint();
    }

    public void paint() {
        BufferStrategy bf = this.getBufferStrategy();
        Graphics2D g = null;
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER);
        try {
            g = (Graphics2D) bf.getDrawGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g.drawImage(background, 0, 0, this);
            g.setComposite(ac);
            engine.draw(g);
        } finally {
            g.dispose();
        }
        bf.show();
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void notifyObservers(KeyEvent keyEvent, Boolean bool) {
        for (Observer obs : obsList) {
            obs.update(keyEvent, bool);
        }
    }
    @Override
    public void addObserver(Observer obs) {
        if (obs != null) {
            obsList.add(obs);
        }
    }
    @Override
    public void delObserver(Observer obs) {
        if (obs != null) {
            obsList.remove(obs);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        notifyObservers(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        notifyObservers(e, false);
    }
}
