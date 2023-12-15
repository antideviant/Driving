<%@page import="model.Student"%>
<%@page import="dao.StudentDAO"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
    int id = Integer.parseInt(session.getAttribute("id").toString());
    StudentDAO studentDAO = new StudentDAO();
    Student student = studentDAO.getStudent(id);
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
                                <h1 class="m-0"><span class="fa fa-plus"></span> Edit Student</h1>
                            </div>
                            <!-- /.col -->
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                                    <li class="breadcrumb-item active">Edit Student</li>
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
                                <h3 class="card-title">Profile Information</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form action="/Driving/StudentUpdateServlet" method="POST">
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
                                                        <label for="exampleInputEmail1">Full Name</label>
                                                        <input type="text" name="stud_name" value="<% out.print(student.getStudName()); %>" class="form-control" placeholder="full name" required>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">License Type</label>
                                                        <input type="text" name="license_type" value="<% out.print(student.getLicenseType()); %>" class="form-control" placeholder="License Type" readonly>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">    
                                                        <label for="exampleInputEmail1">IC No</label>
                                                        <input type="text" name="stud_ic" value="<% out.print(student.getStudIC()); %>" class="form-control" placeholder="IC no" readonly>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Contact</label>
                                                        <input type="text" name="stud_phone" value ="<% out.print(student.getStudPhone()); %> " class="form-control" placeholder="contact" required>
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Email</label>
                                                        <input type="email" name="stud_email" value ="<% out.print(student.getStudEmail()); %>" class="form-control" placeholder="email" readonly>
                                                    </div>
                                                </div>
                                                <div class="col-md-12 mt-2">
                                                    <div class="card-header">
                                                        <span class="fa fa-key"> Account</span>
                                                    </div>
                                                </div>
                                                <input type="hidden" name="stud_id" value="<% out.print(student.getStudID()); %>" class="form-control" placeholder="user id" readonly>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Password</label>
                                                        <input type="password" name="stud_pass" value="<% out.print(student.getStudPass());%>" class="form-control" placeholder="**********" required>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="d-grid gap-2">
                                    <button type="submit" class="btn btn-secondary btn-block">Update</button>
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