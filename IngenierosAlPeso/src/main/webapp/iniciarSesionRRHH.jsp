<%-- 
    Document   : iniciarSesionRRHH
    Created on : 22-ene-2021, 0:44:45
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>
            Ingenieros al peso S.A. | Iniciar sesión
        </title> 
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>

    <body id="iniciarSesion">
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="plantilla.css" media="screen" />

        <!--JavaScript-->
        <script src="funciones.js"></script>

        <!--Contenido-->
        <form class="container">
            <h1>Iniciar sesión</h1>
            <h2>--- Recursos humanos ---</h2>
        
            <label><b>Usuario</b></label><br>
            <input type="text" id="idUser" placeholder="Introduzca su usuario" required><br>
        
            <label><b>Password</b></label><br>
            <input type="password" id="idPsw" placeholder="Introduzca su contraseña" required><br>
        
            <button class="btn" onclick="iniciarSesion()">Iniciar sesión</button>
        </form>
    </body>
</html>
