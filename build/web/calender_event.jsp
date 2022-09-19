<%-- 
    Document   : calender_event
    Created on : 21-Apr-2019, 02:06:59
    Author     : lkfaswuser2
--%>



<%@page import="com.sms.util.UserTypes"%>
<%@include file="header.jsp" %>

<script type="text/javascript" src="js/create_events.js" >

</script>



<div class="d-flex justify-content-center">



    <div class="row" >
        <div class="col-md-1" ></div>
        <div class="col-md-5" >
            <div class="panel panel-default" >
                <div class="panel-heading">Create Calender Event</div>
                <div class="panel-body">

                    <input type="hidden" value="0" name="hid" id="hid" />


                    <div class="form-group">
                        <label for="uname">Title :</label>
                        <input type="text" class="form-control" id="title" placeholder="Title" name="title" required>
                    </div>

                    <div class="form-group">
                        <label for="dtp_input1" class=" control-label">Start Time :</label>
                        <div class="input-group date form_datetime " data-date="1979-09-16T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                            <input class="form-control" size="16" type="text" value="" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                        <input type="hidden" id="dtp_input1" value="" name="dtp_input1" required /><br/>
                    </div>

                    <div class="form-group">
                        <label for="dtp_input2" class=" control-label">End Time :</label>
                        <div class="input-group date form_datetime " data-date="1979-09-16T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input2">
                            <input class="form-control" size="16" type="text" value="" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                        <input type="hidden" id="dtp_input2" value="" name="dtp_input2" required /><br/>
                    </div>


                    <button type="button" id="btnSave" onClick="doSave()" class="btn btn-primary">Register</button>

                </div>
            </div> 
        </div> 

        <div class="col-md-6" id="tbl" >

        </div>
    </div> 
    
        <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            format: 'yyyy-mm-dd hh:ii',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startDate: "2019-04-20 10:00",
            startView: 2,
            forceParse: 0,
            showMeridian: 1
        });

    </script>

</div> 

<%@include file="footer.jsp" %>

