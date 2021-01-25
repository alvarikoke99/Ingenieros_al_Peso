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
 * @return int id del proyecto
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
 * Devuelve el valor del atributo Nombre
 * @return nombre string con el contenido del atributo 
 */
    public String getNombre() {
        return nombre;
    }
/**
 * Establece el valor al atributo Nombre
 * @param nombre String nombre del proyecto 
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * Devuelve el valor del atributo informacion 
 * @return informacion string con el contenio de informacion
 */
    public String getInformacion() {
        return informacion;
    }
/**
 * Establece el valor en el atributo informacion
 * @param informacion string informacion
 */
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
/**
 * Devuelve el contenido del atributo idEmpresa
 * @return  int con el contenido de id Empresa
 */
    public int getIdEmpresa() {
        return idEmpresa;
    }
/**
 * Establece el valor al atributo idEmpresa
 * @param idEmpresa int id del la Empresa
 */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
/**
 * Devuelve el contenido del objeto Proyecto
 * @return string con el contenido del objeto Proyecto
 */
    @Override
    public String toString() {
        return "Proyecto{" + "idProyecto=" + idProyecto + ", nombre=" + nombre + ", informacion=" + informacion + ", idEmpresa=" + idEmpresa + '}';
    }
    
}
