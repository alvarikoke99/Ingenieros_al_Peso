<%-- 
    Document   : infoProyectos
    Created on : 22-ene-2021, 13:31:21
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
        <link rel="stylesheet" type="text/css" href="../plantilla.css" media="screen" /> 

        <!--JavaScript-->
        <script src="../funciones.js"></script>
        
        <!-- Cabecera -->
        <div class="cabecera" id="cabecera">
            <img src="img/logoSmall.png" alt="logo">
        </div>

        <div class="topnav" id="topnav">
            <div class="dropdown" id="idPag">
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
            <a class="enlace" href="TrabajadorController?action=listTrabajadores">Añadir trabajador</a>
            <a class="enlace" href="EmpresaController?action=listEmpresas">Añadir empresa</a>
            <a class="enlace" href="ProyectoController?action=listProyectos">Añadir proyecto</a>
            <a class="enlace" href="index.html">Cerrar sesión</a>
        </div>

        <!-- Contenido -->   
        <div class="content">
            <table id="tabla">
                <thead>
                    <tr>
                        <th>Id proyecto</th>
                        <th>Id empresa</th>
                        <th>Nombre</th>
                        <th>Información</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${proyectos}" var="proyecto"> 
                        <tr> 
                            <td ><c:out value="${proyecto.idProyecto}" /></td>
                            <td ><c:out value="${proyecto.idEmpresa}" /></td>
                            <td><c:out value="${proyecto.nombre}" /></td> 
                            <td><c:out value="${proyecto.informacion}" /></td> 
                            <td><a href="ProyectoController?action=edit&idProyecto=<c:out value="${proyecto.idProyecto}"/>">Editar</a></td> 
                            <td><a href="ProyectoController?action=delete&idProyecto=<c:out value="${proyecto.idProyecto}"/>">Eliminar</a></td> 
                        </tr> 
                    </c:forEach>
                </tbody>   
            </table>
        </div> 
        
        <!-- Pie de pagina -->
        <div class="footerLargo">Ingenieros al peso S.A. - Campus Universitario, Ctra. Madrid-Barcelona km, 33, 600, 28805 Alcalá de Henares - Teléfono: 900.000.000
            <br> Condiciones generales de venta, política de privacidad y utilización web y APP
            <br> © Ingenieros al peso S.A. 2020
        </div>
    </body>
</html>
