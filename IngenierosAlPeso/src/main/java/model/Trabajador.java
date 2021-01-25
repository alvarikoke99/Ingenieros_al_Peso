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
 * Devuelve el valor del atributo idTrabajador
 * @return tipo int con el contenido del atributo idTrabajador
 */
    public int getIdTrabajador() {
        return idTrabajador;
    }
/**
 * Establece el valor al atributo idTrabajador
 * @param idTrabajador int id del trabajador
 */
    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
/**
 * Devuelve el valor del atributo Dni
 * @return tipo String con el contenido del atributo Dni
 */
    public String getDni() {
        return dni;
    }
/**
 * Establece el valor al atributo Dni
 * @param dni string con el dni del trabajador
 */
    public void setDni(String dni) {
        this.dni = dni;
    }
/**
 * Devuelve el valor del atributo Nombre
 * @return tipo string con el contenido del atributo nombre
 */
    public String getNombre() {
        return nombre;
    }
/**
 * Establece el valor al atributo nombre
 * @param nombre string nombre del trabajador
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * Devuelve el valor del atributo apellidos
 * @return tipo string con el contenido del atributo apellidos
 */
    public String getApellidos() {
        return apellidos;
    }
/**
 * Establece el valor al atributo apellidos
 * @param apellidos string apellidos del trabajador
 */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
/**
 *Devuelve el valor del atributo UltimaJornada
 *@return tipo timestampo con el contenido del atributo UltimaJornada
 */
    public Timestamp getUltimaJornada() {
        return ultimaJornada;
    }
/**
 * Establece el valor al atributo ultimaJornada
 * @param ultimaJornada timestamp fecha de la ultima jornada del trabajador
 */
    public void setUltimaJornada(Timestamp ultimaJornada) {
        this.ultimaJornada = ultimaJornada;
    }
/**
 * Devuelve  el contenido del trabajador
 * @return string con el contenido del objeto trabajador
 */
    @Override
    public String toString() {
        return "Trabajador{" + "idTrabajador=" + idTrabajador + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", ultimaJornada=" + ultimaJornada + '}';
    }

    
    

  
}
