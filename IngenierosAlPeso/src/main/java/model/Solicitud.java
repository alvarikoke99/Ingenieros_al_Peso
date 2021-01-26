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
public class Solicitud {
    private int idSolicitud;
    private String tipo;
    private Date fechaIni;
    private Date fechaFinal;
    private String observacion;
    private int tramitada;
    private int idTrabajador;
/**
 * Devuelve el valor del atributo 
 * @return idSolicitud
 */
    public int getIdSolicitud() {
        return idSolicitud;
    }
/**
 * Establece el valor al atributo 
 * @param idSolicitud
 */
    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
/**
 * Devuelve el valor del atributo 
 * @return tipo
 */
    public String getTipo() {
        return tipo;
    }
/**
 * Establece el valor al atributo 
 * @param tipo
 */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
/**
 * Devuelve el valor del atributo 
 * @return fechaIni
 */
    public Date getFechaIni() {
        return fechaIni;
    }
/**
 * Establece el valor al atributo 
 * @param fechaIni
 */
    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }
/**
 * Devuelve el valor del atributo 
 * @return fechalFinal
 */
    public Date getFechaFinal() {
        return fechaFinal;
    }
/**
 * Establece el valor al atributo 
 * @param fechaFinal
 */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
/**
 * Devuelve el valor del atributo 
 * @return observacion
 */
    public String getObservacion() {
        return observacion;
    }
/**
 * Establece el valor al atributo 
 * @param observacion
 */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
/**
 * Devuelve el valor del atributo 
 * @return tramitada
 */
    public int getTramitada() {
        return tramitada;
    }
/**
 * Establece el valor al atributo 
 * @param tramitada
 */
    public void setTramitada(int tramitada) {
        this.tramitada = tramitada;
    }
/**
 * Devuelve el valor del atributo 
 * @return idTrabajador
 */
    public int getIdTrabajador() {
        return idTrabajador;
    }
/**
 * Establece el valor al atributo 
 * @param idTrabajador
 */
    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
/**
 * Devuelve  el contenido del objeto Solicitud
 * @return string con el contenido del objeto Solicitud
 */
    @Override
    public String toString() {
        return "Solicitud{" + "idSolicitud=" + idSolicitud + ", tipo=" + tipo + ", fechaIni=" + fechaIni + ", fechaFinal=" + fechaFinal + ", observacion=" + observacion + ", tramitada=" + tramitada + ", idTrabajador=" + idTrabajador + '}';
    }
    
}
