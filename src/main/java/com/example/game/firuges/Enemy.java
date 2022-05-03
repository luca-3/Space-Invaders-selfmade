package com.example.game.firuges;

import javax.swing.*;

public class Enemy {

    private final int x;
    private final int y;

    private final int speed;
    private final int width;
    private final int height;
    private int hp;
    private final Icon skin;
    private int id;
    private final EnemyE typ;


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



    public Icon getSkin() {return skin;}
    public int getX() {return x;}
    public int getY() {return y;}
    public int getSpeed() {return speed;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public int getHp() {return hp;}
    public EnemyE getTyp(){return typ;}

    public void hpHit(int sub){hp -= sub;}

    public int getID(){return id;}
    public void setId(int id){this.id = id;}


}

