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

public class SolicitudDao {

    private Connection connection;

    public SolicitudDao() {
        connection = DbUtil.getConnection();
    }

    public void addSolicitud(Solicitud solicitud) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into solicitud(tipo,fecha_ini,fecha_final,observacion,tramitada,id_trabajador) values (?, ?, ?, ?, ?, ?)");
            // Parameters start with 1 
            preparedStatement.setString(1, solicitud.getTipo());
            preparedStatement.setDate(2, solicitud.getFechaIni());            
            preparedStatement.setDate(3, solicitud.getFechaFinal());
            preparedStatement.setString(4, solicitud.getObservacion());
            preparedStatement.setBoolean(5, solicitud.getTramitada());
            preparedStatement.setInt(6, solicitud.getIdTrabajador());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

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

    public void updateSolicitud(Solicitud solicitud) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update solicitud set tipo=?, fecha_ini=?, fecha_final=?, observacion=?, tramitada=?, id_trabajador=?" + "where id_solicitud=?");
            // Parameters start with 1 
            preparedStatement.setString(1, solicitud.getTipo());
            preparedStatement.setDate(2, solicitud.getFechaIni());            
            preparedStatement.setDate(3, solicitud.getFechaFinal());
            preparedStatement.setString(4, solicitud.getObservacion());
            preparedStatement.setBoolean(5, solicitud.getTramitada());
            preparedStatement.setInt(6, solicitud.getIdTrabajador());
            preparedStatement.setInt(7, solicitud.getIdSolicitud());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);            
        }
    }

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
                    solicitud.setTramitada(rs.getBoolean("tramitada"));
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
                solicitud.setTramitada(rs.getBoolean("tramitada"));
                solicitud.setIdTrabajador(rs.getInt("id_trabajador"));
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return solicitud;
    }
}
