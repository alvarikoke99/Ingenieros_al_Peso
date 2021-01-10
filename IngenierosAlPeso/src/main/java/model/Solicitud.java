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

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean getTramitada() {
        return tramitada;
    }

    public void setTramitada(boolean tramitada) {
        this.tramitada = tramitada;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "idSolicitud=" + idSolicitud + ", tipo=" + tipo + ", fechaIni=" + fechaIni + ", fechaFinal=" + fechaFinal + ", observacion=" + observacion + ", tramitada=" + tramitada + ", idTrabajador=" + idTrabajador + '}';
    }
    
}
