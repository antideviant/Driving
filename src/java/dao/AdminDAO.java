/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Admin;
import util.DBConnection;

/**
 *
 * @author PC
 */
public class AdminDAO {
    
    public Admin getAdmin(int id){
      
        Connection con = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("select * from admin where admin_id = ? ");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Admin admin = new Admin();
                admin.setAdminID(id);
                admin.setAdminPassword(resultSet.getString("admin_pass"));
                admin.setAdminEmail(resultSet.getString("admin_email"));
                admin.setAdminName(resultSet.getString("admin_name"));
                admin.setAdminPhone(resultSet.getString("admin_phone"));
                admin.setAdminPhoto(resultSet.getString("admin_photo"));
                
                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Admin getAdminWithPassword(String email, String password){
      
        Connection con = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("select * from admin where admin_email = ? and admin_pass = ?");
            statement.setString(1, email);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Admin admin = new Admin();
                admin.setAdminID(resultSet.getInt("admin_id"));
                admin.setAdminPassword(password);
                admin.setAdminEmail(resultSet.getString("admin_email"));
                admin.setAdminName(resultSet.getString("admin_name"));
                admin.setAdminPhone(resultSet.getString("admin_phone"));
                admin.setAdminPhoto(resultSet.getString("admin_photo"));
                
                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
       
    public void updateAdmin(Admin admin){
        Connection con = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("UPDATE admin " +
                "SET admin_pass = ?, " +
                "admin_name = ?, " +
                "admin_email = ? " +
                "admin_phone = ? " +
                "admin_photo = ? " +
                "WHERE admin_id = ?");
            statement.setString(1, admin.getAdminPassword());
            statement.setString(2,admin.getAdminName());
            statement.setString(3,admin.getAdminEmail());
            statement.setString(4, admin.getAdminPhone());
            statement.setString(5, admin.getAdminPhoto());
            statement.setInt(6, admin.getAdminID());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
        
}
