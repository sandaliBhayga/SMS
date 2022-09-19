<%-- 
    Document   : header
    Created on : 11-Apr-2019, 17:07:42
    Author     : lkfaswuser2
--%>

<%@page import="com.sms.util.UserTypes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="sess_check.jsp" %>
<!DOCTYPE html>
<html>

    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <script type="text/javascript" src="js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>





    <body>


        <%             String permissions = "0";
            if (session != null) {
                if (session.getAttribute(SessionUtils.SES_USER_TYPE) != null) {
                    permissions = (String) session.getAttribute(SessionUtils.SES_USER_TYPE);
                } else {
                }
            }

        %>

        <!--nav bar-->
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="home.jsp">UNIVERSITY INFORMATION SYSTEM</a>
                </div>

                <ul class="nav navbar-nav navbar-right">
                    <%if (permissions.equals(UserTypes.STUDENT)) {%>
                    <li class="active"><a href="calendar.jsp">Calender</a></li>
                    <li><a href="register.jsp">Registrations</a></li>
                    <li><a href="create_event.jsp">Create Event</a></li>
                    <li><a href="view_event.jsp">View Event</a></li>

                    <%}%>

                    <%if (permissions.equals(UserTypes.INDUSTRY)) {%>
                    <li class="active"><a href="calendar.jsp">Calender</a></li>
                    <li><a href="register.jsp">Registrations</a></li>
                    <li><a href="create_event.jsp">Create Event</a></li>
                    <li><a href="view_event.jsp">View Event</a></li>
                    <li><a href="create_research_post.jsp">Research Post</a></li>

                    <%}%>

                    <%if (permissions.equals(UserTypes.UNIVERSITY)) {%>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="calendar.jsp">Calender</a></li>
                        <li><a href="calender_event.jsp">Create Academic Dates </a></li>
                        <li><a href="register.jsp">Registrations</a></li>
                        <li><a href="create_event.jsp">Create Event</a></li>
                        <li><a href="view_event.jsp">View Event</a></li>

                        <%}%>

                        <li><a href="logout.jsp">Log Out</a></li>
                    </ul>

            </div>
        </nav>