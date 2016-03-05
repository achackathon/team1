package com.hackathon.service;

import java.sql.SQLException;

import com.hackathon.dao.UsuarioDAO;

public class Teste {
	
	public static void main(String [] args) throws SQLException{
		UsuarioDAO usuario = new UsuarioDAO();
		
		usuario.add();
	}

}
