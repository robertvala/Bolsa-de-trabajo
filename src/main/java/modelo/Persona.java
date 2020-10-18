/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Persona implements Serializable{

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

    public Persona(String nombres, String apellidos, LocalDate fechaNacimiento, int celular, int cedula, String correo, String pais, String ciudad, String sexo, String urlImagen) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.cedula = cedula;
        this.correo = correo;
        this.pais = pais;
        this.ciudad = ciudad;
        this.sexo = sexo;
        this.urlImagen = urlImagen;
    }

    public Persona(String nombres, String apellidos, LocalDate fechaNacimiento, int celular, int cedula, String correo, String pais, String ciudad, String sexo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.cedula = cedula;
        this.correo = correo;
        this.pais = pais;
        this.ciudad = ciudad;
        this.sexo = sexo;
    }

    public Persona(String nombres, String apellidos, int edad, LocalDate fechaNacimiento, int celular, int cedula, String correo, String pais, String ciudad, String sexo) {
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
    }

    public Persona(String nombres, String apellidos, int edad, LocalDate fechaNacimiento, int celular, int cedula, String correo, String pais, String ciudad, String sexo, String urlImagen) {
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
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nombres);
        hash = 97 * hash + Objects.hashCode(this.apellidos);
        hash = 97 * hash + this.edad;
        hash = 97 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 97 * hash + this.celular;
        hash = 97 * hash + this.cedula;
        hash = 97 * hash + Objects.hashCode(this.correo);
        hash = 97 * hash + Objects.hashCode(this.pais);
        hash = 97 * hash + Objects.hashCode(this.ciudad);
        hash = 97 * hash + Objects.hashCode(this.sexo);
        hash = 97 * hash + Objects.hashCode(this.urlImagen);
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
        final Persona other = (Persona) obj;
        if (this.edad != other.edad) {
            return false;
        }
        if (this.celular != other.celular) {
            return false;
        }
        if (this.cedula != other.cedula) {
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
        if (!Objects.equals(this.urlImagen, other.urlImagen)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }

    

}
