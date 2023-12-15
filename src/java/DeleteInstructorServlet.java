/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.InstructorDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class DeleteInstructorServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int instID = Integer.parseInt(request.getParameter("id"));
        InstructorDAO instructorDAO = new InstructorDAO();
        instructorDAO.deleteInstructor(instructorDAO.getInstructor(instID));
        
        response.sendRedirect(request.getContextPath() + "/admin/manage-instructor.jsp");
        
    }


}
