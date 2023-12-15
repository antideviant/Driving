/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.AppointmentDAO;
import dao.InstructorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
public class AppointmentDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int appointID = Integer.parseInt(request.getParameter("id"));
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        appointmentDAO.deleteAppointment(appointmentDAO.getAppointment(appointID));

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
