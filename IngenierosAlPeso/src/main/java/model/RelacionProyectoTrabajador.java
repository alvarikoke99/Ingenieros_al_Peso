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
    private int proyectoIdProyecto;
    private int trabajadorIdTrabajador;

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
        return "RelacionProyectoTrabajador{" + "proyectoIdProyecto=" + proyectoIdProyecto + ", trabajadorIdTrabajador=" + trabajadorIdTrabajador + '}';
    }
    
    
    
}
