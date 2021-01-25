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
 * Devuelve el valor del atributo idProyecto
 * @return tipo int con el contenido del atributo idProyecto 
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
 * Devuelve  el contenido del objeto RelacionProyectoTrabajador
 * @return string con el contenido del objeto RelacionProyectoTrabajador
 */
    @Override
    public String toString() {
        return "RelacionProyectoTrabajador{" + "idProyecto=" + idProyecto + ", idTrabajador=" + idTrabajador + '}';
    }
    
    
    
}
