<%
    HttpSession se = request.getSession();
    if (se.getAttribute("objeto") == null && se.getAttribute("cuentaCliente") == null) {
        request.setAttribute("mensaje", "Ingreso no Valido");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


        <jsp:include page="resource/rutas.jsp" />


        <jsp:include page="resource/rutas.jsp" />

        <style>
            .colordefondo{
                background-color: #fff;
                border-color: #fff;
            }


            body{
                background-image: url("resource/img/fondo2.jpg");
            }
            .emp-profile{
                padding: 3%;
                margin-top: 3%;
                margin-bottom: 3%;
                border-radius: 0.5rem;
                background: #eee3d3;
            }
            .profile-img{
                text-align: center;
            }
            .profile-img img{
                width: 70%;
                height: 100%;
            }
            .profile-img .file {
                position: relative;
                overflow: hidden;
                margin-top: -20%;
                width: 70%;
                border: none;
                border-radius: 0;
                font-size: 15px;
                background: #212529b8;
            }
            .profile-img .file input {
                position: absolute;
                opacity: 0;
                right: 0;
                top: 0;
            }
            .profile-head h5{
                color: #333;
            }
            .profile-head h6{
                color: #0062cc;
            }
            .profile-edit-btn{
                border: none;
                border-radius: 1.5rem;
                width: 70%;
                padding: 2%;
                font-weight: 600;
                color: #6c757d;
                cursor: pointer;
            }
            .proile-rating{
                font-size: 12px;
                color: #818182;
                margin-top: 5%;
            }
            .proile-rating span{
                color: #495057;
                font-size: 15px;
                font-weight: 600;
            }
            .profile-head .nav-tabs{
                margin-bottom:5%;
            }
            .profile-head .nav-tabs .nav-link{
                font-weight:600;
                border: none;
            }
            .profile-head .nav-tabs .nav-link.active{
                border: none;
                border-bottom:2px solid #0062cc;
            }
            .profile-work{
                padding: 14%;
                margin-top: -15%;
            }
            .profile-work p{
                font-size: 12px;
                color: #818182;
                font-weight: 600;
                margin-top: 10%;
            }
            .profile-work a{
                text-decoration: none;
                color: #495057;
                font-weight: 600;
                font-size: 14px;
            }
            .profile-work ul{
                list-style: none;
            }
            .profile-tab label{
                font-weight: 600;
            }
            .profile-tab p{
                font-weight: 600;
                color: #0062cc;
            }
        </style>



        <%-- Estilo de las card de platillos --%>
        <style>


            .card {
                font-size: 1em;
                overflow: hidden;
                padding: 0;
                border: none;
                border-radius: .28571429rem;
                box-shadow: 0 1px 3px 0 #d4d4d5, 0 0 0 1px #d4d4d5;
            }

            .card-block {
                font-size: 1em;
                position: relative;
                margin: 0;
                padding: 1em;
                border: none;
                border-top: 1px solid rgba(34, 36, 38, .1);
                box-shadow: none;
            }

            .card-img-top {
                display: block;
                width: 100%;
                height: auto;
            }

            .card-title {
                font-size: 1.28571429em;
                font-weight: 700;
                line-height: 1.2857em;
            }

            .card-text {
                clear: both;
                margin-top: .5em;
                color: rgba(0, 0, 0, .68);
            }

            .card-footer {
                font-size: 1em;
                position: static;
                top: 0;
                left: 0;
                max-width: 100%;
                padding: .75em 1em;
                color: rgba(0, 0, 0, .4);
                border-top: 1px solid rgba(0, 0, 0, .05) !important;
                background: #fff;
            }

            .card-inverse .btn {
                border: 1px solid rgba(0, 0, 0, .05);
            }

            .profile-inline ~ .card-title {
                display: inline-block;
                margin-left: 4px;
                vertical-align: top;
            }


            .btnSubmit
            {
                border:none;
                border-radius:1.5rem;
                padding: 1%;
                width: 30%;
                align-self: center;
                background: #04adc9;
                color: #fff;
            }


        </style>




    </head>
    <body>

        <%--
        <h1>Menu Cliente</h1>
        <p>Usuario: ${objeto.nombre}</p>
        <p>${mensaje}</p>
        --%>

        <jsp:include page="resource/nav.jsp"/>



        <jsp:include page="/ServletCompra"/>

        <div class="row">
            <div class="col-2">
                <br>
                <div class="nav flex-column nav-pills border border-dark" id="v-pills-tab" role="tablist" aria-orientation="vertical" style="background-color: #eee3d3;">
                    <p class="dropdown-divider"></p>
                    <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true"> Mi Perfil </a>
                    <p class="dropdown-divider" style="border-color: #6c757d"></p>
                    <a class="nav-link" id="v-pills-saldo-tab" data-toggle="pill" href="#v-pills-saldo" role="tab" aria-controls="v-pills-saldo" aria-selected="true"> Agregar Saldo </a>
                    <p class="dropdown-divider" style="border-color: #6c757d"></p>
                    <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false"> Mis Pedidos </a>
                    <p class="dropdown-divider"></p>
                    <a class="  btn-danger btnSubmit text-center" href="cliente-compra.jsp"> Pedir </a>
                </div>
            </div>
            <div class="col-10">
                <div class="tab-content" id="v-pills-tabContent">




                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">



                        <div class="container emp-profile">

                            <div class="row">
                                <div class="col-md-4">
                                    <div class="profile-img">
                                        <img data-src="holder.js/300x200?theme=lava"alt=""/>
                                        <div class="file btn btn-lg btn-primary">
                                            Cambiar Foto
                                            <input type="file" name="file"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="profile-head">
                                        <h5>

                                            <p>Hola ${objeto.usuarioTipoUsuario.usuario.nombre}</p>

                                        </h5>
                                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                                            <li class="nav-item">
                                                <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Usuario</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Cuenta</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>          
                            </div>


                            <div class="tab-content profile-tab" id="myTabContent">
                                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                    <div class="row">
                                        <div class="col-md-2 ml-3">
                                            <label>Nombre</label>
                                        </div>
                                        <div class="col-md-3">
                                            <p class="text-dark">${objeto.nombre} ${objeto.appaterno} ${objeto.apmaterno}</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-2 ml-3">
                                            <label>Rut</label>
                                        </div>
                                        <div class="col-md-3">
                                            <p class="text-dark">${objeto.rut}</p>
                                        </div>
                                    </div>
                                </div>


                                <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                    <div class="row">
                                        <div class="col-md-2 ml-3">
                                            <label>Saldo</label>
                                        </div>
                                        <div class="col-md-3">
                                            <p class="text-dark">$ ${cuentaCliente.saldo}</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-2 ml-3">
                                            <label>Tipo Cuenta</label>
                                        </div>
                                        <div class="col-md-3">
                                            <p class="text-dark">${objeto.usuarioTipoUsuario.tipoUsuario.descripcion}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>







                    </div>



                    <div class="tab-pane fade" id="v-pills-saldo" role="tabpanel" aria-labelledby="v-pills-saldo-tab">




                        <div class="container emp-profile">


                            <form action="ServletCompra" method="POST">
                                <div class="row">
                                    <div class="form-group col-md-4">
                                        <label for="inputState">Monto</label>
                                        <select name="cboMonto" class="form-control">
                                            <option selected value="0">0</option>
                                            <option value="5000">$5.000</option>
                                            <option value="10000">$10.000</option>
                                            <option value="20000">$20.000</option>
                                            <option value="30000">$30.000</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-4 mt-4">
                                        <button type="submit" class="btn btn-primary" name="btnAccion" value="agregarSaldo">Agregar Saldo</button>
                                    </div>
                                </div>
                            </form>
                        </div>





                    </div>







                    <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">




                        <div class="container emp-profile">


                            <!-- lista de pedidos -->


                            <div class="col">
                                <form action="ServletCompra" method="POST">
                                <div class="row">
                                    
                                    <c:forEach var="item" items="${listaMisPedidos}">
                                        <div class="col-sm-6 col-md-4 col-lg-3 mt-4">
                                            <div class="card">
                                                <%-- ${item.img_platillo} algun dia --%>

                                                <div class="card-block">

                                                    <h4 class="card-title"> Pedido: ${item.pedidoId} </h4>
                                                    <h3 class="card-subtitle"> Platos
                                                        <c:set var="contar" value="0" scope="page" />
                                                        <c:set var="contar2" value="0" scope="page" />
                                                        <c:set var="contar3" value="0" scope="page" />
                                                        <c:set var="contarf4" value="0" scope="page" />
                                                        <c:set var="contar5" value="0" scope="page" />
                                                        <c:set var="contar6" value="0" scope="page" />
                                                        <c:forEach var="item2" items="${item.pedidoPlatilloList}">
                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <c:if test="${item2.platilloId.platilloId == 1}"><c:set var="contar" value="${contar+1}" scope="page" /></c:if>
                                                                    ${item2.platilloId.nombre}

                                                                </li>
                                                            </ul>
                                                        </c:forEach>

                                                        <p class="mt-3">Total: $${item.pedidoPlatilloList[0].clientePedidoList[0].detalleVentaList[0].total}</p>
                                                    </h3>
                                                    <div class="card-text">
                                                        <hr>
                                                        <p>Dirección: ${item.direccion}</p>
                                                        <hr>
                                                        <p>Estado: ${item.estadoId.descripcion}</p>
                                                    </div>
                                                </div>
                                                <div class="card-footer text-dark">
                                                    <span>Pedido: <fmt:formatDate value="${item.horaPedido}" pattern="dd'/'MM'/'YYYY '-' HH:mm:ss" /></span>
                                                    <span><i class=""></i>Entrega: <fmt:formatDate value="${item.horaEntrega}" pattern="dd'/'MM'/'YYYY '-' HH:mm" /></span>
                                                    <span class="mt-3">Modificar Entrega: <input type="datetime" placeholder="Formato d/m/a h:m" name="txtHoraCambio"></span>
                                                    <input type="hidden" value="${item.pedidoId}" name="txtPedidoId">
                                                    <input type="submit" name="btnAccion" value="CambiarHora" class="mt-3">
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div> 
                                </form>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="resource/mensajes.jsp"></jsp:include>
        <jsp:include page="resource/footer.jsp"/>
    </body>
    <script>
        $('#myTab a').on('click', function (e) {
            e.preventDefault()
            $(this).tab('show')
        })

        $('#myTab a[href="#profile"]').tab('show') // Select tab by name
        $('#myTab li:first-child a').tab('show') // Select first tab
        $('#myTab li:last-child a').tab('show') // Select last tab
        $('#myTab li:nth-child(3) a').tab('show') // Select third tab
    </script>
</html>