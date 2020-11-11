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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.Partido;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class PartidosController implements Initializable {

    @FXML
    private Button btnAgregar;
    private TableView<Partido> tblPartidos;
    @FXML
    private TableColumn<?, ?> colImagen;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtFiltrarPartido;
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
    
    private ObservableList<Partido> partidos;
    private ObservableList<Partido> filtroPartidos;
    private ArrayList<Partido> listaPartidos=new ArrayList<>();;
    @FXML
    private TableView<?> tbPartidos;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file= new File("partidos.ser");
        try{
            file.createNewFile();
        }
        catch( IOException E){
            System.err.println("No se pudo crear el archivo"+"partidos.ser");
        }
        
        partidos = FXCollections.observableArrayList();
        //partidos=leerSerializado();
        listaPartidos=deserializar();
        System.out.println(listaPartidos);
        this.partidos=listToObservable(listaPartidos);
        filtroPartidos = FXCollections.observableArrayList();
        
        this.tblPartidos.setItems(partidos);
        this.colPartido.setCellValueFactory(new PropertyValueFactory("partidos"));
        this.colFecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.colMarcador.setCellValueFactory(new PropertyValueFactory("marcado"));
        this.colEquipoLocal.setCellValueFactory(new PropertyValueFactory("equipoLocal"));
        this.colEquipoVisitante.setCellValueFactory(new PropertyValueFactory("equipoVisitante"));
        this.colCampeonato.setCellValueFactory(new PropertyValueFactory("campeonato"));
    }    

    @FXML
    private void agregarPersona(ActionEvent event) {
        try {
            //cargo vista
            FXMLLoader loader1= new FXMLLoader(App.class.getResource("IngresarPartido.fxml"));
            //cargo ventana
            Parent root1= loader1.load();
            // Cojo el controlador
           IngresarPartidoController controlador = loader1.getController();
            controlador.initAtributtes(partidos);
            //cargo el scene
            Scene scene1 = new Scene(root1);
            Stage stage1 = new Stage();
            stage1.initModality(Modality.APPLICATION_MODAL);
            stage1.setScene(scene1);  
            stage1.showAndWait();
            //cojo el partido devuelta
            Partido p= controlador.getPartido();
            if (p != null) {
                partidos.add(p);
                listaPartidos.add(p);
                if (p.getPartidos().toLowerCase().contains(this.txtFiltrarPartido.getText().toLowerCase())) {
                    this.filtroPartidos.add(p);
                }
                this.tblPartidos.refresh();
                
               // cRUDFirebase.addFirebase(j);

                serializar();
                
                
            }
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
        
    }

    @FXML
    private void modificar(ActionEvent event) {
        Partido p = this.tblPartidos.getSelectionModel().getSelectedItem();

        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        } else {

            try {

                // Cargo la vista
                FXMLLoader loader = new FXMLLoader(App.class.getResource("IngresarPartido.fxml"));

                // Cargo la ventana
                Parent root = loader.load();

                // Cojo el controlador
                IngresarPartidoController controlador = loader.getController();
                controlador.initAtributtes(partidos, p);

                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                // cojo la persona devuelta
                Partido pSeleccionado = controlador.getPartido();
                if (pSeleccionado != null) {
                    if (!pSeleccionado.getPartidos().toLowerCase().contains(this.txtFiltrarPartido.getText().toLowerCase())) {
                        this.filtroPartidos.remove(pSeleccionado);
                    }
                    this.tblPartidos.refresh();
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
        Partido p = this.tblPartidos.getSelectionModel().getSelectedItem();

        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        } else {
            // Elimino la persona
            this.partidos.remove(p);
            this.listaPartidos.remove(p);
            this.filtroPartidos.remove(p);
            this.tblPartidos.refresh();
            serializar();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Partido eliminado");
            alert.showAndWait();

        }
    }

    private void serializar(){
         try(ObjectOutputStream salida= new ObjectOutputStream(new FileOutputStream("partidos.ser"))){
                    salida.writeObject(listaPartidos);
                    salida.close();
                }catch(FileNotFoundException e){
                    System.err.println("No se encontro el archivo partidos.ser");
                }catch(IOException E){
                    System.out.println("Se produjo un error al serializar");
                }
    }
    
    private ArrayList<Partido> deserializar() {
        ArrayList<Partido> partidos = new ArrayList<>() ;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("partidos.ser"))){
                partidos =   (ArrayList<Partido>) ois.readObject();
                return partidos ;
        } catch (FileNotFoundException ex) {
            System.err.println("No se encontró el archivo "+"partidos.ser");
        } catch (ClassNotFoundException ex) {            
            System.err.println("Error en el casting del objeto a deserializar");
        } catch ( IOException ex) {
            System.err.println("No hay objeto a deserializar o la lista está vacía. Cree al menos un partido");
            return partidos;
        }
        return partidos;
    }

    public ObservableList<Partido> listToObservable(ArrayList<Partido> listaPartidos ){
        ObservableList<Partido> partidos = FXCollections.observableArrayList();
        for(Partido i: listaPartidos){
            partidos.add(i);
        }
        return partidos;
    }

    @FXML
    private void filtrarNombre(KeyEvent event) {
    }
}
