<%-- 
    Document   : header
    Created on : 04/05/2024, 11:22:34
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<% 
//AQUI EU CONFIRO SE O USUÁRIO ESTÁ LOGADO
    HttpServletRequest require = (HttpServletRequest) request;
    Cookie[] cookies = require.getCookies();
    boolean logado = false;
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("logar".equals(cookie.getName())) {
                logado = true;
                break;
            }
        }
    }
%>
<%
    //AQUI EU FAÇO A CONFERÊNCIA DE ADMINISTRADOR (CASO FOR ADM, APARECER LINK DO PAINEL)
    HttpServletRequest requireAdm = (HttpServletRequest) request;
    Cookie[] cookieAdministrativo = requireAdm.getCookies();
    boolean logarAdministativo = false;
    if (cookieAdministrativo != null) {
        for (Cookie cookieAdm : cookieAdministrativo) {
            if ("logarAdministrador".equals(cookieAdm.getName())) {
                logarAdministativo = true;
                break;
            }
        }
    }
%>    

<!DOCTYPE html>
<html>
    <head>
        <link rel="apple-touch-icon" sizes="180x180" href="assets/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="assets/favicon-16x16.png">
        <link rel="manifest" href="assets/site.webmanifest">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/header.css">
        <script src="https://kit.fontawesome.com/72aebe393c.js" crossorigin="anonymous"></script>
        <title>header</title>
    </head>
    <body>
        <header class="header">
                <div class="up">
                    <c:choose>
                        <c:when test="<%=logarAdministativo%>">
                            <a id="painel-adm" href="./painel-adm">PAINEL ADMINISTRADOR</a>
                        </c:when>
                        <c:otherwise>
                            <p>ENVIO PARA TODO O BRASIL</p>
                        </c:otherwise>
                     </c:choose>

                    <div class="user-bag">
                        <div class="user">
                            <c:choose>
                                <c:when test="<%=logado%>">
                                    <div id="div-logado">
                                        <a id="historico" href="./historico-pedidos"><i class="fa-solid fa-clock" style="color: #dfdfdf;"></i></a><a id="deslogar" href="./logout">Deslogar</a>
                                    </div>
                                    
                                    
                                </c:when>
                                <c:otherwise>
                                    <a href="./login"><i class="fa-solid fa-user" style="color: #dfdfdf;"></i></a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                       <div id="bag"><i class="fa-solid fa-bag-shopping" id="bagOpen" style="color: #dfdfdf;"></i></div>
                    </div>
                </div>
                <div class="down">
                    <div id="down-cima">
                        <div class="logo">
                            <a href="./home"><img src="assets/logo-massarim.png" alt="menu"></a>
                        </div>
                        <div id="abrir-menu">
                            <i class="fa-solid fa-bars" style="color: #202020;"></i>
                        </div>
                    </div>
                    <div id="down-baixo">
                        <div id="fechar-down"><h3>X</h3></div>
                        <div class="categorias">
                        <c:forEach items="${categorias}" var="categoria" >
                            <a href="./buscar-produtos?cat=${categoria.idCategorias}&busca=">${categoria.nome}</a>
                        </c:forEach>
                    </div>
                    <div class="search">
                        <form class="d-flex" action="buscar-produtos" method="get">
                            <input class="busca" type="search" name="busca" placeholder="Buscar" aria-label="Search">
                            <button class="btnPesquisa" type="submit"><i class="fa-solid fa-magnifying-glass" style="color: #202020;"></i></button>
                        </form>
                    </div>
                </div>
                    
                </div>
        </header>

        <div id="sacola">
            
            <div id="bg-bag">
                
            </div>
            <div id="container-bag">
                <div class="head-bag">
                    <h3 id="titulo">sacola</h3>
                    <button id="fecharBag">X</button>
                </div>
                <div id="container-prod"></div>
                <div class="foot-bag">
                    <p id="tt">Total: <span>R$0,0</span></p>
                    <button id="checkout"><a href="./revisao">checkout</a></button>
                </div>
            </div>
        </div>
        <script src="js/carrinho.js"></script>
    </body>
</html>
