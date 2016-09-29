/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.KeyEvent;

/**
 *
 * @author willem
 */
public interface Observable {

    public void notifyObservers(KeyEvent keyEvent, Boolean bool);
    
    public void addObserver(Observer obs);
    
    public void delObserver(Observer obs);
}
