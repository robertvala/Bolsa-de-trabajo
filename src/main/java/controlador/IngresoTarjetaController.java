/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class IngresoTarjetaController implements Initializable {

    @FXML
    private Spinner<Integer> spMatchStart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        spMatchStart.setValueFactory(ivf);
        // TODO
    }    
    
}
