<%-- 
    Document   : endereco
    Created on : 12/06/2024, 00:55:22
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="styles/endereco.css">
    <title>endereço * MSSRM</title>
</head>
<body>
    <header></header>
    <main>
        <div class="container">
            <div id="cima">
                <div id="endereco-existente">
                    <h3>selecione um endereço existente:</h3>
                    <div id="enderecos">
                        <c:forEach var="endereco" items="${enderecos}">
                            <div class="endereco-unico">
                                <div id="endereco-esquerda">
                                    <h3 id="endereco-cep">cep: <span>${endereco.cep}</span></h3>
                                    <h3 id="endereco-rua">rua: <span>${endereco.rua}</span></h3>
                                    <h3 id="endereco-numero">numero: <span>${endereco.numero}</span></h3>
                                </div>
                                <div id="endereco-meio">
                                    <h3 id="endereco-complemento">complemento: <span>${endereco.complemento}</span></h3>
                                    <h3 id="endereco-referencia">referência: <span>${endereco.referencia}</span></h3>
                                </div>

                                <div id="endereco-direita">
                                    <h3 id="endereco-bairro">bairro: <span>${endereco.bairro}</span></h3>
                                    <h3 id="endereco-cidade">cidade: <span>${endereco.cidade}</span></h3>
                                    <h3 id="endereco-estado">estado: <span>${endereco.estado}</span></h3>
                                </div>   
                                <div id="escolha-endereco">
                                    <form action="escolherEndereco" method="post">
                                        <input type="hidden" name="rua" value="${endereco.rua}">
                                        <input type="hidden" name="numero" value="${endereco.numero}">
                                        <button type="submit">escolher</button>
                                    </form>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div id="baixo">
                <div id="formulario">
                    <div class="novo-end">
                        <h3>crie um novo endereço abaixo</h3>
                        <h4>novo endereço</h4>
                    </div>
                    <form action="cadastrarEndereco" id="form-method" method="post">
                        <div id="inputs-lados">
                            <div id="inputs-esquerda">
                                <div class="input">
                                    <label for="cep">CEP</label>
                                    <input type="text" name="cep" id="cep" placeholder="CEP do local" required>
                                </div>
                                <div class="input">
                                    <label for="rua">Rua</label>
                                    <input type="text" name="rua" id="rua" placeholder="Qual a rua?" required>
                                </div>
                                <div class="input">
                                    <label for="numero">Número</label>
                                    <input type="number" name="numero" id="numero" placeholder="Digite o número da residência" required>
                                </div>
                                <div class="input">
                                    <label for="complemento">Complemento</label>
                                    <input type="text" name="complemento" id="complemento" placeholder="Possui complemento?" required>
                                </div>
                            </div>
                            <div id="inputs-direita">
                                <div class="input">
                                    <label for="referencia">Referência</label>
                                    <input type="text" name="referencia" id="referencia" placeholder="Você possui alguma referência?" required>
                                </div>
                                <div class="input">
                                    <label for="bairro">Bairro</label>
                                    <input type="text" name="bairro" id="bairro" placeholder="Qual o bairro?" required>
                                </div>
                                <div class="input">
                                    <label for="cidade">Cidade</label>
                                    <input type="text" name="cidade" id="cidade" placeholder="Qual a cidade?" required>
                                </div>
                                <div class="input">
                                    <label for="estado">Estado</label>
                                    <select name="estado" id="estado" required>
                                        <option value="" disabled selected>Selecione o estado</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <button type="submit" class="btn-endereco">cadastrar endereço</button>
                    </form>
                </div>
            </div>
        </div>
    </main>
    <script src="js/endereco.js"></script>
</body>
</html>
