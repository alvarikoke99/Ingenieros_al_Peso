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
import model.Empresa;
import util.DbUtil;
import util.Log;

/**
*
*/
public class EmpresaDao {

    private Connection connection;

    /**
    * Constructor de la clase donde se crea la conexión con la BBDD
    */
    public EmpresaDao() {
        connection = DbUtil.getConnection();
    }

    /**
    * Añade una entrada a la tabla empresa de la BBDD
    * @param empresa objeto Empresa que será insertado
    */
    public void addEmpresa(Empresa empresa) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into empresa(nombre,descripcion) values (?,?)");
            // Parameters start with 1 
            preparedStatement.setString(1, empresa.getNombre());
            preparedStatement.setString(2, empresa.getDescripcion());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    /**
    * Elimina una entrada de la tabla empresa de la BBDD
    * @param idEmpresa ID de la empresa que será eliminada
    */
    public void deleteEmpresa(int idEmpresa) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from empresa where id_empresa=?");
            // Parameters start with 1 
            preparedStatement.setInt(1, idEmpresa);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    /**
    * Actualiza una entrada de la tabla empresa de la BBDD
    * @param solicitud objeto Empresa que será actualizado
    */
    public void updateEmpresa(Empresa empresa) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update empresa set nombre=?, descripcion=? where id_empresa=?");
            // Parameters start with 1 
            preparedStatement.setString(1, empresa.getNombre());
            preparedStatement.setString(2, empresa.getDescripcion());
            preparedStatement.setInt(3, empresa.getIdEmpresa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);            
        }
    }

    /**
    * Devuelve todas las entradas de la tabla empresa de la BBDD
    * @return List de objetos Empresa que contiene todas las entradas de la tabla
    */
    public List<Empresa> getAllEmpresas() {
        List<Empresa> dbEmpresa = new ArrayList<Empresa>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from empresa;");
                while (rs.next()) {
                    Empresa empresa = new Empresa();
                    empresa.setIdEmpresa(rs.getInt("id_empresa"));
                    empresa.setNombre(rs.getString("nombre"));    
                     empresa.setDescripcion(rs.getString("descripcion")); 
                    dbEmpresa.add(empresa);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbEmpresa;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
       
    }

    /**
    * Devuelve la empresa que contiene el ID especificado
    * @param idEmpresa ID de la empresa
    * @return objeto Empresa
    */
    public Empresa getEmpresaById(int idEmpresa) {
        Empresa empresa = new Empresa();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from empresa where id_empresa=?");
            preparedStatement.setInt(1, idEmpresa);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                empresa.setIdEmpresa(rs.getInt("id_empresa"));
                empresa.setNombre(rs.getString("nombre")); 
                empresa.setDescripcion(rs.getString("descripcion")); 
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return empresa;
    }
    
    /**
    * Devuelve la empresa que contiene el nombre de empresa especificado
    * @param nombre nombre de la empresa
    * @return objeto Empresa
    */
    public Empresa getEmpresaByNombre(String nombre) {
        Empresa empresa = new Empresa();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from empresa where nombre=?");
            preparedStatement.setString(1, nombre);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                empresa.setIdEmpresa(rs.getInt("id_empresa"));
                empresa.setNombre(rs.getString("nombre")); 
                empresa.setDescripcion(rs.getString("descripcion")); 
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return empresa;
    }
}
