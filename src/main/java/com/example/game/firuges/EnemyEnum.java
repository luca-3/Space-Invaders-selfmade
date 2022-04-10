package com.example.game.firuges;

public enum EnemyEnum {
    AFFE("File", 200, 100, 1),
    BANNANE("File", 50, 50, 1)
    ;
    private final String skin; //skin of the enemy

    private final int height;
    private final int width;
    private final int hp; // health points


    EnemyEnum(String skin, int height, int width, int hp ){
        this.skin = skin;
        this.height = height;
        this.width =width;
        this.hp = hp;
    }

    public String getSkin(){
       return this.skin;
    }
    public int getHeight(){
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
    public int getHp(){
        return this.hp;
    }
}
