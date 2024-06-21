<%-- 
    Document   : produto-massarim
    Created on : 06/05/2024, 17:08:31
    Author     : Senai
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
        <link rel="stylesheet" href="styles/produto-massarim.css">
        <title> * MSSRM</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <main>
            <div class="container">
                <div class="imagens">
                    <img src="${produto.imagem}" alt="${produto.nome}">             
                </div>
                <div class="info-prod">
                    <div id="nome-preco">
                        <h1 id="nome-produto">${produto.nome}</h1>
                        <h3 id="preco-produto">R$ ${produto.preco}</h3>
                    </div>
                    <div class="addBag">
                        <button id="addSac" data-idproduto="${produto.idProduto}" data-estoque="${produto.estoque}">COMPRAR</button>
                    </div>
                    <div id="tamanho">
                        <h5 >tamanho: <span id="tamanho-produto">${produto.tamanho}</span></h5>
                    </div>
                    <div class="descricao">
                        <p>${produto.descricao}</p>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>
