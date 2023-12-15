/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.AppointmentDAO;
import dao.InstructorDAO;
import dao.StudentDAO;
import dao.VehicleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Appointment;

/**
 *
 * @author PC
 */
public class AppointmentUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

            StudentDAO studentDAO = new StudentDAO();
            InstructorDAO instructorDAO = new InstructorDAO();
            VehicleDAO vehicleDAO = new VehicleDAO();
            AppointmentDAO appointmentDAO = new AppointmentDAO();

            int appointID = Integer.parseInt(request.getParameter("appoint_ID"));
            java.util.Date utilDate = dateFormat.parse(request.getParameter("appoint_date"));
            java.sql.Date appointDate = new java.sql.Date(utilDate.getTime());
            String appointTimeStart = request.getParameter("appoint_timestart");
            String appointTimeEnd = request.getParameter("appoint_timeend");
            String appointStatus = request.getParameter("appoint_status");

            int studID = Integer.parseInt(request.getParameter("stud_id"));
            int instID = Integer.parseInt(request.getParameter("inst_id"));
            int vehiID = Integer.parseInt(request.getParameter("vehi_id"));

            Appointment appointment = new Appointment();
            appointment.setAppointID(appointID);
            appointment.setAppointDate(appointDate);
            appointment.setAppointTimeStart(new Time(timeFormat.parse(appointTimeStart).getTime()));
            appointment.setAppointTimeEnd(new Time(timeFormat.parse(appointTimeEnd).getTime()));
            appointment.setAppointStatus(appointStatus);
            appointment.setAppointStudent(studentDAO.getStudent(studID));
            appointment.setAppointInstructor(instructorDAO.getInstructor(instID));
            appointment.setAppointVehicle(vehicleDAO.getVehicle(vehiID));

            boolean flag = appointmentDAO.checkExistingAppointment(appointment.getAppointStudent(),
                    appointment.getAppointInstructor(),
                    appointment.getAppointVehicle(),
                    appointment.getAppointTimeStart(),
                    appointment.getAppointTimeEnd(),
                    appointment.getAppointDate());

            if (flag) {
                // Appointment time slot already exists
                // You can handle the error scenario here

                // Update all details except date and time
                appointmentDAO.updateAppointmentDetails(appointment);
    
                String alertMessage = "Appointment time slot already exist but other details are updated";
                String script = "<script>alert('" + alertMessage + "');"
                        + "window.location.href = 'http://localhost:8080/Driving/admin/manage-appointment.jsp';</script>";
                response.getWriter().print(script);

            } else {
                appointmentDAO.updateAppointment(appointment);

                //Redirects
                HttpSession session = request.getSession();
                if (session.getAttribute("acc_type") != "") {
                    if (session.getAttribute("acc_type") == "student") {
                        response.sendRedirect(request.getContextPath() + "/student/manage-appointment.jsp");
                        return;
                    } else {
                        response.sendRedirect(request.getContextPath() + "/admin/manage-appointment.jsp");
                        return;
                    }
                } else {
                    //send to index and do nothing
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                    return;
                }
            }

        } catch (ParseException ex) {
            Logger.getLogger(AppointmentAddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
