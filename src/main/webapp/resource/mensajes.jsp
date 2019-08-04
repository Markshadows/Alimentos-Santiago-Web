<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="rutas.jsp"/>
<c:choose>
    <c:when test="${!empty mensajeError}">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="alert alert-danger col-sm-6 mt-5">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>${mensajeError}</strong> 
            </div>
        </div>
        <c:remove var="mensajeError" scope="session" />
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${!empty mensaje}">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="alert alert-danger col-sm-6 mt-5">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>${mensaje}</strong> 
            </div>
        </div>
        <c:remove var="mensaje" scope="session" />
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${!empty mensajeErrorCompra}">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="alert alert-danger col-sm-6 mt-4">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Error</strong> ${mensajeErrorCompra}
            </div>
        </div>
        <c:remove var="mensajeErrorCompra" scope="session" />
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${!empty mensajeCorrectoCompra}">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="alert alert-success col-sm-6 mt-4">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Aviso</strong> ${mensajeCorrectoCompra}
            </div>
        </div>
        <c:remove var="mensajeCorrectoCompra" scope="session" />
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${!empty mensajeCorrecto}">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="alert alert-success col-sm-6 mt-4">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Aviso</strong> ${mensajeCorrecto}
            </div>
        </div>
        <c:remove var="mensajeCorrecto" scope="session" />
    </c:when>
</c:choose>
