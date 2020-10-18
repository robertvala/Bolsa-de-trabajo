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
public class Postulante extends Persona {
   private String profesion;
   private String cargo;
   private ArrayList<String> experiencia;
   
    public Postulante(String nombres, String apellidos, int edad, LocalDate fechaNacimiento, int celular, int cedula, String correo, String pais, String ciudad, String sexo) {
        super(nombres, apellidos, edad, fechaNacimiento, celular, cedula, correo, pais, ciudad, sexo);
    }

}
