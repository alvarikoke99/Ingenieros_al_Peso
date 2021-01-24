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
import model.RelacionProyectoTrabajador;
import util.DbUtil;
import util.Log;

/**
*
*/
public class ProyectoTrabajadorDao {

    private Connection connection;

    /**
    * Constructor de la clase donde se crea la conexión con la BBDD
    */
    public ProyectoTrabajadorDao() {
        connection = DbUtil.getConnection();
    }

    /**
    * Añade una entrada a la tabla relacion_proyecto_trabajador de la BBDD
    * @param relacion objeto RelacionProyectoTrabajador que será insertado
    */
    public void addRelacion(RelacionProyectoTrabajador relacion) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into relacion_proyecto_trabajador(id_proyecto, id_trabajador) values (?, ?)");
            // Parameters start with 1 
            preparedStatement.setInt(1, relacion.getIdProyecto());
            preparedStatement.setInt(2, relacion.getIdTrabajador());         
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    /**
    * Elimina una entrada de la tabla relacion_proyecto_trabajador de la BBDD
    * @param idProyecto ID del proyecto
    * @param idTrabajador ID del trabajador
    */
    public void deleteRelacion(int idProyecto, int idTrabajador) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from relacion_proyecto_trabajador where id_proyecto=? and id_trabajador=?");
            // Parameters start with 1 
            preparedStatement.setInt(1, idProyecto);
            preparedStatement.setInt(2, idTrabajador);            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    /**
    * Devuelve todas las entradas de la tabla relacion_proyecto_trabajador de la BBDD
    * @return List de objetos RelacionProyectoTrabajador que contiene todas las entradas de la tabla
    */
    public List<RelacionProyectoTrabajador> getAllRelaciones() {
        List<RelacionProyectoTrabajador> dbRelacion = new ArrayList<RelacionProyectoTrabajador>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from relacion_proyecto_trabajador;");
                while (rs.next()) {
                    RelacionProyectoTrabajador relacion = new RelacionProyectoTrabajador();
                    relacion.setIdProyecto(rs.getInt("id_proyecto"));
                    relacion.setIdTrabajador(rs.getInt("id_trabajador"));              
                    dbRelacion.add(relacion);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbRelacion;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
       
    }
 
    /**
    * Devuelve la relaciones que contienen el ID especificado
    * @param idProyecto ID del proyecto
    * @return List de objetos RelacionProyectoTrabajador asociados con el ID especificado
    */
    public List<RelacionProyectoTrabajador> getRelacionesByIdProyecto(int idProyecto) {
        List<RelacionProyectoTrabajador> dbRelacion = new ArrayList<RelacionProyectoTrabajador>();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from relacion_proyecto_trabajador where id_proyecto=?;");
                // Parameters start with 1 
                preparedStatement.setInt(1, idProyecto);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    RelacionProyectoTrabajador relacion = new RelacionProyectoTrabajador();
                    relacion.setIdProyecto(rs.getInt("id_proyecto"));
                    relacion.setIdTrabajador(rs.getInt("id_trabajador"));             
                    dbRelacion.add(relacion);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbRelacion;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
    }

    /**
    * Devuelve las relaciones que contiene el ID especificado
    * @param idTrabajador ID del trabajador
    * @return List de objetos RelacionProyectoTrabajador asociados con el ID especificado
    */
    public List<RelacionProyectoTrabajador> getRelacionesByIdTrabajador(int idTrabajador) {
        List<RelacionProyectoTrabajador> dbRelacion = new ArrayList<RelacionProyectoTrabajador>();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from relacion_proyecto_trabajador where id_trabajador=?;");
                // Parameters start with 1 
                preparedStatement.setInt(1, idTrabajador);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    RelacionProyectoTrabajador relacion = new RelacionProyectoTrabajador();
                    relacion.setIdProyecto(rs.getInt("id_proyecto"));
                    relacion.setIdTrabajador(rs.getInt("id_trabajador"));              
                    dbRelacion.add(relacion);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbRelacion;
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
    * @param idTrabajador ID del trbajador
    * @return List de objetos RelacionProyectoTrabajador asociados con el ID especificado
    */
    public List<RelacionProyectoTrabajador> getRelacionesById(int idProyecto, int idTrabajador) {
        List<RelacionProyectoTrabajador> dbRelacion = new ArrayList<RelacionProyectoTrabajador>();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from relacion_proyecto_trabajador where id_proyecto=? and id_trabajador=?;");
                // Parameters start with 1 
                preparedStatement.setInt(1, idTrabajador);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    RelacionProyectoTrabajador relacion = new RelacionProyectoTrabajador();
                    relacion.setIdProyecto(rs.getInt("id_proyecto"));
                    relacion.setIdTrabajador(rs.getInt("id_trabajador"));            
                    dbRelacion.add(relacion);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbRelacion;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
    }
}
