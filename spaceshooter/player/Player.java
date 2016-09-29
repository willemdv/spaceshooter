package spaceshooter.player;

import spaceshooter.main.GUI;
import spaceshooter.main.Observer;
import spaceshooter.ship.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import spaceshooter.main.Engine;

public class Player implements Observer{
    private ConcretePilotManual pilot;
    private AbstractShape shape;
    private ArrayList<AbstractTurret> turrets;
    private int health;
    private Engine engine;
    
    public Player(Engine engine){
        pilot = new ConcretePilotManual(50,300);
        shape = new ConcreteShapePlayer(3);
        turrets = new ArrayList();
        turrets.add(new ConcreteTurretManual(-5,-5,7,250,true));
        turrets.add(new ConcreteTurretManual(-5,5,7,250,true));
        health = 100;
        this.engine = engine;
        engine.getGui().AddObserver((Observer)this);
        for(AbstractTurret turret:turrets){
            turret.setPilot(pilot);
            turret.setEngine(engine);
        }
    }
    
    public void update(){
        pilot.move();
        for(AbstractTurret turret:turrets){
            turret.update();
        }
    }  
    
    public void draw(Graphics2D g){         
        Polygon polygons = shape.getShape(pilot.getX(), pilot.getY()); //create polyon with shape at location                
        g.setColor(new Color(0.5f,0.5f,0.5f,1f));
        g.fill(polygons);       
        g.setColor(new Color(1.0f,1.0f,1.0f,0.5f));
        g.draw(polygons);        
        
        Ellipse2D ellipse = new Ellipse2D.Double(pilot.getX()-30, pilot.getY()-30, 60, 60);
        float[] dist = {0.0f,0.50f,1.00f};
        Color[] colors = {new Color(0.0f,1.0f,1.0f,0.0f),new Color(0.0f,1.0f,1.0f,0.0f),new Color(1.0f,1.0f,1.0f,0.4f)};          
        RadialGradientPaint gradient =  new RadialGradientPaint(new Point2D.Double(pilot.getX(), pilot.getY()), 30, dist, colors);          
        g.setPaint(gradient); 
        g.fill(ellipse);   
        
        g.setStroke(new BasicStroke(2f));
        g.setColor(new Color(0,1.0f,1.0f,0.4f));
        g.draw(ellipse);         
    }

    @Override
    public void update(KeyEvent e, Boolean bool) {
        if(e.getKeyCode()== KeyEvent.VK_UP){            
            pilot.setUp(bool);    
        } 
        if(e.getKeyCode()== KeyEvent.VK_DOWN){           
            pilot.setDown(bool);            
        } 
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){            
            pilot.setRight(bool);               
        } 
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            pilot.setLeft(bool);          
        }  
        if(e.getKeyCode()== KeyEvent.VK_SPACE){
             for(AbstractTurret turret:turrets){
                if(turret instanceof ConcreteTurretManual){
                    ConcreteTurretManual turret2 = (ConcreteTurretManual)turret;
                    turret2.setFire(bool);
                }
            }
        } 
    }

    public AbstractPilot getPilot() {
        return pilot;
    }

    public void setPilot(ConcretePilotManual pilot) {
        this.pilot = pilot;
    }

    public AbstractShape getShape() {
        return shape;
    }

    public void setShape(AbstractShape shape) {
        this.shape = shape;
    }

    public ArrayList<AbstractTurret> getTurrets() {
        return turrets;
    }

    public void setTurrets(ArrayList<AbstractTurret> turrets) {
        this.turrets = turrets;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void addHealth(int health){
        this.health += health;
        System.out.println(this.health);
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    
    
    
    
    
    
    
}