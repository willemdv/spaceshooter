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
public interface Observer {

    public void update(KeyEvent keyEvent, Boolean bool);
}
