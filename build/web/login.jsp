<%-- 
    Document   : login
    Created on : 14-Apr-2019, 07:52:19
    Author     : lkfaswuser2
--%>


<%@include file="header.jsp" %>

<script type="text/javascript" src="js/login.js" />


<div class="row">
    <div class="col-md-6" >
        <img src="images/students.jpg" class="img-rounded" style="width: 800px;height: 500px" alt="Student Management System">
    </div>
    <div class="col-md-3">

        <form action="LoginServelet" method="POST">
            <div class="form-group">
                <label for="uname">Email:</label>
                <input type="text" class="form-control" id="uname" placeholder="Email" name="uname" required>
            </div>

            <div class="form-group">
                <label for="uname">Password:</label>
                <input type="text" class="form-control" id="uname" placeholder="Password" name="uname" required>
            </div>




            <button type="button" id="btnLogin" class="btn btn-primary">Login</button>

        </form>        

    </div>
    <div class="col-md-3"></div>
asdsaaaa
</div>

<%@include file="footer.jsp" %>