<%@page import="model.Vehicle"%>
<%@page import="java.util.List"%>
<%@page import="model.Instructor"%>
<%@page import="dao.InstructorDAO"%>
<%@page import="dao.VehicleDAO"%>
<%@page import="model.Student"%>
<%@page import="dao.StudentDAO"%>
<%
    int id = Integer.parseInt(session.getAttribute("id").toString());
    StudentDAO studentDAO = new StudentDAO();
    InstructorDAO instructerDAO = new InstructorDAO();
    VehicleDAO vehicleDAO = new VehicleDAO();
    
    Student student = studentDAO.getStudent(id);
    List<Student> students = studentDAO.getStudents();
    List<Instructor> instructors = instructerDAO.getInstructors();
    List<Vehicle> vehicles = vehicleDAO.getVehicles();
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Driving-School-Management-System</title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="../asset/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="../asset/css/adminlte.min.css">
        <link rel="stylesheet" href="../asset/css/animate.min.css">
        <link rel="stylesheet" href="../asset/css/style.css">

    </head>
    <body class="hold-transition sidebar-mini layout-fixed">
        <div class="wrapper">
            <!-- Navbar -->
            <nav class="main-header navbar navbar-expand navbar-white navbar-light">
                <!-- Right navbar links -->
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                            <i class="fas fa-expand-arrows-alt"></i>
                        </a>
                    </li>
                    <li class="nav-item">
                  <a class="nav-link" data-widget="fullscreen" href="../LogoutServlet">
                            <i class="fas fa-power-off"></i>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- /.navbar -->
            <!-- Main Sidebar Container -->
            <aside class="main-sidebar sidebar-dark-primary elevation-4" style="background-color: rgb(255, 255, 255);">
                <!-- Brand Logo -->
                <a href="index.jsp" class="brand-link animated swing">
                    <img src="../asset/img/unisexlogo.png" alt="DSMS Logo" width="200" style="padding-top: 25%;">
                </a>
                <!-- Sidebar -->
                <div class="sidebar">
               <!-- Sidebar user panel (optional) -->
               <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                  <div class="image">
                     <img src="../asset/img/avatar.jpg" class="img-circle elevation-2" alt="User Image">
                  </div>
                  <div class="info">
                     <a href="profile.jsp" class="d-block"><% out.print(student.getStudName()); %></a>
                  </div>
               </div>
               <!-- Sidebar Menu -->
               <nav class="mt-2">
                  <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                     <li class="nav-item">
                        <a href="index.jsp" class="nav-link">
                           <i class="nav-icon fa fa-tachometer-alt"></i>
                           <p>
                              Dashboard
                           </p>
                        </a>
                     </li>
                     <li class="nav-item">
                        <a href="profile.jsp" class="nav-link">
                           <i class="nav-icon fa fa-user"></i>
                           <p>
                              My Profile
                           </p>
                        </a>
                     </li>
                     <li class="nav-item animated bounceInRight">
                        <a href="#" class="nav-link">
                           <i class="nav-icon fas fa-book"></i>
                           <p>
                              Appointment
                           </p>
                           <i class="right fas fa-angle-left"></i>
                        </a>
                        <ul class="nav nav-treeview">
                           <li class="nav-item">
                              <a href="add-appointment.jsp" class="nav-link">
                                 <i class="nav-icon fa fa-plus"></i>
                                 <p>Add</p>
                              </a>
                           </li>
                           <li class="nav-item">
                              <a href="manage-appointment.jsp" class="nav-link">
                                 <i class="nav-icon fa fa-list"></i>
                                 <p>Manage</p>
                              </a>
                           </li>
                        </ul>
                     </li>
                  </ul>
                  </li>
                  </ul>
               </nav>
               <!-- /.sidebar-menu -->
            </div>
                <!-- /.sidebar -->
            </aside>
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <div class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6 animated bounceInRight">
                                <h1 class="m-0"><span class="fa fa-plus"></span> Add Appointment</h1>
                            </div>
                            <!-- /.col -->
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li class="breadcrumb-item active">Add Appointment</li>
                                </ol>
                            </div>
                            <!-- /.col -->
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.container-fluid -->
                </div>
                <!-- /.content-header -->
                <!-- Main content -->
                <section class="content">
                    <div class="container-fluid">
                        <div class="card card-info">
                            <div class="card-header">
                                <h3 class="card-title">Appointment Detail</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form action="/Driving/AppointmentAddServlet" method="POST">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-3 border-end">
                                            <div class="form-group d-flex flex-column">
                                                <img class="mb-3" src="../asset/img/avatar.jpg" width="150" style="border-radius: 5px">
                                                <div class="input-group">
                                                    <div class="custom-file">
                                                        <!--<input type="file" name="stud_photo" class="custom-file-input" id="exampleInputFile">-->
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-9">
                                            <div class="card-header">
                                                <span class="fa fa-user"> Profile Information</span>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Student</label>
                                                        <select class="form-control" name="stud_id">
                                                            <option value="<% out.print(student.getStudID()); %>"> <% out.print(student.getStudName()); %> </option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Instructor</label>
                                                        <select class="form-control" name="inst_id">
                                                            <% for (Instructor instructor : instructors) {
                                                            %>
                                                            <option value="<% out.print(instructor.getInstID()); %>"> <% out.print(instructor.getInstName()); %> </option>
                                                            <%
                                                                } %>
                                                        </select>
                                                    </div>
                                                </div>
                                                        <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Vehicle</label>
                                                        <select class="form-control" name="vehi_id">
                                                            <% for (Vehicle vehicle : vehicles) {
                                                            %>
                                                            <option value="<% out.print(vehicle.getVehicleID()); %>"> <% out.print(vehicle.getVehiclePlatNo()); %> </option>
                                                            <%
                                                                }%>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Date</label>
                                                        <input type="date" name="appoint_date" class="form-control" placeholder="birthday" required>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Start Time</label>
                                                        <input type="time" name="appoint_timestart" value ="" class="form-control" placeholder="contact" required>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">End Time</label>
                                                        <input type="time" name="appoint_timeend" value ="" class="form-control" placeholder="email" required>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="d-grid gap-2">
                                    <button type="submit" class="btn btn-secondary btn-block">Submit</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- /.container-fluid -->
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
        </div>
        <!-- ./wrapper -->
        <!-- jQuery -->
        <script src="../asset/jquery/jquery.min.js"></script>
        <script src="../asset/js/adminlte.js"></script>

    </body>
</html>