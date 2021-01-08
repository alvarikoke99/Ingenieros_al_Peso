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
    private int empresaIdEmpresa;
    private int trabajadorIdTrabajador;
    private String departamento;

    public int getEmpresaIdEmpresa() {
        return empresaIdEmpresa;
    }

    public void setEmpresaIdEmpresa(int empresaIdEmpresa) {
        this.empresaIdEmpresa = empresaIdEmpresa;
    }

    public int getTrabajadorIdTrabajador() {
        return trabajadorIdTrabajador;
    }

    public void setTrabajadorIdTrabajador(int trabajadorIdTrabajador) {
        this.trabajadorIdTrabajador = trabajadorIdTrabajador;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "RelacionEmpresaTrabajador{" + "trabajadorIdTrabajador=" + trabajadorIdTrabajador + ", empresaIdEmpresa=" + empresaIdEmpresa + ", departamento=" + departamento + '}';
    }
    
    
}
