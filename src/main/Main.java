package main;
//NEW


import objects.Player;
import objects.bullets.Bullethandler;
import objects.bullets.Bullets;
import objects.enemies.Enemies;
import objects.enemies.EnemyHandler;

import java.util.HashMap;

public class Main {
    static HashMap<String, Integer> daten;

    private static boolean pause;
    private static boolean colorsInverted = false;

    static Player player;
    static Screen s;

    public static void main(String[] args) {
        //no Dependencies
        Enemies.createLists();
        Bullets.createLists();

        daten = new HashMap<>();

        //Dependencies within the creation of the Object
        s = new Screen();
        HomeScreen s= new HomeScreen();
    }
    public static void startGame(){
        //Dependencies within the creation of the Object
        player = new Player();
        s.startGame();

        startThreading();

        pause = false;
        Util.startTimer();
    }


    private static void startThreading() {
        Thread movementPlayer = new Thread(() -> player.move());
        movementPlayer.setName("T - movementPlayer");
        movementPlayer.start();

        Thread spaceKeyPlayer = new Thread(() -> player.shoot());
        spaceKeyPlayer.setName("T - spaceKeyPlayer");
        spaceKeyPlayer.start();

        Thread updaterTags = new Thread(() -> s.updateTags());
        updaterTags.setName("T - updaterTags");
        updaterTags.start();

        Thread levelSpawn = new Thread(() -> EnemyHandler.generateLevel());
        levelSpawn.setName("T - levelSpawn");
        levelSpawn.start();

        Util.sleep(2000);

        Thread loopColision = new Thread(() -> EnemyHandler.checkCollisionPvE());
        loopColision.setName("T - loopColision");
        loopColision.start();

        Thread colisionBullets = new Thread(() -> Bullethandler.collision());
        colisionBullets.setName("T - colisionBullets");
        colisionBullets.start();

    }

    public static void restartGame(){
        setPause(true);
        Util.sleep(1000);

        Enemies.createLists();
        Bullets.createLists();
        daten = new HashMap<>();

        player.reset();

        startThreading();
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
        Main.pause = pause;
        if (pause) {
            //TODO: Pause-Screen
        }
    }

    public static Screen getScreen() {
        return s;
    }

    public static Player getPlayer() {
        return player;
    }

    public static boolean isColorsInverted() {
        return colorsInverted;
    }

    public static void setColorsInverted(boolean colorsInverted) {
        Main.colorsInverted = colorsInverted;
    }

}
