document.addEventListener("DOMContentLoaded", function() {
    const botaoPix = document.getElementById("pix-abrir");
    const botaoCredito = document.getElementById("credito-abrir");
    const botaoDebito = document.getElementById("debito-abrir");
    const botaoConfirmar = document.getElementsByClassName("btn-confirmar-compra");

    const pix = document.getElementById("pix");
    const credito = document.getElementById("credito");
    const debito = document.getElementById("debito");

    botaoPix.addEventListener("click",function(){
        pix.classList.add("ativo");
        credito.classList.remove("ativo");
        debito.classList.remove("ativo");  
    });

    botaoCredito.addEventListener("click", function(){
        credito.classList.add("ativo");
        pix.classList.remove("ativo");
        debito.classList.remove("ativo");  
    });

    botaoDebito.addEventListener("click", function() {
        credito.classList.remove("ativo");
        pix.classList.remove("ativo");
        debito.classList.add("ativo");        
    });

    let cart = [];
    const sacolaContainer = document.getElementById("sacola-produtos");

    function carregarCarrinho() {
        const storedSacola = JSON.parse(localStorage.getItem('cart'));
        if (storedSacola) {
            cart = storedSacola;
        }

        sacolaContainer.innerHTML = "";

        if (cart.length === 0){
            const divVazio = document.createElement("div");
            divVazio.classList.add("sacola-vazia");
            divVazio.innerHTML = `<h3>sacola vazia :(</h3>`;
            sacolaContainer.appendChild(divVazio);
        }else{
            cart.forEach(produto => {
                const divP = document.createElement("div");
                divP.classList.add("produto");
                const divImg = document.createElement("div");
                divImg.classList.add("container-img");
                divImg.innerHTML = `<img src="${produto.image}" >`;

                const divInfo = document.createElement("div");
                divInfo.classList.add("container-info");
                const divParteCima = document.createElement("div");
                divParteCima.classList.add("parteCima");
                divParteCima.innerHTML = `<h3>${produto.nome}</h3>`;
                const divParteBaixo = document.createElement("div");
                divParteBaixo.classList.add("parteBaixo");
                const totalProdutoUnico = produto.quantidade * produto.preco;
                divParteBaixo.innerHTML = `<h4 id="preco">R$ ${produto.preco.toFixed(2)}</h4>
                <h4 id="quantidade">Quantidade: <span> ${produto.quantidade}</span></h4>
                <h4 id="totalUnico">Total:<span> R$ ${totalProdutoUnico.toFixed(2)}</span></h4>`;
                divInfo.appendChild(divParteCima);
                divInfo.appendChild(divParteBaixo);
                divP.appendChild(divImg);
                divP.appendChild(divInfo);
                sacolaContainer.appendChild(divP);
            });
        }
        calcularTotal();
    }

    function calcularTotal() {
        const total = cart.reduce((conta, atual) => conta + (atual.preco * atual.quantidade), 0);
        document.querySelector('#totalCompra span').textContent = 'R$ ' + total.toFixed(2);
    }

    function limparCarrinho() {
        cart = [];
        localStorage.setItem('cart', JSON.stringify(cart));
        carregarCarrinho();
    }
    document.querySelectorAll('form').forEach(form => {
        form.addEventListener('submit', function(event) {
            event.preventDefault();
            if (form.checkValidity()) {
                limparCarrinho();
                form.submit();
            } else {
                form.reportValidity();
            }
        });
    });

    carregarCarrinho();

    //validar inputs e mascarás abaixo
    function aplicarMascarasEValidacoes() {
        const numeroCredito = document.getElementById('numero-credito');
        const nomeCredito = document.getElementById('nome-credito');
        const validadeCredito = document.getElementById('validade-credito');
        const cvcCredito = document.getElementById('cvc-credito');
        const numeroDebito = document.getElementById('numero-debito');
        const nomeDebito = document.getElementById('nome-debito');
        const validadeDebito = document.getElementById('validade-debito');
        const cvcDebito = document.getElementById('cvc-debito');

        function mascaraCartao(input) {
            input.addEventListener('input',function(e) {
                let value = e.target.value.replace(/\D/g, '');
                if (value.length > 16) value = value.substring(0,16);
                value = value.replace(/(\d{4})(?=\d)/g, '$1 ');
                e.target.value = value;
            });
        }

        function validarNome(input){
            input.addEventListener('input',function(e){
                const regex = /^[A-Za-z]+ [A-Za-z]+$/;
                if (!regex.test(e.target.value)) {
                    input.setCustomValidity("nome deve conter pelo menos um espaço.");
                } else {
                    input.setCustomValidity("");
                }
            });
       }

        function mascaraValidade(input){
            input.addEventListener('input', function(e) {
                let value = e.target.value.replace(/\D/g, '');
                if (value.length >= 2) {
                    value = value.substring(0, 2) + '/' + value.substring(2, 4);
                }
                e.target.value = value.substring(0, 5);
            });
            input.addEventListener('blur',function(e) {
                const [mes, ano] = e.target.value.split('/');
                const dataAtual = new Date();
                const mesAtual = dataAtual.getMonth() + 1;
                const anoAtual = dataAtual.getFullYear() % 100;
                if ((parseInt(ano) < anoAtual) || (parseInt(ano) === anoAtual && parseInt(mes) < mesAtual)) {
                    input.setCustomValidity("data de validade deve ser no futuro");
                } else {
                    input.setCustomValidity("");
                }
            });
        }

        function mascaraCVC(input){
            input.addEventListener('input', function(e) {
                let value = e.target.value.replace(/\D/g, '');
                e.target.value =value.substring(0, 3);
            });
        }

        mascaraCartao(numeroCredito);
        validarNome(nomeCredito);
        mascaraValidade(validadeCredito);
        mascaraCVC(cvcCredito);
        mascaraCartao(numeroDebito);
        validarNome(nomeDebito);
        mascaraValidade(validadeDebito);
        mascaraCVC(cvcDebito);
    }

    aplicarMascarasEValidacoes();
});
