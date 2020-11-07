/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import controlador.App;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Jugador;

/**
 *
 * @author himesama
 */
public class CRUDFirebase {
    
    private static Firestore bd = null;
    public CRUDFirebase()
    {
        ConexionFirebase conexionFirebase = new ConexionFirebase();
        bd= conexionFirebase.iniciarFirebase();
    }
    public boolean addFirebase(Jugador jugador){
        boolean key=false;
        // Create a Map to store the data we want to set
        // key
        Map<String, Object> docJugador = new HashMap<>();
        docJugador.put("Equipo", jugador.getEquipo());
        docJugador.put("Posicion", jugador.getPosicion());
        //docJugador.put("Historial", jugador.getHistorial());
        docJugador.put("Tarjetas", jugador.getTarjetas());
        docJugador.put("Nombre", jugador.getNombres());
        docJugador.put("Apellidos", jugador.getApellidos());
        docJugador.put("Fecha de nacimiento", jugador.getFechaNacimiento());
        docJugador.put("Celular", jugador.getCelular());
        docJugador.put("Cedula", jugador.getCedula());
        docJugador.put("Correo", jugador.getCorreo());
        docJugador.put("Pais", jugador.getPais());
        docJugador.put("Ciudad", jugador.getCiudad());
        docJugador.put("Sexo", jugador.getSexo());
       
        
        
       
        // Add a new document (asynchronously) in collection "cities" with id "LA"
        ApiFuture<WriteResult> future = bd.collection("Jugadores").document(UUID.randomUUID().toString()).set(docJugador);
        try {
            // ...
            // future.get() blocks on response
            System.out.println("Update time : " + future.get().getUpdateTime());
            key=true;
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
        return key;
    }
            
}
