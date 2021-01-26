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
import java.sql.Timestamp;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import model.HorasJornada;
import model.RegistroJornada;
import model.Trabajador;
import util.HorasJornadaDao;
import util.RegistroJornadaDao;
import util.TrabajadorDao;
import util.Log;

public class JornadaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String FICHAR = "/fichar.jsp";
    private static String LIST_MIS_HORAS = "/misDatosInfo.jsp";
    private static String LIST_HORAS = "/solicitarInforme.jsp";
    private HorasJornadaDao daoHoras;
    private RegistroJornadaDao daoRegistro;
    private TrabajadorDao daoTrabajador;
    private Log log;

    public JornadaController() {
        super();
        daoRegistro = new RegistroJornadaDao();
        daoHoras = new HorasJornadaDao();
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        Log.log.info("Entramos en el doGet");
        String action = request.getParameter("action");
        Log.log.info("Recogemos el parametro action con valor " + action);
       
        if (action.equalsIgnoreCase("listHoras")) {
            String dni = request.getParameter("dni");
            Trabajador trabajador = daoTrabajador.getTrabajadorByDni(dni);
            int idTrabajador = trabajador.getIdTrabajador();
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
            request.setAttribute("horas", daoHoras.getHorasJornadaById(idProyecto, idTrabajador));
            forward = LIST_MIS_HORAS;
        } else if (action.equalsIgnoreCase("listHorasProyecto")) {
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
            request.setAttribute("horas", daoHoras.getHorasJornadaByIdProyecto(idProyecto)); 
            forward = LIST_HORAS;
        } else if (action.equalsIgnoreCase("listHorasTrabajador")) {
            String dni = request.getParameter("dni");
            Trabajador trabajador = daoTrabajador.getTrabajadorByDni(dni);
            int idTrabajador = trabajador.getIdTrabajador();
            request.setAttribute("horas", daoHoras.getHorasJornadaByIdTrabajador(idTrabajador));
            forward = LIST_HORAS;
        } else {
            Log.log.info("Vamos a fichar");
            forward = FICHAR;
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
        String action = request.getParameter("btn");
        String forward = "/fichar.jsp";
        Log.log.info("Entramos por el doPost");
/*        processRequest(request, response); */
        
        String dni = request.getParameter("dni");
        Trabajador trabajador = daoTrabajador.getTrabajadorByDni(dni);
        int idTrabajador = trabajador.getIdTrabajador();
        int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
        Timestamp fechaActual = new Timestamp (System.currentTimeMillis());
        Timestamp ultimaFecha = trabajador.getUltimaJornada();
        
//        if (action.equalsIgnoreCase("entrada")) {   //comparar value del submit button
//            Log.log.info("Parametro valor ENTRADA");
//            RegistroJornada registro = new RegistroJornada();
//            registro.setFechaEntrada(fechaActual);
//            registro.setFechaSalida(fechaActual);
//            registro.setIdTrabajador(idTrabajador);
//            registro.setIdProyecto(idProyecto);
//            daoRegistro.addRegistro(registro);
            
            RegistroJornada ultimoRegistro = daoRegistro.getRegistroByFechaSalida(idTrabajador, idProyecto, ultimaFecha);
//            if(ultimoRegistro.getFechaEntrada() == null && ultimoRegistro.getFechaSalida() == null) {
                long entrada = ultimoRegistro.getFechaEntrada().getTime();
                long salida = ultimoRegistro.getFechaSalida().getTime();
                long segundosTotales = (salida - entrada) / 1000;
                float horasTrabajadas = (float) segundosTotales / 3600;
                Date fechaJornada = new Date(entrada);
                request.setAttribute("h", horasTrabajadas);
                request.setAttribute("f", fechaJornada);
                
                HorasJornada jornada = new HorasJornada();
                jornada.setHoras(horasTrabajadas);
                jornada.setFecha(fechaJornada);
                jornada.setIdProyecto(idProyecto);
                jornada.setIdTrabajador(idTrabajador);
                daoHoras.addHorasJornada(jornada);
                request.setAttribute("registro", jornada);
            //}
            
//            trabajador.setUltimaJornada(fechaActual);
//            daoTrabajador.updateTrabajador(trabajador);
           
//        } else if (action.equalsIgnoreCase("salida")) {
//            Log.log.info("Parametro valor SALIDA");
//            RegistroJornada registro = daoRegistro.getRegistroByFechaEntrada(idTrabajador, idProyecto, ultimaFecha);
//            registro.setFechaSalida(fechaActual);
//            daoRegistro.updateFechaSalida(registro);
//            trabajador.setUltimaJornada(fechaActual);
//            daoTrabajador.updateTrabajador(trabajador);
//            request.setAttribute("registro", registro);
            
            forward="/prueba.jsp";
//        }
        RequestDispatcher view = request.getRequestDispatcher(forward);            
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
