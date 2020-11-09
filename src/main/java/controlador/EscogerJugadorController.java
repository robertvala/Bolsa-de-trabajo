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
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class EscogerJugadorController implements Initializable {

    @FXML
    private ComboBox<?> selectJugador;
    @FXML
    private Button btnNuevoJugador;
    @FXML
    private Button btnSiguiente;
    @FXML
    private Button btnVolver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nuevoPartido(ActionEvent event) {
    }

    @FXML
    private void siguiente(ActionEvent event) {
    }

    @FXML
    private void volver(ActionEvent event) {
    }
    
}
