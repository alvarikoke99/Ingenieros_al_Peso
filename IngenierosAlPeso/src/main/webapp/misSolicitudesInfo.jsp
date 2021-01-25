<%-- 
    Document   : misSolicitudesInfo
    Created on : 25-ene-2021, 14:54:16
    Author     : Usuario
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>
            Ingenieros al peso S.A. | Usuario
        </title> 
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
         <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="plantilla.css" media="screen" /> 
        
        <!-- Cabecera -->
        <div class="cabecera" id="cabecera">
            <img src="img/logo_small.png" alt="logo">
        </div>

        <div class="topnav" id="topnav">
            <a class="enlace" href="fichar.jsp">Fichar</a>
            <a class="enlace" href="solicitarVacaciones.jsp">Solicitar días libres</a>
            <a class="enlace" id="idPag" href="misProyectos.jsp">Mis proyectos</a>
            <a class="enlace" href="misDatos.jsp">Mis datos</a>
            <a class="enlace" href="bandejaEntrada.jsp">Mis mensajes</a>
            <a class="enlace" href="index.html">Cerrar sesión</a>
        </div>

        <!-- Contenido -->    
        <div class="content">
            <h2>Mis proyectos:</h2>
            <table id="tabla">
                <thead>
                    <tr>
                        <th>Id solicitud:</th>
                        <th>Tipo</th>
                        <th>Fecha inicio:</th>
                        <th>Fecha final:</th>
                        <th>Observación:</th>
                        <th>Tramitada:</th>
                        
                    </tr>  
                </thead>
                <tbody>
                    <c:forEach items="${solicitudesTrabajador}" var="solicitud"> 
                        <tr> 
                            <td ><c:out value="${solicitud.idSolicitud}" /></td>
                            <td><c:out value="${solicitud.tipo}" /></td> 
                            <td><c:out value="${solicitud.fechaIni}" /></td> 
                            <td><c:out value="${solicitud.fechaFinal}" /></td>
                            <td><c:out value="${solicitud.observacion}" /></td>
                            <td><c:out value="${solicitud.tramitada}" /></td>
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
</html>