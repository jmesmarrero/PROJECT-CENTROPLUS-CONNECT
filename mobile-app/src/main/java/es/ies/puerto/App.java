package es.ies.puerto;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("CentroPlus Connect");
        stage.setWidth(390);
        stage.setHeight(760);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
