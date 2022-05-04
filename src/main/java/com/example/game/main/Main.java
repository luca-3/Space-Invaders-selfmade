package com.example.game.main;
import com.example.game.firuges.*;

//Main
public class Main {

    public static boolean gameRun = false;
    static EnemyHandler enemyHandler = new EnemyHandler();
    static Screen s;
    public static Player player;

    public static Screen getScreen(){return s;}


    public static void main(String[] args) {
        Main game = new Main();
        game.start();
    }

    public void start() {
        // create the game objects
        player = new Player("init");

        // create the game window
        s = new Screen();




        // start the game loop


    }
    /*
    Wie wird etwas Verändert:
    Veränderungen finden in den Enums statt, wenn du
    einen neun Enemy erstellen möchtest, kannst du das
    in "EnemyE" machen. Wenn du einen Enemy erstellst, kannst
    du in "MobMoveE" gleich das Bewegungsmuster machen. Weil
    du wahrscheinlich dein Enemy im Spiel haben möchtest,
    kannst du in "Level" dein Enemy zu den bestehenden Levels
    hinzufügen oder sogar deine eigenen Level erstellen.
    Alle Enums findest du in dem "figures" Ordner
     */

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
            System.out.println("testdxcfgvbhnjmk");
            s.startJ.setLocation(-100, -100);
            Thread screen = new Thread(() -> s.start());
            screen.start();

            Thread eH = new Thread(() -> enemyHandler.startEnemy());
            eH.start();

            Thread unicornTargeting = new Thread(MobMoveE::bool);
            unicornTargeting.start();
        }
    }

}