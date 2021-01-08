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
    private int horas;
    private Date fecha;
    private int proyectoIdProyecto;
    private int trabajadorIdTrabajador;

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getProyectoIdProyecto() {
        return proyectoIdProyecto;
    }

    public void setProyectoIdProyecto(int proyectoIdProyecto) {
        this.proyectoIdProyecto = proyectoIdProyecto;
    }

    public int getTrabajadorIdTrabajador() {
        return trabajadorIdTrabajador;
    }

    public void setTrabajadorIdTrabajador(int trabajadorIdTrabajador) {
        this.trabajadorIdTrabajador = trabajadorIdTrabajador;
    }

    @Override
    public String toString() {
        return "HorasJornada{" + "horas=" + horas + ", fecha=" + fecha + ", proyectoIdProyecto=" + proyectoIdProyecto + ", trabajadorIdTrabajador=" + trabajadorIdTrabajador + '}';
    }

    
    
}
