/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author rober
 */
public class Equipo {
    private int posicion;
 
    
    public double puntosExtra(){
        if(this.posicion<=4){
            double extra=0.5;
            return extra;
        }
        else{
            return 0;
        }
    }
    
}
