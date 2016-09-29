/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author wdevoogd
 */
public class Recources {

    private BufferedImage[] images = new BufferedImage[10];
    private BufferedImage projectiles = null;
    private BufferedImage bullets;
    private BufferedImage healthBarFull;
    private BufferedImage healthBarEmpty;
    
    public Recources() {
        try {
            projectiles = ImageIO.read(getClass().getResource("/projectiles.png"));
            healthBarEmpty = ImageIO.read(getClass().getResource("/healthbarE.png"));
            healthBarFull = ImageIO.read(getClass().getResource("/healthbarF.png"));
            bullets = ImageIO.read(getClass().getResource("/bullets.png"));
        } catch (IOException ex) {
            Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
        }
        images[0] = projectiles.getSubimage(0, 0, 50, 50); //big red bullet
        images[1] = projectiles.getSubimage(50, 0, 50, 50); //big green bullet
        images[2] = projectiles.getSubimage(150, 0, 50, 50); // big red laser
        images[3] = projectiles.getSubimage(200, 0, 50, 50); //big green laser   
        images[4] = healthBarFull;
        images[5] = healthBarEmpty;
        images[6] = bullets.getSubimage(0, 0, 20, 20); //rood
        images[7] = bullets.getSubimage(20, 0, 20, 20); //groen
        images[8] = bullets.getSubimage(40, 0, 20, 20); //blauw
        images[9] = bullets.getSubimage(60, 0, 20, 20); //combo
    }

    public BufferedImage getImage(int i) {
        if (i < images.length) {
            return images[i];
        } else {
            return images[0];
        }
    }
}
