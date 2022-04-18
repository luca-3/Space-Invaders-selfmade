package com.example.game.firuges;

public class Player {


    private int x;
    private int y;
    private int width;
    private int speed;
    public static int hp;
    public static int score;


    public Player(int x, int y, int width, int speed, int hp){
        this.x = x;
        this.y = y;
        this.width = width;
        this.speed = speed;
        this.hp = hp;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}





