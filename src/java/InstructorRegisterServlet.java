/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.InstructorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Instructor;

/**
 *
 * @author PC
 */
public class InstructorRegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String instPass = request.getParameter("inst_pass");
        String instPhone = request.getParameter("inst_phone");
        String instName = request.getParameter("inst_name");
        String instEmail = request.getParameter("inst_email");
        String instPhoto = "/assets/img/avatar.jpg";
        
        InstructorDAO instructorDAO = new InstructorDAO();
        Instructor instructor = new Instructor();
        instructor.setInstPassword(instPass);
        instructor.setInstName(instName);
        instructor.setInstPhone(instPhone);
        instructor.setInstPhoto(instPhoto);
        instructor.setInstEmail(instEmail);
        instructorDAO.addInstructor(instructor);
            
        response.sendRedirect(request.getContextPath() + "/admin/manage-instructor.jsp");

    }

}
