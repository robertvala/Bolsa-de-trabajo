/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author rober
 */
public class Partido implements Serializable{
    private String partidos;
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
    
    //constructor

    public Partido(String partidos, Equipo equipoLocal, Equipo equipoVisitante, int golesEquipoLocal, int golesEquipoVisitante, Campeonato campeonato) {
        this.partidos = partidos;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
        this.campeonato = campeonato;
    }
    // get  y set

    public String getPartidos() {
        return partidos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public String getIdPartido() {
        return idPartido;
    }

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public ArrayList<Jugador> getGoleadoresEquipoLocal() {
        return goleadoresEquipoLocal;
    }

    public ArrayList<Jugador> getGoleadoresEquipoVisitante() {
        return goleadoresEquipoVisitante;
    }

    public ArrayList<Jugador> getAsistidoresEquipoLocal() {
        return asistidoresEquipoLocal;
    }

    public ArrayList<Jugador> getAsistidoresEquipoVisitante() {
        return asistidoresEquipoVisitante;
    }
    //equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partido other = (Partido) obj;
        if (this.equipoLocal != other.equipoLocal) {
            return false;
        }
        if (this.equipoVisitante != other.equipoVisitante) {
            return false;
        }
        if (this.golesEquipoVisitante != other.golesEquipoVisitante) {
            return false;
        }
        if (!Objects.equals(this.partidos, other.partidos)) {
            return false;
        }
        if (!Objects.equals(this.golesEquipoLocal, other.golesEquipoLocal)) {
            return false;
        }
        if (!Objects.equals(this.campeonato, other.campeonato)) {
            return false;
        }
        
        return true;
    }
    
}
