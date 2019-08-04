    <%
    HttpSession se=request.getSession();
    se.removeAttribute("objeto");
    se.removeAttribute("cuentaCliente");
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="resource/js/jquery-3.2.0.min.js" type="text/javascript"></script>
        <script src="resource/js/bootstrap.js" type="text/javascript"></script>
        <title>Iniciar Sesión</title>

        <jsp:include page="resource/rutas.jsp"/>

        <style>

            .user_card {
                height: 400px;
                width: 350px;
                margin-top: auto;
                margin-bottom: 60px;
                background: #fff;
                position: relative;
                display: flex;
                justify-content: center;
                flex-direction: column;
                padding: 10px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                -webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                -moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                border-radius: 5px;

            }
            .brand_logo_container {
                position: absolute;
                height: 170px;
                width: 170px;
                top: -75px;
                border-radius: 50%;
                background: #582707;
                padding: 10px;
                text-align: center;
            }
            .brand_logo {
                height: 150px;
                width: 150px;
                border-radius: 50%;
                border: 2px solid white;
            }

            .form_container {
                margin-top: 100px;
            }
            .login_btn {
                width: 100%;
                background: #C2AD6B !important;
                color: white !important;
            }
            .login_btn:focus {
                box-shadow: none !important;
                outline: 0px !important;
            }
            .login_container {
                padding: 0 2rem;
            }
            .input-group-text {
                background:#C2AD6B !important;
                color: white !important;
                border: 0 !important;
                border-radius: 0.25rem 0 0 0.25rem !important;
            }
            .input_user,
            .input_pass:focus {
                box-shadow: none !important;
                outline: 0px !important;
            }
            .custom-checkbox .custom-control-input:checked~.custom-control-label::before {
                background-color: #09f !important;
            }
        </style>
        <style>

            html,body{
                width: 100%;
                height: 100%;
            }

            body {
                background-image: url("resource/img/fondologin.jpg");
            }

            #circle {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%,-50%);
                width: 150px;
                height: 150px;	
            }

            .loader {
                width: calc(100% - 0px);
                height: calc(100% - 0px);
                border: 8px solid #C2AD6B;
                border-top: 8px solid #eee3d3;
                border-radius: 50%;
                animation: rotate 7s linear infinite;
            }

            @keyframes rotate {
                100% {transform: rotate(360deg);}
            } 
        </style>

    </head>
    <body>
        <jsp:include page="resource/nav.jsp"/>


        <div class="container h-100">
            <div class="d-flex justify-content-center h-100">
                <div class="user_card">
                    <div class="d-flex justify-content-center">
                        <div class="brand_logo_container">

                            <div id="circle">
                                <div class="loader">
                                    <div class="loader">
                                        <div class="loader">
                                            <div class="loader">

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>     

                            <%--<img src="https://cdn.freebiesupply.com/logos/large/2x/pinterest-circle-logo-png-transparent.png" class="brand_logo" alt="Logo">
                            --%>					
                        </div>
                    </div>
                    <div class="d-flex justify-content-center form_container">
                        <form method="POST" action="ServletUsuario">
                            <div class="input-group mb-3">
                                <div class="input-group-append">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" class="form-control input_user" name="txtNombre" placeholder="Nombre de Usuario">

                            </div>
                            <div class="input-group mb-2">
                                <div class="input-group-append">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                <input type="password" class="form-control input_pass " name="txtContrasena" placeholder="Contraseña">

                            </div>
                            <div class="form-group">
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input" id="customControlInline">
                                    <label class="custom-control-label" for="customControlInline"> Recordarme </label>
                                </div>
                            </div>
                    </div>
                    <div class="d-flex justify-content-center mt-3 login_container">

                        <input type="submit" class="btn login_btn" name="btnAccion" value="loginCliente">
                    </div>
                    </form>
                    <div class="mt-4">
                        <div class="d-flex justify-content-center links">
                            ¿No tienes una Cuenta? <a href="registro-cliente.jsp" class="ml-2">Crea Una</a>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <jsp:include page="resource/mensajes.jsp"></jsp:include>
            </div>
        <jsp:include page="resource/footer.jsp"></jsp:include>
    </body>
</html>
