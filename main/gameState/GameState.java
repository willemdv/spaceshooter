/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.gameState;

import java.awt.Graphics2D;

/**
 *
 * @author willem
 */
public abstract class GameState {
    public abstract void update();
    public abstract void draw(Graphics2D g);                
}
