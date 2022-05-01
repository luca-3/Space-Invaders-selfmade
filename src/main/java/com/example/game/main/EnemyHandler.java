package com.example.game.main;

import com.example.game.firuges.Enemy;
import com.example.game.firuges.EnemyE;
import com.example.game.firuges.Level;
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


        Enemyinit(Level.LEVELBLANK);
        move();




    }

    public void Enemyinit(Level level){
        for (int i = 0; i < level.getAffe(); i++) {
            Enemy enemy = new Enemy(EnemyE.AFFE, 2000 +200*i, 400);
            enemy.setId(screen.addEnemy(enemy));
            enemies.add(enemy);
            //Thread bannane = new Thread(()-> screen.bannane(enemy.getID()));
            //bannane.start();

        }
    }




    public void move(){
        int k = enemies.size();

        Thread[] moveT = new Thread[k];
            for (int i = 0; i < enemies.size(); i++) {
                int i1 = i;
                moveT[i1] = new Thread(()-> screen.move(enemies.get(i1).getID(), enemies.get(i1).getTyp(), enemies.get(i1).getX()));
                moveT[i1].start();

                Move.sleep(100);
            }



    }

    public static int getAnzahlE(){return enemies.size();}



}
