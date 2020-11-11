/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import modelo.Equipo;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class EquiposController implements Initializable {

    @FXML
    private Button btnAgregar;
    @FXML
    private TableColumn colImagen;
    @FXML
    private TableColumn colNombre;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtFiltrarNombre;
    @FXML
    private Button btnAceptar;
    @FXML
    private TableColumn colCampeonato;
    @FXML
    private TableColumn colWFV;
    @FXML
    private TableView<Equipo> tblEquipos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void agregarPersona(ActionEvent event) {
    }

    @FXML
    private void modificar(ActionEvent event) {
    }

    @FXML
    private void eliminar(ActionEvent event) {
    }

    @FXML
    private void filtrarNombre(KeyEvent event) {
    }

    @FXML
    private void aceptar(ActionEvent event) {
    }
    
}
