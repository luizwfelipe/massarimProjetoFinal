const inputCpf = document.querySelector('#cpf');
const inputTelefone = document.querySelector('#telefone');
const inputDataNascimento = document.querySelector('#dataNascimento');

const btnFecharPop = document.getElementById("h3-fechar");
const popUp = document.getElementById("pop-up-idade");



function cpf(valor){
    valor = valor.replace(/\D/g, ''); 
    if (valor.length > 3) {
        valor = valor.substring(0, 3) + '.' + valor.substring(3);
    }
    if (valor.length > 7) {
        valor = valor.substring(0, 7) + '.' + valor.substring(7);
    }
    if (valor.length > 11) {
        valor = valor.substring(0, 11) + '-' + valor.substring(11);
    }
    
    return valor;
}
function telefone(valor){
    valor = valor.replace(/\D/g, '');
    if (valor.length > 0) {
        if (valor.length === 11 && valor[2] === '9') {
            valor = `(${valor.substring(0, 2)}) ${valor[2]} ${valor.substring(3, 7)}-${valor.substring(7)}`;
        } else {
            valor = `(${valor.substring(0, 2)}) ${valor.substring(2, 7)}-${valor.substring(7)}`;
        }
    }

    return valor;
}


inputCpf.addEventListener('input',()=>{
    let valorAtual = inputCpf.value;
    let cpfok = cpf(valorAtual);

    inputCpf.value = cpfok;
});

inputTelefone.addEventListener('input',()=>{
    let valorAtual = inputTelefone.value;
    let telefoneok = telefone(valorAtual);

    inputTelefone.value = telefoneok;
});

const dataMinima = new Date();
dataMinima.setFullYear(dataMinima.getFullYear() -18);
const datamin = dataMinima.toISOString().slice(0,10);

inputDataNascimento.setAttribute('max', datamin);

inputDataNascimento.addEventListener('input', () =>{
    const dataNascimento = new Date(inputDataNascimento.value);
    const dataLimite = new Date();
    dataLimite.setFullYear(dataLimite.getFullYear()-18);
    if(dataNascimento > dataLimite){
        popUp.classList.add("aberto");
        btnFecharPop.addEventListener("click", function() {
            popUp.classList.remove("aberto");
        });
        inputDataNascimento.value = '';
    }
});
