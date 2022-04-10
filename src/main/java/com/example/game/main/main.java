package com.example.game.main;


import com.example.game.test.Test;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;


public class main extends Application {
    Group root = new Group();
    Scene scene = new Scene(root);
    Stage stage = new Stage();

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {


        Text score = new Text(100, 100, "Score: 200");
        root.getChildren().add(score);
        Rectangle rec = new Rectangle();
        Line line = new Line(100, 100, 200, 200);
        line.rotateProperty().set(45);
        root.getChildren().add(line);


        Rectangle rectangle = new Rectangle(100, 100, 100, 100);
        rectangle.setFill(Color.RED);
        root.getChildren().add(rectangle);



        stage.setTitle("Game");
        stage.setFullScreen(true);

        stage.setScene(scene);
        stage.show();

    }



}




