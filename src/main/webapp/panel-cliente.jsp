<%-- 
    Document   : panel-cliente
    Created on : 15-may-2019, 19:04:49
    Author     : Duoc
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de Cliente</title>
    </head>
    <body>

        <h1>Panel de Cliente</h1>

        <jsp:include page="/ServletPanelUsuario" />

        <div class="">

            <div class="">
                <h2>Lista de CLientes</h2>
                
                <table class="table table-bordered table-striped">
                    <tr>
                        <thead class="">
                            <th>Username</th>
                            <th>idCliente</th>
                            <th>Tipo de Usuario</th>
                            <th>Nombre</th>
                        </thead>
                    </tr>

                    
                    <!--c:forEach var="item" items="{listaClientes}">
                        <tr>


                            <td> {item.nombre}</td>
                            <td> {item.p_id_cliente}</td>
                            <td> {item.descripcion}</td>
                            <td> {item.nombre}</td>

                        </tr>
                    
                    c:forEach -->
                    <p>
                     ${listaClientes[0]}
                     ${listaClientes[1]}
                     ${listaClientes[2]}
                    </p>
                </table>

            </div>
        </div>








        <div class="">
            
        </div>


</body>
</html>


