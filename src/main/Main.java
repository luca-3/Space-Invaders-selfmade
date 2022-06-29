package main;
//NEW


import objects.GameObjects;
import objects.Player;
import objects.bullets.Bullets;
import objects.enemies.Enemies;
import objects.enemies.EnemyHandler;
import objects.enemies.types.Affe;
import objects.enemies.types.Puffy;

import java.util.HashMap;

public class Main {
    static HashMap<String, Integer> daten;
    private static boolean pause;


    static Player player;
    static Screen s;

    public static void main(String[] args) {

        //no Dependencies
        Enemies.createLists();
        Bullets.createLists();
        daten = new HashMap<>();

        //Dependencies within the creation of the Object
        s = new Screen();
        player = new Player();
        s.generateTags();

        startThreading();

        pause = false;
        Util.startTimer();

        new EnemyHandler();

    }


    private static void startThreading() {
        Thread movementPlayer = new Thread(() -> player.move());
        movementPlayer.setName("T - movementPlayer");
        movementPlayer.start();

        Thread spaceKeyPlayer = new Thread(() -> player.spaceKeyMovement());
        spaceKeyPlayer.setName("T - spaceKeyPlayer");
        spaceKeyPlayer.start();

        Thread updaterTags = new Thread(() -> s.updateTags());
        updaterTags.setName("T - updaterTags");
        updaterTags.start();

        Thread levelSpawn = new Thread(() -> EnemyHandler.gernarateLevel());
        levelSpawn.setName("T - levelSpawn");
        levelSpawn.start();

        Util.sleep(2000);

        Thread loopColisionAndRemove = new Thread(() -> EnemyHandler.loop());
        loopColisionAndRemove.setName("T - loopColisionAndRemove");
        loopColisionAndRemove.start();
    }

    /*
    public static void updater(){ //update Data used in Game
        while(true){
            s.autoUpdateScreenDimensions();
            //TODO: bei Veränderungen der Bildschirmdimensionen muss diese Zahl angepasst werden

            Util.sleep(1000);
        }
    }
     */

    public static void updateDataTags(){
        //TODO: Wo 0 steht muss die entsprechende Datenquelle eingetragen werden
        daten.put("score", player.getScore()); //Player get score
        daten.put("lives", player.getHealthpoints()); //Player get lives
        daten.put("level", EnemyHandler.getLevelMap()); //Main
    }

    public static HashMap getDataTags(){
        updateDataTags();
        return daten;
    }

    public static boolean isPause() {
        return pause;
    }

    public static void setPause(boolean pause) {
        pause = pause;
    }

    public static Screen getScreen() {
        return s;
    }

    public static Player getPlayer() {
        return player;
    }

}
