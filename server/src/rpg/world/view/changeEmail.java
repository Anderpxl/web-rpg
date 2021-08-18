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
import rpg.world.model.User;

@WebServlet(urlPatterns = "/changeemail/*")
public class changeEmail extends HttpServlet {
	
	private World world = new World();
	private List<User> user = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pathInfo = request.getPathInfo();
		Gson gson = new Gson();
		String resultadoJSON = null;
		if(pathInfo == null || pathInfo.equals("/")) {
			
			List<User> user = world.listarUsuarios();
			resultadoJSON = gson.toJson(user);
		} else {
			String[] vetor = pathInfo.split("/");
			try {
				int id = (Integer.parseInt(vetor[1]));
				
				User user = world.buscarUserPorId(id);
				resultadoJSON = gson.toJson(user);
				
			} catch (Exception e) {
				resultadoJSON = null;
			}
			
		}
		
		response.setContentType("application/json; charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT");
		response.setHeader("Access-Control-Allow-Credentials", "false");
		
		PrintWriter out = response.getWriter();
		out.println(resultadoJSON);
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
				User user = gson.fromJson(s_builder.toString(), User.class);
				
				world.alterarEmail(user);
				
			} catch (Exception e) {
				
			}
		}
		
		response.setContentType("application/json; charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Credentials", "false");
		
		PrintWriter out = response.getWriter();
		out.println("E-mail alterado com sucesso!!");
	}

}
