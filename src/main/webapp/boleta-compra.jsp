<%-- 
    Document   : boleta-compra
    Created on : 27-05-2019, 11:40:46
    Author     : M_arc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="resource/rutas.jsp"></jsp:include>
        <form>
            <div class="row mt-5">
                <div class="col-sm-3"></div>                   
                <div class="col-sm-6">
  <div class="form-row">
    <div class="form-group col-md-6">
        <label for="inputEmail4" class="bg-info">Fecha</label>
        <input type="text" class="form-control" name="txtFecha" disabled="true" value="${venta.fecha}">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4" class="bg-info">Nro Documento</label>
      <input type="text" class="form-control" name="txtNroDocumento" disabled="true" value="${venta.numeroDocumento}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress" class="bg-info">Pedido</label>
    <input type="text" class="form-control" name="txtPedido" disabled="true" value="${detalleVenta.clientePedidoId.pedidoId.platilloId.nombre}">
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity" class="bg-info">Total Venta</label>
      <input type="text" class="form-control" name="txtTotal" disabled="true" value="${detalleVenta.total}">
    </div>
  </div>
            <a href="menu-cliente.jsp" class="bg-info">Volver</a>
        </div>
                                <div class="col-sm-3"></div>  
            </div>
</form>
    </body>
</html>
