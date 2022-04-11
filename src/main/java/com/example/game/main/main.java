package com.example.game.main;


import com.example.game.firuges.Enemy;
import com.example.game.firuges.EnemyEnum;
import com.example.game.test.MobMove;
import com.example.game.test.Test;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Random;



public class main extends Application {
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); // get screen size
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    Group root = new Group();
    Scene scene = new Scene(root, width, height);
    Stage stage = new Stage();
    Rectangle rectangle = new Rectangle(100, 100, 100, 100);

    public static void main(String[] args) {
        launch(args);

    }

    public void addRectangleToRoot(Rectangle rectangle) {
        root.getChildren().add(rectangle);
    }

    public void start(Stage primaryStage) throws Exception {

        stage.setTitle("Game");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); // get screen size
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();


        Rectangle rectangle = new Rectangle(100, 100, 100, 100);
        rectangle.setFill(Color.RED);
        root.getChildren().add(rectangle);

        Random zufall = new Random();
        int spawnHight = zufall.nextInt(980);

        Enemy name = new Enemy(EnemyEnum.BANNANE);



        Rectangle enemy = new Rectangle(width-200, zufall.nextInt(980), 100, 100);
        enemy.setFill(Color.BLUE);
        root.getChildren().add(enemy);
        Thread enemyThread = new Thread(() ->  enumo2v1(MobMove.HDMOVE, MobMove.HDMOVE.getSpeed(), enemy, zufall.nextInt(980), width-200));



        Rectangle affe = new Rectangle(width-200, zufall.nextInt(980), EnemyEnum.AFFE.getWidth(), EnemyEnum.AFFE.getHeight());
        affe.setFill(Color.BROWN);
        root.getChildren().add(affe);
        Thread affeThread = new Thread(() ->  enumo2v1(MobMove.EHDMOVE, MobMove.EHDMOVE.getSpeed(), affe, zufall.nextInt(980), width-200));


        Rectangle bannane = new Rectangle(width-200, zufall.nextInt(980), EnemyEnum.BANNANE.getWidth(), EnemyEnum.BANNANE.getHeight());
        bannane.setFill(Color.YELLOW);
        Thread bannaneThread = new Thread(() ->  bannane(affe, bannane));



        Thread mainEnemyThread = new Thread(() -> spawn(enemyThread, affeThread, bannaneThread));
        mainEnemyThread.start();


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
    }

    public void enumo2v1(Enum movementType, int speed, Rectangle rectangle, int spawnHight, int spawnWidth) {

        for (int x = spawnWidth; x > 0; x -= speed) {

            double y = MobMove.bew(movementType, spawnHight, x);
            rectangle.setX(x);
            rectangle.setY(y);

            Test.sleep2(5);

        }
}
    public void bannane(Rectangle affe, Rectangle bannane){
       while(affe.getX()!=10) {
           int affeX = (int) affe.getX();
           int affeY = (int) affe.getY();
           root.getChildren().add(bannane);
           bannane.setX(affeX);
           bannane.setY(affeY);
           enumo2v1(MobMove.SMOVE, MobMove.SMOVE.getSpeed(), bannane, affeY, affeX);
           Test.sleep2(1000);
       }
    }

    public void spawn(Thread enemyThread, Thread affeThread, Thread bannaneThread){
        Random zufall = new Random();
        while (true) {
            int z = zufall.nextInt(3);
            if (z == 1) {
                enemyThread.start();
            } else if (z == 2) {
                affeThread.start();
                bannaneThread.start();
            }
            System.out.println(z);
            Test.sleep2(5000);
        }
    }

}
