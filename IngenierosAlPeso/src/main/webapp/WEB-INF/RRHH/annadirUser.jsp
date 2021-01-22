<%-- 
    Document   : annadirUser
    Created on : 22-ene-2021, 0:47:26
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
                    <a href="infoTrabajadores.html">Trabajadores</a>
                    <a href="infoCalendario.html">Calendario</a>
                  </div>
            </div>
            <a class="enlace" href="SolicitudController?action=listSolicitudes">Lista peticiones</a>
            <a class="enlace" href="solicitarInforme.html">Solicitar informe</a>
            <a class="enlace" href="TrabajadorController?action=listTrabajadores">Lista de trabajadores</a>
            <a class="enlace" id="idPag" href="annadirUser.jsp">Añadir trabajador</a>
            <a class="enlace" href="index.html">Cerrar sesión</a>
        </div>

        <!-- Contenido --> 
        <div class="contentCenter">
            <form method="POST" action="TrabajadorController?action=addTrabajador" name="formAnnadirTrabajador">
                <h2>Añadir trabajador:</h2><br>
                <label>Nombre del trabajador:</label><br><br>
                <input type="text" id="nombre" class="casilla" name="nombre" value="<c:out value="${trabajador.nombre}" />" required><br><br>
                <label>Apellidos del trabajador:</label><br><br>
                <input type="text" id="apellido" class="casilla" name="apellido" value="<c:out value="${trabajador.apellidos}" />" required><br><br>
                <label>Departamento del trabajador:</label><br><br>
                <input type="text" id="dep" class="casilla" name="dep" required><br><br>
                <label>DNI del trabajador:</label><br><br>
                <input type="text" id="dni" class="casilla" name="dni" value="<c:out value="${trabajador.dni}" />" required><br><br>
                <button type="submit" class="btnAdd">Añadir</button>
            </form>
        </div>   
        

        <!-- Pie de pagina -->
        <footer>Ingenieros al peso S.A. - Campus Universitario, Ctra. Madrid-Barcelona km, 33, 600, 28805 Alcalá de Henares - Teléfono: 900.000.000
            <br> Condiciones generales de venta, política de privacidad y utilización web y APP
            <br> © Ingenieros al peso S.A. 2020
        </footer>
    </body>
</html>
