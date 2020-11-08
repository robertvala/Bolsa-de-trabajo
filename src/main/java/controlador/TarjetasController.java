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
        
        this.tblTarjetas.setItems(tarjetas);
        this.colJugador.setCellValueFactory(new PropertyValueFactory("jugador"));
        this.colTarjeta.setCellValueFactory(new PropertyValueFactory("idTarjeta"));
        this.colPartido.setCellValueFactory(new PropertyValueFactory("partido"));
        this.colFecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.colGoles.setCellValueFactory(new PropertyValueFactory("goals"));
        this.colCampeonato.setCellValueFactory(new PropertyValueFactory("campeonato"));
    }
    
    

    @FXML
    void agregarPersona(ActionEvent event) {
            try {

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
          
            

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

        

    }

    void eliminar(ActionEvent event) {

    }

    @FXML
    void filtrarNombre(KeyEvent event) {

    }

    @FXML
    void modificar(ActionEvent event) {

    }
    
    
     public ObservableList<Tarjeta> listToObservable(ArrayList<Tarjeta> listaTarjetas ){
        ObservableList<Tarjeta> tarjetas = FXCollections.observableArrayList();
        for(Tarjeta i: listaTarjetas){
            tarjetas.add(i);
        }
        return tarjetas;
    }

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
            System.err.println("No hay objeto a deserializar o la lista está vacía. Cree al menos un jugador");
            return tarjetas;
        }
        return tarjetas;
    }
}
