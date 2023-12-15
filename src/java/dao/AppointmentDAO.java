/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Appointment;
import model.Instructor;
import model.Student;
import model.Vehicle;
import util.DBConnection;

/**
 *
 * @author PC
 */
public class AppointmentDAO {

    private StudentDAO studentDAO;
    private AdminDAO adminDAO;
    private InstructorDAO instructorDAO;
    private VehicleDAO vehicleDAO;

    public boolean checkExistingAppointment(Student student, Instructor instructor, Vehicle vehicle, Time startTime, Time endTime, Date date) {

        Connection con = null;
        ResultSet resultSet = null;

        try {
            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("select * from appointment WHERE "
                    + "(stud_id = ? OR "
                    + "inst_id = ? OR "
                    + "vehi_id = ?)"
                    + "  AND appoint_date = ?"
                    + "  AND appoint_timestart >= ?"
                    + "  AND appoint_timeend <= ?");
            statement.setInt(1, student.getStudID());
            statement.setInt(2, instructor.getInstID());
            statement.setInt(3, vehicle.getVehicleID());
            statement.setDate(4, (java.sql.Date) date);
            statement.setTime(5, startTime);
            statement.setTime(6, endTime);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Appointment getAppointment(int id) {

        Connection con = null;
        ResultSet resultSet = null;

        try {

            StudentDAO studentDAO = new StudentDAO();
            InstructorDAO instructorDAO = new InstructorDAO();
            VehicleDAO vehicleDAO = new VehicleDAO();

            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("select * from appointment where appoint_id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointID(id);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(resultSet.getDate("appoint_date"));
                appointment.setAppointDate(new Date(resultSet.getDate("appoint_date").getTime()));
                appointment.setAppointTimeStart(resultSet.getTime("appoint_timestart"));
                appointment.setAppointTimeEnd(resultSet.getTime("appoint_timeend"));
                appointment.setAppointStatus(resultSet.getString("appoint_status"));
                appointment.setAppointStudent(studentDAO.getStudent(resultSet.getInt("stud_id")));
                appointment.setAppointInstructor(instructorDAO.getInstructor(resultSet.getInt("inst_id")));
                appointment.setAppointVehicle(vehicleDAO.getVehicle(resultSet.getInt("vehi_id")));

                return appointment;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Appointment> getAppointments() {

        Connection con = null;
        ResultSet resultSet = null;

        try {

            StudentDAO studentDAO = new StudentDAO();
            InstructorDAO instructorDAO = new InstructorDAO();
            VehicleDAO vehicleDAO = new VehicleDAO();

            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("select * from appointment");
            resultSet = statement.executeQuery();
            List<Appointment> appointments = new ArrayList();
            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointID(resultSet.getInt("appoint_id"));
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(resultSet.getDate("appoint_date"));
                appointment.setAppointDate(new Date(resultSet.getDate("appoint_date").getTime()));
                appointment.setAppointTimeStart(resultSet.getTime("appoint_timestart"));
                appointment.setAppointTimeEnd(resultSet.getTime("appoint_timeend"));
                appointment.setAppointStatus(resultSet.getString("appoint_status"));
                appointment.setAppointStudent(studentDAO.getStudent(resultSet.getInt("stud_id")));
                appointment.setAppointInstructor(instructorDAO.getInstructor(resultSet.getInt("inst_id")));
                appointment.setAppointVehicle(vehicleDAO.getVehicle(resultSet.getInt("vehi_id")));

                appointments.add(appointment);
            }
            return appointments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Appointment> getUpcomingAppointments() {

        Connection con = null;
        ResultSet resultSet = null;

        try {

            StudentDAO studentDAO = new StudentDAO();
            InstructorDAO instructorDAO = new InstructorDAO();
            VehicleDAO vehicleDAO = new VehicleDAO();

            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("select * from appointment where appoint_status = 'UPCOMING'");
            resultSet = statement.executeQuery();
            List<Appointment> appointments = new ArrayList();
            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointID(resultSet.getInt("appoint_id"));
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(resultSet.getDate("appoint_date"));
                appointment.setAppointDate(new Date(resultSet.getDate("appoint_date").getTime()));
                appointment.setAppointTimeStart(resultSet.getTime("appoint_timestart"));
                appointment.setAppointTimeEnd(resultSet.getTime("appoint_timeend"));
                appointment.setAppointStatus(resultSet.getString("appoint_status"));
                appointment.setAppointStudent(studentDAO.getStudent(resultSet.getInt("stud_id")));
                appointment.setAppointInstructor(instructorDAO.getInstructor(resultSet.getInt("inst_id")));
                appointment.setAppointVehicle(vehicleDAO.getVehicle(resultSet.getInt("vehi_id")));

                appointments.add(appointment);
            }
            return appointments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Appointment> getEnrolledAppointments(int userId) {
    Connection con = null;
    ResultSet resultSet = null;

    try {
        StudentDAO studentDAO = new StudentDAO();
        InstructorDAO instructorDAO = new InstructorDAO();
        VehicleDAO vehicleDAO = new VehicleDAO();

        con = DBConnection.createConnection();
        PreparedStatement statement;
        statement = con.prepareStatement("SELECT * FROM appointment WHERE appoint_status = 'ENROLLED' AND stud_id = ?");
        statement.setInt(1, userId);
        resultSet = statement.executeQuery();
        List<Appointment> appointments = new ArrayList<>();
        while (resultSet.next()) {
            Appointment appointment = new Appointment();
            appointment.setAppointID(resultSet.getInt("appoint_id"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(resultSet.getDate("appoint_date"));
            appointment.setAppointDate(new Date(resultSet.getDate("appoint_date").getTime()));
            appointment.setAppointTimeStart(resultSet.getTime("appoint_timestart"));
            appointment.setAppointTimeEnd(resultSet.getTime("appoint_timeend"));
            appointment.setAppointStatus(resultSet.getString("appoint_status"));
            appointment.setAppointStudent(studentDAO.getStudent(resultSet.getInt("stud_id")));
            appointment.setAppointInstructor(instructorDAO.getInstructor(resultSet.getInt("inst_id")));
            appointment.setAppointVehicle(vehicleDAO.getVehicle(resultSet.getInt("vehi_id")));

            appointments.add(appointment);
        }
        return appointments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Appointment> getAppointments(Student student) {

        Connection con = null;
        ResultSet resultSet = null;

        try {

            int id = student.getStudID();

            StudentDAO studentDAO = new StudentDAO();
            InstructorDAO instructorDAO = new InstructorDAO();
            VehicleDAO vehicleDAO = new VehicleDAO();

            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("select * from appointment where stud_id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            List<Appointment> appointments = new ArrayList();
            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointID(resultSet.getInt("appoint_id"));
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(resultSet.getDate("appoint_date"));
                appointment.setAppointDate(new Date(resultSet.getDate("appoint_date").getTime()));
                appointment.setAppointTimeStart(resultSet.getTime("appoint_timestart"));
                appointment.setAppointTimeEnd(resultSet.getTime("appoint_timeend"));
                appointment.setAppointStatus(resultSet.getString("appoint_status"));
                appointment.setAppointStudent(studentDAO.getStudent(resultSet.getInt("stud_id")));
                appointment.setAppointInstructor(instructorDAO.getInstructor(resultSet.getInt("inst_id")));
                appointment.setAppointVehicle(vehicleDAO.getVehicle(resultSet.getInt("vehi_id")));

                appointments.add(appointment);
            }
            return appointments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Appointment> getAppointments(Instructor instructor) {

        Connection con = null;
        ResultSet resultSet = null;

        try {

            int id = instructor.getInstID();

            StudentDAO studentDAO = new StudentDAO();
            InstructorDAO instructorDAO = new InstructorDAO();
            VehicleDAO vehicleDAO = new VehicleDAO();

            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("select * from appointment where inst_id = ? and appoint_status='UPCOMING'");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            List<Appointment> appointments = new ArrayList();
            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointID(resultSet.getInt("appoint_id"));
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(resultSet.getDate("appoint_date"));
                appointment.setAppointDate(new Date(resultSet.getDate("appoint_date").getTime()));
                appointment.setAppointTimeStart(resultSet.getTime("appoint_timestart"));
                appointment.setAppointTimeEnd(resultSet.getTime("appoint_timeend"));
                appointment.setAppointStatus(resultSet.getString("appoint_status"));
                appointment.setAppointStudent(studentDAO.getStudent(resultSet.getInt("stud_id")));
                appointment.setAppointInstructor(instructorDAO.getInstructor(resultSet.getInt("inst_id")));
                appointment.setAppointVehicle(vehicleDAO.getVehicle(resultSet.getInt("vehi_id")));

                appointments.add(appointment);
            }
            return appointments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Appointment> getAppointments2(Instructor instructor) {

        Connection con = null;
        ResultSet resultSet = null;

        try {

            int id = instructor.getInstID();

            StudentDAO studentDAO = new StudentDAO();
            InstructorDAO instructorDAO = new InstructorDAO();
            VehicleDAO vehicleDAO = new VehicleDAO();

            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("select * from appointment where inst_id = ? and appoint_status='ENROLLED'");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            List<Appointment> appointments = new ArrayList();
            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointID(resultSet.getInt("appoint_id"));
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(resultSet.getDate("appoint_date"));
                appointment.setAppointDate(new Date(resultSet.getDate("appoint_date").getTime()));
                appointment.setAppointTimeStart(resultSet.getTime("appoint_timestart"));
                appointment.setAppointTimeEnd(resultSet.getTime("appoint_timeend"));
                appointment.setAppointStatus(resultSet.getString("appoint_status"));
                appointment.setAppointStudent(studentDAO.getStudent(resultSet.getInt("stud_id")));
                appointment.setAppointInstructor(instructorDAO.getInstructor(resultSet.getInt("inst_id")));
                appointment.setAppointVehicle(vehicleDAO.getVehicle(resultSet.getInt("vehi_id")));

                appointments.add(appointment);
            }
            return appointments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addAppointment(Appointment appointment) {
        Connection con = null;
        ResultSet resultSet = null;

        try {
            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("insert into appointment "
                    + "(appoint_date, appoint_timestart, appoint_timeend, "
                    + "appoint_status, stud_id, inst_id, vehi_id) "
                    + "values (?,?,?,?,?,?,?)");
            statement.setDate(1, new java.sql.Date(appointment.getAppointDate().getTime()));
            statement.setTime(2, appointment.getAppointTimeStart());
            statement.setTime(3, appointment.getAppointTimeEnd());
            statement.setString(4, appointment.getAppointStatus());
            statement.setInt(5, appointment.getAppointStudent().getStudID());
            statement.setInt(6, appointment.getAppointInstructor().getInstID());
            statement.setInt(7, appointment.getAppointVehicle().getVehicleID());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAppointment(Appointment appointment) {
        Connection con = null;

        try {
            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("UPDATE appointment "
                    + "SET appoint_date = ?, "
                    + "appoint_timestart = ?, "
                    + "appoint_timeend = ?, "
                    + "appoint_status = ?, "
                    + "stud_id = ?, "
                    + "inst_id = ?, "
                    + "vehi_id = ? "
                    + "WHERE appoint_id = ?");
            
            LocalDate localDate = appointment.getAppointDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            statement.setDate(1, java.sql.Date.valueOf(localDate));
            statement.setTime(2, appointment.getAppointTimeStart());
            statement.setTime(3, appointment.getAppointTimeEnd());
            statement.setString(4, appointment.getAppointStatus());
            statement.setInt(5, appointment.getAppointStudent().getStudID());
            statement.setInt(6, appointment.getAppointInstructor().getInstID());
            statement.setInt(7, appointment.getAppointVehicle().getVehicleID());
            statement.setInt(8, appointment.getAppointID());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteAppointment(Appointment appointment) {
        Connection con = null;

        try {
            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("Delete from appointment "
                    + "WHERE appoint_id = ?");
            statement.setInt(1, appointment.getAppointID());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int countAppointment() {
        Connection con = null;
        ResultSet resultSet = null;
        int rowCount = 0;

        try {

            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("SELECT COUNT(*) AS row_count FROM appointment");
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
    
    public int countAppointment(Student student) {
        Connection con = null;
        ResultSet resultSet = null;
        int rowCount = 0;

        try {

            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("SELECT COUNT(*) AS row_count FROM appointment where stud_id = ? and appoint_status='ENROLLED'");
            statement.setInt(1, student.getStudID());
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
    
    public int countAppointment(Instructor instructor) {
        Connection con = null;
        ResultSet resultSet = null;
        int rowCount = 0;

        try {

            con = DBConnection.createConnection();
            PreparedStatement statement;
            statement = con.prepareStatement("SELECT COUNT(*) AS row_count FROM appointment where inst_id = ? and appoint_status='Enrolled'");
            statement.setInt(1, instructor.getInstID());
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
    
    public void updateAppointmentDetails(Appointment appointment) {
    Connection con = null;

    try {
        con = DBConnection.createConnection();
        PreparedStatement statement;
        statement = con.prepareStatement("UPDATE appointment "
                + "SET appoint_status = ?, "
                + "stud_id = ?, "
                + "inst_id = ?, "
                + "vehi_id = ? "
                + "WHERE appoint_id = ?");

        statement.setString(1, appointment.getAppointStatus());
        statement.setInt(2, appointment.getAppointStudent().getStudID());
        statement.setInt(3, appointment.getAppointInstructor().getInstID());
        statement.setInt(4, appointment.getAppointVehicle().getVehicleID());
        statement.setInt(5, appointment.getAppointID());

        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
