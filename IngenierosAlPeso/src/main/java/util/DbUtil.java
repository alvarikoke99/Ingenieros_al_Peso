/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Javi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
        String driver = "com.mysql.jdbc.Driver";// Cambiar userdb por el nombre de la base de datos en MySQL
        String url="jdbc:mysql://localhost:3306/userdb?useTimezone=true&serverTimezone=UTC";
        String user="root";
        String password="root"; 
        Log.logdb.info("Entramos a conectar con la BBDD");
        if (connection != null) {
            Log.logdb.info("Ya hay una conexion");
            return connection;
        } else {
            try {                
                Log.logdb.info("Creamos una nueva conexion");
                               
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                Log.logdb.error("Error de conexion: " + e);                
            } catch (SQLException e) {
                Log.logdb.error("Error de SQL: " + e );                
            }
            return connection;
        }
    }
}
