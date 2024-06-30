<%-- 
    Document   : todosPedidos
    Created on : 15/06/2024, 20:08:23
    Author     : Admin
--%>

<%@page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="styles/revisao.css">
        <title>revisão * MSSRM</title>
    </head>
    <body>
        <header>
            <link rel="apple-touch-icon" sizes="180x180" href="assets/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="assets/favicon-16x16.png">
        <link rel="manifest" href="assets/site.webmanifest">
            <a href="./home"><img src="assets/logo-massarim.png" alt="menu"></a>
            <h2>REVISE SUA COMPRA</h2>
        </header>
        
        <main>
            <div id="revisao-sacola">
                <div id="container-revisao">
                    <h2 id="titulo-produtos">seus produtos</h2>
                </div>
                <div class="confirmar-revisao">
                    <h3 class="info-confirmar" id="resumo-pedido">resumo do pedido</h3>
                    <p class="info-confirmar" id="tt-revisao">produtos: <span>R$ 0,0</span></p>
                    <h3 class="info-confirmar" id="frete-revisao">frete: <span>grátis</span></h3>

                    <hr>
                    <h3 class="info-confirmar" id="total-pedido">total do pedido: <span>R$0,0</span></h3>
                    <a href="./endereco"><button id="confirmarCompra">continuar checkout</button></a>
                    <a href="./home">adicionar mais produtos</a>
                </div>
            </div>
            <div id="cep">
                <label for="cep-destino">cep de destino</label>
                <div id="input-cep">
                    <input type="text" id="cep-destino" placeholder="insira o cep">
                    <button id="calcularFrete">calcular frete</button>
                </div>
            </div>


        </main>
        <jsp:include page="footer.jsp"></jsp:include>
        <script src="js/revisao.js"></script>
    </body>
</html>
