<%-- 
    Document   : logout
    Created on : 17-Apr-2019, 22:45:51
    Author     : lkfaswuser2
--%>

<%@page import="com.sms.util.SessionUtils"%>
<%
    
    session.invalidate();
//   session.getAttribute(SessionUtils.SES_USER_TYPE)
        response.sendRedirect("index.jsp");
   
%>