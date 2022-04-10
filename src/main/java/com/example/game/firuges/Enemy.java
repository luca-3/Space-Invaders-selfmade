package com.example.game.firuges;

import com.example.game.test.MobMove;
import com.example.game.test.Test;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.util.Random;

public class Enemy {

    Random zufall = new Random();
    int spawnHight = zufall.nextInt(980);

    String skin = ""; //skin of the enemy

    int height;
    int width;
    int hp; // health points
    int updateSpeed = 5; // speed of calculation


    public Enemy(Enum Type) {
        if (Type == Enum.Type1) {
            skin = Enum.Type1.getSkin();
            height = Enum.Type1.getHeight();
            width = Enum.Type1.getWidth();
            hp = Enum.Type1.getHp();

        }else if (Type == Enum.Type2) {
            skin = Enum.Type2.getSkin();
            height = Enum.Type2.getHeight();
            width = Enum.Type2.getWidth();
            hp = Enum.Type2.getHp();
        }

        enemyMain();

    }

    public void enemyMain(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); // get screen size
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();


        Rectangle enemy = new Rectangle(width-200, n, 100, 100);
        enemy.setFill(Color.BLUE);
        root.getChildren().add(enemy);



        enumo2v1(MobMove.HDMOVE, MobMove.HDMOVE.getSpeed(), enemy, n);
    }



    public void enumo2v1(Enum movementType, int speed, Rectangle rectangle, int spawnHight) {

        for (int x = 1980; x > 0; x -= speed) {

            double y = MobMove.bew(movementType, spawnHight, x);
            rectangle.setX(x);
            rectangle.setY(y);
            Test.sleep2(updateSpeed);
        }
    }
}
