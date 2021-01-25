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
import model.Proyecto;
import util.DbUtil;
import util.Log;

/**
 * Manejo de la tabla proyecto
 */
public class ProyectoDao {

    private Connection connection;

    /**
    * Constructor de la clase donde se crea la conexión con la BBDD
    */
    public ProyectoDao() {
        connection = DbUtil.getConnection();
    }

    /**
    * Añade una entrada a la tabla proyecto de la BBDD
    * @param proyecto objeto Proyecto que será insertado
    */
    public void addProyecto(Proyecto proyecto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into proyecto(nombre, informacion, id_empresa) values (?, ?, ?)");
            // Parameters start with 1 
            preparedStatement.setString(1, proyecto.getNombre());
            preparedStatement.setString(2, proyecto.getInformacion());            
            preparedStatement.setInt(3, proyecto.getIdEmpresa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    /**
    * Elimina una entrada de la tabla proyecto de la BBDD
    * @param idProyecto ID del proyecto que será eliminado
    */
    public void deleteProyecto(int idProyecto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from proyecto where id_proyecto=?");
            // Parameters start with 1 
            preparedStatement.setInt(1, idProyecto);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    /**
    * Actualiza una entrada de la tabla proyecto de la BBDD
    * @param proyecto objeto Proyecto que será actualizado
    */
    public void updateProyecto(Proyecto proyecto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update proyecto set nombre=?, informacion=?, id_empresa=? where id_proyecto=?");
            // Parameters start with 1 
            preparedStatement.setString(1, proyecto.getNombre());
            preparedStatement.setString(2, proyecto.getInformacion());            
            preparedStatement.setInt(3, proyecto.getIdEmpresa());
            preparedStatement.setInt(4, proyecto.getIdProyecto());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);            
        }
    }

    /**
    * Devuelve todas las entradas de la tabla proyecto de la BBDD
    * @return List de objetos Proyecto que contiene todas las entradas de la tabla
    */
    public List<Proyecto> getAllProyectos() {
        List<Proyecto> dbProyecto = new ArrayList<Proyecto>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from proyecto;");
                while (rs.next()) {
                    Proyecto proyecto = new Proyecto();
                    proyecto.setIdProyecto(rs.getInt("id_proyecto"));
                    proyecto.setNombre(rs.getString("nombre"));
                    proyecto.setInformacion(rs.getString("informacion"));
                    proyecto.setIdEmpresa(rs.getInt("id_empresa"));              
                    dbProyecto.add(proyecto);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbProyecto;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
       
    }

    /**
    * Devuelve el proyecto que contiene el ID especificado
    * @param idProyecto ID del proyecto
    * @return objeto Proyecto
    */
    public Proyecto getProyectoById(int idProyecto) {
        Proyecto proyecto = new Proyecto();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from proyecto where id_proyecto=?");
            preparedStatement.setInt(1, idProyecto);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                proyecto.setIdProyecto(rs.getInt("id_proyecto"));
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setInformacion(rs.getString("informacion"));
                proyecto.setIdEmpresa(rs.getInt("id_empresa"));
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return proyecto;
    }
    
    /**
    * Devuelve el proyecto que contiene el nombre especificado
    * @param nombre nombre del proyecto
    * @return objeto Proyecto
    */
    public Proyecto getProyectoByNombre(String nombre) {
        Proyecto proyecto = new Proyecto();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from proyecto where nombre=?");
            preparedStatement.setString(1, nombre);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                proyecto.setIdProyecto(rs.getInt("id_proyecto"));
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setInformacion(rs.getString("informacion"));
                proyecto.setIdEmpresa(rs.getInt("id_empresa"));
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return proyecto;
    }
}
