package spaceshooter.main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.net.URL;
import java.util.ArrayList;

public class GUI extends JFrame implements KeyListener,Observable{

    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private long lastUpdate;
    private Engine engine;   
    URL url = getClass().getResource("/sky.png");
    Image background = toolkit.getImage(url);
    
    private ArrayList<Observer> obsList;

    public static void main(String[] args)
    {
        new GUI();
    }

    public GUI(){    
           
        this.setSize(1200, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createBufferStrategy(2);  
        this.addKeyListener(this);
        obsList = new ArrayList();
        engine = new Engine(this);
        
        loop();
    }
    
    public void loop(){   
        while(true){
            if(System.currentTimeMillis()-lastUpdate>1){                
                update();
                lastUpdate=System.currentTimeMillis();
            }
        }        
    }

    public void update(){
        engine.update();
        paint();	
    }

    public void paint(){
        
        BufferStrategy bf = this.getBufferStrategy();
        Graphics2D g = null;
        AlphaComposite ac = AlphaComposite.getInstance( AlphaComposite.SRC_OVER);
        try {
            g = (Graphics2D) bf.getDrawGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);            
            g.drawImage(background, 0, 0, this);
            g.setComposite(ac);          
            engine.draw(g);
        }
        finally{
            g.dispose();
        }
        bf.show();
        Toolkit.getDefaultToolkit().sync();	
    }

   @Override
   public void NotifyObservers(KeyEvent keyEvent, Boolean bool)
   {
       for(Observer obs : obsList)
       {
           obs.update(keyEvent,bool);
       }
   }

    public void AddObserver(Observer obs){
		if (obs != null)
		obsList.add(obs);
    }

    public void DelObserver(Observer obs){
		if (obs != null)
       		obsList.remove(obs);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        NotifyObservers(e,true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        NotifyObservers(e,false);
    }

    
}
