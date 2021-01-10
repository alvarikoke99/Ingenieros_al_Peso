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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.RegistroJornada;
import util.DbUtil;
import util.Log;

public class RegistroJornadaDao {

    private Connection connection;

    public RegistroJornadaDao() {
        connection = DbUtil.getConnection();
    }

    public void addRegistro(RegistroJornada registro) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into registro_jornada(fecha_entrada, fecha_salida, id_trabajador, id_proyecto) values (?, ?, ?, ?)");
            // Parameters start with 1 
            preparedStatement.setTimestamp(1, registro.getFechaEntrada());
            preparedStatement.setTimestamp(2, registro.getFechaSalida());            
            preparedStatement.setInt(3, registro.getIdTrabajador());
            preparedStatement.setInt(4, registro.getIdProyecto());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void deleteRegistro(RegistroJornada registro) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from registro_jornada where fecha_entrada=? and fecha_salida=? and id_trabajador=? and id_proyecto=?");
            // Parameters start with 1 
            preparedStatement.setTimestamp(1, registro.getFechaEntrada());
            preparedStatement.setTimestamp(2, registro.getFechaSalida());            
            preparedStatement.setInt(3, registro.getIdTrabajador());
            preparedStatement.setInt(4, registro.getIdProyecto());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }
    
    public void updateFechaSalida(RegistroJornada registro) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update registro_jornada set fecha_salida=?" + "where fecha_entrada=? and id_trabajador=? and id_proyecto=?");
            // Parameters start with 1 
            preparedStatement.setTimestamp(1, registro.getFechaSalida()); 
            preparedStatement.setTimestamp(2, registro.getFechaEntrada());                      
            preparedStatement.setInt(3, registro.getIdTrabajador());
            preparedStatement.setInt(4, registro.getIdProyecto());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);            
        }
    }

    public List<RegistroJornada> getAllRegistros() {
        List<RegistroJornada> dbRegistro = new ArrayList<RegistroJornada>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from registro_jornada;");
                while (rs.next()) {
                    RegistroJornada relacion = new RegistroJornada();
                    relacion.setFechaEntrada(rs.getTimestamp("fecha_entrada"));
                    relacion.setFechaSalida(rs.getTimestamp("fecha_salida"));
                    relacion.setIdTrabajador(rs.getInt("id_trabajador"));
                    relacion.setIdProyecto(rs.getInt("id_proyecto"));
                    dbRegistro.add(relacion);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbRegistro;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
       
    }

    public List<RegistroJornada> getRegistroByIdTrabajador(int idTrabajador) {
        List<RegistroJornada> dbRegistro = new ArrayList<RegistroJornada>();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from registro_jornada where id_trabajador=?;");
                // Parameters start with 1 
                preparedStatement.setInt(1, idTrabajador);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    RegistroJornada relacion = new RegistroJornada();
                    relacion.setFechaEntrada(rs.getTimestamp("fecha_entrada"));
                    relacion.setFechaSalida(rs.getTimestamp("fecha_salida"));
                    relacion.setIdTrabajador(rs.getInt("id_trabajador"));
                    relacion.setIdProyecto(rs.getInt("id_proyecto"));             
                    dbRegistro.add(relacion);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbRegistro;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
    }
    
    public List<RegistroJornada> getRegistroByFechaSalida(Timestamp fecha) {
        List<RegistroJornada> dbRegistro = new ArrayList<RegistroJornada>();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from registro_jornada where fecha_salida=?;");
                // Parameters start with 1 
                preparedStatement.setTimestamp(1, fecha);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    RegistroJornada relacion = new RegistroJornada();
                    relacion.setFechaEntrada(rs.getTimestamp("fecha_entrada"));
                    relacion.setFechaSalida(rs.getTimestamp("fecha_salida"));
                    relacion.setIdTrabajador(rs.getInt("id_trabajador"));
                    relacion.setIdProyecto(rs.getInt("id_proyecto"));             
                    dbRegistro.add(relacion);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbRegistro;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
    }
}
