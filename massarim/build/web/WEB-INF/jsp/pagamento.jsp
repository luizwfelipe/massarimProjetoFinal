<%-- 
    Document   : pagamento
    Created on : 13/06/2024, 22:39:19
    Author     : Admin
--%>
<%@page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/72aebe393c.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="styles/pagamento.css">
        <title>pagamento * MSSRM</title>
    </head>
    <body>
        <header></header>
        <main>
            <div id="container">
                <div id="tipo-pagamento">
                    <div class="tipo" id="pix-abrir"><i class="fa-brands fa-pix"  style="color: #616161;"></i>
                        <h3>pix</h3></div>
                    <div class="tipo" id="credito-abrir"><i class="fa-solid fa-credit-card"  style="color: #616161;"></i>
                        <h3>crédito</h3></div>
                    <div class="tipo" id="debito-abrir" ><i class="fa-regular fa-credit-card" style="color: #616161;"></i>
                        <h3>débito</h3></div>
                    <div class="tipo" id="boleto-abrir"><i class="fa-solid fa-barcode"  style="color: #616161;"></i>
                        <h3>boleto</h3></div>
                </div>
                <div id="pix">
                    <div id="parteCima-pix">
                        <div id="pagar-qr">
                            <p>pix qrcode</p>
                            <img src="assets/mssrmqrcode.svg" alt="qrcode-pix">
                        </div>
                        <div id="pagar-pix-code">
                            <p>código pix</p>
                            <div id="code-pix">
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ac tortor vitae purus faucibus ornare suspendisse sed</p>
                            </div>
                            <button id="btn-copiar-pix">copiar código pix</button>
                        </div>
                    </div>
                    <div id="parteBaixo-pix">
                        <div id="intrucoes-pix">
                            <h3>instruções</h3>
                            <p> Abra o aplicativo do seu banco, navegue até a seção de transações instantâneas e selecione a opção para efetuar um pagamento rápido. <br>
                                Agora, é hora de usar a tecnologia: aponte a câmera do seu dispositivo para o QR Code ou copie e cole o código Pix fornecido. <br>
                                Revise atentamente todas as informações apresentadas e, quando estiver tudo certo, confirme o pagamento. <br>
                                Voilà! Assim que a transação for aprovada, seu pedido será automaticamente processado e concluído.</p>
                        </div>
                    </div>
                    <div class="div-confirmar"><button class="btn-confirmar-compra" id="comprar-pix">confirmar compra</button></div>
                </div>
                <div id="credito">
                    <div id="titulo-credito">
                        <div id="instrucoes-credito">
                            <h3 id="instrucoes-h3">instruções:</h3>
                            <img src="assets/cartao.svg" alt="dados-cartao-de-credito">
                        </div>

                        <h3>Cartão de crédito</h3>
                    </div>

                     <div id="area-pagamento-credito">
                        <div class="input-credito">
                            <label for="numero-credito">Número do Cartão</label>
                            <input type="text" name="numero-credito" id="numero-credito" placeholder="Número do Cartão *" required>
                        </div>
                        <div class="input-credito">
                            <label for="nome-credito">Nome no cartão</label>
                            <input type="text" name="nome-credito" id="nome-credito" placeholder="Como está no cartão *" required>
                        </div>
                        <div class="input-credito">
                            <label for="validade-credito">Validade</label>
                            <input type="text" name="validade-credito" id="validade-credito" placeholder="Validade *" required>
                        </div>
                        <div class="input-credito">
                            <label for="cvc-credito">CVC</label>
                            <input type="text" name="cvc-credito" id="cvc-credito" placeholder="CVC do cartão *" required>
                        </div>
                     </div>
                     <div class="div-confirmar"><button class="btn-confirmar-compra" id="comprar-pix">confirmar compra</button></div>
                </div>
                <div id="debito">
                    <div id="titulo-debito">
                        <div id="instrucoes-debito">
                            <h3 id="instrucoes-h3-debito">instruções:</h3>
                            <img src="assets/cartao.svg" alt="dados-cartao-de-debito">
                        </div>
                        <h3>Cartão de débito</h3>
                    </div>

                     <div id="area-pagamento-debito">
                        <div class="input-debito">
                            <label for="numero-debito">Número do Cartão</label>
                            <input type="text" name="numero-debito" id="numero-debito" placeholder="Número do Cartão *" required>
                        </div>
                        <div class="input-debito">
                            <label for="nome-debito">Nome no cartão</label>
                            <input type="text" name="nome-debito" id="nome-debito" placeholder="Como está no cartão *" required>
                        </div>
                        <div class="input-debito">
                            <label for="validade-debito">Validade</label>
                            <input type="text" name="validade-debito" id="validade-debito" placeholder="Validade *" required>
                        </div>
                        <div class="input-debito">
                            <label for="cvc-debito">CVC</label>
                            <input type="text" name="cvc-credidebitoto" id="cvc-debito" placeholder="CVC do cartão *" required>
                        </div>
                     </div>
                     <div class="div-confirmar"><button class="btn-confirmar-compra" id="comprar-pix">confirmar compra</button></div>
                </div>
                <div id="boleto"></div>
            </div>
            <div class="container-pag-end">
                <div class="parteCima">
                    <div id="sacola-pagamento">
                        <h3>produtos:</h3>
                        <div id="sacola-produtos"></div>
                        <hr>
                    </div>

                    <div id="endereco">
                        <h3>endereço: <span>${enderecoSelecionado.rua}, ${enderecoSelecionado.numero}</span></h3>
                        <a href="./endereco">mudar endereço</a>
                    </div>
                    <hr>
                    <div id="totalCompra">total: <span></span></div>
                    

                </div>
                <div id="foto-cortesia">
                    <img src="assets/MassarimMexendo.png" alt="logo-massarim">
                </div>
            </div>
        </main>
        <script src="js/pagamento.js"></script>
    </body>
</html>
