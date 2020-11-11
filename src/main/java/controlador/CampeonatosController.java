/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.C;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Campeonato;
import modelo.Jugador;
import modelo.Tarjeta;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class CampeonatosController implements Initializable {

    @FXML
    private Button btnAgregar;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colPosicion;
    @FXML
    private TableColumn colCiudad;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtFiltrarNombre;
    @FXML
    private Button btnAceptar;
    @FXML
    private TableColumn colFechaInicio;
    @FXML
    private TableColumn colFechaFin;
    @FXML
    private TableColumn colPais;
    @FXML
    private TableColumn colWFV;
    @FXML
    private TableView<Campeonato> tblCampeonatos;
    private ObservableList<Campeonato> campeonatos;
    private ObservableList<Campeonato> filtroCampeonatos;

    private ArrayList<Campeonato> listaCampeonatos; 
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         File file= new File("campeonatos.ser");
        try{
            file.createNewFile();
        }
        catch( IOException E){
            System.err.println("No se pudo crear el archivo"+"tarjetas.ser");
        }
        
        campeonatos=FXCollections.observableArrayList();
        listaCampeonatos=deserealizar();
        this.campeonatos=listToObservable(listaCampeonatos);
        filtroCampeonatos = FXCollections.observableArrayList();
        
        this.tblCampeonatos.setItems(campeonatos);
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colFechaInicio.setCellValueFactory(new PropertyValueFactory("fechainicio"));
        this.colFechaFin.setCellValueFactory(new PropertyValueFactory("fechaFin"));
        this.colPais.setCellValueFactory(new PropertyValueFactory("pais"));
        this.colWFV.setCellValueFactory(new PropertyValueFactory("valorWFV"));
        
        
        // TODO
    }    

    @FXML
    private void agregarPersona(ActionEvent event) {
          try {
            FXMLLoader loader1= new FXMLLoader(App.class.getResource("IngresoCampeonatos.fxml"));
                Parent root1= loader1.load();
                IngresoCampeonatosController controlador1= loader1.getController();
                controlador1.initAtribute(campeonatos);
                Scene scene1 = new Scene(root1);
                Stage stage1 = new Stage();
                stage1.initModality(Modality.APPLICATION_MODAL);
                stage1.setScene(scene1);
                stage1.showAndWait();    
                      


        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        
    }

    @FXML
    private void modificar(ActionEvent event) {
        Campeonato c = this.tblCampeonatos.getSelectionModel().getSelectedItem();

        if (c == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un campeonato");
            alert.showAndWait();
        } else {
            try {

                // Cargo la vista
                FXMLLoader loader = new FXMLLoader(App.class.getResource("IngresoCampeonatos.fxml"));

                // Cargo la ventana
                Parent root = loader.load();

                // Cojo el controlador
                IngresoCampeonatosController controlador = loader.getController();
                controlador.initAtributtes(campeonatos, c);

                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                // cojo la persona devuelta
                Campeonato cSeleccionado = controlador.getTarjeta();
                if (cSeleccionado != null) {
                    if (!cSeleccionado.getNombre().toLowerCase().contains(this.txtFiltrarNombre.getText().toLowerCase())) {
                        this.filtroCampeonatos.remove(cSeleccionado);
                    }
                    this.tblCampeonatos.refresh();
                    serializar();
                }

            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }

    }

    @FXML
    private void eliminar(ActionEvent event) {
        Campeonato c = this.tblCampeonatos.getSelectionModel().getSelectedItem();

        if (c == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un campeonato");
            alert.showAndWait();
        } else {
            //Elimino la tarjeta
            this.campeonatos.remove(c);
            this.listaCampeonatos.remove(c);
            this.filtroCampeonatos.remove(C);
            this.tblCampeonatos.refresh();
            serializar();

        }        

    }

    @FXML
    private void filtrarNombre(KeyEvent event) {
    }

    @FXML
    private void aceptar(ActionEvent event) {
    }
    
    ArrayList<Campeonato> deserealizar() {
        ArrayList<Campeonato> campeonatos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("campeonatos.ser"))) {
            campeonatos = (ArrayList<Campeonato>) ois.readObject();
            return campeonatos;
        } catch (FileNotFoundException ex) {
            System.err.println("No se encontró el archivo " + "tarjetas.ser");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error en el casting del objeto a deserializar");
        } catch (IOException ex) {

            System.err.println("No hay objeto a deserializar o la lista está vacía. Cree al menos una tarjeta");
            return campeonatos;
        }
        return campeonatos;
    }
     private void serializar(){
         try(ObjectOutputStream salida= new ObjectOutputStream(new FileOutputStream("campeonatos.ser"))){
                    salida.writeObject(listaCampeonatos);
                    salida.close();
                }catch(FileNotFoundException e){
                    System.err.println("No se encontro el archivo datos.ser");
                }catch(IOException E){
                    System.out.println("Se produjo un error al serializar");
                }
    }
     
     public ObservableList<Campeonato> listToObservable(ArrayList<Campeonato> listaCampeonatos) {
        ObservableList<Campeonato> campeonatos = FXCollections.observableArrayList();
        for (Campeonato i : listaCampeonatos) {
    }
        return campeonatos;
    }
    
}
