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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class PartidosController implements Initializable {

    @FXML
    private Button btnAgregar;
    @FXML
    private TableView<?> tblJugadores;
    @FXML
    private TableColumn<?, ?> colImagen;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtFiltrarNombre;
    @FXML
    private TableColumn<?, ?> colPartido;
    @FXML
    private TableColumn<?, ?> colFecha;
    @FXML
    private TableColumn<?, ?> colMarcador;
    @FXML
    private TableColumn<?, ?> colEquipoLocal;
    @FXML
    private TableColumn<?, ?> colEquipoVisitante;
    @FXML
    private TableColumn<?, ?> colCampeonato;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void agregarPersona(ActionEvent event) {
        try {
            FXMLLoader loader1= new FXMLLoader(App.class.getResource("IngresarPartido.fxml"));
            Parent root1= loader1.load();
            Scene scene1 = new Scene(root1);
            Stage stage1 = new Stage();
            stage1.initModality(Modality.APPLICATION_MODAL);
            stage1.setScene(scene1);  
            stage1.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(PartidosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
    
}
