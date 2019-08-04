<%-- 
    Document   : Cargar
    Created on : 23-04-2019, 15:26:28
    Author     : M_arc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        File: <br />
        <form action="ServletCargar" method="post"
              enctype="multipart/form-data">
            <input type="file" name="guru_file" size="50" />
            <br />
            <input type="submit" value="Upload" />
        </form>
    </body>
</html>

