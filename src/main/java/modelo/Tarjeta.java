/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author rober
 */
public class Tarjeta implements Serializable{
    //Identificacion de tarjeta
    private Jugador jugador;
    private Partido partido;
    private LocalDate fecha;
    private String Idtarjeta;
    
    //informacion del jugador
    private boolean matchStart;
    private boolean substituted;
    private boolean comingOff;
    private int minutesOnField;
    private int minutesTagged;
    private int playerID;
    private String liga;
    String posicion;
    //Datos totales
    private int goals;
    private int assists;
    private int shots;
    private int headshots;
    private int yellowCards;
    private int redCards;
    private int directRedCards;
    private int penalties;
    private int linkupPlays;
    private int duels;
    private int duelsWon;
    private int defensiveDuelWon;
    private int offensiveDuels;
    private int offensiveDuelsWon;
    private int aerialDuels;
    private int aerialDuelsWon;
    private int fouls;
    private int passes;
    private int successfulPasses;
    private int smartPasses;
    private int succesfulSmartPasses;
    private int passesToFinalThird;
    private int succesfulPassesToFinalThird;
    private int crosses;
    private int succesfulCrosses;
    private int forwardPasses;
    private int  succesFullForwadPasses;
    private int  succesfulBackPasses;
    private int backPasses;
    private int  successfulBackpasses;
    private int throughPasses;
    private int successfulTroughPasses;
    private int keyPasses;
    private int succesfulKeyPasses;
    private int verticalPasses;
    private int succesfulVerticalPasses;
    private int longPases;
    private int succesfulLongPases;
    private int dribbles;
    private int succesfulDribbles;
    private int interceptions;
    private int defensiveActions;
    private int succesfulDefensiceActions;
    private int attackingActions;
    private int successfulAttackingActions;
    private int freekicks;
    private int freeKicksOnTarget;
    private int directFreeKicksOnTarget;
    private int corners;
    private int successfulPenalties;
    private int successfulLinkupPlays;
    private int accelerations;
    private int pressingDuels;
    private int pressingDuelsWon;
    private int looseBallDuel;
    private int looseBallDuelsWon;
    private int missedBalls;
    private int shotAssits;
    private int shotOnTarget;
    private int recoveries;
    private int opponentHalfRecoveries;
    private int dangerousOpponentHalfRecoveries;
    private int losses;
    private int ownHalfRecoveries;
    private int dangerousOwnHalfRecoveries;
    private int fieldAerialDuels;
    private int fieldDuelsWon;
    
    
    
    
    
    
    
}
