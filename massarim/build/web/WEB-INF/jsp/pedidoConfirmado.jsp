<%-- 
    Document   : pedidoConfirmado
    Created on : 16/06/2024, 01:51:13
    Author     : Admin
--%>
<%@page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>agradecemos sua compra! * MSSRM</title>
        <link rel="stylesheet" href="styles/pedidoConfirmado.css">
    </head>
    <body>
        <main>
            <div id="container">
                <img src="assets/concluido.svg" alt="compra confirmada">
                <h1>COMPRA CONCLUÍDA</h1>
                <h3>agradecemos a confiança em nossos serviços</h3>
                <a id="continuar-comprando" href="./home"><button>CONTINUAR COMPRANDO</button></a>
            </div>
        </main>
        <script src="js/instrucao.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    </body>

</html>
