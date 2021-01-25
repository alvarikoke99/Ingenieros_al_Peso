<%-- 
    Document   : annadirProyecto
    Created on : 23 ene. 2021, 12:11:31
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
                    <a href="/TrabajadorController?action=listTrabajadores">Trabajadores</a>
                    <a href="infoCalendario.jsp">Calendario</a>
                  </div>
            </div>
            <a class="enlace" href="SolicitudController?action=listSolicitudes">Lista peticiones</a>
            <a class="enlace" href="solicitarInforme.jsp">Solicitar informe</a>
            <a class="enlace" href="annadirUser.jsp">Añadir trabajador</a>
            <a class="enlace" href="annadirEmpresa.jsp">Añadir/Editar empresa</a>
            <a class="enlace" id="idPag" href="annadirProyecto.jsp">Añadir/Editar proyecto</a>
            <a class="enlace" href="asignarTrabajador.jsp">Asignar trabajador</a>
            <a class="enlace" href="index.html">Cerrar sesión</a>
        </div>

        <!-- Contenido --> 
        <div class="contentCenter">
            <form method="POST" action="ProyectoController?action=addProyecto" name="formAnnadirTrabajador">
                <h2>Añadir/Editar proyecto:</h2><br>
                <input type="text" id="idProyecto" class="oculto" name="idProyecto" value="<c:out value="${proyecto.idProyecto}" />" readonly><br><br>
                <label>Nombre del proyecto:</label><br><br>
                <input type="text" id="nombreProyecto" class="casilla" name="nombre" value="<c:out value="${proyecto.nombre}" />" required><br><br>
                <label>Información del proyecto:</label><br><br>
                <input type="text" id="info" class="casilla" name="info" value="<c:out value="${proyecto.informacion}" />" required><br><br>
                <label>Nombre de la empresa:</label><br><br>
                <input type="text" id="empresa" class="casilla" name="nombreEmpresa" value="<c:out value="${proyecto.nombreEmpresa}" />" required><br><br>
                <button type="submit" class="btnAdd">Añadir</button>
            </form>
        </div>   
        

        <!-- Pie de pagina -->
        <div class="footerLargo">Ingenieros al peso S.A. - Campus Universitario, Ctra. Madrid-Barcelona km, 33, 600, 28805 Alcalá de Henares - Teléfono: 900.000.000
            <br> Condiciones generales de venta, política de privacidad y utilización web y APP
            <br> © Ingenieros al peso S.A. 2020
        </div>
    </body>
</html>

