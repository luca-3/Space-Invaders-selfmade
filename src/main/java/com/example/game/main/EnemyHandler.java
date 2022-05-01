package com.example.game.main;

import com.example.game.firuges.Enemy;
import com.example.game.firuges.EnemyE;
import com.example.game.test.Move;

import java.util.ArrayList;

public class EnemyHandler {
    public static int level = 1;
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    Screen screen;


    public EnemyHandler() {
        // TODO
    }

    public void start(Screen s) {
        this.screen = s;


        Enemy enemy = new Enemy(EnemyE.BANANE, 2000, 400);
        enemy.setId(screen.addEnemy(enemy));
        enemies.add(enemy);

        Enemy enemy2 = new Enemy(EnemyE.VERFOLGER, 1000, 700);
        enemy2.setId(screen.addEnemy(enemy2));
        enemies.add(enemy2.getID(), enemy2);




        move();
    }

    public void move(){
        int k = enemies.size();

        Thread[] moveT = new Thread[k];
            for (int i = 0; i < enemies.size(); i++) {
                int i1 = i;
                moveT[i1] = new Thread(()-> screen.move(enemies.get(i1).getID(), enemies.get(i1).getTyp()));
                moveT[i1].start();

                Move.sleep(100);
            }



    }

    public static int getAnzahlE(){return enemies.size();}



}
