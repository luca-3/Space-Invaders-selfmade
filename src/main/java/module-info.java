module com.example.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.game to javafx.fxml;
    exports com.example.game;
    exports com.example.game.firuges;
    opens com.example.game.firuges to javafx.fxml;
    opens com.example.game.test to javafx.fxml;
    exports com.example.game.test;
    exports com.example.game.main;
    opens com.example.game.main to javafx.fxml;
}