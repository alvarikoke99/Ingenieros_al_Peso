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
import model.HorasJornada;
import model.RegistroJornada;
import util.HorasJornadaDao;
import util.RegistroJornadaDao;
import util.Log;

/**
 *
 * @author Javi
 */
public class JornadaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_USER = "/listUser.jsp";
    private HorasJornadaDao daoHoras;
    private RegistroJornadaDao daoRegistro;
    private Log log;

    public JornadaController() {
        super();
        daoHoras = new HorasJornadaDao();
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        Log.log.info("Entramos en el doGet");
        String action = request.getParameter("action");
        Log.log.info("Recogemos el parametro action con valor " + action);
        if (action.equalsIgnoreCase("delete")) {
            Log.log.info("Parametro valor DELETE");
            int userId = Integer.parseInt(request.getParameter("userId"));
            daoHoras.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else if (action.equalsIgnoreCase("edit")) {
            Log.log.info("Parametro valor EDIT");
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("userId"));
            User user = daoHoras.getUserById(userId);
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")) {
            Log.log.info("Parametro valor LIST");
            forward = LIST_USER;
            request.setAttribute("users", daoHoras.getAllUsers());
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
        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));                
        user.setEmail(request.getParameter("email"));
        String userid = request.getParameter("userid");
        if (userid == null || userid.isEmpty()) {
            Log.log.info("Vamos a añadir el usuario");
            dao.addUser(user);
        } else {
            user.setUserid(Integer.parseInt(userid));
            dao.updateUser(user);
        }
        request.setAttribute("users", dao.getAllUsers());
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);            
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
