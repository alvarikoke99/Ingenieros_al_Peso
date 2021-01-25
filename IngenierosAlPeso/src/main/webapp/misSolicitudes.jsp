<%-- 
    Document   : misSolicitudes
    Created on : 25-ene-2021, 14:47:06
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
            <a class="enlace" href="misProyectos.jsp">Mis proyectos</a>
            <a class="enlace" id="idPag" href="misDatos.jsp">Mis datos</a>
            <a class="enlace" href="bandejaEntrada.jsp">Mis mensajes</a>
            <a class="enlace" href="index.html">Cerrar sesión</a>
        </div>

        <!-- Contenido -->    
        <div class="contentCenter">
            <h2>Mis datos:</h2>
            <form method="POST" action="SolicitudController?action=listSolicitudesByTrabajador" name="formMisDatos">
                <label>DNI del trabajador:</label>
                <input type="text" id="dni" name="dni" class="casillaPeq" placeholder="Introduzca su DNI" required><br><br>
                <button type="submit" class="btnFichar">Validar</button><br><br>
            </form>
        </div>

        <!-- Pie de pagina -->
        <footer>Ingenieros al peso S.A. - Campus Universitario, Ctra. Madrid-Barcelona km, 33, 600, 28805 Alcalá de Henares - Teléfono: 900.000.000
            <br> Condiciones generales de venta, política de privacidad y utilización web y APP
            <br> © Ingenieros al peso S.A. 2020
        </footer>
    </body>
</html>
