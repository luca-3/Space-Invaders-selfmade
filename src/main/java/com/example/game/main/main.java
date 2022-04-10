package com.example.game.main;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        Text score = new Text(100, 100, "Score: 200");
        root.getChildren().add(score);


        stage.setTitle("Game");
        stage.setFullScreen(true);


        stage.setScene(scene);
        stage.show();
    }

}




