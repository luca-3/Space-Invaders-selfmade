package com.example.game.figures;

import com.example.game.main.Main;
import com.example.game.main.Screen;

public class Player {

    private int score;
    private final int width;
    private int speed;
    public int hp;


    public Player(String state) {
        if ("init".equals(state)) {
            this.width = 100;
            this.speed = 10;
            this.hp = 5;
        } else {
            throw new IllegalArgumentException("Wrong input for PlayerN constructor: " + state);
        }
    }

    public void reset(){
        this.hp = 5;
        this.score = 0;
        Screen s = Main.getScreen();
        s.lives.setText("HP: " + this.hp);
    }

    public int getWidth() {return this.width;} 
    public int getSpeed() {return this.speed;}
    public void setSpeed(int speed) {this.speed = speed;}

    public void setHP(int hp){
        this.hp = hp;
        Screen s = Main.getScreen();
        s.lives.setText("HP: " + this.hp);
    }

    public int getHP(){
        return hp;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;

        Screen s = Main.getScreen();
        s.score.setText("Score: " + this.score);
    }

    public void addToScore(int score) {
        this.score += score;

        Screen s = Main.getScreen();
        s.score.setText("Score: " + this.score);
    }

}





