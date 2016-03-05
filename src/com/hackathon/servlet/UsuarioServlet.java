package com.hackathon.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hackathon.dao.UsuarioDAO;
import com.hackathon.model.Usuario;

public class UsuarioServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request,
	                    HttpServletResponse response) 
	                    throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("inputNome");
		String email = request.getParameter("inputEmail");
		String dataEmTexto = request.getParameter("dataNascimento");
		String senha = request.getParameter("inputPassword");
		String sexo = request.getParameter("genero");
		
		Calendar dataNascimento = null;
        
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy")
                    .parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException e) {
            out.println("Erro de conversão da data");
            return; 
        }
	
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setDataNasc(dataNascimento);
		usuario.setSexo(sexo);
		usuario.setSenha(senha);
		
		try {
			UsuarioDAO dao = new UsuarioDAO();
			dao.add(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
