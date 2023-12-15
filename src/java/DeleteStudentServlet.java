/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.InstructorDAO;
import dao.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class DeleteStudentServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int studID = Integer.parseInt(request.getParameter("id"));
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.deleteStudent(studentDAO.getStudent(studID));
        
        response.sendRedirect(request.getContextPath() + "/admin/student.jsp");
        
    }
}
