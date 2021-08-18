var url = 'http://localhost:8080/World/changeemail/';
var id = 'conta logada'

console.log(url)
fetch(url)
    .then(response => response.json())
    .then (json =>{
        var userJSON = json
        console.log(userJSON)
})

function Enviar(e){
    e.preventDefault()
    var dados = new Object
    
    dados.email = document.getElementById('email').value
    dados.email = document.getElementById('confirmEmail').value

    console.log(dados)
    
    fetch(url, {
        mode: 'no-cors',
        method:"PUT",
        headers:{
            "Content-Type":"application/json; charset=UTF-8"
        },
        body: JSON.stringify(dados)
        
    })
        .then((response)=> {alert(response.JSON)}).catch((error) =>{
        console.log(error)
    })
    
}