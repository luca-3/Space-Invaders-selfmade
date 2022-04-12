package com.example.game.firuges;

import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.util.Random;

public class Enemy {

    private int spawnHight; // spawn height of enemy on the right side of the screen
    private int screenWidth;
    private int screenHeight;
    private String skin = ""; //skin of the enemy
    private int height;
    private int width;
    private int hp; // health points
    private Rectangle enemy;


    public Enemy(EnemyEnum type) {
        getScreenWidth();
        if (type == EnemyEnum.AFFE) {
            this.skin = EnemyEnum.AFFE.getSkin();
            this.height = EnemyEnum.AFFE.getHeight();
            this.width = EnemyEnum.AFFE.getWidth();
            this.hp = EnemyEnum.AFFE.getHp();
            this.enemy = new Rectangle(this.width, this.height, EnemyEnum.AFFE.getColor());

        }else if (type == EnemyEnum.BANNANE) {
            this.skin = EnemyEnum.BANNANE.getSkin();
            this.height = EnemyEnum.BANNANE.getHeight();
            this.width = EnemyEnum.BANNANE.getWidth();
            this.hp = EnemyEnum.BANNANE.getHp();
            this.enemy = new Rectangle(this.width, this.height, EnemyEnum.BANNANE.getColor());
        }

        Random zufall = new Random();
        this.spawnHight = zufall.nextInt(980);

    }

    public Rectangle getRectangle() {
        return enemy;
    }


    private void getScreenWidth() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); // get screen size
        this.screenWidth = (int) size.getWidth();
        this.screenHeight = (int) size.getHeight();
    }

}