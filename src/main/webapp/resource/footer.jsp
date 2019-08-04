<%-- 
    Document   : footer
    Created on : 23-05-2019, 10:35:03
    Author     : Administrador
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <jsp:include page="rutas.jsp"/>
        <%-- 
        <link href="resource/css/bootstrap.css" rel="stylesheet" type="text/css"/>

        <script src="resource/js/jquery-3.2.0.min.js" type="text/javascript"></script>
        <script src="resource/js/jquery.validate.min.js" type="text/javascript"></script>
        
        <script src="resource/js/bootstrap.js" type="text/javascript"></script>
        <script src="resource/js/holder.js" type="text/javascript"></script>
        --%>
        <%-- 
      <style>

            .footer-bs {
                background-color: #3c3d41;
                padding: 60px 40px;
                color: rgba(255,255,255,1.00);
                margin-bottom: 20px;
                border-bottom-right-radius: 6px;
                border-top-left-radius: 0px;
                border-bottom-left-radius: 6px;
            }
            .footer-bs .footer-brand, .footer-bs .footer-nav, .footer-bs .footer-social, .footer-bs .footer-ns { padding:10px 25px; }
            .footer-bs .footer-nav, .footer-bs .footer-social, .footer-bs .footer-ns { border-color: transparent; }
            .footer-bs .footer-brand h2 { margin:0px 0px 10px; }
            .footer-bs .footer-brand p { font-size:12px; color:rgba(255,255,255,0.70); }

            .footer-bs .footer-nav ul.pages { list-style:none; padding:0px; }
            .footer-bs .footer-nav ul.pages li { padding:5px 0px;}
            .footer-bs .footer-nav ul.pages a { color:rgba(255,255,255,1.00); font-weight:bold; text-transform:uppercase; }
            .footer-bs .footer-nav ul.pages a:hover { color:rgba(255,255,255,0.80); text-decoration:none; }
            .footer-bs .footer-nav h4 {
                font-size: 11px;
                text-transform: uppercase;
                letter-spacing: 3px;
                margin-bottom:10px;
            }

            .footer-bs .footer-nav ul.list { list-style:none; padding:0px; }
            .footer-bs .footer-nav ul.list li { padding:5px 0px;}
            .footer-bs .footer-nav ul.list a { color:rgba(255,255,255,0.80); }
            .footer-bs .footer-nav ul.list a:hover { color:rgba(255,255,255,0.60); text-decoration:none; }

            .footer-bs .footer-social ul { list-style:none; padding:0px; }
            .footer-bs .footer-social h4 {
                font-size: 11px;
                text-transform: uppercase;
                letter-spacing: 3px;
            }
            .footer-bs .footer-social li { padding:5px 4px;}
            .footer-bs .footer-social a { color:rgba(255,255,255,1.00);}
            .footer-bs .footer-social a:hover { color:rgba(255,255,255,0.80); text-decoration:none; }

            .footer-bs .footer-ns h4 {
                font-size: 11px;
                text-transform: uppercase;
                letter-spacing: 3px;
                margin-bottom:10px;
            }
        </style> 
        --%>
        <style>
            .footer{
                background-color: #3c3d41;
                padding: 60px 40px;
                color: rgba(255,255,255,1.00);

                border-bottom-right-radius: 6px;
                border-top-left-radius: 0px;
                border-bottom-left-radius: 6px;


            }
        </style>

    </head>

    <body>







        <div>
            <footer class="footer">

                <div class="py-3">
                    <div class="container">
                        <div class="row">
                            <div class="col-6 p-3 col-lg-2">
                                <h5> <b>Alimentos Santiago</b><br></h5>
                                <ul class="list-unstyled">
                                    <li> <a href="index.jsp">Iniciio</a> </li>
                                    <li> <a href="#">Mision y Vision</a> </li>
                                </ul>
                            </div>
                            <div class="col-6 p-3 col-lg-2">
                                <h5><b>Sobre Convenios</b></h5>
                                <ul class="list-unstyled">
                                    <li> <a href="#">Informacion de Convenio</a> </li>
                                    <li> <a href="#">Contacto</a> </li>
                                </ul>
                            </div>
                            <div class="col-md-6 p-3 col-lg-6">
                                <h5><b>Reclamos y Sugerencias</b></h5>
                                
                                <p class="mb-0" contenteditable="false">Para informaciones, sugerencias y reclamos dirigirse a:</p>
                                
                                <h6 class="text-primary text-center" contenteditable="true"> 
                                    <i class="far fa-envelope"></i>
                                    informaciones@alimentossantiago.cl</h6>
                            </div>
                            <div class="col-md-6 p-3 col-lg-2">
                                <h5> <b>Siguenos en nuestras redes Sociales</b></h5>
                                <div class="row">
                                    <div class="col-md-12 d-flex align-items-center justify-content-between my-2">
                                        
                                        <a href="#">
                                            <i class="fab fa-instagram"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fab fa-twitter"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fab fa-facebook"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fab fa-github"></i>
                                        </a> 
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 text-center">
                                <p class="mb-0 mt-2">© 2009-2019 Alimentos Santiago</p>
                            </div>
                        </div>
                    </div>
                </div>

            </footer>

        </div>



    </body>
</html>
