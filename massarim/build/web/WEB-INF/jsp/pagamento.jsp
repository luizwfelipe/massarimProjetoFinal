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
        <link rel="apple-touch-icon" sizes="180x180" href="assets/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="assets/favicon-16x16.png">
        <link rel="manifest" href="assets/site.webmanifest">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/pagamento.css">
        <title>pagamento * MSSRM</title>
    </head>
    <body>
        <header>
            <a href="./home"><img src="assets/logo-massarim.png" alt="menu"></a>
            <h2>ESCOLHA SUA FORMA DE PAGAMENTO!</h2>
        </header>
        <main>
            <div id="container">
                <div id="tipo-pagamento">
                    <div class="tipo" id="pix-abrir">
                        <h3>pix</h3></div>
                    <div class="tipo" id="credito-abrir">
                        <h3>crédito</h3></div>
                    <div class="tipo" id="debito-abrir" >
                        <h3>débito</h3></div>
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
                    <form action="confirmarPedido" method="post">
                        <input type="hidden" name="endereco-rua" value="${enderecoSelecionado.rua}">
                        <input type="hidden" name="endereco-numero" value="${enderecoSelecionado.numero}">
                        <input type="hidden" name="tipo-pagamento" value="pix">
                        <input type="hidden" name="statusPedido" value="em trânsito">
                        <button type="submit" class="btn-confirmar-compra" id="comprar-pix">confirmar compra</button>
                        </form>
                </div>
                <div id="credito">
                    <div id="titulo-credito">
                        <div id="instrucoes-credito">
                            <h3 id="instrucoes-h3">instruções:</h3>
                            <img src="assets/cartao.svg" alt="dados-cartao-de-credito">
                        </div>

                        <h3>Cartão de crédito</h3>
                    </div>
                    <form action="confirmarPedido" method="post">
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
                     <div class="div-confirmar">
                        <input type="hidden" name="endereco-rua" value="${enderecoSelecionado.rua}">
                        <input type="hidden" name="endereco-numero" value="${enderecoSelecionado.numero}">
                        <input type="hidden" name="tipo-pagamento" value="credito">
                        <input type="hidden" name="statusPedido" value="em trânsito">
                        <button type="submit" class="btn-confirmar-compra" id="comprar-credito">confirmar compra</button>
                    </div>
                    </form>
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
                        <form action="confirmarPedido" method="post">
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
                     <div class="div-confirmar">
                        
                        <input type="hidden" name="endereco-rua" value="${enderecoSelecionado.rua}">
                        <input type="hidden" name="endereco-numero" value="${enderecoSelecionado.numero}">
                        <input type="hidden" name="tipo-pagamento" value="debito">
                        <input type="hidden" name="statusPedido" value="em trânsito">
                        <button type="submit" class="btn-confirmar-compra" id="comprar-debito">confirmar compra</button>
                        
                    </div>
                </form>
                </div>
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
