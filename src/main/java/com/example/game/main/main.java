package com.example.game.main;


import com.example.game.test.MobMove;
import com.example.game.test.Test;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.Random;


public class main extends Application {
    Group root = new Group();
    Scene scene = new Scene(root);
    Stage stage = new Stage();
    Rectangle rectangle = new Rectangle(100, 100, 100, 100);

    public static void main(String[] args) {
        launch(args);


    }

    public void start(Stage primaryStage) throws Exception {

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        int width = (int)size.getWidth();

        int height = (int)size.getHeight();

        Random zufall = new Random();
        int n = zufall.nextInt(1080);
        Rectangle rectangle = new Rectangle(100, 100, 100, 100);
        rectangle.setFill(Color.RED);
        root.getChildren().add(rectangle);

        Rectangle enemy = new Rectangle(width-200, n, 100, 100);
        enemy.setFill(Color.BLUE);
        root.getChildren().add(enemy);

        new Thread(new Runnable() {
            @Override
            public void run() {
                enumo2v1(MobMove.NMOVE, MobMove.NMOVE.getSpeed(), enemy);
            }
        }).start();

        stage.setTitle("Game");
        stage.setFullScreen(true);

        stage.setScene(scene);
        stage.show();

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.W) {
                updatePosition(0, -10, rectangle);
            } else if (key.getCode() == KeyCode.S) {
                updatePosition(0, 10, rectangle);
            } else if (key.getCode() == KeyCode.A) {
                updatePosition(-10, 0, rectangle);
            } else if (key.getCode() == KeyCode.D) {
                updatePosition(10, 0, rectangle);
            }
        });
    }

    public void controls() {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.W) {
                updatePosition(0, -10, rectangle);
            } else if (key.getCode() == KeyCode.S) {
                updatePosition(0, 10, rectangle);
            } else if (key.getCode() == KeyCode.A) {
                updatePosition(-10, 0, rectangle);
            } else if (key.getCode() == KeyCode.D) {
                updatePosition(10, 0, rectangle);
            }
        });
    }

    public  void updatePosition(int x, int y, Rectangle rectangle) {
        int oldX = (int) rectangle.getX();
        int oldY = (int) rectangle.getY();
        rectangle.setX(oldX+x);
        rectangle.setY(oldY+y);
        update();
    }

    public void update(){
        stage.show();
    }

    public void enumo2v1(Enum t, int sp, Rectangle rectangle){



        for (int x = 200; x> 0; x-= sp){

            int x1= -sp*20;
            double y = MobMove.bew(t, x);

            int y1 = (int)y;
            updatePosition(10 , 10, rectangle);


            Test.sleep2(1000);
        }
    }



}