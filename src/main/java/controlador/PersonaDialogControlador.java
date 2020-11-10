/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.Partido;
import modelo.Persona;

public class PersonaDialogControlador implements Initializable {

    private TextField txtEdad;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtNombre;

    private Jugador jugador;

    private ObservableList<Jugador> jugadores;
    @FXML

    
    private Button btnGuardar;
    @FXML
    private Button btnSalir;
    @FXML
    private TextField txtEquipo;
    @FXML
    private TextField txtPosicion;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtPais;
    @FXML
    private TextField txtCiudad;
    @FXML
    private TextField txtCelular;
    @FXML
    private DatePicker dateFechaNacimiento;
    @FXML
    private ChoiceBox<String> selectSexo;
    
    @FXML
    private TextField txtCorreo;
    
    private ObservableList<String> sexos;
    @FXML
    private ChoiceBox<String> selectLiga;
    
    private ObservableList<String> ligas;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sexos=FXCollections.observableArrayList();
        sexos.add("Masculino");
        sexos.add("Fememino");
        selectSexo.setItems(sexos);
        
        ligas=FXCollections.observableArrayList();
        ligas.add("Primera B");
        ligas.add("Segunda categoria");
        selectLiga.setItems(ligas);

    }

    public void initAtributtes(ObservableList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void initAtributtes(ObservableList<Jugador> jugadores,Jugador jugador) {
        this.jugadores = jugadores;
        this.jugador = jugador;
        // cargo los datos de la jugador
        this.txtNombre.setText(this.jugador.getNombres());
        this.txtApellidos.setText(this.jugador.getApellidos());
        this.txtCelular.setText(this.jugador.getCelular()+"");
        this.dateFechaNacimiento.setValue(this.jugador.getFechaNacimiento());
        this.txtPais.setText(this.jugador.getPais());
        this.txtCiudad.setText(this.jugador.getCiudad());
        //this.selectSexo.setSelectionModel(value);
        this.txtEquipo.setText(this.jugador.getEquipo());
        this.txtPosicion.setText(this.jugador.getPosicion());
        this.txtCedula.setText(this.jugador.getCedula()+"");
        this.txtCorreo.setText(this.jugador.getCorreo());
        this.selectSexo.setValue(this.jugador.getSexo());
        this.selectLiga.setValue(this.jugador.getLiga());
        //esto es para probar si se sube o no
        
        
        
        
        
        
    }

    public Jugador getJugador() {
        return jugador;
    }

    @FXML
    private void guardar(ActionEvent event) {
        
        try{
        // Cojo los datos
        String nombre = this.txtNombre.getText();
        String apellidos = this.txtApellidos.getText();
        //int edad = Integer.parseInt(this.txtEdad.getText());
        String posicion= this.txtPosicion.getText();
        String pais=this.txtPais.getText();
        String correo=this.txtCorreo.getText();
        String ciudad=this.txtCiudad.getText();
        String sexo=this.selectSexo.getValue();
        LocalDate fechaNacimiento=this.dateFechaNacimiento.getValue();
        String equipo = this.txtEquipo.getText();
        String liga= this.selectLiga.getValue();
        int celular=Integer.parseInt(this.txtCelular.getText());
        int cedula=Integer.parseInt(this.txtCedula.getText());
        
        

        // Creo la jugador
        Jugador j = new Jugador(equipo,posicion,nombre, apellidos, fechaNacimiento,celular,cedula,correo,pais,ciudad,liga,sexo );

        // Compruebo si la jugador existe
        if (!jugadores.contains(j)) {

            // Modificar
            if (this.jugador != null) {

                // Modifico el objeto
                this.jugador.setNombres(nombre);
                this.jugador.setApellidos(apellidos);
                this.jugador.setFechaNacimiento(fechaNacimiento);
                this.jugador.setEquipo(equipo);
                this.jugador.setPosicion(posicion);
                this.jugador.setCelular(celular);
                this.jugador.setCedula(cedula);
                this.jugador.setCorreo(correo);
                this.jugador.setPais(pais);
                this.jugador.setCiudad(ciudad);
                this.jugador.setSexo(sexo);
                        
                        
                        

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);                                       
                alert.setTitle("Informacion");
                alert.setContentText("Se ha modificado correctamente");
                alert.showAndWait();
                
                

            } else {
                // insertando

                this.jugador = j;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha añadido correctamente");
                alert.showAndWait();

            }

            // Cerrar la ventana
            Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La persona ya existe");
            alert.showAndWait();
        }
        }
        
        catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Numero de cedula o celular incorrecto. Ingresa unicamente numeros");
            alert.showAndWait();
        }
    }

    @FXML
    private void salir(ActionEvent event) {
        this.jugador = null;
        // Cerrar la ventana
        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();
    }

    void initAtributtes(ObservableList<Partido> partidos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void initAtributtes(ObservableList<Partido> partidos, Partido p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
