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
import model.RelacionEmpresaTrabajador;
import util.DbUtil;
import util.Log;

/**
*
*/
public class EmpresaTrabajadorDao {

    private Connection connection;

    /**
    * Constructor de la clase donde se crea la conexión con la BBDD
    */
    public EmpresaTrabajadorDao() {
        connection = DbUtil.getConnection();
    }

    /**
    * Añade una entrada a la tabla relacion_empresa_trabajador de la BBDD
    * @param relacion objeto RelacionEmpresaTrabajador que será insertado
    */
    public void addRelacion(RelacionEmpresaTrabajador relacion) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into relacion_empresa_trabajador(id_trabajador, id_empresa, departamento) values (?, ?, ? )");
            // Parameters start with 1 
            preparedStatement.setInt(1, relacion.getIdTrabajador());
            preparedStatement.setInt(2, relacion.getIdEmpresa());            
            preparedStatement.setString(3, relacion.getDepartamento());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    /**
    * Elimina una entrada de la tabla relacion_empresa_trabajador de la BBDD
    * @param idTrabajador ID del trabajador de la relación que será eliminada
    * @param idEmpresa ID de la empresa de la relación que será eliminada
    * @param departamento departamento de la relación que será eliminada
    */
    public void deleteRelacion(int idTrabajador, int idEmpresa, String departamento) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from relacion_empresa_trabajador where id_trabajador=? and id_empresa=? and departamento=?");
            // Parameters start with 1 
            preparedStatement.setInt(1, idTrabajador);
            preparedStatement.setInt(2, idEmpresa);            
            preparedStatement.setString(3, departamento);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    /**
    * Devuelve todas las entradas de la tabla relacion_empresa_trabajador de la BBDD
    * @return List de objetos RelacionEmpresaTrabajador que contiene todas las entradas de la tabla
    */
    public List<RelacionEmpresaTrabajador> getAllRelaciones() {
        List<RelacionEmpresaTrabajador> dbRelacion = new ArrayList<RelacionEmpresaTrabajador>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from relacion_empresa_trabajador;");
                while (rs.next()) {
                    RelacionEmpresaTrabajador relacion = new RelacionEmpresaTrabajador();
                    relacion.setIdTrabajador(rs.getInt("id_trabajador"));
                    relacion.setIdEmpresa(rs.getInt("id_empresa"));
                    relacion.setDepartamento(rs.getString("departamento"));              
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
    * Devuelve las relaciones que contiene el ID de trabajador especificado
    * @param idTrabajador ID del trabajador de la relación
    * @return List de objetos RelacionEmpresaTrabajador asociados con el ID especificado
    */
    public List<RelacionEmpresaTrabajador> getRelacionesByIdTrabajador(int idTrabajador) {
        List<RelacionEmpresaTrabajador> dbRelacion = new ArrayList<RelacionEmpresaTrabajador>();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from relacion_empresa_trabajador where id_trabajador=?;");
                // Parameters start with 1 
                preparedStatement.setInt(1, idTrabajador);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    RelacionEmpresaTrabajador relacion = new RelacionEmpresaTrabajador();
                    relacion.setIdTrabajador(rs.getInt("id_trabajador"));
                    relacion.setIdEmpresa(rs.getInt("id_empresa"));
                    relacion.setDepartamento(rs.getString("departamento"));              
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
    * Devuelve la relaciones que contienen el ID de empresa especificado
    * @param idEmpresa ID de la empresa
    * @return List de objetos RelacionEmpresaTrabajador asociados con el ID especificado
    */
    public List<RelacionEmpresaTrabajador> getRelacionesByIdEmpresa(int idEmpresa) {
        List<RelacionEmpresaTrabajador> dbRelacion = new ArrayList<RelacionEmpresaTrabajador>();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from relacion_empresa_trabajador where id_empresa=?;");
                // Parameters start with 1 
                preparedStatement.setInt(1, idEmpresa);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    RelacionEmpresaTrabajador relacion = new RelacionEmpresaTrabajador();
                    relacion.setIdTrabajador(rs.getInt("id_trabajador"));
                    relacion.setIdEmpresa(rs.getInt("id_empresa"));
                    relacion.setDepartamento(rs.getString("departamento"));              
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
    * Devuelve la relaciones que contienen los ID especificados
    * @param idTrabajador ID del trabajador
    * @param idEmpresa ID de la empresa
    * @return List de objetos RelacionEmpresaTrabajador asociados con los ID especificados
    */
    public List<RelacionEmpresaTrabajador> getRelacionesById(int idTrabajador, int idEmpresa) {
        List<RelacionEmpresaTrabajador> dbRelacion = new ArrayList<RelacionEmpresaTrabajador>();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from relacion_empresa_trabajador where id_trabajador=? and id_empresa=?;");
                // Parameters start with 1 
                preparedStatement.setInt(1, idTrabajador);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    RelacionEmpresaTrabajador relacion = new RelacionEmpresaTrabajador();
                    relacion.setIdTrabajador(rs.getInt("id_trabajador"));
                    relacion.setIdEmpresa(rs.getInt("id_empresa"));
                    relacion.setDepartamento(rs.getString("departamento"));              
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
