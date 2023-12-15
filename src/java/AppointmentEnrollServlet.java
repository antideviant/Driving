/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.AppointmentDAO;
import dao.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AppointmentEnrollServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int appointID = Integer.parseInt(request.getParameter("id"));
        int stud_ID = Integer.parseInt(request.getParameter("stud_id"));
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        Appointment appointment = appointmentDAO.getAppointment(appointID);
        appointment.setAppointStatus("ENROLLED");
        StudentDAO studentDAO = new StudentDAO();
        appointment.setAppointStudent(studentDAO.getStudent(stud_ID));
        appointmentDAO.updateAppointment(appointment);

        HttpSession session = request.getSession();
        if (session.getAttribute("acc_type") != "") {
            if (session.getAttribute("acc_type") == "student") {
                response.sendRedirect(request.getContextPath() + "/student/manage-appointment.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/admin/manage-appointment.jsp");

            }
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");

        }

    }

}