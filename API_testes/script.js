const formulario = document.querySelector("form");
const iNome = document.querySelector(".nome");
const iEmail = document.querySelector(".email");
const iSenha = document.querySelector(".senha");
const iTel = document.querySelector(".tel");

function cadastrar(){
    fetch("http://localhost8080/cadastrar",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method:"POST",
            body: JSON.stringify({a: 1, b: 2})
        })
        .then(function(res){console.log(res)})
        .catch(function(res){console.log(res)})
};

formulario.addEventListener('submit', function(event){
    event.preventDefault();
    
    const dados = {
        nome: iNome.value,
        email: iEmail.value,
        senha: iSenha.value,
        telefone: iTel.value
    }
});