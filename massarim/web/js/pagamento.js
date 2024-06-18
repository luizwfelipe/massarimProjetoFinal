document.addEventListener("DOMContentLoaded", function(){
    const botaoPix = document.getElementById("pix-abrir");
    const botaoCredito = document.getElementById("credito-abrir");
    const botaoDebito = document.getElementById("debito-abrir");

    botaoPix.addEventListener("click", function(){
        pix.classList.add("ativo");
        credito.classList.remove("ativo");
        debito.classList.remove("ativo");  
    });

    botaoCredito.addEventListener("click", function(){
        credito.classList.add("ativo");
        pix.classList.remove("ativo");
        debito.classList.remove("ativo");  
    });

    botaoDebito.addEventListener("click", function(){
        credito.classList.remove("ativo");
        pix.classList.remove("ativo");
        debito.classList.add("ativo");        
    });

    let cart = [];
    const sacolaContainer = document.getElementById("sacola-produtos");

    function carregarCarrinho(){
        const storedCart = JSON.parse(localStorage.getItem('cart'));
        if (storedCart) {
            cart = storedCart;
        }

        sacolaContainer.innerHTML = "";

        if (cart.length === 0){
            const divVazio = document.createElement("div");
            divVazio.classList.add("sacola-vazia");
            divVazio.innerHTML = `<h3>sacola vazia :(</h3>`;
            sacolaContainer.appendChild(divVazio);
        } else {
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
        calculateTotal();
    }

    function calculateTotal(){
        const total = cart.reduce((acc, curr)=>acc+(curr.preco*curr.quantidade),0);
        document.querySelector('#totalCompra span').textContent = 'R$ '+ total.toFixed(2);
    }
    carregarCarrinho();
});
