package com.example.game.firuges;

import com.example.game.test.MobMove;
import com.example.game.test.Test;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.util.Random;

public class Enemy {

    public void enemyMain(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); // get screen size
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();

        Random zufall = new Random();
        int n = zufall.nextInt(980);


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
            Test.sleep2(5);
        }
    }
}
