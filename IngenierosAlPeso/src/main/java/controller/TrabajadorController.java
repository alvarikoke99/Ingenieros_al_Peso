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
import util.Log;
/**
 *
 * @author Usuario
 */
public class TrabajadorController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static String INSERT = "_";
    private static String LIST_TRABAJADORES = "listaUsuario.jsp";
    private static String INSERT_EMPRESA = "_";
    private static String LIST_EMPRESAS = "_";
    private static String INSERT_PROYECTO = "_";
    private static String LIST_PROYECTOS = "_";
    private static String MIS_DATOS_INFO = "misDatosInfo.jsp";
    private TrabajadorDao daoTrabajador;
    private EmpresaTrabajadorDao daoEmpresa;
    private ProyectoTrabajadorDao daoProyecto;
    //private Log log;
    
    public TrabajadorController () {
        super();
        daoTrabajador = new TrabajadorDao();
        daoEmpresa = new EmpresaTrabajadorDao();
        daoProyecto = new ProyectoTrabajadorDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward;
        Log.log.info("Entramos en el doGet");
        String action = request.getParameter("action");
        Log.log.info("Recogemos el parametro action con valor " + action);
        
        if (action.equalsIgnoreCase("deleteRelEmpresa")) {
            Log.log.info("Parametro valor DELETE RelacionEmpresaTrabajdor");
            int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
            int idTrabajador = Integer.parseInt(request.getParameter("idTrabajador"));
            String departamento = request.getParameter("departamento");
            daoEmpresa.deleteRelacion(idEmpresa, idTrabajador, departamento);
            forward = LIST_EMPRESAS;
            request.setAttribute("relaciones", daoEmpresa.getAllRelaciones());
        } else if (action.equalsIgnoreCase("listRelEmpresa")) {
            Log.log.info("Parametro valor LIST RelacionEmpresaTrabajdor");
            forward = LIST_EMPRESAS;
            request.setAttribute("relaciones", daoEmpresa.getAllRelaciones());
            
        } else if (action.equalsIgnoreCase("deleteRelProyecto")) {
            Log.log.info("Parametro valor DELETE RelacionProyectoTrabajdor");
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
            int idTrabajador = Integer.parseInt(request.getParameter("idTrabajador"));
            daoProyecto.deleteRelacion(idProyecto, idTrabajador);
            forward = LIST_PROYECTOS;
            request.setAttribute("relaciones", daoProyecto.getAllRelaciones());
        } else if (action.equalsIgnoreCase("listSolicitudes")) {
            Log.log.info("Parametro valor LIST RelacionProyectoTrabajdor");
            forward = LIST_PROYECTOS;
            request.setAttribute("relaciones", daoProyecto.getAllRelaciones());
            
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
            //añadir relEmp y relProy para listaUsuario
            
        //action misDatosInfo, devuelve solo ese trabajador y RelEmpresa, RelProyecto con su id
        //forward MIS_DATOS_INFO 
            
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
        Log.log.info("Entramos por el doPost");
/*        processRequest(request, response); */
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("addRelEmpresa")) { //revisar - fusionar
            Log.log.info("Parametro valor INSERT RelacionEmpresaTrabajdor");
            
            RelacionEmpresaTrabajador relacionEmpresa = new RelacionEmpresaTrabajador();
            relacionEmpresa.setIdTrabajador(Integer.parseInt(request.getParameter("idTrabajador")));
            relacionEmpresa.setIdEmpresa(Integer.parseInt(request.getParameter("idEmpresa")));
            relacionEmpresa.setDepartamento(request.getParameter("idEmpresa"));
            
            daoEmpresa.addRelacion(relacionEmpresa);
            forward = INSERT_EMPRESA;
            request.setAttribute("relaciones", daoEmpresa.getAllRelaciones());
        } else if (action.equalsIgnoreCase("addRelProyecto")) {
            Log.log.info("Parametro valor INSERT RelacionEmpresaTrabajdor");
            
            RelacionProyectoTrabajador relacionProyecto = new RelacionProyectoTrabajador();
            relacionProyecto.setIdTrabajador(Integer.parseInt(request.getParameter("idTrabajador")));
            relacionProyecto.setIdProyecto(Integer.parseInt(request.getParameter("idProyecto")));
         
            daoProyecto.addRelacion(relacionProyecto);
            forward = INSERT_PROYECTO;
            request.setAttribute("relaciones", daoProyecto.getAllRelaciones());
        } else {    //usado - revisar
            Log.log.info("Vamos a añadir el trabajador");
            Trabajador trabajador = new Trabajador();
            trabajador.setNombre(request.getParameter("nombre"));
            trabajador.setApellidos(request.getParameter("apellidos"));
            trabajador.setDni(request.getParameter("dni"));
            trabajador.setUltimaJornada(null);
            daoTrabajador.addTrabajador(trabajador);
            forward = INSERT;
        }      
        RequestDispatcher view = request.getRequestDispatcher(forward);            
        view.forward(request, response);
        return;
    }

    @Override
    public String getServletInfo() {
        return super.getServletInfo(); //To change body of generated methods, choose Tools | Templates.
    }
        
        
    
}
