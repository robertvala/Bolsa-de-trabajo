/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import modelo.Jugador;
import modelo.Tarjeta;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class IngresoTarjetaController implements Initializable {
    
    private ObservableList<Tarjeta> tarjetas;

    @FXML
    private Spinner<Integer> spMatchStart;
    @FXML
    private ChoiceBox<?> ChoiceSubstituted;
    @FXML
    private ChoiceBox<?> ChoiceComingOff;
    @FXML
    private Spinner<?> spMinutesOnField;
    @FXML
    private Spinner<?> spMinutesTagged;
    @FXML
    private Spinner<?> spGoals;
    @FXML
    private Spinner<?> spAssists;
    @FXML
    private Spinner<?> spShots;
    @FXML
    private Spinner<?> spHeadshots;
    @FXML
    private Spinner<?> spYellowCards;
    @FXML
    private Spinner<?> spRedCards;
    @FXML
    private ChoiceBox<?> ChoiceDirectRedCard;
    @FXML
    private Spinner<?> spPenalties;
    @FXML
    private Spinner<?> spLinkupPlays;
    @FXML
    private Spinner<?> spDuels;
    @FXML
    private Spinner<?> spDuelsWon;
    @FXML
    private Spinner<?> spDefensiveDuels;
    @FXML
    private Spinner<?> spAerialDuelsWon;
    @FXML
    private Spinner<?> spFouls;
    @FXML
    private Spinner<?> spPasses;
    @FXML
    private Spinner<?> spSuccesfulPasses;
    @FXML
    private Spinner<?> spSmartPasses;
    @FXML
    private Spinner<?> spSuccesfulSmartPasses;
    @FXML
    private Spinner<?> spPassesToFinalThird;
    @FXML
    private Spinner<?> spSuccesfulPassesToFinalThird;
    @FXML
    private Spinner<?> spCrosses;
    @FXML
    private Spinner<?> spSuccesfulCrosses;
    @FXML
    private Spinner<?> spForwardPasses;
    @FXML
    private Spinner<?> spSuccesFullForwadPasses;
    @FXML
    private Spinner<?> spBackpasses;
    @FXML
    private Spinner<?> spSuccesfulBackpasses;
    @FXML
    private Spinner<?> spThroughPasses;
    @FXML
    private Spinner<?> spKeyPasses;
    @FXML
    private Spinner<?> spSuccesfulKeypasses;
    @FXML
    private Spinner<?> spVerticalPasses;
    @FXML
    private Spinner<?> spSuccesfulVerticalPasses;
    @FXML
    private Spinner<?> spLongPasses;
    @FXML
    private Spinner<?> spSuccesfulLongPasses;
    @FXML
    private Spinner<?> spDribbles;
    @FXML
    private Spinner<?> spSuccesfulDribles;
    @FXML
    private Spinner<?> spInterceptions;
    @FXML
    private Spinner<?> spDefensiveActions;
    @FXML
    private Spinner<?> spSuccesfulDefensiceActions;
    @FXML
    private Spinner<?> spAttackinhActions;
    @FXML
    private Spinner<?> spSuccesfulAttackingActions;
    @FXML
    private Spinner<?> spFreekicks;
    @FXML
    private Spinner<?> spFreekickOnTarget;
    @FXML
    private Spinner<?> spDirectFreeKicksOnTarget;
    @FXML
    private Spinner<?> spCorners;
    @FXML
    private Spinner<?> spSuccesfulPenalties;
    @FXML
    private Spinner<?> spSuccesfulLinkupPlays;
    @FXML
    private Spinner<?> spAccelerations;
    @FXML
    private Spinner<?> spPressingDuels;
    @FXML
    private Spinner<?> spMissedBalls;
    @FXML
    private Spinner<?> spShotAssist;
    @FXML
    private Spinner<?> spShotOnTarget;
    @FXML
    private Spinner<?> spRecoveries;
    @FXML
    private Spinner<?> spOpponentHalfRecoveries;
    @FXML
    private Spinner<?> spDangerousOpponentHalfRecoveries;
    @FXML
    private Spinner<?> spLooses;
    @FXML
    private Spinner<?> spOwnHalfRecoveries;
    @FXML
    private Spinner<?> spDangerousOwnHalfRecoveries;
    @FXML
    private Spinner<?> spFieldAerialDuels;
    @FXML
    private Spinner<?> spFieldDuelsWon;
    @FXML
    private Spinner<?> spLoosBallDuels1;
    @FXML
    private Spinner<?> spLooseBallDuelsWon;
    @FXML
    private ChoiceBox<?> ChoiceDirectRedCard1;
    @FXML
    private Spinner<?> spLooseBallDuelsWon1;
    
    private Tarjeta tarjeta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        spMatchStart.setValueFactory(ivf);
        // TODO
    }    
<<<<<<< Updated upstream
    public void initAtributtes(ObservableList<Tarjeta> tarjetas,Tarjeta tarjeta) {
        
    }
=======
>>>>>>> Stashed changes
    public void initAtributtes(ObservableList<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }
    
    public Tarjeta getTarjeta(){
        return tarjeta;
    }
    
}
