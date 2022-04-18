package com.example.game.main;

import com.example.game.firuges.*;


public class Main {

    public static void main(String[] args) {
        Main game = new Main();
        game.start();
    }

    public void start() {
        // create the game window
        Screen s = new Screen();

        // create the game objects
        //Player player = new Player();
        EnemyHandler enemyHandler = new EnemyHandler();


        // add the game objects to the world
        //s.add(player);
        //s.add(enemyHandler);

        // start the game loop
        s.start();

    }

}

