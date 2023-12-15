package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Appointment;
import dao.AppointmentDAO;
import model.Vehicle;
import java.util.List;
import model.Instructor;
import dao.InstructorDAO;
import dao.VehicleDAO;
import model.Student;
import dao.StudentDAO;
import model.Admin;
import dao.AdminDAO;

public final class edit_002dappointment_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    
    int appointID = Integer.parseInt(request.getParameter("id"));
    AppointmentDAO appointmentDAO = new AppointmentDAO();
    Appointment appointment = appointmentDAO.getAppointment(appointID);
    
    int id = Integer.parseInt(session.getAttribute("id").toString());
    StudentDAO studentDAO = new StudentDAO();
    InstructorDAO instructerDAO = new InstructorDAO();
    VehicleDAO vehicleDAO = new VehicleDAO();

    List<Student> students = studentDAO.getStudents();
    List<Instructor> instructors = instructerDAO.getInstructors();
    List<Vehicle> vehicles = vehicleDAO.getVehicles();

    AdminDAO adminDAO = new AdminDAO();
    Admin admin = adminDAO.getAdmin(id);

      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Driving-School-Management-System</title>\n");
      out.write("        <!-- Font Awesome -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../asset/fontawesome/css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../asset/css/adminlte.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../asset/css/animate.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../asset/css/style.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"hold-transition sidebar-mini layout-fixed\">\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            <!-- Navbar -->\n");
      out.write("            <nav class=\"main-header navbar navbar-expand navbar-white navbar-light\">\n");
      out.write("                <!-- Right navbar links -->\n");
      out.write("                <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" data-widget=\"fullscreen\" href=\"#\" role=\"button\">\n");
      out.write("                            <i class=\"fas fa-expand-arrows-alt\"></i>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" data-widget=\"fullscreen\" href=\"../LogoutServlet\">\n");
      out.write("                            <i class=\"fas fa-power-off\"></i>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("            <!-- /.navbar -->\n");
      out.write("            <!-- Main Sidebar Container -->\n");
      out.write("            <aside class=\"main-sidebar sidebar-dark-primary elevation-4\" style=\"background-color: rgb(255, 255, 255);\">\n");
      out.write("                <!-- Brand Logo -->\n");
      out.write("                <a href=\"index.jsp\" class=\"brand-link animated swing\">\n");
      out.write("                    <img src=\"../asset/img/unisexlogo.png\" alt=\"DSMS Logo\" width=\"200\" style=\"padding-top: 25%;\">\n");
      out.write("                </a>\n");
      out.write("                <!-- Sidebar -->\n");
      out.write("                <div class=\"sidebar\">\n");
      out.write("                    <!-- Sidebar user panel (optional) -->\n");
      out.write("                    <div class=\"user-panel mt-3 pb-3 mb-3 d-flex\">\n");
      out.write("                        <div class=\"image\">\n");
      out.write("                            <img src=\"../asset/img/avatar.jpg\" class=\"img-circle elevation-2\" alt=\"User Image\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"info\">\n");
      out.write("                            <a href=\"#\" class=\"d-block\">");
 out.print(admin.getAdminName()); 
      out.write("</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Sidebar Menu -->\n");
      out.write("                    <nav class=\"mt-2\">\n");
      out.write("                        <ul class=\"nav nav-pills nav-sidebar flex-column\" data-widget=\"treeview\" role=\"menu\" data-accordion=\"false\">\n");
      out.write("                            <li class=\"nav-item animated bounceInLeft\">\n");
      out.write("                                <a href=\"index.jsp\" class=\"nav-link\">\n");
      out.write("                                    <i class=\"nav-icon fa fa-tachometer-alt\"></i>\n");
      out.write("                                    <p>\n");
      out.write("                                        Dashboard\n");
      out.write("                                    </p>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item animated bounceInLeft\">\n");
      out.write("                                <a href=\"#\" class=\"nav-link\">\n");
      out.write("                                    <i class=\"nav-icon fas fa-user\"></i>\n");
      out.write("                                    <p>\n");
      out.write("                                        Student\n");
      out.write("                                    </p>\n");
      out.write("                                    <i class=\"right fas fa-angle-left\"></i>\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"nav nav-treeview\">\n");
      out.write("                                    <li class=\"nav-item\">\n");
      out.write("                                        <a href=\"add-student.jsp\" class=\"nav-link\">\n");
      out.write("                                            <i class=\"nav-icon fa fa-plus\"></i>\n");
      out.write("                                            <p>Add</p>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"nav-item\">\n");
      out.write("                                        <a href=\"student.jsp\" class=\"nav-link\">\n");
      out.write("                                            <i class=\"nav-icon fa fa-list\"></i>\n");
      out.write("                                            <p>Manage</p>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item animated bounceInLeft\">\n");
      out.write("                                <a href=\"#\" class=\"nav-link\">\n");
      out.write("                                    <i class=\"nav-icon fas fa-user\"></i>\n");
      out.write("                                    <p>\n");
      out.write("                                        Instructor\n");
      out.write("                                    </p>\n");
      out.write("                                    <i class=\"right fas fa-angle-left\"></i>\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"nav nav-treeview\">\n");
      out.write("                                    <li class=\"nav-item\">\n");
      out.write("                                        <a href=\"add-instructor.jsp\" class=\"nav-link\">\n");
      out.write("                                            <i class=\"nav-icon fa fa-plus\"></i>\n");
      out.write("                                            <p>Add</p>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"nav-item\">\n");
      out.write("                                        <a href=\"manage-instructor.jsp\" class=\"nav-link\">\n");
      out.write("                                            <i class=\"nav-icon fa fa-list\"></i>\n");
      out.write("                                            <p>Manage</p>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item animated bounceInLeft\">\n");
      out.write("                                <a href=\"#\" class=\"nav-link\">\n");
      out.write("                                    <i class=\"nav-icon fas fa-user\"></i>\n");
      out.write("                                    <p>\n");
      out.write("                                        Vehicle\n");
      out.write("                                    </p>\n");
      out.write("                                    <i class=\"right fas fa-angle-left\"></i>\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"nav nav-treeview\">\n");
      out.write("                                    <li class=\"nav-item\">\n");
      out.write("                                        <a href=\"add-vehicle.jsp\" class=\"nav-link\">\n");
      out.write("                                            <i class=\"nav-icon fa fa-plus\"></i>\n");
      out.write("                                            <p>Add</p>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"nav-item\">\n");
      out.write("                                        <a href=\"manage-vehicle.jsp\" class=\"nav-link\">\n");
      out.write("                                            <i class=\"nav-icon fa fa-list\"></i>\n");
      out.write("                                            <p>Manage</p>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item animated bounceInRight\">\n");
      out.write("                                <a href=\"#\" class=\"nav-link\">\n");
      out.write("                                    <i class=\"nav-icon fas fa-book\"></i>\n");
      out.write("                                    <p>\n");
      out.write("                                        Appointment\n");
      out.write("                                    </p>\n");
      out.write("                                    <i class=\"right fas fa-angle-left\"></i>\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"nav nav-treeview\">\n");
      out.write("                                    <li class=\"nav-item\">\n");
      out.write("                                        <a href=\"add-appointment.jsp\" class=\"nav-link\">\n");
      out.write("                                            <i class=\"nav-icon fa fa-plus\"></i>\n");
      out.write("                                            <p>Add</p>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"nav-item\">\n");
      out.write("                                        <a href=\"manage-appointment.jsp\" class=\"nav-link\">\n");
      out.write("                                            <i class=\"nav-icon fa fa-list\"></i>\n");
      out.write("                                            <p>Manage</p>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("                    <!-- /.sidebar-menu -->\n");
      out.write("                </div>\n");
      out.write("                <!-- /.sidebar -->\n");
      out.write("            </aside>\n");
      out.write("            <!-- Content Wrapper. Contains page content -->\n");
      out.write("            <div class=\"content-wrapper\">\n");
      out.write("                <!-- Content Header (Page header) -->\n");
      out.write("                <div class=\"content-header\">\n");
      out.write("                    <div class=\"container-fluid\">\n");
      out.write("                        <div class=\"row mb-2\">\n");
      out.write("                            <div class=\"col-sm-6 animated bounceInRight\">\n");
      out.write("                                <h1 class=\"m-0\"><span class=\"fa fa-plus\"></span> Add Appointment</h1>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.col -->\n");
      out.write("                            <div class=\"col-sm-6\">\n");
      out.write("                                <ol class=\"breadcrumb float-sm-right\">\n");
      out.write("                                    <li class=\"breadcrumb-item\"><a href=\"#\">Home</a></li>\n");
      out.write("                                    <li class=\"breadcrumb-item active\">Edit Appointment</li>\n");
      out.write("                                </ol>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.col -->\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.row -->\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.container-fluid -->\n");
      out.write("                </div>\n");
      out.write("                <!-- /.content-header -->\n");
      out.write("                <!-- Main content -->\n");
      out.write("                <section class=\"content\">\n");
      out.write("                    <div class=\"container-fluid\">\n");
      out.write("                        <div class=\"card card-info\">\n");
      out.write("                            <div class=\"card-header\">\n");
      out.write("                                <h3 class=\"card-title\">Appointment Detail</h3>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.card-header -->\n");
      out.write("                            <!-- form start -->\n");
      out.write("                            <form action=\"/Driving/AppointmentUpdateServlet\" method=\"POST\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-md-3 border-end\">\n");
      out.write("                                            <div class=\"form-group d-flex flex-column\">\n");
      out.write("                                                <img class=\"mb-3\" src=\"../asset/img/avatar.jpg\" width=\"150\" style=\"border-radius: 5px\">\n");
      out.write("                                                <div class=\"input-group\">\n");
      out.write("                                                    <div class=\"custom-file\">\n");
      out.write("                                                        <!--<input type=\"file\" name=\"stud_photo\" class=\"custom-file-input\" id=\"exampleInputFile\">-->\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-9\">\n");
      out.write("                                            <div class=\"card-header\">\n");
      out.write("                                                <span class=\"fa fa-user\"> Profile Information</span>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("                                                <div class=\"col-md-4\">\n");
      out.write("                                                    <div class=\"form-group\">\n");
      out.write("                                                        <label>Student</label>\n");
      out.write("                                                        <select class=\"form-control\" name=\"stud_id\">\n");
      out.write("                                                            ");
 for (Student student : students) {
                                                            
      out.write("\n");
      out.write("                                                            <option ");
 if(student.getStudID()==appointment.getAppointStudent().getStudID()){out.print("selected"); } 
      out.write('>');
      out.write(' ');
 out.print(student.getStudID()); 
      out.write(" </option>\n");
      out.write("                                                            ");

                                                                } 
      out.write("\n");
      out.write("                                                        </select>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"col-md-4\">\n");
      out.write("                                                    <div class=\"form-group\">\n");
      out.write("                                                        <label>Instructor</label>\n");
      out.write("                                                        <select class=\"form-control\" name=\"inst_id\">\n");
      out.write("                                                            ");
 for (Instructor instructor : instructors) {
                                                            
      out.write("\n");
      out.write("                                                            <option ");
 if(instructor.getInstID() == appointment.getAppointInstructor().getInstID()){ out.print("selected"); } 
      out.write(" > ");
 out.print(instructor.getInstID()); 
      out.write(" </option>\n");
      out.write("                                                            ");

                                                                } 
      out.write("\n");
      out.write("                                                        </select>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"col-md-4\">\n");
      out.write("                                                    <div class=\"form-group\">\n");
      out.write("                                                        <label>Vehicle</label>\n");
      out.write("                                                        <select class=\"form-control\" name=\"vehi_id\">\n");
      out.write("                                                            ");
 for (Vehicle vehicle : vehicles) {
                                                            
      out.write("\n");
      out.write("                                                            <option ");
 if(vehicle.getVehicleID() == appointment.getAppointVehicle().getVehicleID()){out.print("selected");} 
      out.write(" > ");
 out.print(vehicle.getVehicleID()); 
      out.write(" </option>\n");
      out.write("                                                            ");

                                                                }
      out.write("\n");
      out.write("                                                        </select>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"col-md-4\">\n");
      out.write("                                                    <div class=\"form-group\">\n");
      out.write("                                                        <label for=\"exampleInputEmail1\">Date</label>\n");
      out.write("                                                        <input type=\"date\" name=\"appoint_date\" class=\"form-control\" placeholder=\"birthday\" required>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"col-md-4\">\n");
      out.write("                                                    <div class=\"form-group\">\n");
      out.write("                                                        <label for=\"exampleInputEmail1\">Start Time</label>\n");
      out.write("                                                        <input type=\"time\" name=\"appoint_timestart\" value =\"\" class=\"form-control\" placeholder=\"contact\" required>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"col-md-4\">\n");
      out.write("                                                    <div class=\"form-group\">\n");
      out.write("                                                        <label for=\"exampleInputEmail1\">End Time</label>\n");
      out.write("                                                        <input type=\"time\" name=\"appoint_timeend\" value =\"\" class=\"form-control\" placeholder=\"email\" required>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"col-md-4\">\n");
      out.write("                                                    <div class=\"form-group\">\n");
      out.write("                                                        <label>License Type</label>\n");
      out.write("                                                        <select class=\"form-control\" name=\"appoint_status\">\n");
      out.write("                                                            <option value=\"UPCOMING\">UPCOMING</option>\n");
      out.write("                                                            <option value=\"ENROLLED\">ENROLLED</option>\n");
      out.write("                                                            <option value=\"RESCHEDULE\">RESCHEDULE</option>\n");
      out.write("                                                            <option value=\"CANCELED\">CANCELED</option>\n");
      out.write("                                                        </select>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- /.card-body -->\n");
      out.write("                                <div class=\"d-grid gap-2\">\n");
      out.write("                                    <button type=\"submit\" class=\"btn btn-secondary btn-block\">Submit</button>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.container-fluid -->\n");
      out.write("                </section>\n");
      out.write("                <!-- /.content -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.content-wrapper -->\n");
      out.write("        </div>\n");
      out.write("        <!-- ./wrapper -->\n");
      out.write("        <!-- jQuery -->\n");
      out.write("        <script src=\"../asset/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"../asset/js/adminlte.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
