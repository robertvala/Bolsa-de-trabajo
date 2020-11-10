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
import javafx.scene.control.Label;
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
    private ChoiceBox<String> ChoiceSubstituted;
    @FXML
    private ChoiceBox<String> ChoiceComingOff;
    @FXML
    private Spinner<Integer> spMinutesOnField;
    @FXML
    private Spinner<Integer> spMinutesTagged;
    @FXML
    private Spinner<Integer> spGoals;
    @FXML
    private Spinner<Integer> spAssists;
    @FXML
    private Spinner<Integer> spShots;
    @FXML
    private Spinner<Integer> spHeadshots;
    @FXML
    private Spinner<Integer> spYellowCards;
    @FXML
    private Spinner<Integer> spRedCards;
    @FXML
    private ChoiceBox<String> ChoiceDirectRedCard;
    @FXML
    private Spinner<Integer> spPenalties;
    @FXML
    private Spinner<Integer> spLinkupPlays;
    @FXML
    private Spinner<Integer> spDuels;
    @FXML
    private Spinner<Integer> spDuelsWon;
    @FXML
    private Spinner<Integer> spDefensiveDuels;
    @FXML
    private Spinner<Integer> spAerialDuelsWon;
    @FXML
    private Spinner<Integer> spFouls;
    @FXML
    private Spinner<Integer> spPasses;
    @FXML
    private Spinner<Integer> spSuccesfulPasses;
    @FXML
    private Spinner<Integer> spSmartPasses;
    @FXML
    private Spinner<Integer> spSuccesfulSmartPasses;
    @FXML
    private Spinner<Integer> spPassesToFinalThird;
    @FXML
    private Spinner<Integer> spSuccesfulPassesToFinalThird;
    @FXML
    private Spinner<Integer> spCrosses;
    @FXML
    private Spinner<Integer> spSuccesfulCrosses;
    @FXML
    private Spinner<Integer> spForwardPasses;
    @FXML
    private Spinner<Integer> spSuccesFullForwadPasses;
    @FXML
    private Spinner<Integer> spBackpasses;
    @FXML
    private Spinner<Integer> spSuccesfulBackpasses;
    @FXML
    private Spinner<Integer> spThroughPasses;
    @FXML
    private Spinner<Integer> spKeyPasses;
    @FXML
    private Spinner<Integer> spSuccesfulKeypasses;
    @FXML
    private Spinner<Integer> spVerticalPasses;
    @FXML
    private Spinner<Integer> spSuccesfulVerticalPasses;
    @FXML
    private Spinner<Integer> spLongPasses;
    @FXML
    private Spinner<Integer> spSuccesfulLongPasses;
    @FXML
    private Spinner<Integer> spDribbles;
    @FXML
    private Spinner<Integer> spSuccesfulDribles;
    @FXML
    private Spinner<Integer> spInterceptions;
    @FXML
    private Spinner<Integer> spDefensiveActions;
    @FXML
    private Spinner<Integer> spSuccesfulDefensiceActions;
    @FXML
    private Spinner<Integer> spAttackinhActions;
    @FXML
    private Spinner<Integer> spSuccesfulAttackingActions;
    @FXML
    private Spinner<Integer> spFreekicks;
    @FXML
    private Spinner<Integer> spFreekickOnTarget;
    @FXML
    private Spinner<Integer> spDirectFreeKicksOnTarget;
    @FXML
    private Spinner<Integer> spCorners;
    @FXML
    private Spinner<Integer> spSuccesfulPenalties;
    @FXML
    private Spinner<Integer> spSuccesfulLinkupPlays;
    @FXML
    private Spinner<Integer> spAccelerations;
    @FXML
    private Spinner<Integer> spPressingDuels;
    @FXML
    private Spinner<Integer> spMissedBalls;
    @FXML
    private Spinner<Integer> spShotAssist;
    @FXML
    private Spinner<Integer> spShotOnTarget;
    @FXML
    private Spinner<Integer> spRecoveries;
    @FXML
    private Spinner<Integer> spOpponentHalfRecoveries;
    @FXML
    private Spinner<Integer> spDangerousOpponentHalfRecoveries;
    @FXML
    private Spinner<Integer> spLooses;
    @FXML
    private Spinner<Integer> spOwnHalfRecoveries;
    @FXML
    private Spinner<Integer> spDangerousOwnHalfRecoveries;
    @FXML
    private Spinner<Integer> spFieldAerialDuels;
    @FXML
    private Spinner<Integer> spFieldDuelsWon;
    @FXML
    private Spinner<Integer> spLoosBallDuels1;
    @FXML
    private Spinner<Integer> spLooseBallDuelsWon;
    @FXML
    private ChoiceBox<String> ChoiceDirectRedCard1;
    
    private Tarjeta tarjeta;
    @FXML
    
    //private Spinner<Integer> spOffensiveDuelsWon;
    //private Label spOffensiveDuelsWon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf1= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf2= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf3= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf4= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf5= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf6= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf7= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf8= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf9= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf10= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf11= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf12= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf13= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf14= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf15= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf16= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf17= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf18= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf19= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf20= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf21= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf22= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf23= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf24= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf25= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf26= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf27= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf28= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf29= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf30= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf31= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf32= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf33= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf34= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf35= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf36= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf37= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf38= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf39= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf40= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf41= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf42= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf43= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf44= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf45= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf46= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf47= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf48= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf49= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf50= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf51= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf52= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf53= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf54= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf55= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf56= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf57= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf58= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf59= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf60= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf61= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf62= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        SpinnerValueFactory.IntegerSpinnerValueFactory ivf63= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000000,0,1);
        
        spMatchStart.setValueFactory(ivf);
        spMinutesOnField.setValueFactory(ivf1);
        spMinutesTagged.setValueFactory(ivf2);
        spGoals.setValueFactory(ivf3);
        spAssists.setValueFactory(ivf4);
        spShots.setValueFactory(ivf5);
        spHeadshots.setValueFactory(ivf6);
        spYellowCards.setValueFactory(ivf7);
        spRedCards.setValueFactory(ivf8);
        spPenalties.setValueFactory(ivf9);
        spLinkupPlays.setValueFactory(ivf10);
        spDuels.setValueFactory(ivf11);
        spDuelsWon.setValueFactory(ivf12);
        spFouls.setValueFactory(ivf13);
        spPasses.setValueFactory(ivf14);
        spSuccesfulPasses.setValueFactory(ivf15);
        spSmartPasses.setValueFactory(ivf16);
        spSuccesfulSmartPasses.setValueFactory(ivf17);
        spPassesToFinalThird.setValueFactory(ivf18);
        spSuccesfulPassesToFinalThird.setValueFactory(ivf19);
        spCrosses.setValueFactory(ivf20);
        spSuccesfulCrosses.setValueFactory(ivf21);
        spForwardPasses.setValueFactory(ivf22);
        spSuccesFullForwadPasses.setValueFactory(ivf23);
        spBackpasses.setValueFactory(ivf24);
        spSuccesfulBackpasses.setValueFactory(ivf25);
        spThroughPasses.setValueFactory(ivf26);
        //spSuccesfulThroughPasses.setValueFactory(ivf);
        spKeyPasses.setValueFactory(ivf27);
        spSuccesfulKeypasses.setValueFactory(ivf28);
        spVerticalPasses.setValueFactory(ivf29);
        spSuccesfulVerticalPasses.setValueFactory(ivf30);
        spLongPasses.setValueFactory(ivf31);
        spSuccesfulLongPasses.setValueFactory(ivf32);
        spDribbles.setValueFactory(ivf33);
        spSuccesfulDribles.setValueFactory(ivf34);
        spInterceptions.setValueFactory(ivf35);
        spDefensiveActions.setValueFactory(ivf36);
        spSuccesfulDefensiceActions.setValueFactory(ivf37);
        spAttackinhActions.setValueFactory(ivf38);
        spSuccesfulAttackingActions.setValueFactory(ivf39);
        spFreekicks.setValueFactory(ivf40);
        spFreekickOnTarget.setValueFactory(ivf41);
        spCorners.setValueFactory(ivf42);
        spSuccesfulPenalties.setValueFactory(ivf43);
        spSuccesfulLinkupPlays.setValueFactory(ivf44);
        spAccelerations.setValueFactory(ivf45);
        spPressingDuels.setValueFactory(ivf46);
        spMissedBalls.setValueFactory(ivf47);
        spShotAssist.setValueFactory(ivf48);
        spShotOnTarget.setValueFactory(ivf49);
        spRecoveries.setValueFactory(ivf50);
        spOpponentHalfRecoveries.setValueFactory(ivf51);
        spDangerousOpponentHalfRecoveries.setValueFactory(ivf52);
        spLooses.setValueFactory(ivf53);
        spOwnHalfRecoveries.setValueFactory(ivf54);
        spDangerousOwnHalfRecoveries.setValueFactory(ivf55);
        spFieldAerialDuels.setValueFactory(ivf56);
        spFieldDuelsWon.setValueFactory(ivf57);
        spLoosBallDuels1.setValueFactory(ivf58);
        spLooseBallDuelsWon.setValueFactory(ivf59);
        spDirectFreeKicksOnTarget.setValueFactory(ivf60);
        spDefensiveDuels.setValueFactory(ivf61);
        spAerialDuelsWon.setValueFactory(ivf62);
        //spOffensiveDuelsWon.setValueFactory(ivf63);
        
                
        
                
        
        
                
        
    }
    
    public void initAtributtes(ObservableList<Tarjeta> tarjetas,Tarjeta tarjeta) {
        this.tarjetas=tarjetas;
        this.tarjeta=tarjeta;
        
    }
        // TODO

    public void initAtributtes(ObservableList<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }
    
    public Tarjeta getTarjeta(){
        return tarjeta;
    }
    
}
