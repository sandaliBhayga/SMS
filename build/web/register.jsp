<%-- 
    Document   : register
    Created on : 12-Apr-2019, 14:58:12
    Author     : lkfaswuser2
    page       : register
--%>


<%@page import="com.sms.util.UserTypes"%>
<%@include file="header.jsp" %>

<script type="text/javascript" src="js/uregister.js" >

</script>



<div class="d-flex justify-content-center">

    <%
        String uttype = "0";
        if (session != null) {
            if (session.getAttribute(SessionUtils.SES_USER_TYPE) != null) {
                uttype = (String) session.getAttribute(SessionUtils.SES_USER_TYPE);
            } else {
            }
        }

    %>

    <div class="row" >
        <div class="col-md-1" ></div>
        <div class="col-md-5" >
            <div class="panel panel-default" >
                <div class="panel-heading">Register</div>
                <div class="panel-body">

                    <input type="hidden" value="0" name="hid" id="hid" />
                    <input type="hidden" value="<%=uttype%>" name="utp" id="uttypee" />

                    <div class="panel-body">

                        <label><input type="radio"  name="user_type" value="<%=UserTypes.STUDENT%>">Student</label>
                        <label><input type="radio"  name="user_type" value="<%=UserTypes.UNIVERSITY%>">University</label>
                        <label><input type="radio"  name="user_type" value="<%=UserTypes.INDUSTRY%>">Industry</label>
                    </div>

                    <div class="form-group">
                        <label for="uname">Name :</label>
                        <input type="text" class="form-control" id="name" placeholder="Name" name="name" >
                    </div>

                    <div class="form-group">
                        <label for="uname">Email:</label>
                        <input type="text" class="form-control" id="email" placeholder="Email" name="email" >
                    </div>

                    <div class="form-group">
                        <label for="uname">Password:</label>
                        <input type="text" class="form-control" id="password" placeholder="Password" name="password" >
                    </div>

                    <div class="form-group">
                        <label for="uname">Confirm Password:</label>
                        <input type="text" class="form-control" id="con_password" placeholder="Confirm Password" name="con_password" >
                    </div>


                    <button type="button" id="btnSave" onClick="doSave()" class="btn btn-primary">Register</button>

                </div>
            </div> 
        </div> 

        <div class="col-md-6" id="tbl" >

        </div>
    </div> 

</div> 

<%@include file="footer.jsp" %>

