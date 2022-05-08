module com.example.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    exports com.example.game.figures;
    opens com.example.game.figures to javafx.fxml;
    exports com.example.game.main;
    opens com.example.game.main to javafx.fxml;
}