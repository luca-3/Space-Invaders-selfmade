package com.example.game.firuges;

import javax.swing.*;

public class Enemy {

    private int x;
    private int y;

    private int speed;
    private int width;
    private int height;
    private int hp;
    private Icon skin;


    public Enemy(EnemyE type, int x, int y) {

        if (type == EnemyE.AFFE) {
            this.x = x;
            this.y = y;
            this.speed = EnemyE.AFFE.getSpeed();
            this.width = EnemyE.AFFE.getWidth();
            this.height = EnemyE.AFFE.getHeight();
            this.hp = EnemyE.AFFE.getHp();
            this.skin = EnemyE.AFFE.getSkin();

        }else if (type == EnemyE.BANANE) {
            // Data from Enum

        }

    }



    public Icon getSkin() {
        return skin;
    }

    public void setSkin(Icon skin) {
        this.skin = skin;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

}

