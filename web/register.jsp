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
        <div class="container bg-light rounded border border-light border-5 shadow">
            <div class="row">
                <h3 class="bg-primary">Profile</h3>
            </div>
            <form action="/Driving/StudentRegisterServlet" method="POST">
                <div class="card-body">
                   <div class="row">
                      <div class="col-md-3 border-end">
                         <div class="form-group d-flex flex-column">
                            <img class="mb-3" src="asset/img/avatar.jpg" width="150" style="border-radius: 5px">
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
                                  <input type="text" name="stud_name" class="form-control" placeholder="Plese enter your name" required>
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
                                  <label for="exampleInputEmail1">IC No:</label>
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
                                  <input type="email" name="stud_email" class="form-control" placeholder="Please enter e-mail" required>
                               </div>
                            </div>
                            <div class="col-md-12 mt-2">
                               <div class="card-header">
                                  <span class="fa fa-key"> Account</span>
                               </div>
                            </div>
<!--                             <div class="col-md-6">
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
     </div>
      <!-- /.login-box -->
   </body>
</html>