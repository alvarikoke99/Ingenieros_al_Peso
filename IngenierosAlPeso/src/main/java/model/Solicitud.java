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
    private boolean tramitada;
    private int idTrabajador;
/**
 * 
 * @return idSolicitud
 */
    public int getIdSolicitud() {
        return idSolicitud;
    }
/**
 * 
 * @param idSolicitud
 */
    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
/**
 * 
 * @return tipo
 */
    public String getTipo() {
        return tipo;
    }
/**
 * 
 * @param tipo
 */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
/**
 * 
 * @return fechaIni
 */
    public Date getFechaIni() {
        return fechaIni;
    }
/**
 * 
 * @param fechaIni
 */
    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }
/**
 * 
 * @return fechalFinal
 */
    public Date getFechaFinal() {
        return fechaFinal;
    }
/**
 * 
 * @param fechaFinal
 */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
/**
 * 
 * @return observacion
 */
    public String getObservacion() {
        return observacion;
    }
/**
 * 
 * @param observacion
 */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
/**
 * 
 * @return tramitada
 */
    public boolean getTramitada() {
        return tramitada;
    }
/**
 * 
 * @param tramitada
 */
    public void setTramitada(boolean tramitada) {
        this.tramitada = tramitada;
    }
/**
 * 
 * @return idTrabajador
 */
    public int getIdTrabajador() {
        return idTrabajador;
    }
/**
 * 
 * @param idTrabajador
 */
    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
/**
 * 
 * @return 
 */
    @Override
    public String toString() {
        return "Solicitud{" + "idSolicitud=" + idSolicitud + ", tipo=" + tipo + ", fechaIni=" + fechaIni + ", fechaFinal=" + fechaFinal + ", observacion=" + observacion + ", tramitada=" + tramitada + ", idTrabajador=" + idTrabajador + '}';
    }
    
}
