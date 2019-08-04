<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Alimentos Santiago</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <%-- css --%>
        <link href="resource/css/bootstrap.css" rel="stylesheet" type="text/css"/>

        <script src="resource/js/jquery-3.2.0.min.js" type="text/javascript"></script>
        <script src="resource/js/jquery.validate.min.js" type="text/javascript"></script>
        <%-- JS --%>
        <script src="resource/js/bootstrap.js" type="text/javascript"></script>
        <script src="resource/js/holder.js" type="text/javascript"></script>


    </head>
    <style>
        .carousel .item {
            height: 00px;
        }
        #jumbo1 {
            background-image: url("resource/img/fondo1.png");
        }
        
        #jumbo2 {
            background-image: url("resource/img/fondo3.jpg");
        }
        
        #divultimos {
            background-color:#996644;
        }
        #container-platos {
            position: relative;
        }
        #container-platos::after {
            content: "";
            display: block;
            position: absolute;
            top: 0;
            left: 0;
            background-image: url("resource/img/fondo2.jpg");
            width: 100%;
            height: 100%;
            z-index: -1;
        }
    </style>
    <body>

        <jsp:include page="resource/nav.jsp"/>




        <jsp:include page="/ServletUtilidad"></jsp:include>
            <div class="py-5 text-center parallax cover gradient-overlay" style="background-image: url(&quot;assets/img/platillo/comida1.jpg&quot;); position: relative; background-position: 50% calc(50% + 0px); background-size: cover; background-repeat: repeat;">
                <div class="container-fluid d-flex flex-column" >
                    <div class="row my-auto">
                        <div class="col-md-12 text-white">
                            <div class="jumbotron" id="jumbo1">
                                <!--<img class="mb-5" src="assets/img/logo/onlinelogomaker-042119-1348-3439.svg" width="350" height="200">-->
                                <h1 class="mb-3 display-1 text-center">Alimentos Santiago</h1>
                                <hr class="my-4">
                                <p class="lead">De la cocina a tu paladar, los mejores sabores hogareños
                                    y gourmet preparados con calidad</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container mb-5">
                <div class="row">
                    <div class="col-md-12">
                        <div class="row">
                            <div class="col-sm-12">
                                <div id="carouselExampleFade" class="carousel slide carousel-fade" data-ride="carousel">
                                    <div class="carousel-inner">
                                        <div class="carousel-item active">
                                            <img src="resource/img/menu3.jpg" class="d-block w-100" alt="...">
                                        </div>
                                        <div class="carousel-item">
                                            <img src="resource/img/menu2.jfif" class="d-block w-100" alt="...">
                                        </div>
                                        <div class="carousel-item">
                                            <img src="resource/img/menu4.jpg" class="d-block w-100" alt="...">
                                        </div>
                                    </div>
                                    <a class="carousel-control-prev" href="#carouselExampleFade" role="button" data-slide="prev">
                                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                    <a class="carousel-control-next" href="#carouselExampleFade" role="button" data-slide="next">
                                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container mt-5">
                <div class="jumbotron" id="jumbo2">
                                <!--<img class="mb-5" src="assets/img/logo/onlinelogomaker-042119-1348-3439.svg" width="350" height="200">-->
                                <h1 class="mb-3 display-1 text-right">Últimos Platos</h1>
                                <hr class="my-4">
                   </div>
            </div>
            <div style="height: 550px;">
            <div class="container-fluid h-100" id="container-platos">
                <div class="row">
                <c:forEach var="item" items="${ultimosPlatillos}">
                    <div class="col-sm-4 mt-5 mb-5 pt-5">                             
                        <div class="card" style="height: 22rem;">
                            <img class="card-img-top" src="https://s3.us-east-2.amazonaws.com/alimentos-bucket1/imagenes/${item.src}">
                                 <div class="card-body">
                                    <h3 class="card-title">${item.nombre}</h3>
                                    <p class="card-text">${item.descripcion}</p>
                                 </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
                </div>


            <div class="py-5">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="display-4">Nuestros Convenios<br></h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="row">
                                <div class="col-md-2" style=""><img class="img-fluid d-block rounded-circle" src="resource/img/fuentenicanor.jpg"></div>
                                <div class="col-md-2"><img class="img-fluid d-block rounded-circle" src="resource/img/domino.jpg"></div>
                                <div class="col-md-2"><img class="img-fluid d-block rounded-circle" src="resource/img/fuentechica.png"></div>
                                <div class="col-md-2"><img class="img-fluid d-block rounded-circle" src="resource/img/logo.png"></div>
                                <div class="col-md-2"><img class="img-fluid d-block rounded-circle" src="resource/img/rjapon.jpg"></div>
                                <div class="col-md-2"><img class="img-fluid d-block rounded-circle" src="resource/img/bodegon.jpg"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>




            <jsp:include page="resource/footer.jsp"></jsp:include>






    </body>

    <script>
        $('.carouselExampleFade').carousel();
    </script>
</html>
