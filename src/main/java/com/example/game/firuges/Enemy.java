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



    public Icon getSkin() {return this.skin;}
    public int getX() {return this.x;}
    public int getY() {return this.y;}
    public int getSpeed() {return this.speed;}
    public int getWidth() {return this.width;}
    public int getHeight() {return this.height;}
    public int getHp() {return this.hp;}
    public EnemyE getTyp(){return this.typ;}

    public void hpHit(int sub){this.hp -= sub;}

    public int getID(){return this.id;}
    public void setId(int id){this.id = id;}


}

