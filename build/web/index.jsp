<%-- 
    Document   : login
    Created on : 14-Apr-2019, 07:52:19
    Author     : lkfaswuser2
--%>




<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script >
    $(document).ready(function () {
        $("#btnLogin").click(function () {
            login();
        });
    });


    function login() {

        var user = $('#email').val();
        var pass = $('#password').val();
        $.get('AuthServlet', {
            userName: user,
            password: pass,
        }, function (res) {
            if (res == "") {
                alert("error");
            } else {
                window.location = "home.jsp";
            }
        });

    }

</script>


<style>
    .container {
        /* The image used */
        background-image: url('images/students.jpg');

        /* Full height */
        height: 100%; 

        /* Center and scale the image nicely */
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>

<div class="container">
    <!--<div class="row">-->
    <div class="col-md-6" >
        <!--<img src="images/students.jpg" class="img-rounded" style="width: 800px;height: 500px" alt="Student Management System">-->
    </div>
    <div class="col-md-3"></div>
    <div class="col-md-3" style="padding-top: 300px" >

        <div class="panel panel-default" >
            <div class="panel-heading">User Login</div>
            <div class="panel-body">


                <form action="LoginServelet" method="POST">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" class="form-control" id="email" placeholder="Email" name="uname" required>
                    </div>

                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="text" class="form-control" id="password" placeholder="Password" name="uname" required>
                    </div>




                    <button type="button" id="btnLogin" class="btn btn-primary">Login</button>

                </form>  

            </div>
        </div>

    </div>


    <!--</div>-->
</div>
