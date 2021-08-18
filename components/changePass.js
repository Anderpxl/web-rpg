var url = 'http://localhost:8080/World/changepass';
console.log(url)

function getInfo(){
    fetch(url)
    .then(response => response.json())
    .then(json => {
        var userJSON = json
        console.log(userJSON)
        userId = json[0]["id"]
    })
    .catch(error => console.log(error))
}

getInfo()

function getId(userId){
    const id = userId

    Enviar(id)
}

function Enviar(id){
    var dados = new Object

    dados.id = id
    dados.senha = document.getElementById("password").value
    dados.senha = document.getElementById("confirmPassword").value

    console.log(dados)

    fetch(`${url}/${id}`,{
        method:"PUT",
        headers:{"Content-Type":"application/json"},
        body: JSON.stringify(dados)
    })
    .then(response => console.log(response))
    .catch(error => console.log(error))
}











































// fetch(url)
//     .then(response => response.json())
//     .then (json => {
//         getJSON(json)
// }).catch(error => console.log(error))
    


// function getJSON(json){
//     const id = json[0]["id"];
//     const userJSON = json
//     console.log(userJSON)

//     Enviar(id)
// }

// function Enviar(id) {
//     // e.preventDefault()
//     var myHeaders = new Headers();
//     myHeaders.append("Content-Type", "application/json");


//     var dados = new Object

//     // dados.id = id
//     dados.senha = document.getElementById("password").value
//     dados.senha = document.getElementById("confirmPassword").value

//     fetch(`${url}/${id}`, {
//         method: 'PUT',
//         body: JSON.stringify(dados),
//         headers: myHeaders
//     })
//         .then(response => console.log(response))
//         .catch(error => console.log('Request failed', error))

//     // document.location.reload(true);
// }

// // function Enviar(id){
// //     // e.preventDefault()
//     // var dados = new Object

//     // dados.id = id
//     // dados.senha = document.getElementById("password").value
//     // dados.senha = document.getElementById("confirmPassword").value

// //     console.log(dados)

// //     fetch(`${url}/${id}`,{
// //         method:"PUT",
// //         body: JSON.stringify(dados),
// //         headers:{"Content-Type":"application/json; charset=UTF-8"},
// //     })
// //     .then(response => console.log(response))
// //     .catch(error => console.log(error))
// // }