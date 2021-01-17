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
import model.HorasJornada;
import util.DbUtil;
import util.Log;

public class HorasJornadaDao {

    private Connection connection;

    public HorasJornadaDao() {
        connection = DbUtil.getConnection();
    }

    public void addHorasJornada(HorasJornada horasJornada) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into horas_jornada(horas, fecha, id_proyecto, id_trabajador) values (?, ?, ?, ?)");
            // Parameters start with 1 
            preparedStatement.setFloat(1, horasJornada.getHoras());
            preparedStatement.setDate(2, horasJornada.getFecha());            
            preparedStatement.setInt(3, horasJornada.getIdProyecto());
            preparedStatement.setInt(4, horasJornada.getIdTrabajador());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public List<HorasJornada> getAllHorasJornadas() {
        List<HorasJornada> dbHorasJornada = new ArrayList<HorasJornada>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from horas_jornada;");
                while (rs.next()) {
                    HorasJornada trabajador = new HorasJornada();
                    trabajador.setHoras(rs.getFloat("horas"));
                    trabajador.setFecha(rs.getDate("fecha"));
                    trabajador.setIdProyecto(rs.getInt("id_proyecto"));
                    trabajador.setIdTrabajador(rs.getInt("id_trabajador"));              
                    dbHorasJornada.add(trabajador);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbHorasJornada;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }   
    }

    public List<HorasJornada> getHorasJornadaByIdProyecto(int idProyecto) {
        List<HorasJornada> dbHorasJornada = new ArrayList<HorasJornada>();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from horas_jornada where id_proyecto=?;");
                // Parameters start with 1 
                preparedStatement.setInt(1, idProyecto);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    HorasJornada trabajador = new HorasJornada();
                    trabajador.setHoras(rs.getInt("userid"));
                    trabajador.setFecha(rs.getDate("fecha"));
                    trabajador.setIdProyecto(rs.getInt("id_proyecto"));
                    trabajador.setIdTrabajador(rs.getInt("id_trabajador"));              
                    dbHorasJornada.add(trabajador);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbHorasJornada;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
    }
    
    public List<HorasJornada> getHorasJornadaByIdTrabajador(int idTrabajador) {
        List<HorasJornada> dbHorasJornada = new ArrayList<HorasJornada>();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from horas_jornada where id_trabajador=?;");
                // Parameters start with 1 
                preparedStatement.setInt(1, idTrabajador);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    HorasJornada trabajador = new HorasJornada();
                    trabajador.setHoras(rs.getInt("userid"));
                    trabajador.setFecha(rs.getDate("fecha"));
                    trabajador.setIdProyecto(rs.getInt("id_proyecto"));
                    trabajador.setIdTrabajador(rs.getInt("id_trabajador"));              
                    dbHorasJornada.add(trabajador);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbHorasJornada;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
    }
    
    public List<HorasJornada> getHorasJornadaById(int idProyecto, int idTrabajador) {
        List<HorasJornada> dbHorasJornada = new ArrayList<HorasJornada>();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from horas_jornada where id_proyecto=? and id_trabajador=?;");
                // Parameters start with 1 
                preparedStatement.setInt(1, idProyecto);
                preparedStatement.setInt(2, idTrabajador);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    HorasJornada trabajador = new HorasJornada();
                    trabajador.setHoras(rs.getInt("userid"));
                    trabajador.setFecha(rs.getDate("fecha"));
                    trabajador.setIdProyecto(rs.getInt("id_proyecto"));
                    trabajador.setIdTrabajador(rs.getInt("id_trabajador"));              
                    dbHorasJornada.add(trabajador);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbHorasJornada;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
    }
}
