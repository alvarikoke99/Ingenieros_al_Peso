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
public class Empresa {
    private int idEmpresa;
    private String nombre;
    private String descripcion;
/**
 * Devuelve el valor del id de la empresa
 * @return devuelve el valor del id
 */
    public int getIdEmpresa() {
        return idEmpresa;
    }
/**
 * Establece el valor al id de la empresa
 * @param idEmpresa integer
 */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
/**
 * Devuelve el valor del nombre de la empresa
 * @return nombre de la empresa
 */
    public String getNombre() {
        return nombre;
    }
/**
 * Establece el valor al nombre de la empresa
 * @param nombre string con el nombre de la empresa
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * Devuelve la descripcion de la empresa
 * @return el contenido en el atributo descripcion
 */
    public String getDescripcion() {
        return descripcion;
    }
/**
 * Establecemos el contenido de descripcion.
 * @param descripcion string con el contenido  
 */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
/**
 * Devuelve el contenido del objeto empresa
 * @return contenido de los atributos de la empresa
 */
    @Override
    public String toString() {
        return "Empresa{" + "idEmpresa=" + idEmpresa + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }


 
}
