<%-- 
    Document   : cadastroAdm
    Created on : 16/06/2024, 22:55:27
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cadastrar administrador * MSSRM</title>
    </head>
    <body>
        <h1>CADASTRAR ADMINISTRADOR</h1>
        <div class="form">
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
    </body>
</html>
