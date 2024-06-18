document.addEventListener('DOMContentLoaded', function () {
    const cepInput = document.getElementById('cep');
    cepInput.addEventListener('input', function () {
        let value = cepInput.value.replace(/\D/g, '');
        if (value.length > 5) {
            value = value.slice(0, 5) + '-' + value.slice(5, 8);
        }
        cepInput.value = value;
    });
    const estados = ["AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"];
    const estadoSelect = document.getElementById('estado');
    estados.forEach(function (estado) {
        let option = document.createElement('option');
        option.value = estado;
        option.textContent = estado;
        estadoSelect.appendChild(option);
    });
});