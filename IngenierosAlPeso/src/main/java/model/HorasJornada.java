/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class HorasJornada {
    private float horas;
    private Date fecha;
    private int idProyecto;
    private int idTrabajador;
/**
 * Devuelve el valor del atributo horas
 * @return tipo float con el contenido de las horas
 */
    public float getHoras() {
        return horas;
    }
/**
 * Establece el valor de las horas
 * @param horas tipo float
 */
    public void setHoras(float horas) {
        this.horas = horas;
    }
/**
 * Devuelve el valor de la fecha
 * @return tipo date con el contenido de la fecha
 */
    public Date getFecha() {
        return fecha;
    }
/**
 * Establece el valor al atributo fecha
 * @param fecha tipo date 
 */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
/**
 * Devuelve el valor del atributo idProyecto
 * @return tipo int con el valor de idProyecto 
 */
    public int getIdProyecto() {
        return idProyecto;
    }
/**
 * Establece el valor al atributo idProyecto 
 * @param idProyecto id de proyecto 
 */
    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }
/**
 * Devuelve el valor del atributo idTrabajador
 * @return  int con el contenido de idTrabajador
 */
    public int getIdTrabajador() {
        return idTrabajador;
    }
/**
 * Establece el valor de al idTrabajador
 * @param idTrabajador id del trabajador
 */
    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
/**
 * Devuelve un string con el contenido del objeto
 * @return stringo con los contenidos de los atributos
 */
    @Override
    public String toString() {
        return "HorasJornada{" + "horas=" + horas + ", fecha=" + fecha + ", idProyecto=" + idProyecto + ", idTrabajador=" + idTrabajador + '}';
    }
  
}
