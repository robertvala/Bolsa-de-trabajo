/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import modelo.Partido;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class IngresarPartidoController implements Initializable {

    @FXML
    private ChoiceBox<?> selectCampeonato;
    @FXML
    private Spinner<?> spGolesLocal;
    @FXML
    private ComboBox<?> selectEquipoLocal;
    @FXML
    private ComboBox<?> selectEquipovisitante;
    @FXML
    private Spinner<?> spGolesVisitantes;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnSalie;
    
    private Partido partido;
    private ObservableList<Partido> partidos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void guardar(MouseEvent event) {
    }

    @FXML
    private void salir(MouseEvent event) {
    }
    
    void initAtributtes (ObservableList<Partido> partidos){
        this.partidos=partidos;
    }
    
    public Partido getPartido(){
        return this.partido;
    }
    
    void initAtributtes(ObservableList<Partido> partidos,Partido partido){
        
    }
}
