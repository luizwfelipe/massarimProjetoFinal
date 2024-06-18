<%-- 
    Document   : painelAdmin
    Created on : 01/06/2024, 21:58:16
    Author     : Admin
--%>

<%@page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="apple-touch-icon" sizes="180x180" href="assets/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="assets/favicon-16x16.png">
        <link rel="manifest" href="assets/site.webmanifest">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/painel.css">
        <title>PainelADM * MSSRM</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
    <main>
        <div class="container">
            <div id="painel-titulo-img">
                <h1>PAINEL ADMINISTRATIVO</h1>
            </div>
            <div id="botoes"> <!--div para agrupar os botao-->
                <a href="./cadastro-de-administrador"><button class="btn-redireciona">CADASTRAR ADM</button></a>
                <a href="./remover-usuario"><button class="btn-redireciona">REMOVER USUÁRIO</button></a>
                <a href="./cadastrar-produto"><button class="btn-redireciona">CADASTRAR</button></a>
                <a href="#"><button class="btn-redireciona">EXCLUIR</button></a>
            </div>
        </div>
    </main>
    </body>
</html>
