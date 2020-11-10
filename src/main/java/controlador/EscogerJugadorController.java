/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Jugador;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class EscogerJugadorController implements Initializable {

    @FXML
    private ComboBox<Jugador> selectJugador;
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
        try {
            FXMLLoader loader1= new FXMLLoader(App.class.getResource("Partidos.fxml"));
            Parent root1= loader1.load();
            Scene scene1 = new Scene(root1);
            Stage stage1 = new Stage();
            stage1.initModality(Modality.APPLICATION_MODAL);
            stage1.setScene(scene1);  
            stage1.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(EscogerJugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void siguiente(ActionEvent event) {
    }

    @FXML
    private void volver(ActionEvent event) {
    }
    
}
