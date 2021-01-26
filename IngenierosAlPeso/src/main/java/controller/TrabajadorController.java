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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import model.*;
import util.*;
import util.Log;
/**
 *
 * @author Usuario
 */
public class TrabajadorController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static String INSERT = "/annadirUser.jsp"; //usado
    private static String LIST_TRABAJADORES = "/infoTrabajadores.jsp";
    private static String ASIGNAR = "/asignarTrabajador.jsp";
    private static String INSERT_EMPRESA = "_";
    private static String LIST_EMPRESAS = "_";
    private static String INSERT_PROYECTO = "_";
    private static String LIST_PROYECTOS = "_";
    private static String MIS_DATOS_INFO = "/misDatosInfo.jsp";
    private TrabajadorDao daoTrabajador;
    private EmpresaDao daoEmpresa;
    private ProyectoDao daoProyecto;
    private EmpresaTrabajadorDao daoRelEmpresa;
    private ProyectoTrabajadorDao daoRelProyecto;
    //private Log log;
    
    public TrabajadorController () {
        super();
        daoTrabajador = new TrabajadorDao();
        daoEmpresa = new EmpresaDao();
        daoProyecto = new ProyectoDao();
        daoRelEmpresa = new EmpresaTrabajadorDao();
        daoRelProyecto = new ProyectoTrabajadorDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward;
        Log.log.info("Entramos en el doGet");
        String action = request.getParameter("action");
        Log.log.info("Recogemos el parametro action con valor " + action);
        
        if (action.equalsIgnoreCase("deleteRelEmpresa")) {
            Log.log.info("Parametro valor DELETE RelacionEmpresaTrabajador");
            int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
            int idTrabajador = Integer.parseInt(request.getParameter("idTrabajador"));
            String departamento = request.getParameter("departamento");
            daoRelEmpresa.deleteRelacion(idEmpresa, idTrabajador, departamento);
            forward = LIST_EMPRESAS;
            request.setAttribute("relaciones", daoRelEmpresa.getAllRelaciones());
        } else if (action.equalsIgnoreCase("listRelEmpresa")) {
            Log.log.info("Parametro valor LIST RelacionEmpresaTrabajador");
            forward = LIST_EMPRESAS;
            request.setAttribute("relaciones", daoRelEmpresa.getAllRelaciones());
            
        } else if (action.equalsIgnoreCase("deleteRelProyecto")) {
            Log.log.info("Parametro valor DELETE RelacionProyectoTrabajador");
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
            int idTrabajador = Integer.parseInt(request.getParameter("idTrabajador"));
            daoRelProyecto.deleteRelacion(idProyecto, idTrabajador);
            forward = LIST_PROYECTOS;
            request.setAttribute("relaciones", daoRelProyecto.getAllRelaciones());
        } else if (action.equalsIgnoreCase("listSolicitudes")) {
            Log.log.info("Parametro valor LIST RelacionProyectoTrabajdor");
            forward = LIST_PROYECTOS;
            request.setAttribute("relaciones", daoRelProyecto.getAllRelaciones());
            
        } else if (action.equalsIgnoreCase("delete")) {
            Log.log.info("Parametro valor DELETE");
            int idTrabajador = Integer.parseInt(request.getParameter("idTrabajador"));
            daoTrabajador.deleteTrabajador(idTrabajador);
            forward = LIST_TRABAJADORES;
            request.setAttribute("trabajadores", daoTrabajador.getAllTrabajadores());
        } else if (action.equalsIgnoreCase("listTrabajadores")) {   //usado infoTrabajadores
            Log.log.info("Parametro valor LIST");
            forward = LIST_TRABAJADORES;
            request.setAttribute("trabajadores", daoTrabajador.getAllTrabajadores());
            
        } else {    //usado - revisar
            Log.log.info("Parametro valor vacio vamos a insertar");
            forward = INSERT;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        return;
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String forward = "";
        boolean redireccion = false;
        Log.log.info("Entramos por el doPost");
/*        processRequest(request, response); */
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("addRelaciones")) { 
            Log.log.info("Parametro valor INSERT RELACIONES");
            
            String dni = request.getParameter("dni");
            int idTrabajador = daoTrabajador.getTrabajadorByDni(dni).getIdTrabajador();
            
            String nombreProyecto = request.getParameter("nombreProyecto");
            Proyecto proyecto = daoProyecto.getProyectoByNombre(nombreProyecto);
            int idProyecto = proyecto.getIdProyecto();
            int idEmpresa = proyecto.getIdEmpresa();
            
            RelacionEmpresaTrabajador relacionEmpresa = new RelacionEmpresaTrabajador();
            relacionEmpresa.setIdTrabajador(idTrabajador);
            relacionEmpresa.setIdEmpresa(idEmpresa);
            relacionEmpresa.setDepartamento(request.getParameter("departamento"));
            
            RelacionProyectoTrabajador relacionProyecto = new RelacionProyectoTrabajador();
            relacionProyecto.setIdTrabajador(idTrabajador);
            relacionProyecto.setIdProyecto(idProyecto);
            if (idTrabajador != 0 && idProyecto != 0 && idEmpresa != 0) {
                daoRelProyecto.addRelacion(relacionProyecto);
                daoRelEmpresa.addRelacion(relacionEmpresa);
            }
      
            forward = ASIGNAR;
            redireccion = true;
            request.setAttribute("relaciones", daoRelEmpresa.getAllRelaciones());
        } else if (action.equalsIgnoreCase("addRelEmpresa")) { //revisar - fusionar
            Log.log.info("Parametro valor INSERT RelacionEmpresaTrabajdor");
            
            RelacionEmpresaTrabajador relacionEmpresa = new RelacionEmpresaTrabajador();
            relacionEmpresa.setIdTrabajador(Integer.parseInt(request.getParameter("idTrabajador")));
            relacionEmpresa.setIdEmpresa(Integer.parseInt(request.getParameter("idEmpresa")));
            relacionEmpresa.setDepartamento(request.getParameter("idEmpresa"));
            
            daoRelEmpresa.addRelacion(relacionEmpresa);
            forward = INSERT_EMPRESA;
            request.setAttribute("relaciones", daoRelEmpresa.getAllRelaciones());
        } else if (action.equalsIgnoreCase("addRelProyecto")) {
            Log.log.info("Parametro valor INSERT RelacionProyectoTrabajdor");
            
            RelacionProyectoTrabajador relacionProyecto = new RelacionProyectoTrabajador();
            relacionProyecto.setIdTrabajador(Integer.parseInt(request.getParameter("idTrabajador")));
            relacionProyecto.setIdProyecto(Integer.parseInt(request.getParameter("idProyecto")));
         
            daoRelProyecto.addRelacion(relacionProyecto);
            forward = INSERT_PROYECTO;
            request.setAttribute("relaciones", daoRelProyecto.getAllRelaciones());
            
        } else if (action.equalsIgnoreCase("listDatos")) {   //usado infoTrabajadores
            Log.log.info("Parametro valor LIST DATOS");
            forward = MIS_DATOS_INFO;
            String dni = request.getParameter("dni");
            Trabajador trabajador = daoTrabajador.getTrabajadorByDni(dni);
            int idTrabajador = trabajador.getIdTrabajador();
            
            List<RelacionProyectoTrabajador> relacionesProyecto = daoRelProyecto.getRelacionesByIdTrabajador(idTrabajador);
            List<Proyecto> proyectos = new ArrayList<>();
            for (RelacionProyectoTrabajador relacion : relacionesProyecto) {
                proyectos.add(daoProyecto.getProyectoById(relacion.getIdProyecto()));
            }
            
            List<Empresa> empresas = new ArrayList<>();
            for (Proyecto proyecto : proyectos) {
                empresas.add(daoEmpresa.getEmpresaById(proyecto.getIdEmpresa()));
            }
            
            request.setAttribute("trabajador", trabajador);
            request.setAttribute("proyectos", proyectos);
            request.setAttribute("empresas", empresas);
            
        } else if (action.equalsIgnoreCase("add")) {    //usado - revisar
            Log.log.info("Vamos a añadir el trabajador");
            Trabajador trabajador = new Trabajador();
            trabajador.setNombre(request.getParameter("nombre"));
            trabajador.setApellidos(request.getParameter("apellidos"));
            trabajador.setDni(request.getParameter("dni"));
            trabajador.setUltimaJornada(null);
            daoTrabajador.addTrabajador(trabajador);
            forward = INSERT;
            redireccion = true;
            
        } else if (action.equalsIgnoreCase("informe")){
            String parametro = request.getParameter("tipo");
            if (parametro.equalsIgnoreCase("empresa")) {
                Log.log.info("Parametro valor EMPRESA");
                forward = "/infoEmpresa.jsp";
                request.setAttribute("empresas", daoEmpresa.getAllEmpresas());          
            }
            else if (parametro.equalsIgnoreCase("proyecto")) {
                Log.log.info("Parametro valor PROYECTO");
                forward = "/infoProyectos.jsp";
                request.setAttribute("proyectos", daoProyecto.getAllProyectos()); 
            }
            else {
                Log.log.info("Parametro valor TRABAJADOR");
                forward = "/infoTrabajadores.jsp";
                request.setAttribute("trabajadores", daoTrabajador.getAllTrabajadores());
            }
        }
        
        if(redireccion) {
            response.sendRedirect(forward);
        } else {
            RequestDispatcher view = request.getRequestDispatcher(forward);            
            view.forward(request, response);
        } 
        return;
    }

    @Override
    public String getServletInfo() {
        return super.getServletInfo(); //To change body of generated methods, choose Tools | Templates.
    }
        
        
    
}
