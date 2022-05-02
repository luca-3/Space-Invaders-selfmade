package com.example.game.main;

import com.example.game.firuges.Enemy;
import com.example.game.firuges.EnemyE;
import com.example.game.firuges.Level;
import com.example.game.test.Move;

import java.util.ArrayList;
import java.util.Random;

public class EnemyHandler {
    public static int level = 1;
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    Screen s;
    Random random = new Random();
    int cou= 0;

    public EnemyHandler() {
        // TODO
    }

    public void startEnemy() {
        this.s = Main.getScreen();
        System.out.println(1);
        while (true) {
            Move.sleep(1000);
            s.levelEnd = false;
            int r = random.nextInt(1);
            System.out.println(r);
            if (r == 0) {
                Enemyinit(Level.LEVELBLANK);
                move();
                while (s.levelEnd== false){Move.sleep(1000);}

            }
            remove();
            cou = 0;

        }
    }

    public void Enemyinit(Level level){
        for (int i = 0; i < level.getNumberAffe(); i++) {
            Enemy enemy = new Enemy(EnemyE.AFFE, 2000 +200*i, 400);
            enemy.setId(s.addEnemy(enemy));
            enemies.add(cou, enemy);
            cou++;
            //Thread bannane = new Thread(()-> s.bannane(enemy.getID()));
            //bannane.start();
        }
        for (int i = 0; i < level.getNumberUnicorns(); i++) {
            Enemy enemy = new Enemy(EnemyE.UNICORN, 2000 +200*i, 200+200*i);
            enemy.setId(s.addEnemy(enemy));
            enemies.add(cou, enemy);
            cou++;
        }
        for (int i = 0; i < level.getNumberDwarf(); i++) {
            Enemy enemy = new Enemy(EnemyE.DWARF, 2000 +200*i, 200+200*i);
            enemy.setId(s.addEnemy(enemy));
            enemies.add(cou, enemy);
            cou++;
        }
        for (int i = 0; i < level.getNumberPuffy(); i++) {
            Enemy enemy = new Enemy(EnemyE.PUFFY, 2000 +200*i, 200+200*i);
            enemy.setId(s.addEnemy(enemy));
            enemies.add(cou, enemy);
            cou++;
        }
        for (int i = 0; i < level.getNumberKitty(); i++) {
            Enemy enemy = new Enemy(EnemyE.KITTY, 2000 +200*i, 200+200*i);
            enemy.setId(s.addEnemy(enemy));
            enemies.add(cou, enemy);
            cou++;
        }
    }




    public void move(){
        int k = enemies.size();

        Thread[] moveT = new Thread[k];

        for (int i = 0; i < enemies.size(); i++) {
            int i1 = i;
            moveT[i1] = new Thread(()-> s.move(enemies.get(i1).getID(), enemies.get(i1).getTyp(), enemies.get(i1).getX()));
            moveT[i1].start();

            Move.sleep(10);
        }
    }

    public void remove(){
        for (int i = 0; i < enemies.size(); i++) {
            enemies.remove(i);
        }
    }

    public static int getAnzahlE(){return enemies.size();}



}
