package objects;
//NEW

import main.Keyboard;
import main.Main;
import main.Util;

import java.awt.*;

public class Player extends GameObjects {

    private int healthpoints, score;
    int speed = 10;


    public Player() {
        super(500, 500, 200, 200, "Spaceship.png");

        this.score = 0;
        this.healthpoints = 5;
        getJLabel().setBackground(Color.red);
    }

    public void reset(){
        setX(100);
        setY(200);
        this.score = 0;
        this.healthpoints = 5;
    }

    public void wKeyMovement() {
        while (!Main.isPause()) {
            if (Keyboard.isWPressed()) {
                if (getY() > 0) setLocation(getX(), getY() - speed);
            }
            while (Main.isPause()) Util.sleep(100);
            Util.sleep(20);
        }
    }

    public void aKeyMovement() {
        while (!Main.isPause()) {
            if (Keyboard.isAPressed()) {
                if (getX() > 0) setLocation(getX() - speed, getY());
            }
            while (Main.isPause()) Util.sleep(100);
            Util.sleep(20);
        }
    }

    public void sKeyMovement() {
        while (!Main.isPause()) {
            if (Keyboard.isSPressed()) {
                if (getY() < getScreen().getMonitorHeight() - getHeight()) setLocation(getX(), getY() + speed);
            }
            while (Main.isPause()) Util.sleep(100);
            Util.sleep(20);
        }
    }

    public void dKeyMovement() {
        while (!Main.isPause()) {
            if (Keyboard.isDPressed()) {
                if (getX() < getScreen().getMonitorWidth() - getWidth()) setLocation(getX() + speed, getY());
            }
            while (Main.isPause()) Util.sleep(100);
            Util.sleep(20);
        }
    }
    
    public void spaceKeyMovement() {
        while (!Main.isPause()) {
            if (Keyboard.isSpacePressed()) {
                /* //TODO: Shoot Methode in Bullet Class verschieben
                if (this.countBullet < this.shot.length) {
                    this.k++;
                    this.shot[this.k].setLocation(getX() + 100, getY() + 50);
                    add(this.shot[k]);

                    Thread t2 = new Thread(this::shot);
                    t2.start();

                    Util.sleep(200);
                    if (this.k == this.shot.length - 1) {
                        this.k = -1;
                    }
                    this.countBullet++;
                }

                 */
            }
            while (Main.isPause()) Util.sleep(100);
            Util.sleep(20);
        }
    }


    public void setHealthpoints(int hp){
        this.healthpoints = hp;
        //TODO: HP im Screen aktualisieren
    }

    public int getHealthpoints(){
        return healthpoints;
    }

    public void setScore(int score) {
        this.score = score;

        //TODO: Score im Screen aktualisieren
    }

    public int getScore() {
        return score;
    }


    public void addToScore(int score) {
        this.score += score;

        //TODO: Score im Screen aktualisieren
    }
}
