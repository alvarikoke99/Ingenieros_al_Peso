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

public class ProyectoDao {

    private Connection connection;

    public ProyectoDao() {
        connection = DbUtil.getConnection();
    }

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

    public void updateProyecto(Proyecto proyecto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update proyecto set nombre=?, informacion=?, id_empresa=?" + "where id_proyecto=?");
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
