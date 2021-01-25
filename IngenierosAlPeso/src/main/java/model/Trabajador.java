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
    
    
 /**
 * Devuelve el valor del atributo 
 */
    public int getIdTrabajador() {
        return idTrabajador;
    }
/**
 * Establece el valor al atributo 
 */
    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
/**
 * 
 */
    public String getDni() {
        return dni;
    }
/**
 * Establece el valor al atributo 
 */
    public void setDni(String dni) {
        this.dni = dni;
    }
/**
 * Devuelve el valor del atributo 
 */
    public String getNombre() {
        return nombre;
    }
/**
 * Establece el valor al atributo 
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * Devuelve el valor del atributo 
 */
    public String getApellidos() {
        return apellidos;
    }
/**
 * Establece el valor al atributo 
 */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
/**
 *Devuelve el valor del atributo 
 * 
 */
    public Timestamp getUltimaJornada() {
        return ultimaJornada;
    }
/**
 * Establece el valor al atributo 
 */
    public void setUltimaJornada(Timestamp ultimaJornada) {
        this.ultimaJornada = ultimaJornada;
    }
/**
 * 
 */
    @Override
    public String toString() {
        return "Trabajador{" + "idTrabajador=" + idTrabajador + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", ultimaJornada=" + ultimaJornada + '}';
    }

    
    

  
}
