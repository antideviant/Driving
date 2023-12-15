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
import java.util.List;
import model.Instructor;
import util.DBConnection;

/**
 *
 * @author PC
 */
public class InstructorDAO {
    
    public Instructor getInstructor(int id){
      
        Connection con = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("select * from instructor where inst_id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Instructor instructor = new Instructor();
                instructor.setInstID(id);
                instructor.setInstPassword(resultSet.getString("inst_pass"));
                instructor.setInstName(resultSet.getString("inst_name"));
                instructor.setInstPhone(resultSet.getString("inst_phone"));
                instructor.setInstPhoto(resultSet.getString("inst_photo"));
                instructor.setInstEmail(resultSet.getString("inst_email"));
                
                return instructor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Instructor getInstructorWithEmailandPassword(String email, String password){
      
        Connection con = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("select * from instructor where inst_email = ? and inst_pass = ?");
            statement.setString(1, email);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Instructor instructor = new Instructor();
                instructor.setInstID(resultSet.getInt("inst_id"));
                instructor.setInstPassword(password);
                instructor.setInstName(resultSet.getString("inst_name"));
                instructor.setInstPhone(resultSet.getString("inst_phone"));
                instructor.setInstPhoto(resultSet.getString("inst_photo"));
                instructor.setInstEmail(resultSet.getString("inst_email"));
                
                return instructor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Instructor> getInstructors(){
        
        Connection con = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("select * from instructor");
            resultSet = statement.executeQuery();
            List<Instructor> instructors = new ArrayList();
            while (resultSet.next())
            {
                Instructor instructor = new Instructor();
                instructor.setInstID(resultSet.getInt("inst_id"));
                instructor.setInstPassword(resultSet.getString("inst_pass"));
                instructor.setInstName(resultSet.getString("inst_name"));
                instructor.setInstPhone(resultSet.getString("inst_phone"));
                instructor.setInstPhoto(resultSet.getString("inst_photo"));
                instructor.setInstEmail(resultSet.getString("inst_email"));
                
                instructors.add(instructor);
            }
            return instructors;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void addInstructor(Instructor instructor){
        Connection con = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("insert into instructor (inst_pass,inst_name,inst_phone,inst_photo, inst_email) values (?,?,?,?,?)");
            statement.setString(1, instructor.getInstPassword());
            statement.setString(2,instructor.getInstName());
            statement.setString(3, instructor.getInstPhone());
            statement.setString(4, instructor.getInstPhoto());
            statement.setString(5, instructor.getInstEmail());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateInstructor(Instructor instructor){
        Connection con = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("update instructor " +
                "SET inst_pass = ?, " +
                "inst_name = ?, " +
                "inst_phone = ?, " +
                "inst_photo = ?, " +
                "inst_email = ? " +
                "WHERE inst_id = ?");
            statement.setString(1, instructor.getInstPassword());
            statement.setString(2,instructor.getInstName());
            statement.setString(3, instructor.getInstPhone());
            statement.setString(4, instructor.getInstPhoto());
            statement.setString(5, instructor.getInstEmail());
            statement.setInt(6, instructor.getInstID());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    
    public void deleteInstructor(Instructor instructor){
        Connection con = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("Delete from instructor " +
                "WHERE inst_id = ?");
            statement.setInt(1, instructor.getInstID());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    
    public int countInstructor() {
        Connection con = null;
        ResultSet resultSet = null;
        int rowCount = 0;

        try {

            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("SELECT COUNT(*) AS row_count FROM instructor");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                rowCount = resultSet.getInt("row_count");
                return rowCount;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
}
