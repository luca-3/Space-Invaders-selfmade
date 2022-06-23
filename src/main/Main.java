package main;
//NEW


import objects.Player;
import objects.enemies.Affe;

import java.util.HashMap;

public class Main {
    static HashMap<String, Integer> daten;
    private static boolean pause;
    static Player player;
    static Screen s;

    public static void main(String[] args) {

        daten = new HashMap<>();
        s = new Screen();
        player = new Player();
        s.generateTags();

        startThreading();


        pause = false;
        Util.startTimer();

        Affe a = new Affe();
        Util.sleep(1000);
        a.move();

    }


    private static void startThreading() {
        Thread wKeyPlayer = new Thread(() -> player.wKeyMovement());
        wKeyPlayer.start();

        Thread aKeyPlayer = new Thread(() -> player.aKeyMovement());
        aKeyPlayer.start();

        Thread sKeyPlayer = new Thread(() -> player.sKeyMovement());
        sKeyPlayer.start();

        Thread dKeyPlayer = new Thread(() -> player.dKeyMovement());
        dKeyPlayer.start();

        Thread spaceKeyPlayer = new Thread(() -> player.spaceKeyMovement());
        spaceKeyPlayer.start();

        Thread updaterTags = new Thread(() -> s.updateTags());
        updaterTags.start();
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
        daten.put("level", 0); //Main
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
}
