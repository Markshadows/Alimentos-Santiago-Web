<%-- 
    Document   : resultado
    Created on : 27-04-2019, 15:38:36
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
                <% String msg = (String) request.getAttribute("gurumessage");
            out.println(msg);
        %>
    </body>
</html>
