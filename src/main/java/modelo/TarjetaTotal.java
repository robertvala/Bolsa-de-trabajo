/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author rober
 */
public class TarjetaTotal extends Tarjeta implements Serializable{
    private int matches;
    private int matchesInStart;
    private int matchesSubstituted;
    private int matchesComingOff;
    private int minutesOnField;
    private int minutesTagged;
    private int WFV;
    //WORLD FOOTBALL VALUE
    private int ADM;
    private int injuries;
    //ACTIVITY DEVELOPMENT MARGIN  

    public TarjetaTotal(int matches, int matchesInStart, int matchesSubstituted, int matchesComingOff, int minutesOnField, int minutesTagged, int WFV, int ADM) {
        super();
        this.matches = matches;
        this.matchesInStart = matchesInStart;
        this.matchesSubstituted = matchesSubstituted;
        this.matchesComingOff = matchesComingOff;
        this.minutesOnField = minutesOnField;
        this.minutesTagged = minutesTagged;
        this.WFV = WFV;
        this.ADM = ADM;

    }
    
    
    
    
    
}
