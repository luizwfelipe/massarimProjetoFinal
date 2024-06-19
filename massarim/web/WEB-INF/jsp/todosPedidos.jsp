<%-- 
    Document   : todosPedidos
    Created on : 19/06/2024, 04:05:56
    Author     : Admin
--%>

<%@page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/72aebe393c.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="styles/historico-todos.css">
        <title>pedidos * MSSRM</title>
    </head>
    <body>
        <main>
            <div id="container">
                <div>
                    <h2>pedidos</h2>
                </div>
                <div id="container-pedido">
                    <c:forEach var="pedido" items="${pedidos}">
                        <div class="pedido-unico">
                            <h5>endereço: <span>${pedido.rua}, ${pedido.numero}</span></h5>
                            <h5>tipo de pagamento: <span>${pedido.tipoPagamento}</span></h5>
                            <h5>status: <span>${pedido.statusPedido}</span></h5>
                            <form action="atualizarPedido" method="post">
                                <input type="hidden" name="idPedido" value="${pedido.idPedido}">
                                <input type="hidden" name="statusPedido" value="pedido entregue">
                                <button type="submit" class="btn-confirmar" id="atualizarStatus">
                                    <i class="fa-solid fa-pen" style="color: #f2f2f2;"></i>
                                </button>
                            </form>
                            
                        </div>
                    </c:forEach>
                </div> 
        </div>
        </main>
        
    </body>
</html>
