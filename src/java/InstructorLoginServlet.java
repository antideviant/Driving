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
import javax.servlet.http.HttpSession;
import model.Instructor;

/**
 *
 * @author PC
 */
public class InstructorLoginServlet extends HttpServlet {
/**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String inst_email = request.getParameter("inst_email");
        String inst_pass = request.getParameter("inst_pass");
        
        InstructorDAO instructorDAO = new InstructorDAO();
        
        Instructor instructor = instructorDAO.getInstructorWithEmailandPassword(inst_email, inst_pass);
        if(instructor!=null){
            HttpSession session = request.getSession();
            session.setAttribute("id", instructor.getInstID());
            session.setAttribute("acc_type","instructor");
            response.sendRedirect(request.getContextPath() + "/instructor/index.jsp");
//            req.getRequestDispatcher("/student/index.jsp").forward(req, resp);
        }else{
            
            String alertMessage = "Invalid combination of id / password";
            String script = "<script>alert('"+ alertMessage +"');"
                    + "window.location.href = 'http://localhost:8080/Driving/inslogin.jsp';</script>";
            response.getWriter().print(script);
        }
        
    }

}
