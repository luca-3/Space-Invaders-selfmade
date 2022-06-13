package com.example.game.objects;
//NEW
import com.example.game.main.Keyboard;
import com.example.game.main.Main;
import com.example.game.main.Screen;

import javax.swing.*;

public class PlayerN extends GameObjects {

    private int hitpoints;
    private int score;


    public PlayerN() {
        super(100, 200, 10, 10, "src/main/resources/com/example/game/enemy/TempMain.png");

        this.score = 0;
        this.hitpoints = 5;
    }

    public void reset(){
        setX(100);
        setY(200);
        this.score = 0;
        this.hitpoints = 5;
    }



    private void w() {
        while (Main.getInstance().isGameRun()) {
            if (Keyboard.wKey) {
                if (getY() - 10 > 0) setLocation(getX(), getY() - Main.player.getSpeed());
            }
            while (com.example.game.mainNew.Main.isPause()) Main.sleep(100);
            Main.sleep(20);
        }
    }
    private void a() {
        while (Main.getInstance().isGameRun()) {
            if (Keyboard.aKey) {
                if (getX() - 10 > 0) setLocation(getX() - Main.player.getSpeed(), getY());
            }
            while (com.example.game.mainNew.Main.isPause()) Main.sleep(100);
            Main.sleep(20);
        }
    }
    private void s() {
        while (Main.getInstance().isGameRun()) {
            if (Keyboard.sKey) {
                if (getY() < getScreen().getMonitorHeight()) setLocation(getX(), getY() + Main.player.getSpeed());
            }
            while (com.example.game.mainNew.Main.isPause()) Main.sleep(100);
            Main.sleep(20);
        }
    }
    private void d() {
        while (Main.getInstance().isGameRun()) {
            if (Keyboard.dKey) {
                if (getX() + 10 < 1840) setLocation(getX() + Main.player.getSpeed(), getY());
            }
            while (com.example.game.mainNew.Main.isPause()) Main.sleep(100);
            Main.sleep(20);
        }
    }
    private void space() {
        while (Main.getInstance().isGameRun()) {
            if (Keyboard.spaceKey) {
                /* //TODO: Shoot Methode in Bullet Class verschieben
                if (this.countBullet < this.shot.length) {
                    this.k++;
                    this.shot[this.k].setLocation(getX() + 100, getY() + 50);
                    add(this.shot[k]);

                    Thread t2 = new Thread(this::shot);
                    t2.start();

                    Main.sleep(200);
                    if (this.k == this.shot.length - 1) {
                        this.k = -1;
                    }
                    this.countBullet++;
                }

                 */
            }
            while (com.example.game.mainNew.Main.isPause()) Main.sleep(100);
            Main.sleep(20);
        }
    }


    public void setHitpoints(int hp){
        this.hitpoints = hp;
        Screen s = Main.getScreen();
        s.lives.setText("HP: " + this.hitpoints);
    }

    public int getHitpoints(){
        return hitpoints;
    }

    public void setScore(int score) {
        this.score = score;

        Screen s = Main.getScreen();
        s.score.setText("Score: " + this.score);
    }

    public int getScore() {
        return score;
    }


    public void addToScore(int score) {
        this.score += score;

        Screen s = Main.getScreen();
        s.score.setText("Score: " + this.score);
    }
}
