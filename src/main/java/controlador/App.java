package controlador;

import Firebase.ConexionFirebase;
import com.google.cloud.firestore.Firestore;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    
    //private final ConexionFirebase conexionFirebase= new ConexionFirebase();
    //public static Firestore bd;
    
            

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("javafx.runtime.version: " + System.getProperties().get("javafx.runtime.version")); System.exit(0);
        
        scene = new Scene(loadFXML("MenuPrincipal"));
        stage.setScene(scene);
        stage.show();
        
        //bd=conexionFirebase.iniciarFirebase();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}