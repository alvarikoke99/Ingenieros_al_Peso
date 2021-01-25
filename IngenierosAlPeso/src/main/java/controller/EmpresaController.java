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
import model.Empresa;
import util.EmpresaDao;
import util.Log;

public class EmpresaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/annadirEmpresa.jsp";
    private static String LIST_EMPRESAS = "/infoEmpresa.jsp";
    private EmpresaDao dao;
    private Log log;

    public EmpresaController() {
        super();
        dao = new EmpresaDao();
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
            int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
            dao.deleteEmpresa(idEmpresa);
            forward = LIST_EMPRESAS;
            request.setAttribute("empresas", dao.getAllEmpresas());
        } else if (action.equalsIgnoreCase("edit")) {
            Log.log.info("Parametro valor EDIT");
            forward = INSERT_OR_EDIT;
            int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
            Empresa empresa = dao.getEmpresaById(idEmpresa);
            request.setAttribute("empresa", empresa);
        } else if (action.equalsIgnoreCase("listEmpresas")) {   //usado
            Log.log.info("Parametro valor LIST");
            forward = LIST_EMPRESAS;
            request.setAttribute("empresas", dao.getAllEmpresas());
        } else {
            Log.log.info("Parametro valor vacio vamos a insertar");
            forward = LIST_EMPRESAS;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Log.log.info("Entramos por el doPost");
/*        processRequest(request, response); */
        Empresa empresa = new Empresa();
        empresa.setNombre(request.getParameter("nombre"));
        empresa.setDescripcion(request.getParameter("descripcion"));                
        String idEmpresa = request.getParameter("idEmpresa");
        if (idEmpresa == null || idEmpresa.isEmpty()) {
            Log.log.info("Vamos a añadir la empresa");
            dao.addEmpresa(empresa);
        } else {
            empresa.setIdEmpresa(Integer.parseInt(idEmpresa));
            dao.updateEmpresa(empresa);
        }
        request.setAttribute("empresas", dao.getAllEmpresas());
        RequestDispatcher view = request.getRequestDispatcher(LIST_EMPRESAS);            
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
