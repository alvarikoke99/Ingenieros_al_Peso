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
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import model.Solicitud;
import model.Trabajador;
import util.SolicitudDao;
import util.TrabajadorDao;
import util.Log;

public class SolicitudController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_SOLICITUDES = "/listaPeticiones.jsp"; //RRHH
    private static String LIST_MIS_SOLICITUDES = "/misSolicitudesInfo"; //Trabajador
    private SolicitudDao dao;
    private TrabajadorDao daoTrabajador;
    private Log log;

    public SolicitudController() {
        super();
        dao = new SolicitudDao();
        daoTrabajador = new TrabajadorDao();
    }
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward;
        Log.log.info("Entramos en el doGet");
        String action = request.getParameter("action");
        Log.log.info("Recogemos el parametro action con valor " + action);
        if (action.equalsIgnoreCase("delete")) {
            Log.log.info("Parametro valor DELETE");
            int idSolicitud = Integer.parseInt(request.getParameter("idSolicitud"));
            dao.deleteSolicitud(idSolicitud);
            forward = LIST_SOLICITUDES;
            request.setAttribute("solicitudes", dao.getAllSolicitudes());
//        } else if (action.equalsIgnoreCase("edit")) {
//            Log.log.info("Parametro valor EDIT");
//            forward = INSERT_OR_EDIT;
//            int idSolicitud = Integer.parseInt(request.getParameter("userId"));
//            Solicitud solicitud = dao.getSolicitudById(idSolicitud);
//            request.setAttribute("solicitud", solicitud);
        } else if (action.equalsIgnoreCase("aceptar")) {    //usado
            Log.log.info("Parametro valor ACEPTAR");
            forward = LIST_SOLICITUDES;
            dao.aceptarSolicitud(Integer.parseInt(request.getParameter("idSolicitud")));
            request.setAttribute("solicitudes", dao.getAllSolicitudes());
        } else if (action.equalsIgnoreCase("rechazar")) {    //usado
            Log.log.info("Parametro valor RECHAZAR");
            forward = LIST_SOLICITUDES;
            dao.rechazarSolicitud(Integer.parseInt(request.getParameter("idSolicitud")));
            request.setAttribute("solicitudes", dao.getAllSolicitudes());
        } else if (action.equalsIgnoreCase("listSolicitudes")) {    //usado
            Log.log.info("Parametro valor LIST");
            forward = LIST_SOLICITUDES;
            request.setAttribute("solicitudes", dao.getAllSolicitudes());
        } else {
            Log.log.info("Parametro valor vacio vamos a insertar");
            forward = INSERT_OR_EDIT;
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
        Log.log.info("Entramos por el doPost");
        String forward="";
        String action = request.getParameter("action");
        Log.log.info("Recogemos el parametro action con valor " + action);
/*        processRequest(request, response); */
        if (action.equalsIgnoreCase("annadirSolicitud")) {
            Solicitud solicitud = new Solicitud();
            solicitud.setTipo(request.getParameter("tipo"));
            Date fechaIni = Date.valueOf(request.getParameter("fechaIni"));
            solicitud.setFechaIni(fechaIni); 
            Date fechaFinal = Date.valueOf(request.getParameter("fechaFinal"));
            solicitud.setFechaIni(fechaFinal); 
            solicitud.setObservacion(request.getParameter("observacion"));
            solicitud.setTramitada(false);

            String dni = request.getParameter("dni");
            Trabajador trabajador = daoTrabajador.getTrabajadorByDni(dni);
            solicitud.setIdTrabajador(trabajador.getIdTrabajador());
            forward=LIST_MIS_SOLICITUDES;
            request.setAttribute("solicitudes", dao.getAllSolicitudes());   //dao.getSolicitudesByIdTrabajador(idTrabajador)

            /*if (dni == null || dni.isEmpty()) {
                Log.log.info("Vamos a añadir el usuario");
                dao.addUser(solicitud);
            } else {
                solicitud.setUserid(Integer.parseInt(userid));
                dao.updateUser(solicitud);
            }*/
        } else if (action.equalsIgnoreCase("listSolicitudesByTrabajador")) {    //usado
            Log.log.info("Parametro valor LIST BY TRABAJADOR");
            forward = LIST_MIS_SOLICITUDES;
            String dni = request.getParameter("dni");
            int idTrabajador = daoTrabajador.getTrabajadorByDni(dni).getIdTrabajador();
            request.setAttribute("solicitudesTrabajador", dao.getSolicitudById(idTrabajador));
        } 
        
        RequestDispatcher view = request.getRequestDispatcher(forward);    //solic del trabajador        
        view.forward(request, response);
        return;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
