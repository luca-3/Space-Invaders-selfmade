package com.example.game.main;



public class Scoreboard {
    private String name;
    private int score;



    public Scoreboard(){
        load();
    }

    public void save(){

    }

    public void load(){

    }



    public int getScore(){return this.score;}
    public void setScore(int score){this.score = score;}

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
}
