/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Firebase;

import com.google.auth.oauth2.GoogleCredentials;
import static com.google.cloud.Identity.serviceAccount;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author himesama
 */
public class ConexionFirebase
{
  
    public Firestore iniciarFirebase()
    {

        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(getClass().getResourceAsStream("proyectof-7ab92-firebase-adminsdk-vej79-ed8a680d31.json")))
                    .setDatabaseUrl("https://proyectof-7ab92.firebaseio.com")
                    .build();
            
            FirebaseApp.initializeApp(options);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return FirestoreClient.getFirestore();
    }
            
}
