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

    public static boolean gameRun;
    static EnemyHandler enemyHandler;
    static Screen s;
    public static Player player;


    public static void main(String[] args) {
        Main game = new Main();
        game.start();

    }

    public void start() {
        this.gameRun = false;
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

    public static void startSpiel() {
        if (!gameRun) {
            gameRun = true;
            s.startJ.setLocation(-100, -100);
            Thread screen = new Thread(() -> s.start());
            screen.start();
            Thread eH = new Thread(() -> enemyHandler.startEnemy());
            eH.start();
            Thread unicornTargeting = new Thread(MobMoveE::bool);
            unicornTargeting.start();
            Player.hp = 5;
            Player.score = 0;
            EnemyHandler.level = 1;

        }
    }

    public static void stopSpiel() {
        gameRun = false;
        s.levelEnd = true;
        Main.sleep(1000);
        s.startJ.setLocation(s.width / 2 - 100, s.height / 2);

    }

    public static Screen getScreen() {
        return s;
    }
}

