<%@page import="model.Admin"%>
<%@page import="dao.AdminDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Instructor"%>
<%@page import="dao.InstructorDAO"%>
<%
    InstructorDAO instructorDAO = new InstructorDAO();
    List<Instructor> instructors = instructorDAO.getInstructors();

    int id = Integer.parseInt(session.getAttribute("id").toString()) ;
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
        <!-- DataTables -->
        <link rel="stylesheet" href="../asset/tables/datatables-bs4/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="../asset/tables/datatables-responsive/css/responsive.bootstrap4.min.css">
        <link rel="stylesheet" href="../asset/tables/datatables-buttons/css/buttons.bootstrap4.min.css">
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
                     <a href="#" class="d-block"><% out.print(admin.getAdminName()); %></a>
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
                                <h1 class="m-0"><span class="fa fa-user"></span> Instructors List</h1>
                            </div>
                            <!-- /.col -->
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li class="breadcrumb-item active">Instructors</li>
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
                        <div class="card-body animated pulse">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th>Profile</th>
                                        <th>Instructor Info</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                               for (Instructor instructor : instructors) {%>
                                    <tr>
                                        <td><img src="../asset/img/profile.png" width="100" alt="User Image"></td>
                                        <td>
                                            <p class="info">Name: <b><% out.print(instructor.getInstName()); %></b></p>
                                            <p class="info"><small>Contact #: <b><% out.print(instructor.getInstPhone()); %></b></small></p>
                                            <p class="info"><small>Email: <b><% out.print(instructor.getInstEmail()); %></b></small></p>
                                        </td>
                                        <td class="text-right">
                                            <a class="btn btn-sm btn-success" href="edit-instructor.jsp?id=<% out.print(instructor.getInstID()); %>"><i
                                                    class="fa fa-pen"></i></a>
                                            <a class="btn btn-sm btn-danger" href="../DeleteInstructorServlet?id=<% out.print(instructor.getInstID()); %>" 
                                               data-target="#delete"><i
                                                    class="fa fa-trash"></i></a>
                                        </td>
                                    </tr>

                                    <%
                                        }
                                    %>
                                    </tfoot>
                            </table>
                        </div>
                    </div>
                    <!-- /.container-fluid -->
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
        </div>
        <!-- ./wrapper -->
        <div id="delete" class="modal animated rubberBand delete-modal" role="dialog">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-body text-center">
                        <img src="../asset/img/sent.png" alt="" width="50" height="46">
                        <h3>Are you sure want to delete this Instructor?</h3>
                        <div class="m-t-20"> <a href="#" class="btn btn-white" data-dismiss="modal">Close</a>
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- jQuery -->
        <script src="../asset/jquery/jquery.min.js"></script>
        <script src="../asset/js/bootstrap.bundle.min.js"></script>
        <script src="../asset/js/adminlte.js"></script>
        <!-- DataTables  & Plugins -->
        <script src="../asset/tables/datatables/jquery.dataTables.min.js"></script>
        <script src="../asset/tables/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
        <script src="../asset/tables/datatables-responsive/js/responsive.bootstrap4.min.js"></script>s
        <script src="../asset/tables/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
        <script>
            $(function () {
                $("#example1").DataTable();
            });
        </script>
    </body>
</html>