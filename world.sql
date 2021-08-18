CREATE DATABASE world;
USE world;

CREATE TABLE world.users(
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  grupo_id INT NOT NULL,
  usuario VARCHAR(20) NOT NULL UNIQUE KEY,
  senha VARCHAR(20) NOT NULL,
  email VARCHAR(50) NOT NULL UNIQUE KEY,
  sexo VARCHAR(10) NOT NULL,

  nome_personagem VARCHAR(20) NOT NULL UNIQUE KEY,
  dataNascimento VARCHAR(20) NOT NULL,
  classe VARCHAR(20) NOT NULL,
  deus VARCHAR(20) NOT NULL,

  vida INT NOT NULL,
  mana INT NOT NULL,
  habilidade_unica VARCHAR(200) NOT NULL,
  capacidade INT NOT NULL,
  nivel INT NOT NULL,
  habilidade VARCHAR(200) NOT NULL,
  qtd_item INT NOT NULL,
  item VARCHAR(200) NOT NULL,
  historia VARCHAR(5000) NOT NULL
);

CREATE TABLE world.monsters(
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nome VARCHAR(20) NOT NULL,
  vida INT NOT NULL,
  mana INT NOT NULL,
  dano INT NOT NULL,
  habilidade VARCHAR(200) NOT NULL,
  imagem VARCHAR(500) NOT NULL
);

SELECT * FROM world.users;
SELECT * FROM world.monsters;

SELECT * FROM historico_senhas_emails;

INSERT INTO world.users (grupo_id, usuario, senha, email, sexo, nome_personagem, dataNascimento, classe, deus) VALUES (1,'anderpxl','anderson123','anderpxl@hotmail.com','masculino','Akatosh','1999-04-07','Cavaleiro','Zeus');
INSERT INTO world.users (grupo_id, usuario, senha, email, sexo, nome_personagem, dataNascimento, classe, deus) VALUES (1,'ander123','ander321','ander@hotmail.com','feminino','Alduin','1997-05-07','Mago','Hades');
INSERT INTO world.users (grupo_id, usuario, senha, email, sexo, nome_personagem, dataNascimento, classe, deus) VALUES (1,'kyle','kyle123','kyle@hotmail.com','feminino','Kyle Bellini','1992-01-24','Druida','Poseidon');

UPDATE world.users SET grupo_id = 1, usuario = 'ander123', senha = 'ander321', email = 'ander@hotmail.com', sexo = 'feminino', nome_personagem = 'Alduin', classe = 'Mago', deus = 'Poseidon' WHERE id = 1;

DELETE FROM world.users WHERE id = 1;
DELETE FROM world.users WHERE id = 2;
DELETE FROM world.users WHERE id = 3;

INSERT INTO world.monsters (nome, vida, mana, dano, habilidade, imagem) VALUES ('Troll', 50, 25, 10, 'Sugar energia vital', 'https://static.wikia.nocookie.net/tsrd/images/2/23/Troll.jpg/revision/latest?cb=20180922041504&path-prefix=pt-br');

UPDATE world.monsters SET nome = 'Rei Troll', vida = 120, mana = 100, dano = 60, habilidade='Choque do Trovão', imagem = '' WHERE id = 1;

DELETE FROM world.monsters WHERE id = 1;

CREATE TABLE world.historico_contas(
  id INT AUTO_INCREMENT PRIMARY KEY,
  grupo_id INT,
  usuario VARCHAR(20),
  senha VARCHAR(20),
  email VARCHAR(50),
  sexo VARCHAR(10),
  nome_personagem VARCHAR(20),
  dataNascimento VARCHAR(20),
  classe VARCHAR(20),
  deus VARCHAR(20)
);

DELIMITER $
CREATE TRIGGER tr_usuarios_contas BEFORE DELETE ON users FOR EACH ROW
  BEGIN
    INSERT INTO historico_contas (id, grupo_id, usuario, senha, email, sexo, nome_personagem, dataNascimento, classe, deus) VALUES (OLD.id, OLD.grupo_id, OLD.usuario, OLD.senha, OLD.email, OLD.sexo, OLD.nome_personagem, OLD.dataNascimento, OLD.classe, OLD.deus);
  END$
DELIMITER ;

CREATE TABLE world.historico_senhas_emails(
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario VARCHAR(20),
  senha VARCHAR(20),
  email VARCHAR(20)
);

DELIMITER &
CREATE TRIGGER tr_senhas_emails_usuarios BEFORE UPDATE ON users FOR EACH ROW
  BEGIN
    INSERT INTO historico_senhas_emails (id, usuario, senha, email) VALUES (OLD.id, OLD.usuario, OLD.senha, OLD.email);
  END&
DELIMITER ;