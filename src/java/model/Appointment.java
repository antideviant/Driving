/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Time;
import java.util.Date;


/**
 *
 * @author PC
 */
public class Appointment {
    
    private int appointID;
    private Date appointDate;
    private Time appointTimeStart;
    private Time appointTimeEnd;
    private String appointStatus;
    private Student appointStudent;
    private Instructor appointInstructor;
    private Vehicle appointVehicle;

    public Appointment() {
    }

    public int getAppointID() {
        return appointID;
    }

    public void setAppointID(int appointID) {
        this.appointID = appointID;
    }

    public Date getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(Date appointDate) {
        this.appointDate = appointDate;
    }

    public Time getAppointTimeStart() {
        return appointTimeStart;
    }

    public void setAppointTimeStart(Time appointTimeStart) {
        this.appointTimeStart = appointTimeStart;
    }

    public Time getAppointTimeEnd() {
        return appointTimeEnd;
    }

    public void setAppointTimeEnd(Time appointTimeEnd) {
        this.appointTimeEnd = appointTimeEnd;
    }

    public String getAppointStatus() {
        return appointStatus;
    }

    public void setAppointStatus(String appointStatus) {
        this.appointStatus = appointStatus;
    }

    public Student getAppointStudent() {
        return appointStudent;
    }

    public void setAppointStudent(Student appointStudent) {
        this.appointStudent = appointStudent;
    }

    public Instructor getAppointInstructor() {
        return appointInstructor;
    }

    public void setAppointInstructor(Instructor appointInstructor) {
        this.appointInstructor = appointInstructor;
    }

    public Vehicle getAppointVehicle() {
        return appointVehicle;
    }

    public void setAppointVehicle(Vehicle appointVehicle) {
        this.appointVehicle = appointVehicle;
    }

    public Appointment(Date appointDate, Time appointTimeStart, Time appointTimeEnd, String appointStatus, Student appointStudent, Instructor appointInstructor, Vehicle appointVehicle) {
        this.appointDate = appointDate;
        this.appointTimeStart = appointTimeStart;
        this.appointTimeEnd = appointTimeEnd;
        this.appointStatus = appointStatus;
        this.appointStudent = appointStudent;
        this.appointInstructor = appointInstructor;
        this.appointVehicle = appointVehicle;
    }  
}
