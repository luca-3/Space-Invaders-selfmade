package com.example.game.main;

import com.example.game.firuges.Enemy;
import com.example.game.firuges.EnemyE;
import com.example.game.firuges.Level;


import java.util.ArrayList;
import java.util.Random;

public class EnemyHandler {
    public static int level = 1;
    public static ArrayList<Enemy> enemies = new ArrayList<>();
    Screen s;
    Random random = new Random();
    int cou= 0;
    public static Level levelE;

    public EnemyHandler() {

    }

    public void startEnemy() {
        this.s = Main.getScreen();
        while (s.gameRun) { //enemy handling
            Main.sleep(1000);
            s.levelEnd = false;
            //levelE = Level.randomLevel();
            Level levelE = new Level();
                EnemyInit(levelE);
                move();
                while (!s.levelEnd){Main.sleep(1000);}
                s.levelEnd = false;
            Main.sleep(100);
            remove();
            cou = 0;

        }
    }

    public void EnemyInit(Level level){
        for (int i = 0; i < EnemyE.SIZE; i++) {
            for (int j = 0; j < EnemyE.getSize(EnemyE.VALUES.get(i), level); j++) {
                int r = random.nextInt(6);
                Enemy enemy = new Enemy(EnemyE.VALUES.get(i), 2000 + 200 * r, random.nextInt(100,s.height-200));
                enemy.setId(s.addEnemy(enemy));
                enemies.add(cou, enemy);
                cou++;
            }
        }
    }

    public void move(){
        int k = enemies.size();
        Thread[] moveT = new Thread[k];
        for (int i = 0; i < enemies.size(); i++) {
            int i1 = i;
            moveT[i1] = new Thread(()-> s.move(enemies.get(i1).getID(), enemies.get(i1).getTyp(), enemies.get(i1).getX()));
            moveT[i1].start();
            Main.sleep(10);
        }
    }

    public void remove(){
            enemies.clear();

    }
    public static int getAnzahlE(){return enemies.size();}



}
