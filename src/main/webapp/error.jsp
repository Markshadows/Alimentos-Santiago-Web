<%-- 
    Document   : error
    Created on : 11-05-2019, 4:27:49
    Author     : M_arc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <jsp:include page="resource/rutas.jsp"/>


        <style>
            body {
                background-attachment:scroll;
                background-repeat:no-repeat;
                background-position:center;
                background-size:cover;
                line-height:5px; 
            }
            .display-1 {text-align:center;color:#23a7bc;}
            .display-1 .fa {animation:fa-spin 5s infinite linear;}
            .display-3 {text-align:center;color:#23a7bc;}
            .lower-case {text-align:center;}

        </style>

    </head>
    <body>

        <jsp:include page="resource/nav.jsp"/>

        <br>
        <br>


        <!------------start content ------------>

        <div class="wrapper">
            <div class="container-fluid" id="top-container-fluid-nav">
                <div class="container">	
                    <!---- for nav container ----->	
                </div>
            </div> 


            <div class="container-fluid" id="body-container-fluid">
                <div class="container">
                    <!---- for body container ---->


                    <div class="jumbotron">
                        <h1 class="display-1">4 <i class="fa  fa-spin fa-cog fa-3x"></i> 4</h1>
                        <h1 class="display-3">ERROR</h1>

                        <div>
                            <div class="row">
                                <p class="lower-case">${mensaje}</p>

                            </div>
                        </div>

                    </div>

                    <!-------mother container middle class------------------->


                </div>
            </div>






        </div>

        <br>
        <br>
        <br>


        <jsp:include page="resource/footer.jsp"></jsp:include>                   





    </body>
</html>
