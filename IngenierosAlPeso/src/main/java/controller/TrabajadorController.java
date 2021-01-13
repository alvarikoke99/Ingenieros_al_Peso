/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import model.Trabajador;
import model.RelacionEmpresaTrabajador;
import model.RelacionProyectoTrabajador;
import util.TrabajadorDao;
import util.EmpresaTrabajadorDao;
import util.ProyectoTrabajadorDao;
//import util.Log;
/**
 *
 * @author Usuario
 */
public class TrabajadorController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "_";
    private static String LIST_TRABAJADORES = "_";
    private TrabajadorDao daoTrabajador;
    private EmpresaTrabajadorDao daoEmpresa;
    private ProyectoTrabajadorDao daoProyecto;
    //private Log log;
    
    public TrabajadorController () {
        super();
        daoTrabajador = new TrabajadorDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("delete")) {
            int id_trabajador = Integer.parseInt(request.getParameter("id_trabajador"));
            daoTrabajador.deleteTrabajador(id_trabajador);
            forward = LIST_TRABAJADORES;
            //request.setAttribute("trabajadores", /*dao.getAllUsers()*/);
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id_trabajador = Integer.parseInt(request.getParameter("id_trabajador"));
            Trabajador trabajador = daoTrabajador.getTrabajadorById(id_trabajador);
            request.setAttribute("trabajador", trabajador);
        } else if (action.equalsIgnoreCase("listTrabajador")) {
            forward = LIST_TRABAJADORES;
            //request.setAttribute("trabajadores", /*dao.getAllUsers()*/);
        } else { //insert
            forward = INSERT_OR_EDIT;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        return;
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Trabajador trabajador = new Trabajador();
        trabajador.setNombre(request.getParameter("_"));
        trabajador.setApellidos(request.getParameter("_")); 
        String id_trabajador = request.getParameter("_");
        if (id_trabajador == null || id_trabajador.isEmpty()) {
            daoTrabajador.addTrabajador(trabajador);
        } else {
            trabajador.setIdTrabajador(Integer.parseInt(id_trabajador));
            daoTrabajador.updateTrabajador(trabajador);
        }
        //request.setAttribute("trabajadores", /*dao.getAllUsers()*/);
        RequestDispatcher view = request.getRequestDispatcher(LIST_TRABAJADORES);            
        view.forward(request, response);
        return;
    }

    @Override
    public String getServletInfo() {
        return super.getServletInfo(); //To change body of generated methods, choose Tools | Templates.
    }
        
        
    
}
