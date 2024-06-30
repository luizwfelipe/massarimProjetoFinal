<%-- 
    Document   : problemaLogin
    Created on : 03/04/2024, 21:44:53
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
        <link rel="stylesheet" href="styles/erroLogin.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login * MSSRM</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <main>
            <div id="container">
                <img src="assets/naoAutorizado.svg" alt="">
                <h1>Opa... Erro ao efetuar login</h1>
                <h3>Confira seus dados novamente!</h3>
                <a href="./login"><button>Voltar ao Login</button></a>
            </div>
        </main>

    </body>
</html>