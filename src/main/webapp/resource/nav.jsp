<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="rutas.jsp"/>
        <style>
            @import url(https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.3/css/mdb.min.css);


            .navbar .dropdown-menu a:hover {
                color: #04adc9 !important;

            }
            .darken-grey-text {
                color: #2E2E2E;
            }
            .dropdown-divider-color {
                color: #2E2E2E;
            }

            #navmenu {
                background-color: #eee3d3;
            }

        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light" id="navmenu">
            <a class="navbar-brand font-bold" href="index.jsp">Alimentos Santiago</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-4" aria-controls="navbarSupportedContent-4" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent-4">
                <ul class="navbar-nav  ml-auto">
                    <li class="nav-item active dropdown">
                        <c:choose>
                            <c:when test="${! empty objeto}">
                                <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown" >
                                    <i class="fa fa-user"></i> Mi Cuenta
                                </a>
                                <div class="dropdown-menu dropdown-primary dropdown-menu-xl-right " aria-labelledby="navbarDropdownMenuLink-4">
                                    <a class="dropdown-item" href="menu-cliente.jsp">Panel Cuenta</a>
                                    <p class="dropdown-divider .dropdown-divider-color"></p>
                                    <a class="dropdown-item" href="login-cliente.jsp">Cerrar Sesión</a>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown" >
                                    <i class="fa fa-user"></i> Iniciar Sesión
                                </a>
                                <div class="dropdown-menu dropdown-primary dropdown-menu-xl-right " aria-labelledby="navbarDropdownMenuLink-4">

                                    <a class="dropdown-item" href="login-cliente.jsp">Clientes</a>
                                    <p class="dropdown-divider .dropdown-divider-color"></p>
                                    <a class="dropdown-item" href="login-trabajador.jsp">Otros</a>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </li>
                </ul>
            </div>
        </nav>
    </body>
</html>