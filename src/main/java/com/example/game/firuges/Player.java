package com.example.game.firuges;

public class Player {


    private final int width;
    private int speed;
    public static int hp;
    public static int score ;
/*
    public Player(int width, int speed, int hp){
        this.width = width;
        this.speed = speed;
        Player.hp = hp;
    }*/

    public Player(String state) {
        if ("init".equals(state)) {
            this.width = 100;
            this.speed = 10;
            Player.hp = 5;
        } else {
            throw new IllegalArgumentException("Wrong input for Player constructor: " + state);
        }
    }

    public int getWidth() {return width;}


    public int getSpeed() {return speed;}
    public void setSpeed(int speed) {this.speed = speed;}

    public static void editScore(int plus){score += plus;}
    public static void editHP(int plus){hp += plus;}

}





