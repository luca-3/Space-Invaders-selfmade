package com.example.game.firuges;

import javax.swing.*;

public enum EnemyE {
    AFFE(100, 200, 30,  20,"src/main/resources/com/example/game/enemy/Spaceship.png"),
    BANANE(100, 100, 10, 30, "src/main/resources/com/example/game/enemy/Bannane.png"),
    ;


    private final int width;
    private final int height;
    private final int speed;
    private final Icon skin;
    private final int hp;
    //private final MobMoveE MOVE;



     EnemyE(int width, int height, int hp, int speed, String skin) {
        this.width = width;
        this.height = height;
        this.skin = new ImageIcon(skin); // creates icon object from incoming path
        this.hp = hp;

        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
    public int getHp() {
        return hp;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Icon getSkin() {
        return skin;
    }


    public static int getSpeed(EnemyE a) {
        return a.getSpeed();
    }
    public static int getHp(EnemyE a) {
        return a.getHp();
    }
    public static int getWidth(EnemyE a) {
        return a.getWidth();
    }
    public static int getHeight(EnemyE a) {
        return a.getHeight();
    }
    public static Icon getSkin(EnemyE a) {
        return a.getSkin();
    }

}



