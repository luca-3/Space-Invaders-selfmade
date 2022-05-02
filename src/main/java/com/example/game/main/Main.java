package com.example.game.main;

import com.example.game.firuges.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Main
public class Main {
    EnemyHandler enemyHandler = new EnemyHandler();
    static Screen s;

    public static Screen getScreen(){return s;}

    public static void main(String[] args) {
        Main game = new Main();
        game.start();
    }

    public void start() {
        // create the game window
        s = new Screen();


        // create the game objects
        Player player = new Player("init");

        // start the game loop
        Thread screen = new Thread(() -> s.start());
        screen.start();

        Thread eH = new Thread(() -> enemyHandler.startEnemy());
        eH.start();

        Thread zielSytem = new Thread(()-> MobMoveE.bool());
        zielSytem.start();

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

}