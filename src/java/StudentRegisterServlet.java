/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Student;

/**
 *
 * @author PC
 */
public class StudentRegisterServlet extends HttpServlet {

    public StudentRegisterServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studPass = request.getParameter("stud_pass");
        String studName = request.getParameter("stud_name");
        String studPhone = request.getParameter("stud_phone");
        String studEmail = request.getParameter("stud_email");
        String studIC = request.getParameter("stud_ic");
        String licenseType = request.getParameter("license_type");
        String studPhoto = "/assets/img/avatar.jpg";
        StudentDAO studentDAO = new StudentDAO();
        Student student = new Student(studName, studPhone, studPass, studEmail, studIC, studPhoto, licenseType);
        studentDAO.registerStudent(student);
        HttpSession session = request.getSession();
        if (session.getAttribute("acc_type") == "admin") {//registration by admin
            response.sendRedirect(request.getContextPath() + "/admin/student.jsp");
        } else {//user registration
            student = studentDAO.getStudentWithEmailandPassword(student.getStudEmail(), student.getStudPass());
            session.setAttribute("id", student.getStudID());
            session.setAttribute("acc_type", "student");
            response.sendRedirect(request.getContextPath() + "/student/index.jsp");
        }

    }

}
