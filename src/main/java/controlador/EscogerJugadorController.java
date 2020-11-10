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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import modelo.Jugador;
import modelo.Partido;
import modelo.Tarjeta;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class EscogerJugadorController implements Initializable {

   
    @FXML
    private Button btnSiguiente;
    @FXML
    private Button btnVolver;
    
   
   
    @FXML
    private Label lblJugador;
    @FXML
    private Label lblPartido;
   
    private Jugador jugador;
    
    private Partido partido;
    @FXML
    private Button selecJugador;
    @FXML
    private Button selectPartido;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
       
        
        
        
        
        
        
        // TODO
    }    

    

    @FXML
    private void escogerJugador(MouseEvent event) {
        try {
            FXMLLoader loader1= new FXMLLoader(App.class.getResource("PersonasVista.fxml"));
            Parent root1= loader1.load();
            Scene scene1 = new Scene(root1);
            Stage stage1 = new Stage();
            stage1.initModality(Modality.APPLICATION_MODAL);
            stage1.setScene(scene1);  
            stage1.showAndWait();
            
            PersonasController controlador= loader1.getController();
            this.jugador=controlador.getTableView().getSelectionModel().getSelectedItem();
            String texto="Nombres: "+jugador.getNombres()+"\nApellidos: "+jugador.getApellidos()+"\nEquipo: "+jugador.getEquipo()+"\nPosicion"+jugador.getPosicion();
            lblJugador.setText(texto);
            
            
        } catch (IOException ex) {
            Logger.getLogger(EscogerJugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void agregarPartido(MouseEvent event) {
    }

}
