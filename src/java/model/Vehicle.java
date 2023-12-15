/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Vehicle {
    
    private int vehicleID;
    private String vehicleName;
    private String vehicleType;
    private String vehiclePlatNo;
    private String vehicleStatus;

    public Vehicle() {
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehiclePlatNo() {
        return vehiclePlatNo;
    }

    public void setVehiclePlatNo(String vehiclePlatNo) {
        this.vehiclePlatNo = vehiclePlatNo;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public Vehicle(String vehicleName, String vehicleType, String vehiclePlatNo, String vehicleStatus) {
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.vehiclePlatNo = vehiclePlatNo;
        this.vehicleStatus = vehicleStatus;
    }  
    
}
