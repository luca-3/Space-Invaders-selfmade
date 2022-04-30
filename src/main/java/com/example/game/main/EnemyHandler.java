package com.example.game.main;

import com.example.game.firuges.Enemy;
import com.example.game.firuges.EnemyE;

import java.util.ArrayList;

public class EnemyHandler {
    public static int level = 1;
    public static ArrayList<Enemy> enemies;

    public EnemyHandler() {

    }

    public void start(Screen s) {
        Enemy enemy = new Enemy(EnemyE.BANANE, 100, 400);
        Main.s.addEnemy(enemy);


    }

    public void move(){


    }



}
