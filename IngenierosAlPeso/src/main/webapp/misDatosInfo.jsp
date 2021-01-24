<%-- 
    Document   : misDatosInfo
    Created on : 23-ene-2021, 2:15:12
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
            <a class="enlace" href="ProyectoController?action=listMisProyectos">Mis proyectos</a>
            <a class="enlace" id="idPag" href="misDatos.jsp">Mis datos</a>
            <a class="enlace" href="bandejaEntrada.jsp">Mis mensajes</a>
            <a class="enlace" href="index.html">Cerrar sesión</a>
        </div>

        <!-- Contenido -->    
        <div class="contentCenter">
            <h2>Mis datos:</h2>
            <label>Nombre del usuario: <c:out value="${trabajador.nombre}"/> </label><br><br>
            <label>Apellidos del usuario: <c:out value="${trabajador.apellidos}"/> </label><br><br>
            <label>DNI del usuario: <c:out value="${trabajador.dni}"/> </label><br><br>
            <label>Mis empresas:
                <c:forEach items="${relEmpresa}" var="empresa"> 
                    <c:out value=" ${empresa.idEmpresa} " />
                </c:forEach>
            </label><br><br>
            <label>Mis proyectos:
                <c:forEach items="${relProyecto}" var="proyecto"> 
                    <c:out value=" ${proyecto.idProyecto} " />
                </c:forEach>
            </label><br><br>
            <label>Mis solicitudes:</label>
        </div>

        <!-- Pie de pagina -->
        <div class="footerLargo">Ingenieros al peso S.A. - Campus Universitario, Ctra. Madrid-Barcelona km, 33, 600, 28805 Alcalá de Henares - Teléfono: 900.000.000
            <br> Condiciones generales de venta, política de privacidad y utilización web y APP
            <br> © Ingenieros al peso S.A. 2020
        </div>
    </body>
</html>
