document.addEventListener("DOMContentLoaded", function(){
    const sacolaContainer = document.getElementById("container-revisao");

    function carregarCarrinho(){
        const storedCart = JSON.parse(localStorage.getItem('cart'));

        sacolaContainer.innerHTML = "";

        storedCart.forEach((produto,index) => {
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
                const currentQuantity = parseInt(inputQuantidade.value);
                if (currentQuantity > 1) {
                    inputQuantidade.value = currentQuantity - 1;
                    storedCart[index].quantidade = currentQuantity - 1;
                    atualizarLocalStorage(storedCart);
                    calculateTotal(storedCart);
                }
            });

            btnIncrementar.addEventListener('click', function(){
                const currentQuantity = parseInt(inputQuantidade.value);
                if (currentQuantity < produto.estoque) {
                    inputQuantidade.value = currentQuantity + 1;
                    storedCart[index].quantidade = currentQuantity + 1;
                    atualizarLocalStorage(storedCart);
                    calculateTotal(storedCart);
                }
            });

            inputQuantidade.addEventListener('change', function(){
                const newQuantity = parseInt(this.value);
                if (newQuantity <= 0){
                    removeFromCart(index);
                } else if (newQuantity > produto.estoque) {
                    this.value = produto.estoque;
                    storedCart[index].quantidade = produto.estoque;
                } else {
                    storedCart[index].quantidade = newQuantity;
                }
                atualizarLocalStorage(storedCart);
                calculateTotal(storedCart);
            });

            btnDelete.addEventListener('click', function(){
                removeFromCart(index);
            });
        });

        calculateTotal(storedCart);
    }
    function removeFromCart(index){
        let cart = JSON.parse(localStorage.getItem('cart'));
        cart.splice(index, 1);
        atualizarLocalStorage(cart);
        carregarCarrinho();
    }
    function calculateTotal(cart){
        const total = cart.reduce((acc, curr)=>acc+(curr.preco *curr.quantidade), 0);
        document.querySelector('#tt-revisao span').textContent = 'R$ ' + total.toFixed(2);
    }
    function atualizarLocalStorage(cart){
        localStorage.setItem('cart', JSON.stringify(cart));
    }
    carregarCarrinho();
});
