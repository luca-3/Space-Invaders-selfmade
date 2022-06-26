package objects.enemies;

import main.Main;
import main.Util;

import objects.Player;
import objects.enemies.types.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class EnemyHandler {

    private static int levelMap = 2;

    public static void loop(){
        while (true){
            checkCollisionPvE();

            deleteDeadEnemies();
        }

    }

    public static void checkCollisionPvE() {
        Player p = Main.getPlayer();


        ArrayList<ArrayList> enemys =  Enemies.getInstances();


        for(int j = 0; j < enemys.size(); j++){
            System.out.println(enemys + "     "+ j);

            for(int i = 0; i < enemys.get(j).size(); i++){
                JLabel enemy = null;

                if(j == 0){
                    Affe tempA = (Affe) enemys.get(j).get(i);
                    enemy = tempA.getJLabel();

                }else if(j == 1){
                    Puffy tempP = (Puffy) enemys.get(j).get(i);
                    enemy = tempP.getJLabel();
                    //System.out.println(tempP.isAlive());

                }else if(j == 2){
                    Dwarf tempD = (Dwarf) enemys.get(j).get(i);
                    enemy = tempD.getJLabel();

                }else if(j == 3){
                    Kitty tempK = (Kitty) enemys.get(j).get(i);
                    enemy = tempK.getJLabel();

                }else if(j == 4){
                    Unicorn tempU = (Unicorn) enemys.get(j).get(i);
                    enemy = tempU.getJLabel();

                }

                if(rectCollision(p.getJLabel(), enemy)) Main.getPlayer().gotHit();
            }

        }
        Util.sleep(100);


    }

    public static void gernarateLevel(){
        int x = levelMap;
        int numberEnemies = (int) (2.216883 - 0.7697576*x + Math.pow(0.8798266*x, 2) - Math.pow(0.1099424*x, 3) + Math.pow(0.005293009*x, 4) - Math.pow(0.00008628167*x, 5));

            //spawn
        spawnEnemies(numberEnemies);


        boolean stillAlive = isEnemyStillAlive();
        while(stillAlive) {
            Util.sleep(1000);
            stillAlive = isEnemyStillAlive();
        }
        levelMap++;
        Enemies.createLists();
        gernarateLevel();


    }

    private static void spawnEnemies(int numberEnemies) {
        Random r = new Random();

        for(int i = 0; i < numberEnemies; i++){
            int difficulty =(int) ( r.nextDouble(1, 2.5) + levelMap / 10 );
            int id = -1;


            if (difficulty == 1){ //Puffy,
                id =(int) r.nextDouble(1, 2.99) ;
                if (id == 1) Puffy.createInstance(); ;//spawn Puffy;
                if (id == 2) ;//spawn . . .

            }else if (difficulty == 2){ //Affe, Dwarf
                id = (int) r.nextDouble(1, 2.99) ; ;
                if (id == 1) Affe.createInstance(); //spawn Affe;
                if (id == 2) Dwarf.createInstance(); //spawn Dwarf

            }else if (difficulty >= 3){ //Kitty, Unicorn
                id = (int) r.nextDouble(1, 2.99);
                if (id == 1) Kitty.createInstance(); ;//spawn Kitty;
                if (id == 2) Unicorn.createInstance();//spawn Unicorn
            }else{
                System.out.println("Error while assigning enemy type");
            }
            Util.sleep(500); //TODO spawn rate vom level abhängig berechnen
            System.out.println("diff: "+difficulty + "   id: " + id);
        }

    }

    private static boolean isEnemyStillAlive(){
        boolean enemyStillAlive = false;
        for(ArrayList<ArrayList> list : Enemies.getInstances()){
            if(list.size() > 0){
                enemyStillAlive = true;

            }
        }
        return enemyStillAlive;
    }

    public static void deleteDeadEnemies() {
        ArrayList<ArrayList> enemys = Enemies.getInstances();

        for (int j = 0; j < enemys.size(); j++) {


            for (int i = 0; i < enemys.get(j).size(); i++) {


                if (j == 0) {
                    Affe tempA = (Affe) enemys.get(j).get(i);
                    if (!tempA.isAlive()) {
                        ((Affe) enemys.get(j).get(i)).removeJLabel();
                        enemys.get(j).remove(i);
                    }
                } else if (j == 1) {
                    Puffy tempP = (Puffy) enemys.get(j).get(i);
                    if (!tempP.isAlive()) {
                        ((Puffy) enemys.get(j).get(i)).removeJLabel();
                        enemys.get(j).remove(i);
                    }

                } else if (j == 2) {
                    Dwarf tempD = (Dwarf) enemys.get(j).get(i);
                    if (!tempD.isAlive()) {
                        ((Dwarf) enemys.get(j).get(i)).removeJLabel();
                        enemys.get(j).remove(i);
                    }

                } else if (j == 3) {
                    Kitty tempK = (Kitty) enemys.get(j).get(i);
                    if (!tempK.isAlive()) {
                        ((Kitty) enemys.get(j).get(i)).removeJLabel();
                        enemys.get(j).remove(i);
                    }

                } else if (j == 4) {
                    Unicorn tempU = (Unicorn) enemys.get(j).get(i);
                    if (!tempU.isAlive()) {
                        ((Unicorn) enemys.get(j).get(i)).removeJLabel();
                        enemys.get(j).remove(i);
                    }
                }
            }


        }
    }






    public static int getLevelMap() {
        return levelMap;
    }

    private static boolean rangeIntersect(int min, int max, int min1, int max1){
        return Math.max(min, max) >= Math.min(min1, max1) &&
                Math.min(min, max) <=  Math.max(min1, max1);
    }

    public static boolean rectCollision(JLabel rect, JLabel rect1) {
        return rangeIntersect(rect.getX(), rect.getX() + rect.getWidth(), rect1.getX(), rect1.getX() + rect1.getWidth()) &&
                rangeIntersect(rect.getY(), rect.getY() + rect.getHeight(), rect1.getY(), rect1.getY() + rect1.getHeight());
    }

}
