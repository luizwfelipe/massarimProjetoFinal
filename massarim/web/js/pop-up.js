document.addEventListener("DOMContentLoaded", function() {
    const btnFecharPop = document.getElementById("h3-fechar");
    const popUp = document.getElementById("pop-up");

    setInterval(function() {
        popUp.classList.add("aberto");
    },40000);  //20000= para deixar 20 segundos
    btnFecharPop.addEventListener("click", function() {
        popUp.classList.remove("aberto");
    });
});