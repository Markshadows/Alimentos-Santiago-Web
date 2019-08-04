<%
    HttpSession se = request.getSession();
    if (se.getAttribute("objeto") == null && se.getAttribute("cuentaCliente") == null) {
        request.setAttribute("mensaje", "Ingreso no Valido");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comprar</title>
        <style>
            body {
                background-image: url("resource/img/fondo3.jpg");
            }
            #jumbo2 {
                background-image: url("resource/img/logodomino.png");
                height: 320px;
                width: 960px;
                background-color: white;
            }
            #divPago {
                background-color: #C2AD6B;
            }
        </style>
        <jsp:include page="resource/rutas.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="resource/nav.jsp" />
        <form action="ServletCompra" method="POST">
            <jsp:include page="/ServletCompra" />
            <div class="">
                <!-- Platillo  -->
                <div class="row mt-5">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 text-white rounded p-2 shadow-sm" style="background-color: #C2AD6B">
                        <h2 class="text-center">Menú Semanal</h2>
                    </div>
                    <div class="col-sm-4"></div>
                    <div class="row ml-3">
                        <c:forEach var="item" items="${listaPlatillos}">
                            <div class="col-sm-3 ml-5 mt-5">          
                                <div class="card" style="height: 33rem;">
                                    <img src="https://s3.us-east-2.amazonaws.com/alimentos-bucket1/imagenes/${item.src}" class="card-img-top">
                                    <div class="card-body">
                                        <h3>${item.nombre}</h3>
                                        <h5 class="card-title">${item.descripcion}</h5>
                                        <p class="card-text">Tiempo de Preparación: ${item.promedioPreparacion} minutos aprox.</p>
                                        <h1>$${item.valor}</h1>
                                        <input type="checkbox" name="idPlatillo" value="${item.platilloId}" /> Seleccionar
                                        <input type="number" min="0" max="20" name="cantidadPlatillos">
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="container mt-5">
                            <div class="jumbotron" id="jumbo2">
                                <!--<img class="mb-5" src="assets/img/logo/onlinelogomaker-042119-1348-3439.svg" width="350" height="200">-->
                            </div>
                        </div>
                        <c:forEach var="item" items="${listaPlatillosWS}">
                            <div class="col-sm-3 ml-5 mt-5">          
                                <div class="card" style="height: 33rem;">
                                    <img src="https://s3.us-east-2.amazonaws.com/alimentos-bucket1/imagenes/domino/${item.src}" class="card-img-top" height="200px;">
                                    <div class="card-body">
                                        <h3>${item.nombre}</h3>
                                        <h5 class="card-title">${item.descripcion}</h5>
                                        <p class="card-text">Tiempo de Preparación: ${item.promedioPreparacion} minutos aprox.</p>
                                        <h1>$${item.valor}</h1>
                                        <input type="checkbox" name="idPlatillo" value="${item.platilloId}" /> Seleccionar
                                        <input type="number" min="0" max="20" name="cantidadPlatillos">
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <br>
            <br>
            <br>
            <div class="row">
                <div class="col-sm-4"></div> 
                <div class="col-sm-4 " id="divPago">
                    <hr>
                    <p>Forma de Pago: </p>
                    <select name="cboFormaPago">
                        <option value="0"> Seleccione...</option>
                        <c:forEach var="item" items="${listaFormaPago}">
                            <option value="${item.formaPagoId}"> ${item.descripcion}</option>
                        </c:forEach>
                    </select>
                    <p class="mt-3">Dirección Pedido</p>
                    <input type="text" name="txtDireccion" required="true"class="mb-3">
                    <input type="submit" name="btnAccion" value="Pedir" class="mb-3">
                    <hr>
                </div>
            </div>
            <jsp:include page="resource/mensajes.jsp"></jsp:include>
        </form>
    </body>
</html>


