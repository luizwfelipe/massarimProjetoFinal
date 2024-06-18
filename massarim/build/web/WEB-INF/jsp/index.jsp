
<%@page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <link rel="apple-touch-icon" sizes="180x180" href="assets/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="assets/favicon-16x16.png">
        <link rel="manifest" href="assets/site.webmanifest">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/index.css">
        <title>home * MSSRM</title>
    </head>

    <body>
            <jsp:include page="header.jsp"></jsp:include>

    <main>
        <section>
            <img src="assets/massarim-fundo-home (1).png" alt="">
        </section>
            <div class="containerProduto">
                <c:forEach var="produtos" items="${produto}">
                
                <div class="cartao">
                    <a href="./produto-massarim?focado=${produtos.idProduto}">
                    <div class="imagemProduto">
                        <img src="${produtos.imagem}" alt="${produtos.nome}">
                    </div>
                    <div class="cartao-info">
                        <h5 class="nome-produto">${produtos.nome}</h5>
                        <p class="preco-produto">R$ ${produtos.preco}</p>
                    </div>
                </div>
                    </a>
                </c:forEach>
            </div>
                

    </main>
    <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
