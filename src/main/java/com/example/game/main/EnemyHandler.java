package com.example.game.main;

import com.example.game.firuges.Enemy;
import com.example.game.firuges.EnemyE;
import com.example.game.firuges.Level;


import java.util.ArrayList;
import java.util.Random;

public class EnemyHandler {
    public static int level = 1;
    public static ArrayList<Enemy> enemies = new ArrayList<>();
    private Screen s;
    private Random random = new Random();
    private int cou= 0;
    public static Level levelE;
    public static Thread[] moveT;
    public EnemyHandler() {

    }

    public void startEnemy() {
        Main.sleep(1000);
        this.s = Main.getScreen();
        while (Main.gameRun) { //enemy handling
            Main.sleep(1000);
            this.s.levelEnd = false;
            //levelE = Level.randomLevel();
            Level levelE = new Level();
                EnemyInit(levelE);
                move();
                while (!this.s.levelEnd){Main.sleep(1000);}
                this.s.levelEnd = false;
            Main.sleep(100);
            remove();
            this.cou = 0;

        }
    }

    public void EnemyInit(Level level){
        for (int i = 0; i < EnemyE.SIZE; i++) {
            for (int j = 0; j < EnemyE.getSize(EnemyE.VALUES.get(i), level); j++) {
                int r = this.random.nextInt(6);
                Enemy enemy = new Enemy(EnemyE.VALUES.get(i), 2000 + 200 * r, this.random.nextInt(100,s.height-200));
                enemy.setId(this.s.addEnemy(enemy));
                this.enemies.add(this.cou, enemy);
                this.cou++;
            }
        }
    }


    public void move(){
        this.moveT = new Thread[this.enemies.size()];
        for (int i = 0; i < this.enemies.size(); i++) {
            int i1 = i;
            this.moveT[i1] = new Thread(()-> this.s.move(this.enemies.get(i1).getID(), this.enemies.get(i1).getTyp(), this.enemies.get(i1).getX()));
            this.moveT[i1].start();
            Main.sleep(10);
        }
    }

    public void remove(){
        this.enemies.clear();
    }
    public static int getAnzahlE(){return enemies.size();}



}
