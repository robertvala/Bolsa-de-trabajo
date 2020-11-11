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
public class Campeonato {
    
    private LocalDate fechainicio;
    private LocalDate fechaFin;
    private String nombre;
    private int valorWFV;
    private ArrayList<Equipo> equipos;
    private String pais;

   

    public LocalDate getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(LocalDate fechainicio) {
        this.fechainicio = fechainicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValorWFV() {
        return valorWFV;
    }

    public void setValorWFV(int valorWFV) {
        this.valorWFV = valorWFV;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Campeonato(LocalDate fechainicio, LocalDate fechaFin, String nombre, int valorWFV, String pais) {
        this.fechainicio = fechainicio;
        this.fechaFin = fechaFin;
        this.nombre = nombre;
        this.valorWFV = valorWFV;
        this.pais = pais;
    }

    
    
    
}
