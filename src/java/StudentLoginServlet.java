
import dao.StudentDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Student;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class StudentLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String stud_email = req.getParameter("stud_email");
        String stud_pass = req.getParameter("stud_pass");
        
        StudentDAO studentDAO = new StudentDAO();
        
        Student student = studentDAO.getStudentWithEmailandPassword(stud_email, stud_pass);
        if(student != null){
            HttpSession session = req.getSession();
            session.setAttribute("id", student.getStudID());
            session.setAttribute("acc_type","student");
            resp.sendRedirect(req.getContextPath() + "/student/index.jsp");
//            req.getRequestDispatcher("/student/index.jsp").forward(req, resp);
        }else{
            
            String alertMessage = "Invalid combination of email / password";
            String script = "<script>alert('"+ alertMessage +"');"
                    + "window.location.href = 'http://localhost:8080/Driving/login.jsp';</script>";
            resp.getWriter().print(script);
        }
    }   
}
