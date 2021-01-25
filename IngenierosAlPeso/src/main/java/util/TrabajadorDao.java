/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author alvarikoke
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Trabajador;
import util.DbUtil;
import util.Log;

/**
*
*/
public class TrabajadorDao {

    private Connection connection;

    /**
    * Constructor de la clase donde se crea la conexión con la BBDD
    */
    public TrabajadorDao() {
        connection = DbUtil.getConnection();
    }

    /**
    * Añade una entrada a la tabla trabajador de la BBDD
    * @param trabajador objeto Trabajador que será insertado
    */
    public void addTrabajador(Trabajador trabajador) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into trabajador(nombre,apellidos, dni, ultima_jornada) values (?, ?, ?, ?)");
            // Parameters start with 1 
            preparedStatement.setString(1, trabajador.getNombre());
            preparedStatement.setString(2, trabajador.getApellidos());            
            preparedStatement.setString(3, trabajador.getDni());
            preparedStatement.setTimestamp(4, trabajador.getUltimaJornada());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    /**
    * Elimina una entrada de la tabla trabajador de la BBDD
    * @param idTrabajador ID del trabajador que será eliminado
    */
    public void deleteTrabajador(int idTrabajador) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from trabajador where id_trabajador=?");
            // Parameters start with 1 
            preparedStatement.setInt(1, idTrabajador);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    /**
    * Actualiza una entrada de la tabla trabajador de la BBDD
    * @param trabajador objeto Trabajador que será actualizado
    */
    public void updateTrabajador(Trabajador trabajador) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update trabajador set nombre=?, apellidos=?, dni=?, ultima_jornada=? where id_trabajador=?");
            // Parameters start with 1 
            preparedStatement.setString(1, trabajador.getNombre());
            preparedStatement.setString(2, trabajador.getApellidos());            
            preparedStatement.setString(3, trabajador.getDni());
            preparedStatement.setTimestamp(4, trabajador.getUltimaJornada());
            preparedStatement.setInt(5, trabajador.getIdTrabajador());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);            
        }
    }

    /**
    * Devuelve todas las entradas de la tabla trabajador de la BBDD
    * @return List de objetos Trabajador que contiene todas las entradas de la tabla
    */
    public List<Trabajador> getAllTrabajadores() {
        List<Trabajador> dbTrabajador = new ArrayList<Trabajador>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from trabajador;");
                while (rs.next()) {
                    Trabajador trabajador = new Trabajador();
                    trabajador.setIdTrabajador(rs.getInt("id_trabajador"));
                    trabajador.setNombre(rs.getString("nombre"));
                    trabajador.setApellidos(rs.getString("apellidos"));
                    trabajador.setDni(rs.getString("dni"));
                    trabajador.setUltimaJornada(rs.getTimestamp("ultima_jornada"));   
                    dbTrabajador.add(trabajador);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbTrabajador;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
       
    }

    /**
    * Devuelve el trabajador que contiene el ID especificado
    * @param idTrabajador ID del trabajador
    * @return objeto Trabajador
    */
    public Trabajador getTrabajadorById(int idTrabajador) {
        Trabajador trabajador = new Trabajador();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from trabajador where id_trabajador=?");
            preparedStatement.setInt(1, idTrabajador);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                trabajador.setIdTrabajador(rs.getInt("id_trabajador"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setApellidos(rs.getString("apellidos"));
                trabajador.setDni(rs.getString("dni"));
                trabajador.setUltimaJornada(rs.getTimestamp("ultima_jornada"));
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return trabajador;
    }
   
    /**
    * Devuelve el Trabajador que contiene el DNI especificado
    * @param dni DNI del trabajador
    * @return objeto Trabajador
    */
    public Trabajador getTrabajadorByDni(String dni) {
        Trabajador trabajador = new Trabajador();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from trabajador where dni=?");
            preparedStatement.setString(1, dni);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                trabajador.setIdTrabajador(rs.getInt("id_trabajador"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setApellidos(rs.getString("apellidos"));
                trabajador.setDni(rs.getString("dni"));
                trabajador.setUltimaJornada(rs.getTimestamp("ultima_jornada"));
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return trabajador;
    }
}
