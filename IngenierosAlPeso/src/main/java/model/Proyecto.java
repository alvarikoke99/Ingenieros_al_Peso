/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class Proyecto {
    private int idProyecto;
    private String nombre;
    private String informacion;
    private int idEmpresa;
/**
 * Devuelve el valor del id del proyecto
 * @return valor del id
 */
    public int getIdProyecto() {
        return idProyecto;
    }
/**
 * @param idProyecto
 */
    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }
/**
 * 
 * @return nombre
 */
    public String getNombre() {
        return nombre;
    }
/**
 * 
 * @param nombre
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * 
 * 
 */
    public String getInformacion() {
        return informacion;
    }
/**
 * 
 */
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
/**
 * 
 */
    public int getIdEmpresa() {
        return idEmpresa;
    }
/**
 * 
 */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
/**
 * 
 */
    @Override
    public String toString() {
        return "Proyecto{" + "idProyecto=" + idProyecto + ", nombre=" + nombre + ", informacion=" + informacion + ", idEmpresa=" + idEmpresa + '}';
    }
    
}
