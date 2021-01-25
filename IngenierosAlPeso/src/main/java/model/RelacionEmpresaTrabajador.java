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
 * Devuelve el valor del atributo idEmpresa
 * @return tipo int con el contenido del atributo idEmpresa
 */
    public int getIdEmpresa() {
        return idEmpresa;
    }
/**
 * Establece el valor al atributo idEmpresa
 * @param idEmpresa int id de la empresa
 */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
/**
 * Devuelve el valor del atributo idTrajador
 * @return tipo int con el contenido del atributo idTrabajador
 */
    public int getIdTrabajador() {
        return idTrabajador;
    }
/**
 * Establece el valor al atributo  idTrabajdor
 * @param idTrabajador int id del trabajar
 */
    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
/**
 * Devuelve el valor del atributo Departamento
 * @return tipo int con el contenido del atributo Departamento
 */
    public String getDepartamento() {
        return departamento;
    }
/**
 * Establece el valor al atributo departamento
 * @param departamento string con el nombre del departamento
 */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
/**
 * Devuelve  el contenido del objeto RelacionEmpresaTrabajador
 * @return string con el contenido del objeto RelacionEmpresaTrabajador
 */
    @Override
    public String toString() {
        return "RelacionEmpresaTrabajador{" + "idTrabajador=" + idTrabajador + ", idEmpresa=" + idEmpresa + ", departamento=" + departamento + '}';
    }
    
    
}
