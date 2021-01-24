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

/**
*
*/
public class HorasJornadaDao {

    private Connection connection;

    /**
    * Constructor de la clase donde se crea la conexión con la BBDD
    */
    public HorasJornadaDao() {
        connection = DbUtil.getConnection();
    }

    /**
    * Añade una entrada a la tabla horas_jornada de la BBDD
    * @param horasJornada objeto HorasJornada que será insertado
    */
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

    /**
    * Devuelve todas las entradas de la tabla horas_jornada de la BBDD
    * @return List de objetos HorasJornada que contiene todas las entradas de la tabla
    */
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

    /**
    * Devuelve las relaciones que contienen el ID especificado
    * @param idProyecto ID del proyecto
    * @return List de objetos HorasJornada asociados con el ID especificado
    */
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
  
    /**
    * Devuelve las relaciones que contienen el ID especificado
    * @param idTrabajador ID del trabajador
    * @return List de objetos HorasJornada asociados con el ID especificado
    */
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
    
    /**
    * Devuelve las relaciones que contienen los ID especificados
    * @param idProyecto ID del proyecto
    * @param idTrabajador ID del trabajador
    * @return List de objetos HorasJornada asociados con el ID especificado
    */
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
