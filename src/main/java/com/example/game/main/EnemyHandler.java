package com.example.game.main;

import com.example.game.firuges.Enemy;
import com.example.game.firuges.EnemyE;

import java.util.ArrayList;

public class EnemyHandler {
    public static int level = 1;
    public static ArrayList<Enemy> enemies;
    Screen screen;

    public EnemyHandler() {
        // TODO
    }

    public void start(Screen s) {
        this.screen = s;
        Thread move = new Thread(()-> move());
        move.start();

        Enemy enemy = new Enemy(EnemyE.BANANE, 500, 400);
        screen.enToJl(enemy);


    }

    public void move(){
        while (true){

        }

    }



}
