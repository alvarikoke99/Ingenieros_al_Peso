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
import model.Solicitud;
import util.DbUtil;
import util.Log;

/**
 * Manejo de la tabla solicitud
 */
public class SolicitudDao {

    private Connection connection;

    /**
    * Constructor de la clase donde se crea la conexión con la BBDD
    */
    public SolicitudDao() {
        connection = DbUtil.getConnection();
    }
    
    /**
    * Añade una entrada a la tabla solicitud de la BBDD
    * @param solicitud objeto Solicitud que será insertado
    */
    public void addSolicitud(Solicitud solicitud) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into solicitud(tipo,fecha_ini,fecha_final,observacion,tramitada,id_trabajador) values (?, ?, ?, ?, ?, ?)");
            // Parameters start with 1 
            preparedStatement.setString(1, solicitud.getTipo());
            preparedStatement.setDate(2, solicitud.getFechaIni());            
            preparedStatement.setDate(3, solicitud.getFechaFinal());
            preparedStatement.setString(4, solicitud.getObservacion());
            preparedStatement.setInt(5, solicitud.getTramitada());
            preparedStatement.setInt(6, solicitud.getIdTrabajador());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }
    
    /**
    * Elimina una entrada de la tabla solicitud de la BBDD
    * @param idSolicitud ID de la solicitud que será eliminada
    */
    public void deleteSolicitud(int idSolicitud) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from solicitud where id_solicitud=?");
            // Parameters start with 1 
            preparedStatement.setInt(1, idSolicitud);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    /**
    * Actualiza una entrada de la tabla solicictud de la BBDD
    * @param solicitud objeto Solicitud que será actualizado
    */
    public void updateSolicitud(Solicitud solicitud) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update solicitud set tipo=?, fecha_ini=?, fecha_final=?, observacion=?, tramitada=?, id_trabajador=? where id_solicitud=?");
            // Parameters start with 1 
            preparedStatement.setString(1, solicitud.getTipo());
            preparedStatement.setDate(2, solicitud.getFechaIni());            
            preparedStatement.setDate(3, solicitud.getFechaFinal());
            preparedStatement.setString(4, solicitud.getObservacion());
            preparedStatement.setInt(5, solicitud.getTramitada());
            preparedStatement.setInt(6, solicitud.getIdTrabajador());
            preparedStatement.setInt(7, solicitud.getIdSolicitud());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e); 
        }
    }
    
    /**
    * Devuelve todas las entradas de la tabla solicitudes de la BBDD
    * @return List de objetos Solicitud que contiene todas las entradas de la tabla
    */
    public List<Solicitud> getAllSolicitudes() {
        List<Solicitud> dbSolicitud = new ArrayList<Solicitud>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from solicitud;");
                while (rs.next()) {
                    Solicitud solicitud = new Solicitud();
                    solicitud.setIdSolicitud(rs.getInt("id_solicitud"));
                    solicitud.setTipo(rs.getString("tipo"));
                    solicitud.setFechaIni(rs.getDate("fecha_ini"));
                    solicitud.setFechaFinal(rs.getDate("fecha_final"));
                    solicitud.setObservacion(rs.getString("observacion"));
                    solicitud.setTramitada(rs.getInt("tramitada"));
                    solicitud.setIdTrabajador(rs.getInt("id_trabajador"));
                    dbSolicitud.add(solicitud);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbSolicitud;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
       
    }
    
    /**
    * Devuelve la solicitud que contiene el ID especificado
    * @param idSolicitud ID de la solicitud
    * @return objeto Solicitud
    */
    public Solicitud getSolicitudById(int idSolicitud) {
        Solicitud solicitud = new Solicitud();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from solicitud where id_solicitud=?");
            preparedStatement.setInt(1, idSolicitud);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                solicitud.setIdSolicitud(rs.getInt("id_solicitud"));
                solicitud.setTipo(rs.getString("tipo"));
                solicitud.setFechaIni(rs.getDate("fecha_ini"));
                solicitud.setFechaFinal(rs.getDate("fecha_final"));
                solicitud.setObservacion(rs.getString("observacion"));
                solicitud.setTramitada(rs.getInt("tramitada"));
                solicitud.setIdTrabajador(rs.getInt("id_trabajador"));
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return solicitud;
    }
    
    public void aceptarSolicitud(int idSolicitud) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update solicitud set tramitada=? where id_solicitud=?");
            // Parameters start with 1 
            preparedStatement.setInt(1, 2);
            preparedStatement.setInt(2, idSolicitud);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e); 
        }
    }
    
    public void rechazarSolicitud(int idSolicitud) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update solicitud set tramitada=? where id_solicitud=?");
            // Parameters start with 1 
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, idSolicitud);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e); 
        }
    }
    
    /**
    * Devuelve la solicitud que contiene el ID de trabajador especificado
    * @param idTrabajador ID del trabajador asociado con la solicitud
    * @return objeto Solicitud
    */
    public List<Solicitud> getSolicitudesByIdTrabajador(int idTrabajador) {
        List<Solicitud> dbSolicitud = new ArrayList<Solicitud>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from solicitud where id_trabajador=?");
            preparedStatement.setInt(1, idTrabajador);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Solicitud solicitud = new Solicitud();
                solicitud.setIdSolicitud(rs.getInt("id_solicitud"));
                solicitud.setTipo(rs.getString("tipo"));
                solicitud.setFechaIni(rs.getDate("fecha_ini"));
                solicitud.setFechaFinal(rs.getDate("fecha_final"));
                solicitud.setObservacion(rs.getString("observacion"));
                solicitud.setTramitada(rs.getInt("tramitada"));
                solicitud.setIdTrabajador(rs.getInt("id_trabajador"));
                dbSolicitud.add(solicitud);
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return dbSolicitud;
    }
}
