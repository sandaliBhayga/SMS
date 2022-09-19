<%@page import="com.sms.events.UniversityFunctions"%>
<%@page import="java.util.ArrayList"%>
<%-- 
    Document   : create_event
    Created on : 14-Apr-2019, 07:37:20
    Author     : lkfaswuser2
--%>

<%@include file="header.jsp" %>

<script>

    $(document).ready(function () {
        doGett();
    });




    function doSave() {


        $.ajax({
            type: "POST",
            url: "AnnualEventServlet",
            data: {
                hid: $("#hid").val(),
                event_name: $("#event_name").val(),
                university: $("#university").val(),
                date: $("#dtp_input1").val(),
                venue: $("#venue").val(),
                remark: $("#remark").val()
            },
            success: function (response) {
                doGett();
                swal("saving....", response);
                doClear();
            }
        });
    }


    function doGett() {
        $.ajax({
            type: "GET",
            url: "AnnualEventViewServlet",
            data: {
                user_type: $("#uttypee").val(),
                mode: 'load'
            },
            success: function (response) {
                $("#tbl").html(response);
            }
        });
    }
    function doEdit(id) {
        $.ajax({
            type: "GET",
            url: "AnnualEventViewServlet",
            data: {
                id: id,
                mode: 'edit'
            },
            success: function (response) {
                var res = response.split("~@~");
                $("#hid").val(res[0]);
                $("#event_name").val(res[1]);
                $("#university").val(res[2]);
//                $("#dtp_input1").val(res[3]);
//                $('#dtp_input1').attr('data-date', res[3]);

                $('#dtp_input1').currentDate(res[3]);

                $("#venue").val(res[4]);
                $("#remark").val(res[5]);
                
                
            }
        });
    }
    function doDelete(id) {
        alert(id);
    }
    function doClear() {
        $("#hid").val('0');
        $("#event_name").val('');
        $("#university").val('');
        $('#dtp_input1').val('');
        $("#venue").val('');
        $("#remark").val('');
    }

</script>




<div class="row" >
    .<div class="col-md-1" ></div>
    <div class="col-md-5" >

        <div class="panel panel-success" >
            <div class="panel-heading">Create Event</div>
            <div class="panel-body">

                <div class="form-group">
                    <input type="hidden" value="0" name="hid" id="hid" />
                    <label for="uname">Event Name :</label>
                    <input type="text" class="form-control" id="event_name" placeholder="Event Name" name="event_name" required>
                </div>

                <div class="form-group">
                    <label for="uname" for="sel1">University :</label>
                    <select class="form-control" id="university" name="university">
                        <%
                            ArrayList<String> univer = UniversityFunctions.getAllUniversities();
                            for (String elem : univer) {
                        %>
                        <option value="<%=elem%>" > <%=elem%></option>
                        <%}%>
                    </select>
                </div>

                <div class="form-group">
                    <label for="dtp_input1" class=" control-label">DateTime :</label>
                    <div class="input-group date form_datetime " data-date="1979-09-16T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                        <input class="form-control" size="16" type="text" value="" readonly>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                    </div>
                    <input type="hidden" id="dtp_input1" value="" name="dtp_input1" required /><br/>
                </div>



                <div class="form-group">
                    <label for="uname">venue :</label>
                    <input type="text" class="form-control" id="venue" placeholder="Value" name="venue" required>
                </div>


                <div class="form-group">
                    <label for="uname">Remark :</label>
                    <textarea type="text" class="form-control" id="remark" placeholder="Remark" name="remark" required></textarea>
                </div>

                <button type="button" onClick="doSave()" class="btn btn-primary">Save</button>.








            </div>
        </div>
    </div>

    <div class="col-md-6" id="tbl" >

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

</div> 

<%@include file="footer.jsp" %>