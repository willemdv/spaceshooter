/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author wdevoogd
 */
public class GameInfo {

    private int score;
    private int lives;
    private int fps;
    private long now;
    private long lastupdate;
    private long time;

    public GameInfo() {
        now = System.currentTimeMillis();
        lastupdate = now - 100;
        score = 0;
        lives = 5;
    }

    public void update() {
        now = System.nanoTime();
        time = now - lastupdate;
        fps = (int) (1000000000f / time);
        lastupdate = now;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getFps() {
        return fps;
    }
    
    public void addScore(int score){
        this.score += score;
    }
    
    public void addlives(int lives){
        this.lives += lives;
    }
}
