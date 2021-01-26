<%-- 
    Document   : infoCalendario
    Created on : 23 ene. 2021, 12:32:04
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>
            Ingenieros al peso S.A. | RRHH
        </title> 
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body id="cuerpo">
         <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="plantilla.css" media="screen" /> 

        <!--JavaScript-->
        <script src="funciones.js"></script>
        
        <!-- Cabecera -->
        <div class="cabecera" id="cabecera">
            <img src="img/logoSmall.png" alt="logo">
        </div>

        <div class="topnav" id="topnav">
            <div class="dropdown">
                <a class="dropbtn">Ver informacion
                  <i class="down"></i>
                </a>
                <div class="dropdown-content">
                    <a href="EmpresaController?action=listEmpresas">Empresa</a>
                    <a href="ProyectoController?action=listProyectos">Proyectos</a>
                    <a href="TrabajadorController?action=listTrabajadores">Trabajadores</a>
                    <a href="infoCalendario.jsp">Calendario</a>
                  </div>
            </div>
            <a class="enlace" href="SolicitudController?action=listSolicitudes">Lista peticiones</a>
            <a class="enlace" href="solicitarInforme.jsp">Solicitar informe</a>
            <a class="enlace" href="annadirUser.jsp">Añadir trabajador</a>
            <a class="enlace" href="annadirEmpresa.jsp">Añadir/Editar empresa</a>
            <a class="enlace" href="annadirProyecto.jsp">Añadir/Editar proyecto</a>
            <a class="enlace" href="asignarTrabajador.jsp">Asignar trabajador</a>
            <a class="enlace" href="index.html">Cerrar sesión</a>
        </div>

        <!-- Contenido -->  
            <div class="contentCalendar">
                <div class="calendar">
                  <div class="front">
                    <div class="current-date">
                      <h1>Miercoles 27</h1>
                      <h1>Enero 2021</h1> 
                    </div>

                    <div class="current-month">
                      <ul class="week-days">
                        <li>Lu</li>
                        <li>Ma</li>
                        <li>Mi</li>
                        <li>Ju</li>
                        <li>Vi</li>
                        <li>Sa</li>
                        <li>Do</li>
                      </ul>

                      <div class="weeks">
                        <div class="first">
                          <span class="last-month">28</span>
                          <span class="last-month">29</span>
                          <span class="last-month">30</span>
                          <span class="last-month">31</span>
                          <span>01</span>
                          <span>02</span>
                          <span>03</span>
                        </div>

                        <div class="second">
                          <span>04</span>
                          <span>05</span>
                          <span class="event">06</span>
                          <span>07</span>
                          <span>08</span>
                          <span>09</span>
                          <span>10</span>
                        </div>

                        <div class="third">
                          <span>11</span>
                          <span>12</span>
                          <span>13</span>
                          <span>14</span>
                          <span class="event">15</span>
                          <span>16</span>
                          <span>17</span>
                        </div>

                        <div class="fourth">
                          <span>18</span>
                          <span>19</span>
                          <span>20</span>
                          <span>21</span>
                          <span>22</span>
                          <span>23</span>
                          <span>24</span>
                        </div>

                        <div class="fifth">
                          <span class="event">25</span>
                          <span>26</span>
                          <span class="active">27</span>
                          <span>28</span>
                          <span>29</span>
                          <span>30</span>
                          <span>31</span>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
            </div>
        
        <!-- Pie de pagina -->
        <div class="footerLargo">Ingenieros al peso S.A. - Campus Universitario, Ctra. Madrid-Barcelona km, 33, 600, 28805 Alcalá de Henares - Teléfono: 900.000.000
            <br> Condiciones generales de venta, política de privacidad y utilización web y APP
            <br> © Ingenieros al peso S.A. 2020
        </div>
    </body>
</html>

