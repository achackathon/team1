package com.hackathon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.hackathon.model.Usuario;

public class UsuarioDAO {
	
	private Connection conn;
	private Statement stmt;	
	
	
	public UsuarioDAO() throws SQLException {
	    try {
			conn = getConnection("jdbc:mysql://localhost:3306/webgotinha", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    stmt = conn.createStatement();
		
	}
	
<<<<<<< 4b9b136efcc56c4c3fc8a1ba3badb651ddbdd6c3
    public boolean add(Usuario usuario) throws SQLException {
		boolean result = stmt.execute("insert into Usuario values (" + usuario.getNome() + 
				", " + usuario.getDataNasc() +
				", " + usuario.getEmail() +
				", " + usuario.getSexo() +
				", " + usuario.getSenha() + ");");
		return result;
=======
    public void add(Usuario usuario) throws SQLException {
		stmt.execute("INSERT INTO USUARIO VALUES (" + usuario.getNome() + "," 
					+ usuario.getSenha() + ","
					+ usuario.getDataNasc() + ","
					+ usuario.getEmail() + ","
					+ usuario.getSexo() + ")");
>>>>>>> Altera os DAO's
    }

    public List<Usuario> getUsuarios() throws SQLException {
    	@SuppressWarnings("unchecked")
		List<Usuario> usuarios = (List<Usuario>)stmt.executeQuery("select * from Usuario");
        return usuarios;
    }

    public Usuario find(int id) throws SQLException {
        Usuario usuario = (Usuario)stmt.executeQuery("select * from Usuario where idUsuario = " + id + ";");
		return usuario;
    }

    public boolean delete(Usuario usuario) throws SQLException {
    	boolean result = stmt.execute("delete from Usuario where idUsuario = " + usuario.getIdUsuario() + ";");
        return result;
    }

    public boolean update(Usuario usuario) throws SQLException {
        boolean result = stmt.execute("update Usuario set (nome = " + usuario.getNome() + 
				", dataNasc = " + usuario.getDataNasc() +
				", email = " + usuario.getEmail() +
				", sexo = " + usuario.getSexo() +
				", senha = " + usuario.getSenha() + ") where idUsuario = " + usuario.getIdUsuario() + ";");
        return result;
    }
	
	public static Connection getConnection(String dbURL, String user, String password)
		      throws SQLException, ClassNotFoundException {
		    Class.forName("com.mysql.jdbc.Driver");
		    return DriverManager.getConnection(dbURL, user, password);
	}
}
