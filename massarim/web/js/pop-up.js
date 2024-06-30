document.addEventListener("DOMContentLoaded", function() {
    const btnFecharPop = document.getElementById("h3-fechar");
    const popUp = document.getElementById("pop-up");

    setInterval(function() {
        popUp.classList.add("aberto");
    },20000);  //20000
    btnFecharPop.addEventListener("click", function() {
        popUp.classList.remove("aberto");
    });
});