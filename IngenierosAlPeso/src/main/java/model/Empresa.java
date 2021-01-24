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
 * @ param idEmpresa integer
 */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
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
 * @return descripicion
 */
    public String getDescripcion() {
        return descripcion;
    }
/**
 * 
 * @param descripcion
 */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
/**
 * 
 * @return 
 */
    @Override
    public String toString() {
        return "Empresa{" + "idEmpresa=" + idEmpresa + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }


 
}
