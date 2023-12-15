<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Driving-School-Management-System</title>
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
    <!-- Font Awesome -->
    <link rel="stylesheet" href="asset/fontawesome/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="asset/bootstrap/bootstrap-5.0.2-dist/css/bootstrap.css">
    <!-- <link rel="stylesheet" href="asset/css/adminlte.min.css"> -->
</head>
   <body class="bg-primary">
      <nav class="navbar navbar-expand-sm navbar-light bg-light shadow">
         <div class="container-fluid d-flex flex-row justify-content-between mx-5 my-2">
             <a class="navbar-brand d-flex align-items-center" href="index.jsp">
                 <img src="asset\img\unisexlogo.png" alt="Brand Logo" style="max-height: 40px;">
             </a>
             <div class="mx-0 d-flex flex-row">
                 <a class="ms-2 btn btn-primary btn-md rounded" href="login.jsp" role="button">Login</a>
             </div>
         </div>
     </nav>
     <div class="container-fluid d-flex flex-row justify-content-center py-5">
      <div class="mx-auto d-inline-block">
         <!-- /.login-logo -->
         <div class="card card-outline card-primary">
            <div class="card-header text-center">
               <a href="index.html" class="brand-link">
               <img src="asset/img/unisexlogo.png" alt="DSMS Logo" width="200">
               </a>
            </div>
            <div class="card-body">
               <br>
               <h3 class="font-weight-bold" style="text-align: left;">
                  Login now to book your appointment today!
               </h3>
               <br>
               <form action="/Driving/StudentLoginServlet" method="post">
                  <div class="input-group mb-3">
                     <input type="text" class="form-control" id="username" name="stud_email" placeholder="Please enter your e-mail" required>
                     <div class="input-group-text">
                        <span class="fas fa-envelope"></span>
                     </div>
                  </div>
                  <div class="input-group mb-3">
                     <input type="password" class="form-control" id="password" name="stud_pass" placeholder="Please enter your password" required>
                     <div class="input-group-text">
                        <span class="fas fa-lock"></span>
                     </div>
                  </div>
                  <div class="row">
                     <div class="col-12">
                        <div class="icheck-primary">
                           <input type="checkbox" id="remember">
                           <label for="remember">
                           Remember Me
                           </label>
                        </div>
                     </div>
                     <div class="d-flex flex-row container-fluid justify-content-center">
                        <div class="me-2 mt-2">
                           <button type="submit" class="btn btn-secondary btn-block">Sign In</button>
                        </div>
                        <div class="me-2 mt-2">
                           <a href="register.jsp" class="text-center btn btn-secondary btn-block">Register Account</a>
                        </div>
                     </div>
                     <br>
                  </div>
                  <br>
                  <h6 class="text-center">Are you an admin? <a href="adlogin.jsp">Log In</a> here!</h6>
                  <h6 class="text-center">Are you an instructor? <a href="inslogin.jsp">Log In</a> here!</h6>
               </form>
            </div>
            <!-- /.card-body -->
         </div>
         <!-- /.card -->
      </div>
     </div>
      <!-- /.login-box -->
   </body>

</html>