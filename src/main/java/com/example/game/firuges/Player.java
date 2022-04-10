package com.example.game.firuges;


import java.util.ArrayList;

public class Player {
    private int x; //x coordinate
    private int y; //y coordinate
    private int hp; //health points
    private int size; //size of player
    private int speed; //speed of player
    private ArrayList<String> items; //items collected
    private String skin; //path to skin of player
    private int score; //score of player

    public Player(int x, int y, int hp, int size, int speed, ArrayList<String> items) { //constructor
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.size = size;
        this.speed = speed;

        this.items = items;
        this.skin = skin;
        this.score = score;
    }

    //methods to get and set parameters

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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

