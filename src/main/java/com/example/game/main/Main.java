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

}