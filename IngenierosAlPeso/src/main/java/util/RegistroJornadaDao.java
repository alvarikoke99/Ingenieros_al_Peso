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

/**
*
*/
public class RegistroJornadaDao {

    private Connection connection;

    /**
    * Constructor de la clase donde se crea la conexión con la BBDD
    */
    public RegistroJornadaDao() {
        connection = DbUtil.getConnection();
    }

    /**
    * Añade una entrada a la tabla registro_jornada de la BBDD
    * @param registro objeto RegistroJornada que será insertado
    */
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

    /**
    * Elimina una entrada de la tabla registro_jornada de la BBDD
    * @param registro objeto RegistroJornada que será eliminado
    */
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
   
    /**
    * Actualiza una entrada de la tabla registro_jornada de la BBDD
    * @param registro objeto RegistroJornada que será actualizado
    */
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

    /**
    * Devuelve todas las entradas de la tabla registro_jornada de la BBDD
    * @return List de objetos RegistroJornada que contiene todas las entradas de la tabla
    */
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

    /**
    * Devuelve los registros que contienen el ID especificado
    * @param idTrabajador ID del trabajador
    * @return List de objetos RegistroJornada asociados con el ID especificado
    */
    public List<RegistroJornada> getRegistrosByIdTrabajador(int idTrabajador) {
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
  
    /**
    * Devuelve el registro especificando la fecha de entrada
    * @param idTrabajador ID del trabajador
    * @param idProyecto ID del proyecto
    * @param fecha fecha de entrada del trabajador
    * @return objeto RegistroJornada
    */
    public RegistroJornada getRegistroByFechaEntrada(int idTrabajador, int idProyecto, Timestamp fecha) {
        RegistroJornada registro = new RegistroJornada();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from registro_jornada where fecha_entrada=? and id_trabajador=? and id_proyecto=?;");
            preparedStatement.setTimestamp(1, fecha);
            preparedStatement.setInt(2, idTrabajador);
            preparedStatement.setInt(3, idProyecto);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                registro.setFechaEntrada(rs.getTimestamp("fecha_entrada"));
                registro.setFechaSalida(rs.getTimestamp("fecha_salida"));
                registro.setIdTrabajador(rs.getInt("id_trabajador"));
                registro.setIdProyecto(rs.getInt("id_proyecto")); 
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return registro;
    }
   
    /**
    * Devuelve el registro especificando la fecha de salida
    * @param idTrabajador ID del trabajador
    * @param idProyecto ID del proyecto
    * @param fecha fecha de salida del trabajador
    * @return objeto RegistroJornada
    */
    public RegistroJornada getRegistroByFechaSalida(int idTrabajador, int idProyecto, Timestamp fecha) {
        RegistroJornada registro = new RegistroJornada();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from registro_jornada where fecha_salida=? and id_trabajador=? and id_proyecto=?;");
            preparedStatement.setTimestamp(1, fecha);
            preparedStatement.setInt(2, idTrabajador);
            preparedStatement.setInt(3, idProyecto);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                registro.setFechaEntrada(rs.getTimestamp("fecha_entrada"));
                registro.setFechaSalida(rs.getTimestamp("fecha_salida"));
                registro.setIdTrabajador(rs.getInt("id_trabajador"));
                registro.setIdProyecto(rs.getInt("id_proyecto")); 
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return registro;
    }
}
