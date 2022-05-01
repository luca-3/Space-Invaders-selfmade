package com.example.game.firuges;

public class Player {


    private int width;
    private int speed;
    public static int hp;
    public static int score ;

    public Player(int width, int speed, int hp){
        this.width = width;
        this.speed = speed;
        Player.hp = hp;
    }

    public Player(String state) {
        switch (state){
            case "init":
                this.width = 100;
                this.speed = 10;
                Player.hp = 3;
                break;
            default:
                throw new IllegalArgumentException("Wrong input for Player constructor: " + state);

        }
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
    public static void addScore(int plus){
        score += score+plus;
    }
}





