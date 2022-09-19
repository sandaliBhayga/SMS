 
    $(document).ready(function () {
        doGett();
    });




    function doSave() {

        var radioValue = $("input[name='user_type']:checked").val();

        $.ajax({
            type: "POST",
            url: "RegisterServlet",
            data: {
                user_type: radioValue,
                hid: $("#hid").val(),
                name: $("#name").val(),
                email: $("#email").val(),
                con_password: $("#con_password").val(),
                password: $("#password").val()
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
            url: "RegisterView",
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
            url: "RegisterView",
            data: {
                id: id,
                mode: 'edit'
            },
            success: function (response) {
                var res = response.split("~@~");
                $('input:radio[name="user_type"]').filter("[value="+res[3]+"]").attr('checked', true);
                $("#hid").val(res[0]);
                $("#name").val(res[1]);
                $("#email").val(res[2]);
            }
        });
    }
    function doDelete(id) {
        alert(id);
    }
    
    function doClear() {
        $("#hid").val('0');
        $("#name").val('');
        $("#email").val('');
        $('#con_password').val('');
        $("#password").val('');
    }
