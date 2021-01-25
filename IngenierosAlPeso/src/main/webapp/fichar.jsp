<%-- 
    Document   : fichar
    Created on : 22-ene-2021, 20:21:09
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
            <a class="enlace" id="idPag" href="fichar.jsp">Fichar</a>
            <a class="enlace" href="solicitarVacaciones.jsp">Solicitar días libres</a>
            <a class="enlace" href="misProyectos.jsp">Mis proyectos</a>
            <a class="enlace" href="misDatos.jsp">Mis datos</a>
            <a class="enlace" href="misSolicitudes.jsp">Mis mensajes</a>
            <a class="enlace" href="index.html">Cerrar sesión</a>
        </div>

        <!-- Contenido -->    
        <div class="contentCenter">
            <form method="POST" action="JornadaController?action=fichar" name="formRegJornada">
                <h2>Registro de la jornada:</h2><br>
                <label>Id del proyecto:</label><br><br>
                <input type="text" id="id" class="casilla" name="idProyecto" value="<c:out value="${jornada.idProyecto}" />" required><br><br>
                <label>DNI:</label><br><br>
                <input type="text" id="dni" class="casilla" name="dni" value="<c:out value="${jornada.dni}" />" required><br><br>
                <button type="submit" class="btnFichar" name="btn" value="entrada">Fichar entrada</button>
                <button type="submit" class="btnFichar" name="btn" value="salida">Fichar salida</button>
            </form>
        </div>

        <!-- Pie de pagina -->
        <footer>Ingenieros al peso S.A. - Campus Universitario, Ctra. Madrid-Barcelona km, 33, 600, 28805 Alcalá de Henares - Teléfono: 900.000.000
            <br> Condiciones generales de venta, política de privacidad y utilización web y APP
            <br> © Ingenieros al peso S.A. 2020
        </footer>
    </body>
</html>
