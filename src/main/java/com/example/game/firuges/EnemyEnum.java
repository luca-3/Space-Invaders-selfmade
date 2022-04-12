package com.example.game.firuges;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public enum EnemyEnum {
    AFFE("File", 200, 100, 1, Color.BROWN),
    BANNANE("File", 50, 50, 1, Color.YELLOW),
    ;
    private final String skin; //skin of the enemy

    private final int height;
    private final int width;
    private final int hp; // health points
    private final Color color; // color of the enemy


    EnemyEnum(String skin, int height, int width, int hp, Color color) {
        this.skin = skin;
        this.height = height;
        this.width =width;
        this.hp = hp;
        this.color = color;
    }

    public String getSkin(){
       return this.skin;
    }
    public int getHeight(){
        return this.height;
    }
    public Color getColor(){
        return this.color;
    }
    public int getWidth() {
        return this.width;
    }
    public int getHp(){
        return this.hp;
    }
}
