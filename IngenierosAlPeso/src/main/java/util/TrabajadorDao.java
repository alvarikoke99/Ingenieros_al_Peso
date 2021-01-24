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
    *
    */
    public TrabajadorDao() {
        connection = DbUtil.getConnection();
    }

    /**
    *
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
    *
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
    *
    */
    public void updateTrabajador(Trabajador trabajador) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update trabajador set nombre=?, apellidos=?, dni=?, ultima_jornada=?" + "where id_trabajador=?");
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
    *
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
    *
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
    *
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
