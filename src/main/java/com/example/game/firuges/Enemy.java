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
    private int id;
    private EnemyE typ;


    public Enemy(EnemyE type, int x, int y) {

            this.x = x;
            this.y = y;
            this.speed = EnemyE.getSpeed(type);
            this.width = EnemyE.getWidth(type);
            this.height = EnemyE.getHeight(type);
            this.hp = EnemyE.getHp(type);
            this.skin = EnemyE.getSkin(type);
            this.typ = type;

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

    public int getID(){return id;}
    public void setId(int id){this.id = id;}

    public EnemyE getTyp(){return typ;}
}

