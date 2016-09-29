/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.main;

import java.awt.event.KeyEvent;

/**
 *
 * @author willem
 */
public interface Observable
{
   public void NotifyObservers(KeyEvent keyEvent, Boolean bool);
}
