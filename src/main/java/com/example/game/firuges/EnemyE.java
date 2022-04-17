package com.example.game.firuges;

import javax.swing.*;

public enum EnemyE {
    AFFE(100, 200, 30, MobMoveE.NMOVE, 20,"src/main/resources/com/example/game/enemy/Spaceship.png"),
    BANANE(100, 100, 10, MobMoveE.EHDMOVE, 30, "src/main/resources/com/example/game/enemy/Bannane.png"),
    ;

    private final int width;
    private final int height;
    private int speed;
    private final Icon skin;
    private int hp;
    private final MobMoveE MOVE;



     EnemyE(int width, int height, int hp, MobMoveE move, int speed, String skin) {
        this.width = width;
        this.height = height;
        this.skin = new ImageIcon(skin); // creates icon object from incoming path
        this.hp = hp;
        this.MOVE = move;
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

}



