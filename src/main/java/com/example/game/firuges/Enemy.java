package com.example.game.firuges;

import com.example.game.main.main;
import com.example.game.test.MobMove;
import com.example.game.test.Test;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.util.Random;

public class Enemy {

    int spawnHight; // spawn height of enemy on the right side of the screen
    int screenWidth;
    int screenHeight;
    String skin = ""; //skin of the enemy
    int height;
    int width;
    int hp; // health points
    int updateSpeed = 5; // speed of calculation
    Rectangle enemy;


    public Enemy(EnemyEnum Type) {
        getScreenWidth();
        if (Type == EnemyEnum.AFFE) {
            this.skin = EnemyEnum.AFFE.getSkin();
            this.height = EnemyEnum.AFFE.getHeight();
            this.width = EnemyEnum.AFFE.getWidth();
            this.hp = EnemyEnum.AFFE.getHp();
            this.enemy = new Rectangle(this.width, this.height, EnemyEnum.AFFE.getColor());

        }else if (Type == EnemyEnum.BANNANE) {
            this.skin = EnemyEnum.BANNANE.getSkin();
            this.height = EnemyEnum.BANNANE.getHeight();
            this.width = EnemyEnum.BANNANE.getWidth();
            this.hp = EnemyEnum.BANNANE.getHp();
            this.enemy = new Rectangle(this.width, this.height, EnemyEnum.BANNANE.getColor());
        }

        Random zufall = new Random();
        this.spawnHight = zufall.nextInt(980);

    }

    public void start() {
        enemyMain();
    }

    public Rectangle getRectangle() {
        return enemy;
    }

    public void enemyMain(){

    }

    private void getScreenWidth() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); // get screen size
        this.screenWidth = (int) size.getWidth();
        this.screenHeight = (int) size.getHeight();
    }

}