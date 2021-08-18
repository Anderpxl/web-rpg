var url = 'http://localhost:8080/World/createmonster'

console.log(url)
fetch(url)
  .then(response => response.json())
  .then(json => {
    var monsterJSON = json
    console.log(monsterJSON)
    gerarMonstro()

    let heatlhPoint = monsterJSON[i].vida
    let manaPoint = monsterJSON[i].mana
    // let skill = 
    let damage = 0

    function gerarMonstro() {
      document.getElementById(`cardMonster`).innerHTML = ""
      for (let i = 0; i < monsterJSON.length; i++) {
        document.getElementById(`cardMonster`).innerHTML += `
        <div class="gameContent">
            <div class="cardMonster">
            <div class="cardTitle">
                <h2>${monsterJSON[i].nome}</h2>
            </div>
            <div class="cardImage">
                <img class="imageMonster" src="${monsterJSON[i].imagem}">
            </div>
            <div class="cardInfo">
                <p><span>Vida: </span>${monsterJSON[i].vida}</p>
                <p><span>Mana: </span>${monsterJSON[i].mana}</p>
                <p><span>Dano: </span>${monsterJSON[i].dano}</p>
                <p><span>Habilidades: </span>${monsterJSON[i].habilidade}</p>
            </div>
            </div>
        </div>
        `
      }
    }
  })