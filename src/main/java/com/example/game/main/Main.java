package com.example.game.main;

import com.example.game.firuges.*;
import com.example.game.test.vorlage.Gamescreen;

import javax.swing.*;

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




        // add the game objects to the world
        //s.add(player);
        //s.add(enemyHandler);


        // start the game loop
        Thread screen = new Thread(() -> s.start());
        screen.start();

        Thread eH = new Thread(() -> enemyHandler.start(s));
        eH.start();

        Thread zielSytem = new Thread(()-> MobMoveE.bool());
        zielSytem.start();

    }






}

