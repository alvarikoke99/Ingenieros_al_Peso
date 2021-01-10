/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Usuario
 */
public class Trabajador {
    private int idTrabajador;
    private String dni;
    private String nombre;
    private String apellidos;
    private Timestamp ultimaJornada;
    
    
    //Getters and setters
    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Timestamp getUltimaJornada() {
        return ultimaJornada;
    }

    public void setUltimaJornada(Timestamp ultimaJornada) {
        this.ultimaJornada = ultimaJornada;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "idTrabajador=" + idTrabajador + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", ultimaJornada=" + ultimaJornada + '}';
    }

    
    

  
}
