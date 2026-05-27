package es.ies.puerto.controllers;

import java.util.List;

import es.ies.puerto.models.Actividad;
import es.ies.puerto.repositories.sqlite.ActividadRepository;
import es.ies.puerto.services.IActividadService;
import es.ies.puerto.services.impl.ActividadServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ActividadesController {

    @FXML
    private ListView<String> listActividades;

    @FXML
    public void initialize() {
        String url = "jdbc:sqlite:../database/centroplus.db";
        ActividadRepository repo = new ActividadRepository(url);
        IActividadService service = new ActividadServiceImpl(repo);

        List<Actividad> actividades = service.findAll();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Actividad a : actividades) {
            items.add(a.getNombre() + " - " + a.getTipoActividad() + " - " + a.getPrecio() + "€");
        }
        listActividades.setItems(items);
    }
}
