document.addEventListener("DOMContentLoaded", function() {
    const btnContinuarCompra = document.getElementById("continuar-comprando");
    const btnHistorico = document.getElementById("historico");
    historico
    //o then e o preventdefault serve para garantir que só irá trocar de tela após o usuário clicar em OK
    btnContinuarCompra.addEventListener("click", function(event){
        event.preventDefault();
        btnHistorico.classList.add("aviso");
        Swal.fire({
            title: "Compra Confirmada!",
            text: "Agora o senhor(a) pode ver o status do seu pedido no icone de tempo acima!",
            icon: "info"
        }).then(()=>{
            window.location.href = btnContinuarCompra.href;
        });
    });
});