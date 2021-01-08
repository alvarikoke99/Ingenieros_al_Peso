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
import model.Horas_jornada;
import util.DbUtil;
import util.Log;

public class HorasJornadaDao {

    private Connection connection;

    public HorasJornadaDao() {
        connection = DbUtil.getConnection();
    }

    public void addTrabajador(Horas_jornada trabajador) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into horas_jornada(nombre,apellidos, dni) values (?, ?, ? )");
            // Parameters start with 1 
            preparedStatement.setString(1, trabajador.getNombre());
            preparedStatement.setString(2, trabajador.getApellidos());            
            preparedStatement.setString(3, trabajador.getDni());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void deleteTrabajador(int idHorasJornada) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from horas_jornada where userid=?");
            // Parameters start with 1 
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void updateTrabajador(Horas_jornada trabajador) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update horas_jornada set nombre=?, apellidos=?, dni=?" + "where id_trabajador=?");
            // Parameters start with 1 
            preparedStatement.setString(1, trabajador.getNombre());
            preparedStatement.setString(2, trabajador.getApellidos());            
            preparedStatement.setString(3, trabajador.getDni());
            preparedStatement.setInt(4, trabajador.getId_trabajador());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);            
        }
    }

    public List<Horas_jornada> getAllTrabajadores() {
        List<Horas_jornada> dbTrabajador = new ArrayList<Horas_jornada>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from horas_jornada;");
                while (rs.next()) {
                    Horas_jornada trabajador = new Horas_jornada();
                    trabajador.setId_trabajador(rs.getInt("userid"));
                    trabajador.setNombre(rs.getString("firstname"));
                    trabajador.setApellidos(rs.getString("lastname"));
                    trabajador.setDni(rs.getString("dni"));              
                    dbTrabajador.add(trabajador);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return dbTrabajador;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
       
    }

    public Horas_jornada getTrabajadorById(int idHorasJornada) {
        Horas_jornada trabajador = new Horas_jornada();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from horas_jornada where id_trabajador=?");
            preparedStatement.setInt(1, idHorasJornada);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                trabajador.setId_trabajador(rs.getInt("userid"));
                trabajador.setNombre(rs.getString("firstname"));
                trabajador.setApellidos(rs.getString("lastname"));
                trabajador.setDni(rs.getString("dni"));
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return trabajador;
    }
}
