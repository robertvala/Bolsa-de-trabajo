/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author rober
 */
public class Partido {
    private String nombre;
    private LocalDate fecha;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String idPartido;    
    private int golesEquipoLocal;
    private int golesEquipoVisitante;
    private Campeonato campeonato;
    private ArrayList<Jugador> goleadoresEquipoLocal;
    private ArrayList<Jugador> goleadoresEquipoVisitante;
    private ArrayList<Jugador> asistidoresEquipoLocal;
    private ArrayList<Jugador> asistidoresEquipoVisitante;
    
    
}
