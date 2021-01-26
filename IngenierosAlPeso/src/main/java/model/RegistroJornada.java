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
public class RegistroJornada {
    private Timestamp fechaEntrada;
    private Timestamp fechaSalida;
    private int idTrabajador;
    private int idProyecto;
/**
 *Devuelve el valor del atributo fechaEntrada
 * @return tipo timestap que contiene el valor del atriuto fechaEntrada
 */
    public Timestamp getFechaEntrada() {
        return fechaEntrada;
    }
/**
 * Establece el valor al atributo fechaEntrada
 * @param fechaEntrada timestamp fecha de entrada
 */
    public void setFechaEntrada(Timestamp fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
/**
 * Devuelve el valor del atributo FechaSalida
 * @return tipo timestamp que contiene el valor del atributo fechaSalida
 */
    public Timestamp getFechaSalida() {
        return fechaSalida;
    }
/**
 * Establece el valor al atributo fechaSalida
 * @param fechaSalida timepstamp fecha de salida
 */
    public void setFechaSalida(Timestamp fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
/**
 * Devuelve el valor del atributo idTrabajador
 * @return tipo int que contiene el valor del atributo idTrabajador
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
 * Devuelve el valor del atributo idProyecto
 * @return tipo int con el contenido idProyecto
 */
    public int getIdProyecto() {
        return idProyecto;
    }
/**
 * Establece el valor al atributo idProyecto
 * @param idProyecto int id del proyecto  
 */
    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }
/**
 * Devuelve  el contenido del objeto RegistroJornada
 * @return string con el contenido del objeto RegistroJornada
 */
    @Override
    public String toString() {
        return "RegistroJornada{" + "fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", idTrabajador=" + idTrabajador + ", idProyecto=" + idProyecto + '}';
    }
    
    
}
