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
public class AppointmentAddServlet extends HttpServlet {

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

            java.util.Date utilDate = dateFormat.parse(request.getParameter("appoint_date"));
            java.sql.Date appointDate = new java.sql.Date(utilDate.getTime());
            String appointTimeStart = request.getParameter("appoint_timestart");
            String appointTimeEnd = request.getParameter("appoint_timeend");
            int studID = Integer.parseInt(request.getParameter("stud_id"));
            int instID = Integer.parseInt(request.getParameter("inst_id"));
            int vehiID = Integer.parseInt(request.getParameter("vehi_id"));

            Appointment appointment = new Appointment();
            appointment.setAppointDate(appointDate);
            appointment.setAppointTimeStart(new Time(timeFormat.parse(appointTimeStart).getTime()));
            appointment.setAppointTimeEnd(new Time(timeFormat.parse(appointTimeEnd).getTime()));
            appointment.setAppointStatus("UPCOMING");
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
                //already exist need Error handling
                String alertMessage = "Appointment time slot already exist";
                String script = "<script>alert('" + alertMessage + "');"
                        + "window.location.href = 'http://localhost:8080/Driving/index.jsp';</script>";
                response.getWriter().print(script);

            } else {
                appointmentDAO.addAppointment(appointment);
                HttpSession session = request.getSession();
                if (session.getAttribute("acc_type") != null && !session.getAttribute("acc_type").toString().isEmpty()) {
                if (session.getAttribute("acc_type").equals("student")) {
                    response.sendRedirect(request.getContextPath() + "/student/manage-appointment.jsp");
                } else {
                    response.sendRedirect(request.getContextPath() + "/admin/manage-appointment.jsp");
                }
                } else {
                    //send to index and do nothing
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                }
            }

        } catch (ParseException ex) {
            Logger.getLogger(AppointmentAddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
