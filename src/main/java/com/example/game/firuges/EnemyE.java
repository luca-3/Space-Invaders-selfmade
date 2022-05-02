package com.example.game.firuges;

import javax.swing.*;

import static com.example.game.firuges.MobMoveE.HDMOVE;

public enum EnemyE {
    AFFE(100, 200, 30,  20, MobMoveE.HDMOVE,"src/main/resources/com/example/game/enemy/Spaceship.png"),
    BANANE(40, 40, 10, 70, MobMoveE.NMOVE, "src/main/resources/com/example/game/enemy/Bannane1.png"),
    UNICORN(64, 64, 1 , 20, MobMoveE.VERMOVE, "src/main/resources/com/example/game/enemy/Test.png"),
    DWARF(75, 125, 1, 30, MobMoveE.RAINBOW, null),
    PUFFY(50, 50, 1, 65, MobMoveE.NMOVE, null),
    KITTY(75, 75, 1, 20, MobMoveE.NMOVE, null),

    ;


    private final int width;
    private final int height;
    private final int speed;// Max speed = 100
    private final Icon skin;
    private final int hp;
    private final MobMoveE move;



     EnemyE(int width, int height, int hp, int speed,MobMoveE m, String skin) {
        this.width = width;
        this.height = height;
        this.skin = new ImageIcon(skin); // creates icon object from incoming path
        this.hp = hp;
        this.move = m;
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
    public MobMoveE getMove(){return move;}
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
    public static MobMoveE getMove(EnemyE a){return a.getMove();}
    public static Icon getSkin(EnemyE a) {
        return a.getSkin();
    }


}



