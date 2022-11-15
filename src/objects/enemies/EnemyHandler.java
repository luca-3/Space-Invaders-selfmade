package objects.enemies;

import main.Main;
import main.Util;

import objects.GameObjects;
import objects.Player;
import objects.enemies.types.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class EnemyHandler {
    private static int levelMap = 4;

    public static void checkCollisionPvE() {
        while(!Main.isPause()){
            Player p = Main.getPlayer();
            ArrayList<ArrayList> enemys = Enemies.getInstances();

            for (int j = 0; j < enemys.size(); j++) {
                for (int i = 0; i < enemys.get(j).size(); i++) {
                    JLabel enemy = null;

                    GameObjects temp = (GameObjects) enemys.get(j).get(i);
                    enemy = temp.getJLabel();

                    if (Util.rectCollision(p.getJLabel(), enemy) && !Main.getPlayer().isInvulnerable()) Main.getPlayer().gotHit();
                }
            }
            Util.sleep(200);
        }

    }

    public static void generateLevel() {
        while(!Main.isPause()){
            int x = levelMap;
            int numberEnemies = (int) (2.216883 - 0.7697576 * x + Math.pow(0.8798266 * x, 2) - Math.pow(0.1099424 * x, 3) + Math.pow(0.005293009 * x, 4) - Math.pow(0.00008628167 * x, 5));

            //spawn
            spawnEnemies(numberEnemies);

            boolean stillAlive = isEnemyStillAlive();
            while (stillAlive) {
                Util.sleep(1000);
                stillAlive = isEnemyStillAlive();
            }
            levelMap++;
            Enemies.createLists();
        }
    }

    private static void spawnEnemies(int numberEnemies) {
        Random r = new Random();

        for (int i = 0; i < numberEnemies; i++) {
            int difficulty = (int) (r.nextDouble(1, 2.5) + levelMap / 10);
            int id = -1;


            if (difficulty == 1) { //Puffy,
                id = (int) r.nextDouble(1, 2.99);
                if (id == 1) Puffy.createInstance();
                ;//spawn Puffy;
                if (id == 2) ;//spawn . . .

            } else if (difficulty == 2) { //Affe, Dwarf
                id = (int) r.nextDouble(1, 2.99);
                if (id == 1) Affe.createInstance(); //spawn Affe;
                if (id == 2) Dwarf.createInstance(); //spawn Dwarf

            } else if (difficulty >= 3) { //Kitty, Unicorn
                id = (int) r.nextDouble(1, 2.99);
                if (id == 1) Kitty.createInstance();
                ;//spawn Kitty;
                if (id == 2) Unicorn.createInstance();//spawn Unicorn
            } else {
                System.out.println("Error while assigning enemy type");
            }
            Util.sleep(500); //TODO spawn rate vom level abhängig berechnen
            //System.out.println("diff: " + difficulty + "   id: " + id);
        }

    }

    private static boolean isEnemyStillAlive() {
        boolean enemyStillAlive = false;
        for (ArrayList<ArrayList> list : Enemies.getInstances()) {
            if (list.size() > 0) {
                enemyStillAlive = true;
            }
        }
        return enemyStillAlive;
    }

    public static void deleteDeadEnemies() {
        ArrayList<ArrayList> enemys = Enemies.getInstances();

        for (int j = 0; j < enemys.size(); j++) {
            for (int i = 0; i < enemys.get(j).size(); i++) {

                if (!((Enemies) enemys.get(j).get(i)).isAlive()) {
                    ((Enemies) enemys.get(j).get(i)).removeJLabel();
                    try{
                        //because the method can run several times at the same time and then try to accesses objects that have already been deleted
                        enemys.get(j).set(i, null);
                        enemys.get(j).remove(i);
                    }catch (Exception e){
                        System.out.println("Error while deleting enemy: " + e);
                    }


                }
            }
        }
    }


    public static int getLevelMap() {
        return levelMap;
    }


}

