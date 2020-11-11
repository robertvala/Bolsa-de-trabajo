/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Campeonato;
import modelo.Jugador;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class IngresoCampeonatosController implements Initializable {

    @FXML
    private TextField txtNombreCampeonato;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnSalir;
    @FXML
    private DatePicker dateFechaCierre;
    @FXML
    private DatePicker dateFechaInicio;
    @FXML
    private Spinner<Integer> spWFV;
    @FXML
    private ChoiceBox<String> selectPais;
    
     private ObservableList<Campeonato> campeonatos;
     private Campeonato campeonato;
     private ObservableList<String> paises;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paises=FXCollections.observableArrayList();
        paises.add("Ecuador");
        paises.add("Peru");
        selectPais.setItems(paises);
        
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        spWFV.setValueFactory(ivf);
        // TODO
    }    

    @FXML
    private void guardar(ActionEvent event) {
        
       try{
        String nombre = this.txtNombreCampeonato.getText();
        LocalDate fechaInicio = this.dateFechaInicio.getValue();
        LocalDate fechaFin = this.dateFechaCierre.getValue();
        int WFV = this.spWFV.getValue();
        String pais = this.selectPais.getValue();

        // Creo la jugador
        Campeonato c = new Campeonato(fechaInicio, fechaFin, nombre, WFV, pais);

        // Compruebo si la jugador existe
        if (!campeonatos.contains(c)) {

            // Modificar
            if (this.campeonato != null) {
                this.campeonato.setNombre(nombre);
                this.campeonato.setFechaFin(fechaFin);
                this.campeonato.setFechainicio(fechaInicio);
                this.campeonato.setPais(pais);
                this.campeonato.setValorWFV(WFV);
                // Modifico el objeto

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha modificado correctamente");
                alert.showAndWait();

            }
        }
        
        else {
                // insertando

                this.campeonato = c;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha añadido correctamente");
                alert.showAndWait();

            }
        
        // Cerrar la ventana
            Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
            stage.close();
       }
       
        catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Dato ingresado incorrectamente");
            alert.showAndWait();
        }
       
       
    }

    @FXML
    private void salir(ActionEvent event) {
        this.campeonato= null;
        //Cierro la ventana
        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();
    }

    void initAtribute(ObservableList<Campeonato> campeonatos) {
        this.campeonatos=campeonatos;
    }

    void initAtributtes(ObservableList<Campeonato> campeonatos, Campeonato c) {
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        this.campeonatos=campeonatos;
        this.campeonato=c;
        
        //Cargo los datos del campeonato
        this.txtNombreCampeonato.setText( this.campeonato.getNombre());
        this.dateFechaInicio.setValue(this.campeonato.getFechainicio());
        this.dateFechaCierre.setValue(this.campeonato.getFechaFin());
        ivf.setValue(this.campeonato.getValorWFV());
        this.spWFV.setValueFactory(ivf);
        this.selectPais.setValue(this.campeonato.getPais());
        
    }

    Campeonato getTarjeta() {
        return campeonato;
    }
    
}
