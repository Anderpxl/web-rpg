package rpg.world.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rpg.world.model.Monster;
import rpg.world.model.User;

public class World {

  private String stringConexao = "jdbc:mysql://localhost/world?useTimezone=true&serverTimezone=UTC";
  private String usuario = "root";
  private String senha = "root";

  private Connection conexao = null;

  public boolean conectar() {
    try {
      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
      conexao = DriverManager.getConnection(stringConexao, usuario, senha);
      return true;
    } catch (SQLException error1) {
      return false;
    }
  }

  public boolean novoUsuario(User usuario) {
    if(conectar()) {
      String sql = "INSERT INTO world.users (grupo_id, usuario, senha, email, sexo, nome_personagem, dataNascimento, classe, deus) "
    		  	+ "VALUES("+ usuario.getGrupo_id()
      				+ ", '"+ usuario.getUsuario()
					+ "', '"+ usuario.getSenha()
					+ "', '"+ usuario.getEmail()
					+ "', '"+ usuario.getSexo()
					+ "', '"+ usuario.getNome_personagem()
					+ "', '"+ usuario.getDataNascimento()
					+ "', '"+ usuario.getClasse()
					+ "', '"+ usuario.getDeus() +"')";

      try {
        Statement acaoSql = conexao.createStatement();
        acaoSql.execute(sql);
      } catch (SQLException error2) {
        return false;
      }
      return true;
    } else {
      return false;
    }
  }

  public boolean alterarSenha(User usuario){
    if(conectar()) {
      String sql = " UPDATE world.users "
                  +" SET senha = ?"
                  +" WHERE id = ?";
      
      try {
        PreparedStatement acaoSql = conexao.prepareStatement(sql);
        acaoSql.setString(1, usuario.getSenha());
        acaoSql.setInt(2, usuario.getId());
        acaoSql.executeUpdate();
        return true;
      } catch (SQLException error3) {
        return false;
      }
    }
    return false;
  }

  public boolean alterarEmail(User usuario){
    if(conectar()) {
      String sql = " UPDATE world.users "
                  +" SET email = ?"
                  +" WHERE id = ?";
      
      try {
        PreparedStatement acaoSql = conexao.prepareStatement(sql);
        acaoSql.setString(1, usuario.getEmail());
        acaoSql.setInt(2, usuario.getId());
        acaoSql.executeUpdate();
        return true;
      } catch (SQLException error4){
        return false;
      }
    }
    return false;
  }
  
