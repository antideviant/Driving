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
import model.Vehicle;
import util.DBConnection;

/**
 *
 * @author PC
 */
public class VehicleDAO {
    
        
    public Vehicle getVehicle(int id){
      
        Connection con = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("select * from vehicle where vehi_id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleID(id);
                vehicle.setVehicleType(resultSet.getString("vehi_type"));
                vehicle.setVehicleName(resultSet.getString("vehi_name"));
                vehicle.setVehiclePlatNo(resultSet.getString("vehi_platno"));
                vehicle.setVehicleStatus(resultSet.getString("vehi_status"));
                
                return vehicle;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Vehicle> getVehicles(){
        
        Connection con = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("select * from vehicle");
            resultSet = statement.executeQuery();
            List<Vehicle> vehicles = new ArrayList();
            while (resultSet.next())
            {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleID(resultSet.getInt("vehi_id"));
                vehicle.setVehicleType(resultSet.getString("vehi_type"));
                vehicle.setVehicleName(resultSet.getString("vehi_name"));
                vehicle.setVehiclePlatNo(resultSet.getString("vehi_platno"));
                vehicle.setVehicleStatus(resultSet.getString("vehi_status"));
                
                
                vehicles.add(vehicle);
            }
            return vehicles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void addVehicle(Vehicle vehicle){
        Connection con = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("insert into vehicle (vehi_name,vehi_type,vehi_platno,vehi_status) values (?,?,?,?)");
            statement.setString(1, vehicle.getVehicleName());
            statement.setString(2,vehicle.getVehicleType());
            statement.setString(3, vehicle.getVehiclePlatNo());
            statement.setString(4, vehicle.getVehicleStatus());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateVehicle(Vehicle vehicle){
        Connection con = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("UPDATE vehicle " +
                "SET vehi_name = ?, " +
                "vehi_type = ?, " +
                "vehi_platno = ?, " +
                "vehi_status = ? " +
                "WHERE vehi_id = ?");
            statement.setString(1, vehicle.getVehicleName());
            statement.setString(2,vehicle.getVehicleType());
            statement.setString(3, vehicle.getVehiclePlatNo());
            statement.setString(4, vehicle.getVehicleStatus());
            statement.setInt(5, vehicle.getVehicleID());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    
    public void deleteVehicle(Vehicle vehicle){
        Connection con = null;
        
        try {
            con = DBConnection.createConnection(); 
            PreparedStatement statement;  
            statement = con.prepareStatement("Delete from vehicle " +
                "WHERE vehi_id = ?");
            statement.setInt(1, vehicle.getVehicleID());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    
    public int countVehicle() {
        Connection con = null;
        ResultSet resultSet = null;
        int rowCount = 0;

        try {

            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("SELECT COUNT(*) AS row_count FROM vehicle");
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
