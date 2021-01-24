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
 * 
 */
    public float getHoras() {
        return horas;
    }
/**
 * 
 */
    public void setHoras(float horas) {
        this.horas = horas;
    }
/**
 * 
 */
    public Date getFecha() {
        return fecha;
    }
/**
 * 
 */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
/**
 * 
 */
    public int getIdProyecto() {
        return idProyecto;
    }
/**
 * 
 */
    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }
/**
 * 
 */
    public int getIdTrabajador() {
        return idTrabajador;
    }
/**
 * 
 */
    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
/**
 * 
 */
    @Override
    public String toString() {
        return "HorasJornada{" + "horas=" + horas + ", fecha=" + fecha + ", idProyecto=" + idProyecto + ", idTrabajador=" + idTrabajador + '}';
    }
  
}
