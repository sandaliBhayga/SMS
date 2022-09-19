<%-- 
    Document   : create_research_post
    Created on : 19-Apr-2019, 00:14:07
    Author     : lkfaswuser2
--%>

<%-- 
    Document   : register
    Created on : 12-Apr-2019, 14:58:12
    Author     : lkfaswuser2
    page       : register
--%>


<%@include file="header.jsp" %>

<div class="d-flex justify-content-center">

    <form action="ResearchPostServlet" method="POST" enctype="multipart/form-data" >
        <div class="row" >
            <div class="col-md-3" ></div>
            <div class="col-md-6" >
                <div class="panel panel-default" >
                    <div class="panel-heading">Research Post</div>
                    <div class="panel-body">

                        <input type="hidden" value="0" name="hid"  />
                      
                        <div class="form-group">
                            <label for="uname">Heading :</label>
                            <input type="text" class="form-control" id="heading" placeholder="Heading" name="heading" >
                        </div>

                        <div class="form-group">
                            <label for="des">Description :</label>
                            <textarea type="text" class="form-control" id="des" placeholder="Description ....." name="des" ></textarea>
                        </div>

                        <div class="form-group"  >
                            <label for="des">File :</label>
                            <input style="padding: 50px" class="form-control" type="file" name="file" />
                        </div>


                        <h3>${requestScope["message"]}</h3>


                        <button type="submit" class="btn btn-primary">Register</button>

                    </div>
                </div> 
            </div> 

            <div class="col-md-3" ></div>
        </div> 

    </form>
</div> 

<%@include file="footer.jsp" %>

