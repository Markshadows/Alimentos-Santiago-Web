<%-- 
    Document   : menu-rrhh
    Created on : 11-05-2019, 3:34:17
    Author     : M_arc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Repartidor</title>


        <jsp:include page="resource/rutas.jsp" />

        <style>
            .colordefondo{
                background-color: #fff;
                border-color: #fff;
            }


            body{
                background: -webkit-linear-gradient(left, #3931af, #00c6ff);
            }
            .emp-profile{
                padding: 3%;
                margin-top: 3%;
                margin-bottom: 3%;
                border-radius: 0.5rem;
                background: #fff;
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




        </style>

    </head>

    <body>
        <jsp:include page="resource/nav.jsp"/>



        <div class="row">
            <div class="col-2">
                <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true"> Mi Perfil </a>
                    <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false"> Pedidos </a>

                </div>
            </div>
            <div class="col-10">
                <div class="tab-content" id="v-pills-tabContent">




                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">









                        <div class="container emp-profile">

                            <div class="row">
                                <div class="col-md-4">
                                    <div class="profile-img">
                                        <img src="holder.js/300x200"alt=""/>
                                        <div class="file btn btn-lg btn-primary">
                                            Cambiar Foto
                                            <input type="file" name="file"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="profile-head">
                                        <h5>

                                            <p>Usuario: ${objeto.nombre}</p>

                                        </h5>
                                        <h6>
                                            <p>Tipo Usuario ${objeto.tipoUsuario}</p>
                                        </h6>
                                        <p class="proile-rating"><p>Usuario: ${objeto.nombre}</p></span></p>
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

                            <div class="col-md-8">
                                <div class="tab-content profile-tab" id="myTabContent">
                                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Id Usuario</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${objeto.idUsuario}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Nombre</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${objeto.nombre}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Tipo Usuario</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${objeto.tipoUsuario}</p>
                                            </div>
                                        </div> 
                                    </div>


                                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Usuario</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${objeto.idUsuario}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Username</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${objeto.nombre}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Contraseña</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${objeto.contraseña}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>







                    </div>







                    <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">




                        <div class="container emp-profile">


                            <!-- lista de pedidos -->


                            <div class="col">
                                <div class="row">



                                    <div class="col-sm-6 col-md-4 col-lg-3 mt-4">
                                        <div class="card">
                                            <%-- ${item.img_platillo} algun dia --%>
                                            
                                            <img class="card-img-top" src="holder.js/300x150">
                                            <div class="card-block">
                                                
                                                <h4 class="card-title"> Pedido: ${item.pedido_id} </h4>
                                                <h3 class="card-subtitle"> Platillo: ${item.pedido_id} </h3>
                                                <div class="meta">
                                                    <a href="#"> Cliente : ${item.usuario}</a>
                                                </div>
                                                <div class="card-text">
                                                    <p>Direccion: ${item.direccion}</p>
                                                    <p>Hora de pedido: ${item.hora_pedido}</p>
                                                    
                                                </div>
                                            </div>
                                            <div class="card-footer">
                                                <span class="float-right">Estado: ${item.estado_id} </span>
                                                <span><i class=""></i>Hora entrega: ${item.hora_entrega}</span>
                                            </div>
                                        </div>
                                    </div>
                                       
                                            
                                             <!-- segunda de prueba -->
                                                
                                    <div class="col-sm-6 col-md-4 col-lg-3 mt-4">
                                        <div class="card">
                                            <img class="card-img-top" src="holder.js/250x150">
                                            <div class="card-block">
                                                
                                                <h4 class="card-title"> Pedido:  </h4>
                                                <div class="meta">
                                                    <a href="#">Friends</a>
                                                </div>
                                                <div class="card-text">
                                                    Tawshif is a web designer living in Bangladesh.
                                                </div>
                                            </div>
                                            <div class="card-footer">
                                                <span class="float-right">Joined in 2013</span>
                                                <span><i class=""></i>75 Friends</span>
                                            </div>
                                        </div>
                                    </div>



                                </div> 
                            </div>




                        </div>





                    </div>

                </div>
            </div>
        </div>






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



<!-- 
<h1>Menu RRHH</h1>
        <p>Usuario: ${objeto.nombre}</p>
        <p>${mensaje}</p>














                        <br>
                        <br>
                        <br>




                        </form>           
                    </div>



-->