  public User buscarUserPorId(int id) {
		if(conectar()) {
			String sql = "SELECT id, grupo_id, usuario, senha, email, sexo, nome_personagem, dataNascimento, classe, deus FROM world.users WHERE id = "+ id;
			try {
			Statement acaoSql = conexao.createStatement();
			acaoSql.execute(sql);
			acaoSql.executeQuery(sql);
				
			ResultSet rs = acaoSql.getResultSet();
				
			if(rs.next()) {
				User usuario = new User();
				
				usuario.setId(rs.getInt("id"));
				usuario.setGrupo_id(rs.getInt("grupo_id"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setNome_personagem(rs.getString("nome_personagem"));
				usuario.setDataNascimento(rs.getString("dataNascimento"));
				usuario.setClasse(rs.getString("classe"));
				usuario.setDeus(rs.getString("deus"));
					
				return usuario;
			}
			return null;
		} catch(SQLException error10) {
		return null;
		}
	}
	return null;
  }

  public List<User> listarUsuarios() {
    if(conectar()) {
      String sql = "SELECT id, grupo_id, usuario, senha, email, sexo, nome_personagem, dataNascimento, classe, deus FROM world.users";
      List<User> lista = new ArrayList<User>();
      try{
        Statement acaoSql = conexao.createStatement();
        acaoSql.execute(sql);

        ResultSet rs = acaoSql.getResultSet();
        while(rs.next()) {
          User usuario = new User();

          usuario.setId(rs.getInt("id"));
          usuario.setGrupo_id(rs.getInt("grupo_id"));
          usuario.setUsuario(rs.getString("usuario"));
          usuario.setSenha(rs.getString("senha"));
          usuario.setEmail(rs.getString("email"));
          usuario.setSexo(rs.getString("sexo"));
          usuario.setNome_personagem(rs.getString("nome_personagem"));
          usuario.setDataNascimento(rs.getString("dataNascimento"));
          usuario.setClasse(rs.getString("classe"));
          usuario.setDeus(rs.getString("deus"));

          lista.add(usuario);
        }
      } catch (SQLException error5) {
        return null;
      }
      return lista;
    }
    return null;
  }

  public boolean excluirUsuario(int id){
    if(conectar()) {
      String sql = "DELETE FROM world.users WHERE id = "+ id;
      try {
        Statement acaoSql = conexao.createStatement();
        acaoSql.execute(sql);
        acaoSql.executeUpdate(sql);
        return true;
      } catch (SQLException error6) {
        return false;
      }
    }
    return false;
  }

  public List<User> listarJogadores() {
    if(conectar()) {
      String sql = "SELECT nome_personagem, sexo, classe, deus FROM world.users";
      List<User> lista = new ArrayList<User>();
      try{
        Statement acaoSql = conexao.createStatement();
        acaoSql.execute(sql);

        ResultSet rs = acaoSql.getResultSet();
        while(rs.next()) {
          User jogador = new User();

          jogador.setNome_personagem(rs.getString("nome_personagem"));
          jogador.setSexo(rs.getString("sexo"));
          jogador.setClasse(rs.getString("classe"));
          jogador.setDeus(rs.getString("deus"));

          lista.add(jogador);
        }
      } catch (SQLException error7) {
        return null;
      }
      return lista;
    }
    return null;
  }

  public boolean novoMonstro(Monster monstro) {
    if(conectar()) {
      String sql = "INSERT INTO world.monsters (nome, vida, mana, dano, habilidade, imagem) "
                + "VALUES('"+ monstro.getNome()
					+ "', "+ monstro.getVida()
					+ ", "+ monstro.getMana()
					+ ", "+ monstro.getDano()
					+ ", "+ monstro.getHabilidade()
					+ ", '"+ monstro.getImagem() +"')";

      try {
        Statement acaoSql = conexao.createStatement();
        acaoSql.execute(sql);
      } catch (SQLException error8) {
        return false;
      }
      return true;
    } else {
      return false;
    }
  }
  
  public List<Monster> listarMonstros() {
	    if(conectar()) {
	      String sql = "SELECT id, nome, vida, mana, dano, imagem FROM world.monsters";
	      List<Monster> lista = new ArrayList<Monster>();
	      try{
	        Statement acaoSql = conexao.createStatement();
	        acaoSql.execute(sql);

	        ResultSet rs = acaoSql.getResultSet();
	        while(rs.next()) {
	          Monster monstro = new Monster();
	          
	          monstro.setId(rs.getInt("id"));
	          monstro.setNome(rs.getString("nome"));
	          monstro.setVida(rs.getInt("vida"));
	          monstro.setMana(rs.getInt("mana"));
	          monstro.setDano(rs.getInt("dano"));
	          monstro.setImagem(rs.getString("imagem"));

	          lista.add(monstro);
	        }
	      } catch (SQLException error9) {
	        return null;
	      }
	      return lista;
	    }
	    return null;
	  }

  public boolean alterarMonstro(Monster monstro){
    if(conectar()) {
      String sql = " UPDATE world.monsters "
                  +" SET nome = ?, "
                  +"     vida = ?, "
                  +"     mana = ?, "
                  +"     dano = ?, "
                  +"     imagem = ? "
                  +" WHERE id = ?";
      
      try {
        PreparedStatement acaoSql = conexao.prepareStatement(sql);
        acaoSql.setString(1, monstro.getNome());
        acaoSql.setInt(2, monstro.getVida());
        acaoSql.setInt(3, monstro.getMana());
        acaoSql.setInt(4, monstro.getDano());
        acaoSql.setString(5, monstro.getImagem());
        acaoSql.executeUpdate();
        return true;
      } catch (SQLException error10) {
        return false;
      }
    }
    return false;
  }
  
  public Monster buscarMonsterPorId(int id) {
		if(conectar()) {
			String sql = "SELECT id, nome, vida, mana, dano, imagem FROM world.monsters WHERE id = "+ id;
			try {
			Statement acaoSql = conexao.createStatement();
			acaoSql.execute(sql);
			acaoSql.executeQuery(sql);
				
			ResultSet rs = acaoSql.getResultSet();
				
			if(rs.next()) {
				Monster monstro = new Monster();
				
				monstro.setId(rs.getInt("id"));
				monstro.setNome(rs.getString("nome"));
				monstro.setVida(rs.getInt("vida"));
				monstro.setMana(rs.getInt("mana"));
				monstro.setDano(rs.getInt("dano"));
				monstro.setImagem(rs.getString("imagem"));
					
				return monstro;
			}
			return null;
		} catch(SQLException error11) {
		return null;
		}
	}
	return null;
  }
  
  public boolean excluirMonstro(int id){
    if(conectar()) {
      String sql = "DELETE FROM world.monsters WHERE id = "+ id;
      try {
        Statement acaoSql = conexao.createStatement();
        acaoSql.execute(sql);
        acaoSql.executeUpdate(sql);
        return true;
      } catch (SQLException error12) {
        return false;
      }
    }
    return false;
  }
}