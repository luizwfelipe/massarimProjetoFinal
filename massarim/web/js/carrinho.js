document.addEventListener("DOMContentLoaded", function() {
    let cart = [];
    const checkbotao = document.getElementById("checkout");
    const sacola = document.getElementById("sacola");
    const btnAbrir = document.getElementById("bagOpen");
    const btnFechar = document.getElementById("fecharBag");

/* ABRIR MOBILE*/
        const downBaixo = document.getElementById("down-baixo");
        const abrirMenuMobile = document.getElementById("abrir-menu");
        const downFechar = document.getElementById("fechar-down");
    
        abrirMenuMobile.addEventListener("click", function() {
            downBaixo.classList.add("aberto");
        });
    
        downFechar.addEventListener("click", function() {
            downBaixo.classList.remove("aberto");
        });
    
/* fim*/
    btnAbrir.addEventListener("click", function(){
        sacola.classList.add("ativo");
        carregarCarrinho();
    });

    btnFechar.addEventListener("click", function(){
        sacola.classList.remove("ativo");
    });

    function carregarCarrinho(){
        const storedCart = JSON.parse(localStorage.getItem('cart'));
        if (storedCart) {
            cart = storedCart;
        }

        const sacolaContainer = document.getElementById("container-prod");
        sacolaContainer.innerHTML = "";

        if (cart.length === 0){
            const divVazio = document.createElement("div");
            divVazio.classList.add("sacola-vazia");
            divVazio.innerHTML = `<h3>sacola vazia :(</h3>`;
            sacolaContainer.appendChild(divVazio);
            checkbotao.classList.remove("ativo");
        } else {
            cart.forEach((produto, index) => {
                const divP = document.createElement("div");
                divP.classList.add("produto");

                checkbotao.classList.add("ativo");

                const divImg = document.createElement("div");
                divImg.classList.add("container-img");
                divImg.innerHTML = `<img src="${produto.image}" >`;

                const divInfo = document.createElement("div");
                divInfo.classList.add("container-info");

                const divParteCima = document.createElement("div");
                divParteCima.classList.add("parteCima");
                divParteCima.innerHTML = `<h3>${produto.nome}</h3><h3>${produto.tamanho}</h3>`;

                const divParteBaixo = document.createElement("div");
                divParteBaixo.classList.add("parteBaixo");
                divParteBaixo.innerHTML = 
                    `<h4 id="preco">R$ ${produto.preco.toFixed(2)}</h4>
                     <button class="btn-decrementar" data-index="${index}">-</button>
                     <input type="number" name="qtd" class="quantidade" value="${produto.quantidade}" min="1" max="${produto.estoque}" readonly>
                     <button class="btn-incrementar" data-index="${index}">+</button>
                     <button class="botaoTira" data-index="${index}">X</button>`;

                divInfo.appendChild(divParteCima);
                divInfo.appendChild(divParteBaixo);

                divP.appendChild(divImg);
                divP.appendChild(divInfo);

                sacolaContainer.appendChild(divP);

                const inputQuantidade = divParteBaixo.querySelector('input.quantidade');
                const btnDecrementar = divParteBaixo.querySelector('.btn-decrementar');
                const btnIncrementar = divParteBaixo.querySelector('.btn-incrementar');
                const btnDelete = divParteBaixo.querySelector('.botaoTira');

                btnDecrementar.addEventListener('click', function() {
                    const quantidadeAtual = parseInt(inputQuantidade.value);
                    if (quantidadeAtual > 1) {
                        inputQuantidade.value = quantidadeAtual - 1;
                        cart[index].quantidade = quantidadeAtual - 1;
                        atualizarLocalStorage();
                        calculateTotal();
                    }
                });

                btnIncrementar.addEventListener('click', function(){
                    const currentQuantity = parseInt(inputQuantidade.value);
                    if (currentQuantity < produto.estoque) {
                        inputQuantidade.value = currentQuantity + 1;
                        cart[index].quantidade = currentQuantity + 1;
                        atualizarLocalStorage();
                        calculateTotal();
                    }
                });

                btnDelete.addEventListener('click', function(){
                    removeFromCart(index);
                });
            });
        }
        calculateTotal();
    }

    function adicionarItemAoCarrinho(product) {
        const existingProduct = cart.find(item => item.nome === product.nome);

        if(existingProduct){
            const availableQuantity = product.estoque - existingProduct.quantidade;
            if(availableQuantity > 0) {
                const quantityToAdd = Math.min(product.quantidade, availableQuantity);
                existingProduct.quantidade += quantityToAdd;
            }
        } else{
            cart.push(product);
        }

        atualizarLocalStorage();
        carregarCarrinho();
    }

    function removeFromCart(index){
        cart.splice(index, 1);
        atualizarLocalStorage();
        carregarCarrinho();
    }

    function calculateTotal(){
        const total = cart.reduce((conta, atual) => conta + (atual.preco * atual.quantidade), 0);
        document.querySelector('#tt span').textContent = 'R$ ' + total.toFixed(2);
    }

    function atualizarLocalStorage(){
        localStorage.setItem('cart', JSON.stringify(cart));
    }

    const btnAddSac = document.getElementById("addSac");
    if(btnAddSac !== null){
        btnAddSac.addEventListener("click", function(){
            const button =this;
            const product ={
                image: document.querySelector('.imagens img').src,
                nome: document.getElementById('nome-produto').textContent,
                tamanho: document.getElementById('tamanho-produto').textContent,
                preco: parseFloat(document.getElementById('preco-produto').textContent.replace('R$','').trim()),
                quantidade: 1,
                estoque: parseInt(button.getAttribute('data-estoque'))
            };
            adicionarItemAoCarrinho(product);
        });
    }
    
    carregarCarrinho();
});


