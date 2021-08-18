package rpg.world.model;

import java.util.Date;

public class User {
  private int id;
  private int grupo_id;
  private String usuario;
  private String senha;
  private String email;
  private String sexo;
  private String nome_personagem;
  private String dataNascimento;
  private String classe;
  private String deus;
  private int vida;

  public User(){

  }

  public int getId(){
    return id;
  }
  public void setId(int id){
    this.id = id;
  }
  public int getGrupo_id(){
    return grupo_id;
  }
  public void setGrupo_id(int grupo_id){
	this.grupo_id = grupo_id;
  }
  public String getUsuario(){
    return usuario;
  }
  public void setUsuario(String usuario){
    this.usuario = usuario;
  }
  public String getSenha(){
    return senha;
  }
  public void setSenha(String senha){
    this.senha = senha;
  }
  public String getEmail(){
    return email;
  }
  public void setEmail(String email){
    this.email = email;
  }
  public String getSexo(){
    return sexo;
  }
  public void setSexo(String sexo){
    this.sexo = sexo;
  }
  public String getNome_personagem(){
    return nome_personagem;
  }
  public void setNome_personagem(String nome_personagem){
    this.nome_personagem = nome_personagem;
  }
  public String getDataNascimento() {
	  return dataNascimento;
  }
  public void setDataNascimento(String dataNascimento){
	  this.dataNascimento = dataNascimento;
  }
  public String getClasse(){
    return classe;
  }
  public void setClasse(String classe){
    this.classe = classe;
  }
  public String getDeus(){
    return deus;
  }
  public void setDeus(String deus){
    this.deus = deus;
  }

}