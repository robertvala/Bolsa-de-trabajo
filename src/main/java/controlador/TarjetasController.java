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
import modelo.Tarjeta;

public class TarjetasController {

    @FXML
    private Button btnAgregar;

    @FXML
    private TableColumn colJugador;

    @FXML
    private TableColumn colTarjeta;

    @FXML
    private TableColumn colFecha;

    @FXML
    private TableColumn colPartido;

    @FXML
    private TableColumn colCampeonato;

    @FXML
    private TableColumn colGoles;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextField txtFiltrarNombre;
    @FXML
    private TableColumn<?, ?> colURLImagen;
    @FXML
    private TableView<Tarjeta> tblTarjetas;
<<<<<<< Updated upstream

    private ObservableList<Tarjeta> tarjetas;
    private ObservableList<Jugador> filtroTarjetas;

    private ArrayList<Tarjeta> listaTarjetas;

    public void initialize(URL url, ResourceBundle rb) {

        File file = new File("tarjetas.ser");
        try {
            file.createNewFile();
        } catch (IOException E) {
            System.err.println("No se pudo crear el archivo" + "tarjetas.ser");
        }

        tarjetas = FXCollections.observableArrayList();
        //jugadores=leerSerializado();
        listaTarjetas = deserializar();
        System.out.println(listaTarjetas);
        this.tarjetas = listToObservable(listaTarjetas);
        filtroTarjetas = FXCollections.observableArrayList();

=======
    
    private ObservableList<Tarjeta> tarjetas;
    private ObservableList<Jugador> filtroTarjetas;
    
    private ArrayList<Tarjeta> listaTarjetas;
    
    
     public void initialize(URL url, ResourceBundle rb) {
        
        File file= new File("tarjetas.ser");
        try{
            file.createNewFile();
        }
        catch( IOException E){
            System.err.println("No se pudo crear el archivo"+"tarjetas.ser");
        }
        
        tarjetas = FXCollections.observableArrayList();
        //jugadores=leerSerializado();
        listaTarjetas=deserializar();
        System.out.println(listaTarjetas);
        this.tarjetas=listToObservable(listaTarjetas);
        filtroTarjetas = FXCollections.observableArrayList();
        
>>>>>>> Stashed changes
        this.tblTarjetas.setItems(tarjetas);
        this.colJugador.setCellValueFactory(new PropertyValueFactory("jugador"));
        this.colTarjeta.setCellValueFactory(new PropertyValueFactory("idTarjeta"));
        this.colPartido.setCellValueFactory(new PropertyValueFactory("partido"));
        this.colFecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.colGoles.setCellValueFactory(new PropertyValueFactory("goals"));
        this.colCampeonato.setCellValueFactory(new PropertyValueFactory("campeonato"));
    }
<<<<<<< Updated upstream

    @FXML
    void agregarPersona(ActionEvent event) {
        try {
=======
    
    

    @FXML
    void agregarPersona(ActionEvent event) {
            try {
>>>>>>> Stashed changes

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(App.class.getResource("IngresoTarjeta.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Cojo el controlador
            IngresoTarjetaController controlador = loader.getController();
            controlador.initAtributtes(tarjetas);

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            // cojo la persona devuelta
<<<<<<< Updated upstream
=======
          
            

>>>>>>> Stashed changes
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

<<<<<<< Updated upstream
    }

    void eliminar(ActionEvent event) {
        Tarjeta t = this.tblTarjetas.getSelectionModel().getSelectedItem();

        if (t == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una tarjeta");
            alert.showAndWait();
        } else {
            //Elimino la tarjeta
            this.tarjetas.remove(t);
            this.listaTarjetas.remove(t);
            this.filtroTarjetas.remove(t);
            this.tblTarjetas.refresh();
            serializar();

        }
=======
        

    }

    void eliminar(ActionEvent event) {
>>>>>>> Stashed changes

    }

    @FXML
    void filtrarNombre(KeyEvent event) {

    }

    @FXML
    void modificar(ActionEvent event) {
<<<<<<< Updated upstream
        Tarjeta t = this.tblTarjetas.getSelectionModel().getSelectedItem();

        if (t == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una tarjeta");
            alert.showAndWait();
        } else {
            try {

                // Cargo la vista
                FXMLLoader loader = new FXMLLoader(App.class.getResource("IngresoTarjeta.fxml"));

                // Cargo la ventana
                Parent root = loader.load();

                // Cojo el controlador
                IngresoTarjetaController controlador = loader.getController();
                controlador.initAtributtes(tarjetas, t);

                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                // cojo la persona devuelta
                Tarjeta pSeleccionado = controlador.getTarjeta();
                if (pSeleccionado != null) {
                    if (!pSeleccionado.getIdtarjeta().toLowerCase().contains(this.txtFiltrarNombre.getText().toLowerCase())) {
                        this.filtroTarjetas.remove(pSeleccionado);
                    }
                    this.tblTarjetas.refresh();
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

    public ObservableList<Tarjeta> listToObservable(ArrayList<Tarjeta> listaTarjetas) {
        ObservableList<Tarjeta> tarjetas = FXCollections.observableArrayList();
        for (Tarjeta i : listaTarjetas) {
=======

    }
    
    
     public ObservableList<Tarjeta> listToObservable(ArrayList<Tarjeta> listaTarjetas ){
        ObservableList<Tarjeta> tarjetas = FXCollections.observableArrayList();
        for(Tarjeta i: listaTarjetas){
>>>>>>> Stashed changes
            tarjetas.add(i);
        }
        return tarjetas;
    }

<<<<<<< Updated upstream
    private void serializar() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("tarjetas.ser"))) {
            salida.writeObject(listaTarjetas);
            salida.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se encontro el archivo datos.ser");
        } catch (IOException E) {
            System.out.println("Se produjo un error al serializar");
        }
    }

    private ArrayList<Tarjeta> deserializar() {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tarjetas.ser"))) {
            tarjetas = (ArrayList<Tarjeta>) ois.readObject();
            return tarjetas;
        } catch (FileNotFoundException ex) {
            System.err.println("No se encontró el archivo " + "datos.ser");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error en el casting del objeto a deserializar");
        } catch (IOException ex) {
=======
      private void serializar(){
         try(ObjectOutputStream salida= new ObjectOutputStream(new FileOutputStream("tarjetas.ser"))){
                    salida.writeObject(listaTarjetas);
                    salida.close();
                }catch(FileNotFoundException e){
                    System.err.println("No se encontro el archivo datos.ser");
                }catch(IOException E){
                    System.out.println("Se produjo un error al serializar");
                }
    }
    
    private ArrayList<Tarjeta> deserializar() {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>() ;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tarjetas.ser"))){
                tarjetas =   (ArrayList<Tarjeta>) ois.readObject();
                return tarjetas ;
        } catch (FileNotFoundException ex) {
            System.err.println("No se encontró el archivo "+"datos.ser");
        } catch (ClassNotFoundException ex) {            
            System.err.println("Error en el casting del objeto a deserializar");
        } catch ( IOException ex) {
>>>>>>> Stashed changes
            System.err.println("No hay objeto a deserializar o la lista está vacía. Cree al menos un jugador");
            return tarjetas;
        }
        return tarjetas;
    }
}
