<%-- 
    Document   : cadastro
    Created on : 30/04/2024, 14:27:50
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
        <title>Cadastro * MSSRM</title>
        <link href="styles/cadastroUser.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <section id="pop-up-idade">
            <div id="img-pop">
                <img src="assets/cadastroIdade.png" alt="idade minima: 18 anos">
            </div>
            <div id="fechar-pop">
                <h3 id="h3-fechar">OK</h3>
            </div>
        </section>
        <main>
            <div class="container">
                <div class="image">
                    <img src="assets/massarimMODA.png" alt="">
                </div>
                <div class="form">
                    <form action="cadastrar" method="POST">
                        <h1>Cadastrar</h1>
                        <div class="input">
                            <label for="nome">Nome</label>
                            <input type="text" name="nome" id="nome" placeholder="Digite seu Nome..." required>
                        </div>
                        <div class="input">
                            <label for="senha">Senha</label>
                            <input type="password" name="senha" id="senha" placeholder="Digite sua senha..." required>
                        </div>
                        <div class="input">
                            <label for="email">Email</label>
                            <input type="email" name="email" id="email" placeholder="Digite seu email..." required>
                        </div>
                        <div class="input">
                            <label for="cpf">Cpf</label>
                            <input type="text" name="cpf" id="cpf" placeholder="Digite seu cpf..." required autocomplete="off" maxlength="14">
                        </div>
                        <div class="input">
                            <label for="telefone">Telefone</label>
                            <input type="text" name="telefone" id="telefone" placeholder="Digite seu telefone..." required maxlength="15">
                        </div>
                        <div class="input">
                            <label for="dataNascimento">Data de Nascimento</label>
                            <input type="date" name="dataNascimento" id="dataNascimento" placeholder="Digite sua data de nascimento..." required>
                        </div>
                        <button type="submit" class="btn btn-cadastro btn-block">Cadastre-se</button>
                        <p>Já possui uma conta? <a href="./login">Faça login!</a></p>
                        <p id="maiores-aviso">apenas maiores de 18 anos podem se cadastrar em nosso sistema</p>
                    </form>
                </div>
            </div>
        </main>
        <script src="js/cadastro.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    </body>
</html>
