package com.example.game.main;
import com.example.game.figures.*;

//Main

/*
Wie wird etwas Verändert:
Veränderungen finden in den Enums statt, wenn du
einen neun Enemy erstellen möchtest, kannst du das
in "EnemyE" machen. Wenn du einen Enemy erstellst, kannst
du in "MobMoveE" gleich das Bewegungsmuster machen. Weil
du wahrscheinlich dein Enemy im Spiel haben möchtest,
kannst du in "Level" dein Enemy zu den bestehenden Levels
hinzufügen oder sogar deine eigenen Level erstellen.
Alle Enums findest du in dem "figures" Ordner.
*/
public class Main {

    private boolean gameRun;
    static EnemyHandler enemyHandler;
    static Screen s;
    public static Player player;
    private static Main game = new Main();

    public static void main(String[] args) {
        game.start();
    }

    private void start() {
        this.enemyHandler = new EnemyHandler();

        // create the game objects
        this.player = new Player("init");

        // create the game window
        this.s = new Screen();
    }


    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Screen getScreen() {
        return s;
    }

    public static void setGameRun(boolean gameRun) { //have to meke method not static
        Main.getInstance().gameRun = gameRun;
        if (gameRun){
            s.startJ.setLocation(-100, -100);
            Thread screen = new Thread(() -> s.start());
            screen.start();
            Thread eH = new Thread(() -> enemyHandler.startEnemy());
            eH.start();
            Thread unicornTargeting = new Thread(MobMoveE::bool);
            unicornTargeting.start();
            Main.enemyHandler.setLevel(1);
        } else if (!gameRun) {
            s.levelEnd = true;

            Main.player.reset();
            Main.sleep(1000);
            s.startJ.setLocation(s.width / 2 - 100, s.height / 2);
        }

    }

    public boolean isGameRun() {
        return gameRun;
    }

    public static Main getInstance(){
        return game;
    }

    public static EnemyHandler getEnemyHandler(){
        return enemyHandler;
    }
}

