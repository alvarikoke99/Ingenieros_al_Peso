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

public class EmpresaDao {

    private Connection connection;

    public EmpresaDao() {
        connection = DbUtil.getConnection();
    }

    public void addEmpresa(Empresa empresa) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into empresa(nombre) values (?)");
            // Parameters start with 1 
            preparedStatement.setString(1, empresa.getNombre());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void deleteEmpresa(int idEmpresa) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from trabajador where id_empresa=?");
            // Parameters start with 1 
            preparedStatement.setInt(1, idEmpresa);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void updateEmpresa(Empresa empresa) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update empresa set nombre=?, apellidos=?, dni=?" + "where id_trabajador=?");
            // Parameters start with 1 
            preparedStatement.setString(1, empresa.getNombre());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);            
        }
    }

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

    public Empresa getEmpresaById(int idEmpresa) {
        Empresa empresa = new Empresa();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from empresa where id_empresa=?");
            preparedStatement.setInt(1, idEmpresa);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                empresa.setIdEmpresa(rs.getInt("id_empresa"));
                empresa.setNombre(rs.getString("nombre")); 
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return empresa;
    }
}
