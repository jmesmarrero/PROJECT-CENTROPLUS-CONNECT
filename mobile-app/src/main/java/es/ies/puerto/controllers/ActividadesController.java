package es.ies.puerto.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ActividadesController {

    @FXML
    private ListView<String> listActividades;

    @FXML
    public void initialize() {
        ObservableList<String> actividades = FXCollections.observableArrayList(
            "Yoga - DEPORTIVA - 25.50€",
            "Programación Java - ACADEMICA - 40.00€",
            "Spinning - DEPORTIVA - 18.00€",
            "Inglés técnico - ACADEMICA - 30.00€",
            "Sistemas Linux - ACADEMICA - 45.00€"
        );
        listActividades.setItems(actividades);
    }
}