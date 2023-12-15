/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.InstructorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Instructor;

/**
 *
 * @author PC
 */
public class InstructorUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int instID = Integer.parseInt(request.getParameter("inst_id"));
        String instPass = request.getParameter("inst_pass");
        String instPhone = request.getParameter("inst_phone");
        String instName = request.getParameter("inst_name");
        String instEmail = request.getParameter("inst_email");
        String instPhoto = "/assets/img/avatar.jpg";

        InstructorDAO instructorDAO = new InstructorDAO();
        Instructor instructor = new Instructor();
        instructor.setInstID(instID);
        instructor.setInstPassword(instPass);
        instructor.setInstName(instName);
        instructor.setInstPhone(instPhone);
        instructor.setInstPhoto(instPhoto);
        instructor.setInstEmail(instEmail);
        instructorDAO.updateInstructor(instructor);

        HttpSession session = request.getSession();
        if ("admin".equals(session.getAttribute("acc_type"))) {//registration by admin
            response.sendRedirect(request.getContextPath() + "/admin/manage-instructor.jsp");
        } else {//user registration
            response.sendRedirect(request.getContextPath() + "/instructor/index.jsp");
        }
    }
}
