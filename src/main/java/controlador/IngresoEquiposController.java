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
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class IngresoEquiposController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private Spinner<Integer> spWFV;
    @FXML
    private Button btnCampeonato;
    @FXML
    private Button btnSalir;
    @FXML
    private Button btnGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void escogerCampeonato(ActionEvent event) {
    }

    @FXML
    private void salir(ActionEvent event) {
    }

    @FXML
    private void guardar(ActionEvent event) {
    }
    
}
