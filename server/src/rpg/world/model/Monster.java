package rpg.world.model;

public class Monster{
  private int id;
  private String nome;
  private int vida;
  private int mana;
  private int dano;
  private String habilidade;
  private String imagem;

  public Monster(){

  }

  public int getId(){
    return id;
  }
  public void setId(int id){
    this.id = id;
  }
  public String getNome(){
    return nome;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
  public int getVida(){
    return vida;
  }
  public void setVida(int vida){
    this.vida = vida;
  }
  public int getMana(){
    return mana;
  }
  public void setMana(int mana){
    this.mana = mana;
  }
  public int getDano(){
    return dano;
  }
  public void setDano(int dano){
    this.dano = dano;
  }
  public String getHabilidade() {
	  return habilidade;
  }
  public void getHabilidade(String habilidade) {
	  this.habilidade = habilidade;
  }
  public String getImagem(){
    return imagem;
  }
  public void setImagem(String imagem){
    this.imagem = imagem;
  }

}