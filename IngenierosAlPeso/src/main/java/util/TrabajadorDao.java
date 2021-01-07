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
import model.Trabajador;
import util.DbUtil;
import util.Log;

public class TrabajadorDao {

    private Connection connection;

    public TrabajadorDao() {
        connection = DbUtil.getConnection();
    }

//    public void addUser(User user) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("insert into users(firstname,lastname,email) values (?, ?, ? )");
//// Parameters start with 1 
//            preparedStatement.setString(1, user.getFirstName());
//            preparedStatement.setString(2, user.getLastName());            
//            preparedStatement.setString(3, user.getEmail());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            Log.logdb.error("SQL Exception: " + e);
//        }
//    }
//
//    public void deleteUser(int userId) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where userid=?");
//            // Parameters start with 1 
//            preparedStatement.setInt(1, userId);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            Log.logdb.error("SQL Exception: " + e);
//        }
//    }
//
//    public void updateUser(User user) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("update users set firstname=?, lastname=?, email=?" + "where userid=?");
//// Parameters start with 1 
//            preparedStatement.setString(1, user.getFirstName());
//            preparedStatement.setString(2, user.getLastName());            
//            preparedStatement.setString(3, user.getEmail());
//            preparedStatement.setInt(4, user.getUserid());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            Log.logdb.error("SQL Exception: " + e);            
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> userdb = new ArrayList<User>();
//        if (connection != null)
//        {
//            try {
//                Statement statement = connection.createStatement();
//                ResultSet rs = statement.executeQuery("select * from users;");
//                while (rs.next()) {
//                    User user = new User();
//                    user.setUserid(rs.getInt("userid"));
//                    user.setFirstName(rs.getString("firstname"));
//                    user.setLastName(rs.getString("lastname"));
//                    user.setDob(rs.getDate("dob"));
//                    user.setEmail(rs.getString("email"));
//                    userdb.add(user);
//                }
//            } catch (SQLException e) {
//                Log.logdb.error("SQL Exception: " + e);            
//            }
//            return userdb;
//        }
//        else
//        {
//            Log.logdb.error("No hay conexion con la bbdd");
//            return null;
//        }
//       
//    }
//
//    public User getUserById(int userId) {
//        User user = new User();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where userid=?");
//            preparedStatement.setInt(1, userId);
//            ResultSet rs = preparedStatement.executeQuery();
//            if (rs.next()) {
//                user.setUserid(rs.getInt("userid"));
//                user.setFirstName(rs.getString("firstname"));
//                user.setLastName(rs.getString("lastname"));
//                user.setDob(rs.getDate("dob"));
//                user.setEmail(rs.getString("email"));
//            }
//        } catch (SQLException e) {
//            Log.logdb.error("SQL Exception: " + e);
//        }
//        return user;
//    }
}
