var url = 'http://localhost:8080/World/createmonster';

console.log(url)
fetch(url)
    .then(response => response.json())
    .then (json =>{
        var monsterJSON = json
        console.log(monsterJSON)
})

function Enviar(e){
  e.preventDefault()

  var dados = new Object

  dados.nome = document.getElementById('nameMonster').value
  dados.vida = document.getElementById('lifeMonster').value
  dados.mana = document.getElementById('manaMonster').value
  dados.dano = document.getElementById('damageMonster').value
  dados.habilidade = document.getElementById('skillMonster').value
  dados.imagem = document.getElementById('imageMonster').value

  console.log(dados)

  fetch(url, {
    mode: 'no-cors',
    method:"POST",
    headers:{
      "Content-Type":"application/json; charset=UTF-8"
    },
    body: JSON.stringify(dados)
  })
  .then(response => console.log(response))
  .catch(error => console.log(error))
}