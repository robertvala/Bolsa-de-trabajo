/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import javafx.collections.ObservableList;

/**
 *
 * @author rober
 */
public class Jugador implements Serializable {
    private String equipo;
    private String posicion;
    private ArrayList<String> historial;
    private ObservableList<Tarjeta> tarjetas;
    private String nombres;
    private String apellidos;
    private int edad;
    private LocalDate fechaNacimiento;
    private int celular;
    private int cedula;
    private String correo;
    private String pais;
    private String ciudad;
    private String sexo;
    private String urlImagen;

    public Jugador(String equipo, String posicion, ArrayList<String> historial, ObservableList<Tarjeta> tarjetas, String nombres, String apellidos, int edad, LocalDate fechaNacimiento, int celular, int cedula, String correo, String pais, String ciudad, String sexo, String urlImagen) {
        this.equipo = equipo;
        this.posicion = posicion;
        this.historial = historial;
        this.tarjetas = tarjetas;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.cedula = cedula;
        this.correo = correo;
        this.pais = pais;
        this.ciudad = ciudad;
        this.sexo = sexo;
        this.urlImagen = urlImagen;
        obternerEdad();
    }

    public Jugador(String equipo, String posicion, String nombres, String apellidos, LocalDate fechaNacimiento, int celular, int cedula, String correo, String pais, String ciudad, String sexo) {
        this.equipo = equipo;
        this.posicion = posicion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.cedula = cedula;
        this.correo = correo;
        this.pais = pais;
        this.ciudad = ciudad;
        this.sexo = sexo;
        obternerEdad();
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public ArrayList<String> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<String> historial) {
        this.historial = historial;
    }

    public ObservableList<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(ObservableList<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.equipo);
        hash = 71 * hash + Objects.hashCode(this.posicion);
        hash = 71 * hash + Objects.hashCode(this.historial);
        hash = 71 * hash + Objects.hashCode(this.tarjetas);
        hash = 71 * hash + Objects.hashCode(this.nombres);
        hash = 71 * hash + Objects.hashCode(this.apellidos);
        hash = 71 * hash + this.edad;
        hash = 71 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 71 * hash + this.celular;
        hash = 71 * hash + this.cedula;
        hash = 71 * hash + Objects.hashCode(this.correo);
        hash = 71 * hash + Objects.hashCode(this.pais);
        hash = 71 * hash + Objects.hashCode(this.ciudad);
        hash = 71 * hash + Objects.hashCode(this.sexo);
        hash = 71 * hash + Objects.hashCode(this.urlImagen);
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
        final Jugador other = (Jugador) obj;
        if (this.edad != other.edad) {
            return false;
        }
        if (this.celular != other.celular) {
            return false;
        }
        if (this.cedula != other.cedula) {
            return false;
        }
        if (!Objects.equals(this.equipo, other.equipo)) {
            return false;
        }
        if (!Objects.equals(this.posicion, other.posicion)) {
            return false;
        }
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        if (!Objects.equals(this.ciudad, other.ciudad)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }
    
    private void obternerEdad(){
        Calendar c1 = Calendar.getInstance();
        int annio = c1.get(Calendar.YEAR);
        int dia = c1.get(Calendar.DATE);
        int mes = c1.get(Calendar.MONTH);
        String[] partes = this.fechaNacimiento.toString().split("-");
        int annioNacimiento = Integer.parseInt(partes[0]);
        int mesNacimiento = Integer.parseInt(partes[1]);
        int diaNacimiento = Integer.parseInt(partes[2]);

        if (mes - mesNacimiento < 0) {
            this.edad = annio - annioNacimiento - 1;
        }
        if ((mes - mesNacimiento) == 0) {
            if (dia - diaNacimiento > 0) {
                this.edad = annio - annioNacimiento;
            } else {
                this.edad = annio - annioNacimiento - 1;
            }
        }
        
        else{
            this.edad = annio - annioNacimiento;
        }

        
    }
     


        
    
}
    
