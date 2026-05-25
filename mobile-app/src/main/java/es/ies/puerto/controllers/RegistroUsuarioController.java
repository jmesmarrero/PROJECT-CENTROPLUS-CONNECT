package es.ies.puerto.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistroUsuarioController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDni;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTelefono;

    @FXML
    private Button btnRegistrar;

    @FXML
    private void registrarUsuario() {
        System.out.println("Nombre: " + txtNombre.getText());
        System.out.println("DNI: " + txtDni.getText());
        System.out.println("Email: " + txtEmail.getText());
        System.out.println("Telefono: " + txtTelefono.getText());
    }
}
