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
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Jugador;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class MenuPrincipalController implements Initializable {

    @FXML
    private Button btnJugadores;
    @FXML
    private Button btnTarjetas;
    @FXML
    private Button btnPostulantes;
    @FXML
    private ImageView imgLogo;

    private ObservableList<Jugador> jugadores;

    ArrayList<Jugador> listaJugadores;

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
        listaJugadores = deserializarJugadores();
        this.jugadores = listToObservable(listaJugadores);
        System.out.println("Aqui se deben imprimir los jugadores");
        
        System.out.println(jugadores);

        Image image1 = new Image(App.class.getResourceAsStream("logo.png"));
        imgLogo = new ImageView();
        imgLogo.setImage(image1);
        imgLogo.setX(50);
        imgLogo.setY(50);

        // TODO
    }

    @FXML
    private void menuTarjetas(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("Tarjetas.fxml"));
            Parent root = loader.load();
            TarjetasController controladorTarjeta= loader.getController();
            controladorTarjeta.initAtributtes(jugadores);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void menuPostulantes(MouseEvent event) {
    }

    @FXML
    private void menuJugadores(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("PersonasVista.fxml"));
            Parent root = loader.load();
            PersonasController controladorPersonas = loader.getController();
            //controladorPersonas.initAtributtes(jugadores);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            //Cuando termino cojo la lista que quedo
            this.jugadores.addAll(controladorPersonas.getJugadores());
            this.listaJugadores.addAll(controladorPersonas.getListaJugadores());
            
            
            

        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void serializarJugadores() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("datos.ser"))) {
            salida.writeObject(listaJugadores);
            salida.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se encontro el archivo datos.ser");
        } catch (IOException E) {
            System.out.println("Se produjo un error al serializar");
        }

    }

    private ArrayList<Jugador> deserializarJugadores() {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datos.ser"))) {
            jugadores = (ArrayList<Jugador>) ois.readObject();
            return jugadores;
        } catch (FileNotFoundException ex) {
            System.err.println("No se encontró el archivo " + "datos.ser");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error en el casting del objeto a deserializar");
        } catch (IOException ex) {
            System.err.println("No hay objeto a deserializar o la lista está vacía. Cree al menos un jugador");
            return jugadores;
        }
        return jugadores;
    }

    public ObservableList<Jugador> listToObservable(ArrayList<Jugador> listaJugadores) {
        ObservableList<Jugador> jugadores = FXCollections.observableArrayList();
        for (Jugador i : listaJugadores) {
            jugadores.add(i);
        }
        return jugadores;
    }
    
    
}
