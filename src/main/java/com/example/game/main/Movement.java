package com.example.game.main;

import com.example.game.firuges.Enemy;
import com.example.game.firuges.Player;

public class Movement {


    public void addVector(Vector vector, Player player) {
        player.setX(player.getX() + vector.getX());
        player.setY(player.getY() + vector.getY());
    }

    public void addVector(Vector vector, Enemy enemy) {
        enemy.setX(enemy.getX() + vector.getX());
        enemy.setY(enemy.getY() + vector.getY());
    }



}


