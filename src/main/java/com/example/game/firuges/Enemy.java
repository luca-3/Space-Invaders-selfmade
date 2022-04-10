package com.example.game.firuges;

import com.example.game.main.main;
import com.example.game.test.MobMove;
import com.example.game.test.Test;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.util.Random;

public class Enemy {

    Random zufall = new Random();
    int spawnHight = zufall.nextInt(980);
    int screenWidth;
    int screenHeight;

    String skin = ""; //skin of the enemy

    int height;
    int width;
    int hp; // health points
    int updateSpeed = 5; // speed of calculation





    public Enemy(EnemyEnum Type) {
        getScreenWidth();
        if (Type == EnemyEnum.AFFE) {
            skin = EnemyEnum.AFFE.getSkin();
            height = EnemyEnum.AFFE.getHeight();
            width = EnemyEnum.AFFE.getWidth();
            hp = EnemyEnum.AFFE.getHp();

        }else if (Type == EnemyEnum.BANNANE) {
            skin = EnemyEnum.BANNANE.getSkin();
            height = EnemyEnum.BANNANE.getHeight();
            width = EnemyEnum.BANNANE.getWidth();
            hp = EnemyEnum.BANNANE.getHp();
        }

    }

    public void start(){
        enemyMain();

    }

    public void enemyMain(){



    }







    private void getScreenWidth() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); // get screen size
        this.screenWidth = (int) size.getWidth();
        this.screenHeight = (int) size.getHeight();
    }

}