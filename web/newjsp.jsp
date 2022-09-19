<%-- 
    Document   : index
    Created on : Jul 10, 2018, 7:31:05 PM
    Author     : Saroj
--%>



<%@include file="header.jsp" %>

<script>

    $(document).ready(function () {
        doGett();
    });
    
      function doGett() {
        $.ajax({
            type: "GET",
            url: "PostsServlet",
            data: {
            },
            success: function (response) {
                $("#tbl").html(response);
            }
        });
    }
    
    </script>

<div class="row">
<div class="col-md-2" ></div>
<div class="col-md-8">
    
    
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" id="tbl" style="background-color: #218838;height: 400px" >
       
        
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

    
    
</div>
<div class="col-md-4"></div>
</div>


<%@include file="footer.jsp" %>