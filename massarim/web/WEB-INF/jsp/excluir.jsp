<%-- 
    Document   : excluir
    Created on : 18/06/2024, 21:18:04
    Author     : Admin
--%>

<%@page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>excluir * MSSRM</title>
        <link rel="stylesheet" href="styles/remover-produto.css">
        <script src="https://kit.fontawesome.com/72aebe393c.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <main>
            <div id="container-produto">
                <div id="dados-produto">
                    <div id="imagem-dados">
                        <h4>IMAGEM</h4>
                    </div>
                    <div id="outros-dados">
                        <h4>IDENTIFICAÇÃO</h4>
                        <h4>NOME</h4>
                        <h4>ESTOQUE</h4>
                        <h4>PREÇO</h4>
                        <h4>AÇÃO</h4>
                    </div>
                </div>
                <c:forEach var="produtos" items="${produto}">
                    <div id="cartao-produto">
                        <div id="imagemProduto">
                          <img src="${produtos.imagem}" alt="${produtos.nome}">             
                        </div>
                        <div class="cartao-info">
                            <h5 id="id-produto">${produtos.idProduto}</h5>
                            <h5 id="nome-produto">${produtos.nome}</h5>
                            <h5 id="nome-produto">${produtos.estoque}</h5>
                            <h5 id="preco-produto">R$ ${produtos.preco}</h5>
                            <form action="excluirProduto" method="post">
                                <input type="hidden" name="idProduto" value="${produtos.idProduto}">
                                <button type="submit" id="btn-excluir-prod" name="btn-excluir-prod">
                                    <i class="fa-solid fa-trash" style="color: #202020;"></i>
                                </button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div id="container-categoria">
                <div id="cartao-cat-info">
                    <h4>ID</h4>
                    <h4>NOME</h4>
                    <h4>AÇÃO</h4>
                </div>
                <c:forEach items="${categorias}" var="categoria" >
                    <div id="cartao-categoria">
                        <h5>${categoria.idCategorias}</h5>
                        <h5>${categoria.nome}</h5>
                        <form action="excluirCategoria" method="post">
                            <input type="hidden" name="idCategorias" value="${categoria.idCategorias}">
                            <button type="submit" id="btn-excluir-cat" name="btn-excluir-cat">
                                <i class="fa-solid fa-trash" style="color: #202020;"></i>
                            </button>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </main>
    </body>
</html>
