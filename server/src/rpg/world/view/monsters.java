package rpg.world.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import rpg.world.controller.World;
import rpg.world.model.Monster;
import rpg.world.model.User;

@WebServlet(urlPatterns = "/createmonster/*")
public class monsters extends HttpServlet {
	
	private World world = new World();
	
	private List<Monster> monster = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pathInfo = request.getPathInfo();
		Gson gson = new Gson();
		String resultadoJSON = null;
		if(pathInfo == null || pathInfo.equals("/")) {
			
			List<Monster> lista = world.listarMonstros();
			resultadoJSON = gson.toJson(lista);
		} else {
			String[] vetor = pathInfo.split("/");
			try {
				int id = (Integer.parseInt(vetor[1]));
				
				Monster monster = world.buscarMonsterPorId(id);
				
			} catch (Exception e) {
				resultadoJSON = null;
			}
			
		}
		
		response.setContentType("application/json; charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, OPTIONS, POST, PUT");
		response.setHeader("Access-Control-Allow-Credentials", "false");
		
		PrintWriter out = response.getWriter();
		out.println(resultadoJSON);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedReader b_reader = request.getReader();
		
		StringBuilder s_builder = new StringBuilder();
		String linha;
		while((linha = b_reader.readLine()) != null) {
			s_builder.append(linha);
		}
		
		Gson gson = new Gson();
		Monster monstro = gson.fromJson(s_builder.toString(), Monster.class);
		
		world.novoMonstro(monstro);
		
		PrintWriter out = response.getWriter();
		out.println("Monstro cadastrado com sucesso!!");
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pathInfo = request.getPathInfo();
		if(pathInfo != null) {
			String[] vetor = pathInfo.split("/");
			try {
				
				int id = (Integer.parseInt(vetor[1]));
				BufferedReader b_reader = request.getReader();
				
				StringBuilder s_builder = new StringBuilder();
				String linha;
				while((linha = b_reader.readLine()) != null) {
					s_builder.append(linha);
				}
				
				Gson gson = new Gson();
				Monster monstro = gson.fromJson(s_builder.toString(), Monster.class);
				
			} catch (Exception e) {
				
			}
		}
		
		PrintWriter out = response.getWriter();
		out.println("Monstro alterado com sucesso!!");
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pathInfo = request.getPathInfo();
		
		if(pathInfo != null) {
			String[] vetor = pathInfo.split("/");
			int id = (Integer.parseInt(vetor[1]));
			
			world.excluirMonstro(id);
		}
		
		PrintWriter out = response.getWriter();
		out.println("Monstro excluido com sucesso!!");
	}

}
