/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.nombre);
        hash = 13 * hash + Objects.hashCode(this.fecha);
        hash = 13 * hash + Objects.hashCode(this.equipoLocal);
        hash = 13 * hash + Objects.hashCode(this.equipoVisitante);
        hash = 13 * hash + Objects.hashCode(this.idPartido);
        hash = 13 * hash + this.golesEquipoLocal;
        hash = 13 * hash + this.golesEquipoVisitante;
        hash = 13 * hash + Objects.hashCode(this.campeonato);
        hash = 13 * hash + Objects.hashCode(this.goleadoresEquipoLocal);
        hash = 13 * hash + Objects.hashCode(this.goleadoresEquipoVisitante);
        hash = 13 * hash + Objects.hashCode(this.asistidoresEquipoLocal);
        hash = 13 * hash + Objects.hashCode(this.asistidoresEquipoVisitante);
        return hash;
    }

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
        if (this.golesEquipoLocal != other.golesEquipoLocal) {
            return false;
        }
        if (this.golesEquipoVisitante != other.golesEquipoVisitante) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.equipoLocal, other.equipoLocal)) {
            return false;
        }
        if (!Objects.equals(this.equipoVisitante, other.equipoVisitante)) {
            return false;
        }
        if (!Objects.equals(this.campeonato, other.campeonato)) {
            return false;
        }
        if (!Objects.equals(this.goleadoresEquipoLocal, other.goleadoresEquipoLocal)) {
            return false;
        }
        if (!Objects.equals(this.goleadoresEquipoVisitante, other.goleadoresEquipoVisitante)) {
            return false;
        }
        if (!Objects.equals(this.asistidoresEquipoLocal, other.asistidoresEquipoLocal)) {
            return false;
        }
        if (!Objects.equals(this.asistidoresEquipoVisitante, other.asistidoresEquipoVisitante)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
