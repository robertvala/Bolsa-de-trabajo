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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class MenuPrincipalController implements Initializable {

    @FXML
    private Button btnJugadores;
    @FXML
    private Button btnTarjetas;
    @FXML
    private Button btnPostulantes;
    @FXML
    private ListView<?> tblJugadores;
    @FXML
    private ListView<?> tblTarjetas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
   

    @FXML
    private void menuTarjetas(MouseEvent event) {
    }

    @FXML
    private void menuPostulantes(MouseEvent event) {
    }

    @FXML
    private void menuJugadores(MouseEvent event) {
        try {
            FXMLLoader loader= new FXMLLoader(App.class.getResource("PersonasVista.fxml"));
            Parent root= loader.load();
            Scene scene= new Scene(root);
            Stage stage= new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
