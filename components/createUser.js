var url = 'http://localhost:8080/World/createuser';

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

    let life
    let mana
    let capacity
    let nivel
    let skill
    let qtd_item
    
    dados.usuario = document.getElementById('user').value
    dados.senha = document.getElementById('pass').value
    dados.confirmPass = document.getElementById('confirmPass').value
    dados.email = document.getElementById('email').value
    dados.dataNascimento = document.getElementById('date').value
    dados.nome_personagem = document.getElementById('name').value
    dados.classe = document.getElementById('class').value
    dados.deus = document.getElementById('god1').value
    dados.deus = document.getElementById('god2').value
    dados.deus = document.getElementById('god3').value
    dados.sexo = document.getElementById('sex1').checked ? 'Masculino' : 'Feminino'
    dados.historia = document.getElementById('history').value
    dados.grupo_id = document.getElementById('group_id').value

    switch(dados.classe){
        case 1:
            'alchemist' = life = 50, mana = 200, capacity = 24, nivel = 1, skill = 'Invocação inferior', qtd_item = 0
            break
        case 2:
            'archer' = life = 120, mana = 100, capacity = 24, nivel = 1, skill = 'Tiro triplo', qtd_item = 0
            break
        case 3:
            'barbarian' = life = 240, mana = 50, capacity = 24, nivel = 1, skill = 'Arremesso de machado', qtd_item = 0
            break
        case 4:
            'bard' = life = 100, mana = 120, capacity = 24, nivel = 1, skill = 'Som artodoador', qtd_item = 0
            break
        case 5:
            'knight' = life = 220, mana = 70, capacity = 24, nivel = 1, skill = 'Coração de aço', qtd_item = 0
            break        
        case 6:
            'cleric' = life = 150, mana = 100, capacity = 24, nivel = 1, skill = 'Benção divina', qtd_item = 0
            break
        case 7:
            'druid' = life = 40, mana = 220, capacity = 24, nivel = 1, skill = 'Prisão de terra', qtd_item = 0
            break
        case 8:
            'elf' = life = 80, mana = 150, capacity = 24, nivel = 1, skill = 'Invocação de espírito', qtd_item = 0
            break
        case 9: 
            'wizard' = life = 70, mana = 250, capacity = 24, nivel = 1, skill = 'Trovão negro', qtd_item = 0
            break
        case 10:
            'warrior' = life = 200, mana = 80, capacity = 24, nivel = 1, skill = 'Maestria perfeita', qtd_item = 0
            break
        case 11:
            'human' = life = 80, mana = 100, capacity = 24, nivel = 1, skill = 'Malandro', qtd_item = 0
            break
        case 12:
            'rogue' = life = 80, mana = 150, capacity = 24, nivel = 1, skill = 'Indetectável', qtd_item = 0
            break
        case 13:
            'mage' = life = 80, mana = 230, capacity = 24, nivel = 1, skill = 'Bola de fogo', qtd_item = 0
            break
        case 14:
            'half_elf' = life = 100, mana = 100, capacity = 24, nivel = 1, skill = 'Tiro certeiro', qtd_item = 0
            break
        case 15: 
            'monk' = life = 180, mana = 130, capacity = 24, nivel = 1, skill = 'Sino sagrado', qtd_item = 0
            break
        case 16:
            'necromancer' = life = 70, mana = 150, capacity = 24, nivel = 1, skill = 'Invocação de mortos-vivos', qtd_item = 0
            break
        case 17:
            'paladin' = life = 180, mana = 130, capacity = 24, nivel = 1, skill = 'Proteção divina', qtd_item = 0
            break
        case 18:
            'shaman' = life = 80, mana = 150, capacity = 24, nivel = 1, skill = 'Possesão de animais', qtd_item = 0
            break
        default:
            'selecione' = 'Selecione uma classe'
    }

    console.log(dados)
    console.log(dados.classe)
    
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