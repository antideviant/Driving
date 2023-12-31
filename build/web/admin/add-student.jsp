<%@page import="model.Admin"%>
<%@page import="dao.AdminDAO"%>

<%
    int id = Integer.parseInt(session.getAttribute("id").toString());
    AdminDAO adminDAO = new AdminDAO();
    Admin admin = adminDAO.getAdmin(id);
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
                            <a href="#" class="d-block"><% out.print(admin.getAdminName());%></a>
                        </div>
                    </div>
                    <!-- Sidebar Menu -->
                    <nav class="mt-2">
                        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                            <li class="nav-item animated bounceInLeft">
                                <a href="index.jsp" class="nav-link">
                                    <i class="nav-icon fa fa-tachometer-alt"></i>
                                    <p>
                                        Dashboard
                                    </p>
                                </a>
                            </li>
                            <li class="nav-item animated bounceInLeft">
                                <a href="#" class="nav-link">
                                    <i class="nav-icon fas fa-user"></i>
                                    <p>
                                        Student
                                    </p>
                                    <i class="right fas fa-angle-left"></i>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="add-student.jsp" class="nav-link">
                                            <i class="nav-icon fa fa-plus"></i>
                                            <p>Add</p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="student.jsp" class="nav-link">
                                            <i class="nav-icon fa fa-list"></i>
                                            <p>Manage</p>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item animated bounceInLeft">
                                <a href="#" class="nav-link">
                                    <i class="nav-icon fas fa-user"></i>
                                    <p>
                                        Instructor
                                    </p>
                                    <i class="right fas fa-angle-left"></i>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="add-instructor.jsp" class="nav-link">
                                            <i class="nav-icon fa fa-plus"></i>
                                            <p>Add</p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="manage-instructor.jsp" class="nav-link">
                                            <i class="nav-icon fa fa-list"></i>
                                            <p>Manage</p>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item animated bounceInLeft">
                                <a href="#" class="nav-link">
                                    <i class="nav-icon fas fa-user"></i>
                                    <p>
                                        Vehicle
                                    </p>
                                    <i class="right fas fa-angle-left"></i>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="add-vehicle.jsp" class="nav-link">
                                            <i class="nav-icon fa fa-plus"></i>
                                            <p>Add</p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="manage-vehicle.jsp" class="nav-link">
                                            <i class="nav-icon fa fa-list"></i>
                                            <p>Manage</p>
                                        </a>
                                    </li>
                                </ul>
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
                                <h1 class="m-0"><span class="fa fa-plus"></span> Add Student</h1>
                            </div>
                            <!-- /.col -->
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li class="breadcrumb-item active">Add Student</li>
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
                            <form action="/Driving/StudentRegisterServlet" method="POST">
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
                                                        <input type="text" name="stud_name" class="form-control" placeholder="Please enter full name" required>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>License Type</label>
                                                        <select class="form-control" name="license_type">
                                                            <option>D</option>
                                                            <option>DA</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">IC No</label>
                                                        <input type="text" name="stud_ic" class="form-control" placeholder="Please enter IC Number" required>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Contact</label>
                                                        <input type="text" name="stud_phone" class="form-control" placeholder="Please enter contact number" required>
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Email</label>
                                                        <input type="email" name="stud_email" class="form-control" placeholder="Please enter email address" required>
                                                    </div>
                                                </div>
                                                <div class="col-md-12 mt-2">
                                                    <div class="card-header">
                                                        <span class="fa fa-key"> Account</span>
                                                    </div>
                                                </div>
                                                <!--                                                <div class="col-md-6">
                                                                                                    <div class="form-group">
                                                                                                        <label for="exampleInputEmail1">User ID</label>
                                                                                                        <input type="text" name="stud_id" class="form-control" placeholder="user id" required>
                                                                                                    </div>
                                                                                                </div>-->
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Password</label>
                                                        <input type="password" name="stud_pass" class="form-control" placeholder="**********" required>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="d-grid gap-2">
                                    <button type="submit" class="btn btn-secondary btn-block">Register</button>
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