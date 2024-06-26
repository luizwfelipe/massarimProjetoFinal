<%-- 
    Document   : cadastroAdm
    Created on : 16/06/2024, 22:55:27
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="apple-touch-icon" sizes="180x180" href="assets/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="assets/favicon-16x16.png">
        <link rel="manifest" href="assets/site.webmanifest">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cadastrar administrador * MSSRM</title>
        <link rel="stylesheet" href="styles/cadastroAdm.css">
        <script src="https://kit.fontawesome.com/72aebe393c.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <main>
            <form action="cadastrarAdministrador" method="POST">
                <h1>Cadastrar</h1>
                <div class="input">
                    <label for="nome">Nome</label>
                    <input type="text" name="nome" id="nome" placeholder="Nome *" required>
                </div>
                <div class="input">
                    <label for="senha">Senha</label>
                    <input type="password" name="senha" id="senha" placeholder="Senha *" required>
                </div>
                <div class="input">
                    <label for="email">Email</label>
                    <input type="email" name="email" id="email" placeholder="Email *" required>
                </div>
                <div class="input">
                    <label for="cpf">Cpf</label>
                    <input type="text" name="cpf" id="cpf" placeholder="CPF" required autocomplete="off" maxlength="14">
                </div>
                <div class="input">
                    <label for="telefone">Telefone</label>
                    <input type="text" name="telefone" id="telefone" placeholder="Telefone *" required maxlength="15">
                </div>
                <div class="input">
                    <label for="dataNascimento">Data de Nascimento</label>
                    <input type="date" name="dataNascimento" id="dataNascimento" placeholder="Digite sua data de nascimento..." required>
                </div>
                <button type="submit" class="btn btn-cadastro btn-block">Cadastrar administrador</button>
            </form>
        </main>
        <h1>CADASTRAR ADMINISTRADOR</h1>
        <div class="form">
            
    </body>
</html>
