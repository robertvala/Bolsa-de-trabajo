package controlador;

import Firebase.CRUDFirebase;
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
import modelo.Persona;

public class PersonasController implements Initializable {

    @FXML
    private Button btnAgregar;
    @FXML
    private TableView<Jugador> tblJugadores;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidos;
    @FXML
    private TableColumn colEdad;

    private ObservableList<Jugador> jugadores;
    private ObservableList<Jugador> filtroJugadores;
    private ObservableList<String> sexos;

    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtFiltrarNombre;
    @FXML
    private TableColumn colEquipo;
    @FXML
    private TableColumn colPosicion;
    @FXML
    private TableColumn colCiudad;
    @FXML
    private TableColumn colImagen;
    
    private ArrayList<Jugador> listaJugadores=new ArrayList<>();;
    
    //private final CRUDFirebase cRUDFirebase = new CRUDFirebase();
    @FXML
    private Button btnAceptar;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            File file = new File("datos.ser");
        try {
            file.createNewFile();
        } catch (IOException E) {
            System.err.println("No se pudo crear el archivo" + "datos.ser");
        }
        jugadores = FXCollections.observableArrayList();
        listaJugadores = deserializar();
        this.jugadores = listToObservable(listaJugadores);
        System.out.println("Aqui se deben imprimir los jugadores");
        
        System.out.println(jugadores);
       
       
        
          
        filtroJugadores = FXCollections.observableArrayList();
        this.tblJugadores.setItems(jugadores);
        
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombres"));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory("edad"));
        this.colEquipo.setCellValueFactory(new PropertyValueFactory("equipo"));
        this.colPosicion.setCellValueFactory(new PropertyValueFactory("posicion"));
        this.colCiudad.setCellValueFactory(new PropertyValueFactory("ciudad"));
    }

    @FXML
  
    
    private void agregarPersona(ActionEvent event) {

        try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(App.class.getResource("PersonaDialogVista.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Cojo el controlador
            PersonaDialogControlador controlador = loader.getController();
            controlador.initAtributtes(jugadores);

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            // cojo la persona devuelta
            Jugador j = controlador.getJugador();
            if (j != null) {
                this.jugadores.add(j);
                this.listaJugadores.add(j);
                if (j.getNombres().toLowerCase().contains(this.txtFiltrarNombre.getText().toLowerCase())) {
                    this.filtroJugadores.add(j);
                }
                this.tblJugadores.refresh();
                
               // cRUDFirebase.addFirebase(j);

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

    @FXML
    private void modificar(ActionEvent event) {

        Jugador j = this.tblJugadores.getSelectionModel().getSelectedItem();

        if (j == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        } else {

            try {

                // Cargo la vista
                FXMLLoader loader = new FXMLLoader(App.class.getResource("PersonaDialogVista.fxml"));

                // Cargo la ventana
                Parent root = loader.load();

                // Cojo el controlador
                PersonaDialogControlador controlador = loader.getController();
                controlador.initAtributtes(jugadores, j);

                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                // cojo la persona devuelta
                Jugador pSeleccionado = controlador.getJugador();
                if (pSeleccionado != null) {
                    if (!pSeleccionado.getNombres().toLowerCase().contains(this.txtFiltrarNombre.getText().toLowerCase())) {
                        this.filtroJugadores.remove(pSeleccionado);
                    }
                    this.tblJugadores.refresh();
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

        Jugador j = this.tblJugadores.getSelectionModel().getSelectedItem();

        if (j == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        } else {
            // Elimino la persona
            this.jugadores.remove(j);
            this.listaJugadores.remove(j);
            this.filtroJugadores.remove(j);
            this.tblJugadores.refresh();
            serializar();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Persona eliminada");
            alert.showAndWait();

        }

    }

    @FXML
    private void filtrarNombre(KeyEvent event) {

        String filtroNombre = this.txtFiltrarNombre.getText();

        // Si el texto del nombre esta vacio, seteamos la tabla de jugadores con el original
        if (filtroNombre.isEmpty()) {
            this.tblJugadores.setItems(jugadores);
        } else {

            // Limpio la lista
            this.filtroJugadores.clear();

            for (Jugador j : this.jugadores) {
                if (j.getNombres().toLowerCase().contains(filtroNombre.toLowerCase())) {
                    this.filtroJugadores.add(j);
                }
            }

            this.tblJugadores.setItems(filtroJugadores);

        }

    }
    
    public ObservableList<Jugador> listToObservable(ArrayList<Jugador> listaJugadores ){
        ObservableList<Jugador> jugadores = FXCollections.observableArrayList();
        for(Jugador i: listaJugadores){
            jugadores.add(i);
        }
        return jugadores;
    }
    
    private void serializar(){
         try(ObjectOutputStream salida= new ObjectOutputStream(new FileOutputStream("datos.ser"))){
                    salida.writeObject(listaJugadores);
                    salida.close();
                    System.out.println("Se serializo en ingreso de jugadores");
                }catch(FileNotFoundException e){
                    System.err.println("No se encontro el archivo datos.ser");
                }catch(IOException E){
                    System.out.println("Se produjo un error al serializar");
                }
    }
    
    private ArrayList<Jugador> deserializar() {
        ArrayList<Jugador> jugadores = new ArrayList<>() ;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datos.ser"))){
                jugadores =   (ArrayList<Jugador>) ois.readObject();
                return jugadores ;
        } catch (FileNotFoundException ex) {
            System.err.println("No se encontró el archivo "+"datos.ser");
        } catch (ClassNotFoundException ex) {            
            System.err.println("Error en el casting del objeto a deserializar");
        } catch ( IOException ex) {
            System.err.println("No hay objeto a deserializar o la lista está vacía. Cree al menos un jugador");
            return jugadores;
        }
        return jugadores;
    }
    
    public ObservableList<Jugador> getJugadores(){
        return this.jugadores;
    }
    
    public ArrayList<Jugador> getListaJugadores(){
        return this.listaJugadores;
    }    
    
        public void initAtributtes(ObservableList<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.tblJugadores.setItems(jugadores);
    }

    @FXML
    private void aceptar(ActionEvent event) {
        Stage stage = (Stage) this.btnAceptar.getScene().getWindow();
        stage.close();
    }
    
    public TableView<Jugador> getTableView(){
        return this.tblJugadores;
    }


}
