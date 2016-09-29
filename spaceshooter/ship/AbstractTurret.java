/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.ship;

import spaceshooter.main.Engine;
import spaceshooter.player.Player;

/**
 *
 * @author willem
 */
public interface AbstractTurret{
    public void setEngine(Engine engine);
    public void setPilot(AbstractPilot pilot);
    public void update();
    public void aim();
    public void fire();
}
