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
public class RelacionProyectoTrabajador {
    private int idProyecto;
    private int idTrabajador;
/**
 * Devuelve el valor del atributo 
 * 
 */
    public int getIdProyecto() {
        return idProyecto;
    }
/**
 * Establece el valor al atributo 
 */
    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }
/**
 * Devuelve el valor del atributo 
 * 
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
    @Override
    public String toString() {
        return "RelacionProyectoTrabajador{" + "idProyecto=" + idProyecto + ", idTrabajador=" + idTrabajador + '}';
    }
    
    
    
}
