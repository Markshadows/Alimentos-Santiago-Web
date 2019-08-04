<%-- 
    Document   : login-trabajador
    Created on : 23-05-2019, 18:35:19
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Trabajador</title>

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <jsp:include page="resource/rutas.jsp" ></jsp:include>

            <style>
                .login-container{
                    margin-top: 5%;
                    margin-bottom: 5%;
                }
                .login-logo{
                    position: relative;
                    margin-left: -22%;
                }
                .login-logo img{
                    position: initial;
                    width: 30%;
                    margin-top: 19%;
                    background: #adb5bd;
                    border-radius: 4.5rem;
                    padding: 5%;
                }

                .login-form-1{
                    padding: 9%;
                    background:#282726;
                    box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
                }
                .login-form-1 h3{
                    text-align: center;
                    margin-bottom:12%;
                    color:#13acc4;
                }

                .login-form-2{
                    padding: 9%;
                    background: #fff;
                    box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
                }
                .login-form-2 h3{
                    text-align: center;
                    margin-bottom:12%;
                    color: #13acc4;
                }
                .btnSubmit{
                    font-weight: 600;
                    width: 50%;
                    color: #282726;
                    background-color: #13acc4;
                    border: none;
                    border-radius: 1.5rem;
                    padding:2%;
                }
                .btnForgetPwd{
                    color: #fff;
                    font-weight: 600;
                    text-decoration: none;
                }
                .btnForgetPwd:hover{
                    text-decoration:none;
                    color:#fff;
                }

            </style>

        </head>
        <body>
        <jsp:include page="resource/nav.jsp"/>



        <div class="container login-container">
            <div class="row">

                <div class="col-md-6 login-form-1">
                    <h3>Login Empleadores</h3>
                    <div class="form-group">
                        <form action="ServletUsuario" method="POST">
                            <div class="form-group">
                                <input type="text" class="form-control" name="txtNombre" placeholder="Nombre de Usuario">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control " name="txtContrasena" placeholder="Contraseña">
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btnSubmit" name="btnAccion" value="loginEmpleador">
                            </div>

                        </form>
                    </div>                 
                </div>


                <div class="col-md-6 login-form-2">
                    <div class="login-logo">
                        <img src="resource/img/servicio-tecnico.png" alt=""/>
                    </div>

                    <h3>Login Trabajadores</h3>

                    <div class="form-group">
                        <form action="ServletUsuario" method="POST">
                            <div class="form-group">
                                <input type="text" class="form-control" name="txtNombre" placeholder="Nombre de Usuario">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control " name="txtContrasena" placeholder="Contraseña">
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btnSubmit" name="btnAccion" value="loginTrabajador">
                            </div>
                        </form>
                    </div>       

                    </form>
                </div>

            </div>
        </div>




        <jsp:include page="resource/footer.jsp"></jsp:include>
    </body>
</html>
