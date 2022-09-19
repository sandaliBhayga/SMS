<%-- 
    Document   : calendar
    Created on : 14-Apr-2019, 06:41:28
    Author     : lkfaswuser2
--%>



<link href='packages/core/main.css' rel='stylesheet' />
<link href='packages/daygrid/main.css' rel='stylesheet' />
<link href='packages/timegrid/main.css' rel='stylesheet' />
<link href='packages/list/main.css' rel='stylesheet' />
<script src='packages/core/main.js'></script>
<script src='packages/interaction/main.js'></script>
<script src='packages/daygrid/main.js'></script>
<script src='packages/timegrid/main.js'></script>
<script src='packages/list/main.js'></script>
<%@include file="header.jsp" %>


<script type="text/javascript" src="js/ccalender.js" ></script>
<style>

    body {
        margin: 0px 10px;
        padding: 0;
        font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
        font-size: 14px;
    }

    #calendar {
        max-width: 900px;
        margin: 0 auto;
    }

</style>

<div class="panel panel-success" >
    <div class="panel-heading center-block"><div class='panel-heading text-center'><b>Academic Calender</b></div></div>
    <div class="panel-body">
        <div id='calendar'></div>

    </div>
</div>


