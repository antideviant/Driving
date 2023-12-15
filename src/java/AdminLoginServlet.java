/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;

/**
 *
 * @author PC
 */
public class AdminLoginServlet extends HttpServlet {

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
        
        String admin_email = request.getParameter("admin_email");
        String admin_pass = request.getParameter("admin_pass");
        
        AdminDAO adminDAO = new AdminDAO();
        
        Admin admin = adminDAO.getAdminWithPassword(admin_email, admin_pass);
        if(admin != null){
            HttpSession session = request.getSession();
            session.setAttribute("id", admin.getAdminID());
            session.setAttribute("acc_type","admin");
            response.sendRedirect(request.getContextPath() + "/admin/index.jsp");
//            req.getRequestDispatcher("/student/index.jsp").forward(req, resp);
        }else{
            
            String alertMessage = "Invalid combination of id / password";
            String script = "<script>alert('"+ alertMessage +"');"
                    + "window.location.href = 'http://localhost:8080/Driving/adlogin.jsp';</script>";
            response.getWriter().print(script);
        }
        
    }

}
