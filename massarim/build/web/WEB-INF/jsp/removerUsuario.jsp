<%-- 
    Document   : removerUsuario
    Created on : 16/06/2024, 23:56:36
    Author     : Admin
--%>
<%@page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>remover usuário * MSSRM</title>
    </head>
    <body>
        <h1>REMOVER USUÁRIO</h1>
        <div class="containerUsuario">
            <c:forEach var="usuarios" items="${usuarios}">
                <div class="cartao">
                    <h5 id="id-usuario">identificação: <span>${usuarios.idUsuario}</span></h5>
                    <h5 id="nome-usuario">${usuarios.nome}</h5>
                    <div id="contato-usuario">
                        <p>contatos:</p>
                        <p id="email-usuario">${usuarios.email}</p>
                        <p id="telefone-usuario">${usuarios.telefone}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
