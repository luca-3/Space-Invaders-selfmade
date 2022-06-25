package objects;
//NEW

import main.Keyboard;
import main.Main;
import main.Util;

import java.awt.*;

public class Player extends GameObjects {

    private int healthpoints, score, levelPlayer;
    int speed = 10;


    public Player() {
        super(500, 500, 120, 120, "resources/player/Spaceship.png");

        this.score = 0;
        this.healthpoints = 5;
        this.levelPlayer = 1;
        getJLabel().setBackground(Color.red);
    }

    public void reset(){
        setX(500);
        setY(500);
        this.score = 0;
        this.healthpoints = 5;
        this.levelPlayer = 1;
    }

    public void gotHit(){
        manipulateHealthpoints(-1);
        setLocation(500, 500);
        setInvulnerable(true);

    }

    private void setInvulnerable(boolean b) {
        //TODO change skin to one with shield
        Util.sleep(2000);

    }

    public void checkIfDead(){
        if(healthpoints <= 0){
            reset();
            //TODO: Game Over message
        }
    }

    public void wKeyMovement() {
        while (!Main.isPause()) {
            if (Keyboard.isWPressed()) {
                if (getY() > 0) setY(getY() - speed);
            }
            while (Main.isPause()) Util.sleep(100);
            Util.sleep(20);
        }
    }

    public void aKeyMovement() {
        while (!Main.isPause()) {
            if (Keyboard.isAPressed()) {
                if (getX() > 0) setX(getX() - speed);
            }
            while (Main.isPause()) Util.sleep(100);
            Util.sleep(20);
        }
    }

    public void sKeyMovement() {
        while (!Main.isPause()) {
            if (Keyboard.isSPressed()) {
                if (getY() < getScreen().getMonitorHeight() - getHeight()) setY(getY() + speed);
            }
            while (Main.isPause()) Util.sleep(100);
            Util.sleep(20);
        }
    }

    public void dKeyMovement() {
        while (!Main.isPause()) {
            if (Keyboard.isDPressed()) {
                if (getX() < getScreen().getMonitorWidth() - getWidth()) setX(getX() + speed);
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
        checkIfDead();
    }

    public int getHealthpoints(){
        return healthpoints;
    }

    public void manipulateHealthpoints(int hp){
        this.healthpoints += hp;
        checkIfDead();
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

    public int getSpeed() {
        return speed;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLevelPlayer() {
        return levelPlayer;
    }

    public void setLevelPlayer(int levelPlayer) {
        this.levelPlayer = levelPlayer;
    }
}
