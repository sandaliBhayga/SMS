
    $(document).ready(function () {
        doGett();
    });




    function doSave() {


        $.ajax({
            type: "POST",
            url: "CalenderEventServlet",
            data: {
                hid: $("#hid").val(),
                title: $("#title").val(),
                start: $("#dtp_input1").val(),
                end: $("#dtp_input2").val()
            },
            success: function (response) {
                doGett();
                swal("saving....", response);
                title: $("#title").val('');
            }
        });
    }


    function doGett() {
        $.ajax({
            type: "GET",
            url: "CalenderEditServlet",
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
            url: "CalenderEditServlet",
            data: {
                id: id,
                mode: 'edit'
            },
            success: function (response) {
                var res = response.split("~@~");
                $("#hid").val(res[0]);
                $("#title").val(res[1]);
            }
        });
    }
    function doDelete(id) {
        alert(id);
    }
