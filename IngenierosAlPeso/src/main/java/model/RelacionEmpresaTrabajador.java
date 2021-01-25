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
public class RelacionEmpresaTrabajador {
    private int idEmpresa;
    private int idTrabajador;
    private String departamento;
/**
 * Devuelve el valor del atributo 
 * 
 */
    public int getIdEmpresa() {
        return idEmpresa;
    }
/**
 * Establece el valor al atributo 
 */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
/**
 * Devuelve el valor del atributo 
 * 
 */
    public int getIdTrabajador() {
        return idTrabajador;
    }
/**
 *Establece el valor al atributo  
 */
    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
/**
 * v
 * 
 */
    public String getDepartamento() {
        return departamento;
    }
/**
 * Establece el valor al atributo 
 */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
/**
 * 
 */
    @Override
    public String toString() {
        return "RelacionEmpresaTrabajador{" + "idTrabajador=" + idTrabajador + ", idEmpresa=" + idEmpresa + ", departamento=" + departamento + '}';
    }
    
    
}
