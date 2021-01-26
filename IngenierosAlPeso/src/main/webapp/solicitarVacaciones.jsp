<%-- 
    Document   : solicitarVacaciones
    Created on : 23-ene-2021, 0:19:19
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
            <a class="enlace" id="idPag" href="solicitarVacaciones.jsp">Solicitar días libres</a>
            <a class="enlace" href="misProyectos.jsp">Mis proyectos</a>
            <a class="enlace" href="misDatos.jsp">Mis datos</a>
            <a class="enlace" href="misSolicitudes.jsp">Mis mensajes</a>
            <a class="enlace" href="index.html">Cerrar sesión</a>
        </div>

        <!-- Contenido -->    
        <div class="contentCenter">
            <form method="POST" action="SolicitudController?action=annadirSolicitud" name="formSolicitarVac">
                <h2>Solicitar días libres:</h2>
                <label>DNI:</label>
                <input type="text" id="dni" name="dni" placeholder="Introduzca su DNI" value="<c:out value="${solicitud.dni}" />" required><br><br>
                <label>Desde:</label>
                <input type="date" id="fechaIni" name="fechaIni" value="<c:out value="${solicitud.fechaIni}" />" required><br><br>
                <label>Hasta:</label>
                <input type="date" id="fechaFinal" name="fechaFinal" value="<c:out value="${solicitud.fechaFinal}" />" required><br><br>
                <label>Observaciones:</label><br><br>
                <textarea id="observaciones" name="observacion" rows="15" cols="50" value="<c:out value="${solicitud.observacion}" />" required></textarea><br><br>
                <label class="contenido">Días libres
                    <input type="radio" checked="checked" name="tipo" value="Dias Libres">
                    <span class="checkmark"></span>
                </label>
                <label class="contenido">Vacaciones
                    <input type="radio" name="tipo" value="Vacaciones">
                    <span class="checkmark"></span>
                </label> <br><br>
                <button type="submit" class="btnAdd">Mandar solicitud</button>
            </form>
        </div>

        <!-- Pie de pagina -->
        <footer>Ingenieros al peso S.A. - Campus Universitario, Ctra. Madrid-Barcelona km, 33, 600, 28805 Alcalá de Henares - Teléfono: 900.000.000
            <br> Condiciones generales de venta, política de privacidad y utilización web y APP
            <br> © Ingenieros al peso S.A. 2020
        </footer>
    </body>
</html>
