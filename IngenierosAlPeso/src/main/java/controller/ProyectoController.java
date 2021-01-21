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
import model.Proyecto;
import util.ProyectoDao;
import util.Log;

public class ProyectoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_PROYECTOS = "/listUser.jsp";
    private ProyectoDao dao;
    private Log log;

    public ProyectoController() {
        super();
        dao = new ProyectoDao();
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
        String forward = "";
        Log.log.info("Entramos en el doGet");
        String action = request.getParameter("action");
        Log.log.info("Recogemos el parametro action con valor " + action);
        if (action.equalsIgnoreCase("delete")) {
            Log.log.info("Parametro valor DELETE");
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
            dao.deleteProyecto(idProyecto);
            forward = LIST_PROYECTOS;
            request.setAttribute("proyectos", dao.getAllProyectos());
        } else if (action.equalsIgnoreCase("edit")) {
            Log.log.info("Parametro valor EDIT");
            forward = INSERT_OR_EDIT;
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
            Proyecto proyecto = dao.getProyectoById(idProyecto);
            request.setAttribute("proyecto", proyecto);
            } else if (action.equalsIgnoreCase("listProyectos")) {
            Log.log.info("Parametro valor LIST");
            forward = LIST_PROYECTOS;
            request.setAttribute("proyectos", dao.getAllProyectos());
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Log.log.info("Entramos por el doPost");
/*        processRequest(request, response); */
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre(request.getParameter("nombre"));
        proyecto.setInformacion(request.getParameter("info"));                
        proyecto.setIdEmpresa(Integer.parseInt(request.getParameter("idEmpresa")));
        String idProyecto = request.getParameter("userid");
        if (idProyecto == null || idProyecto.isEmpty()) {
            Log.log.info("Vamos a añadir el usuario");
            dao.addProyecto(proyecto);
        } else {
            proyecto.setIdProyecto(Integer.parseInt(idProyecto));
            dao.updateProyecto(proyecto);
        }
        request.setAttribute("proyectos", dao.getAllProyectos());
        RequestDispatcher view = request.getRequestDispatcher(LIST_PROYECTOS);            
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
