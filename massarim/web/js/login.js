const form = document.getElementById("form");

form.addEventListener("submit",function(event){
    event.preventDefault();

    const email = document.getElementById("email").value.trim();
    const senha = document.getElementById("senha").value.trim();

    if(email ==="" || senha === ""){
        alert("Usuário e Senha não preenchidos!");
    }else{
        form.onsubmit();
    }
})