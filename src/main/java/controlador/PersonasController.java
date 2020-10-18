package controlador;

import java.io.IOException;
import java.net.URL;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jugadores = FXCollections.observableArrayList();
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
                jugadores.add(j);
                if (j.getNombres().toLowerCase().contains(this.txtFiltrarNombre.getText().toLowerCase())) {
                    this.filtroJugadores.add(j);
                }
                this.tblJugadores.refresh();
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
            this.filtroJugadores.remove(j);
            this.tblJugadores.refresh();

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

}
