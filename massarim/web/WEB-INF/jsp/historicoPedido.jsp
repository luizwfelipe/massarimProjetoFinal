<%-- 
    Document   : historicoPedido
    Created on : 19/06/2024, 02:51:12
    Author     : Admin
--%>

<%@page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="apple-touch-icon" sizes="180x180" href="assets/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="assets/favicon-16x16.png">
        <link rel="manifest" href="assets/site.webmanifest">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/72aebe393c.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="styles/historico-pedido.css">
        <title>histórico * MSSRM</title>
    </head>
    <jsp:include page="header.jsp"></jsp:include>
    <body>
        <main>
            <div id="container">
                <div>
                    <h2>seus pedidos</h2>
                </div>
                <div id="container-pedido">
                    <c:forEach var="pedido" items="${pedidos}">
                        <div class="pedido-unico">
                            <h5>endereço: <span>${pedido.rua}, ${pedido.numero}</span></h5>
                            <h5>tipo de pagamento: <span>${pedido.tipoPagamento}</span></h5>
                            <h5>status: <span>${pedido.statusPedido}</span></h5>
                        </div>
                    </c:forEach>
                </div> 
            </div>
            
        </main>
       
    </body>
</html>
