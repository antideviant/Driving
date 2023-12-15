/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author PC
 */
public class StudentDAO {
    
    public Student getStudentWithEmailandPassword(String email, String password){
        Connection con = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("select * from student where stud_email = ? and stud_pass = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Student student = new Student();
                student.setStudID(resultSet.getInt("stud_id"));
                student.setStudPass(resultSet.getString("stud_pass"));
                student.setLicenseType(resultSet.getString("license_type"));
                student.setStudEmail(resultSet.getString("stud_email"));
                student.setStudName(resultSet.getString("stud_name"));
                student.setStudPhone(resultSet.getString("stud_phone"));
                student.setStudPhoto(resultSet.getString("stud_photo"));
                student.setStudIC(resultSet.getString("stud_ic"));
                
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    
    }
    
    public Student getStudent(int id){
      
        Connection con = null;
        ResultSet resultSet = null;
        String studID = "";
        String studPass = "";
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("select * from student where stud_id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Student student = new Student();
                student.setStudID(id);
                student.setStudPass(resultSet.getString("stud_pass"));
                student.setLicenseType(resultSet.getString("license_type"));
                student.setStudEmail(resultSet.getString("stud_email"));
                student.setStudName(resultSet.getString("stud_name"));
                student.setStudPhone(resultSet.getString("stud_phone"));
                student.setStudPhoto(resultSet.getString("stud_photo"));
                student.setStudIC(resultSet.getString("stud_ic"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Student> getStudents(){
        
        Connection con = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("select * from student");
            resultSet = statement.executeQuery();
            List<Student> students = new ArrayList();
            while (resultSet.next())
            {
                Student student = new Student();
                student.setStudID(resultSet.getInt("stud_id"));
                student.setStudPass(resultSet.getString("stud_pass"));
                student.setLicenseType(resultSet.getString("license_type"));
                student.setStudEmail(resultSet.getString("stud_email"));
                student.setStudName(resultSet.getString("stud_name"));
                student.setStudPhone(resultSet.getString("stud_phone"));
                student.setStudPhoto(resultSet.getString("stud_photo"));
                student.setStudIC(resultSet.getString("stud_ic"));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void registerStudent(Student student){
        Connection con = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("insert into student (stud_pass,stud_name,stud_email,stud_phone,stud_photo,license_type,stud_ic) values (?,?,?,?,?,?,?)");
            statement.setString(1, student.getStudPass());
            statement.setString(2,student.getStudName());
            statement.setString(3,student.getStudEmail());
            statement.setString(4, student.getStudPhone());
            statement.setString(5, student.getStudPhoto());
            statement.setString(6, student.getLicenseType());
            statement.setString(7, student.getStudIC());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateStudent(Student student){
        Connection con = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("UPDATE student " +
                "SET stud_pass = ?, " +
                "stud_name = ?, " +
                "stud_email = ?, " +
                "stud_phone = ?, " +
                "stud_photo = ?," +
                "license_type = ?, " +
                "stud_ic = ?" +
                "WHERE stud_id = ?");
            statement.setString(1, student.getStudPass());
            statement.setString(2, student.getStudName());
            statement.setString(3, student.getStudEmail());
            statement.setString(4, student.getStudPhone());
            statement.setString(5, student.getStudPhoto());
            statement.setString(6, student.getLicenseType());
            statement.setString(7, student.getStudIC());
            statement.setInt(8, student.getStudID());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    
    public void deleteStudent(Student student){
        Connection con = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("Delete from student " +
                "WHERE stud_id = ?");
            statement.setInt(1, student.getStudID());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    
    public int countStudent() {
        Connection con = null;
        ResultSet resultSet = null;
        int rowCount = 0;

        try {

            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("SELECT COUNT(*) AS row_count FROM student");
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
