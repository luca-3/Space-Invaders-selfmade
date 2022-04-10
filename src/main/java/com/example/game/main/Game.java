package com.example.game.main;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Game {

    //Methode to initialize the game
    public void start() {

        System.out.println("Game started");
        VBox vBox = new VBox(new Label("A JavaFX Label"));
        Scene scene = new Scene(vBox);

        Stage stage = new Stage();
        stage.setScene(scene);

    }
}
