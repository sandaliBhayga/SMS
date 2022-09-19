<%-- 
    Document   : file_upload
    Created on : 19-Apr-2019, 09:48:06
    Author     : lkfaswuser2
--%>




 <h3>${requestScope["message"]}</h3>

<div>
    <h3> Choose File to Upload in Server </h3>
    <form action="FileUploadHandler" method="post" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="submit" value="upload" />
    </form>          
</div>