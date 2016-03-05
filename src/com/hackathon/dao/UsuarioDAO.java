package com.hackathon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hackathon.model.Usuario;

public class UsuarioDAO {
	
	private Connection conn;
	private Statement stmt;
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioDAO() throws SQLException {
	    try {
			conn = getConnection("jdbc:mysql://localhost:3306/webgotinha", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    stmt = conn.createStatement();
		
	}
	
    public boolean add() throws SQLException {
		boolean rs = stmt.execute("INSERT INTO TESTE VALUES ( 5, 'VINICIUS' )");
		return rs;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario find(int id) {
        for (Usuario usuario : usuarios) {
            if(usuario.getIdUsuario() == id) return usuario;
        }
        return null;
    }

    public void delete(Usuario usuario) {
        usuarios.remove(find(usuario.getIdUsuario()));
    }

    public boolean update(Usuario usuario) {
        find(usuario.getIdUsuario());
        for (Usuario usu : usuarios) {
            if(usuario.getIdUsuario() == usu.getIdUsuario()){
            	usu = usuario;
                return true;
            }
        }
        return false;
    }
	
	public static Connection getConnection(String dbURL, String user, String password)
		      throws SQLException, ClassNotFoundException {
		    Class.forName("com.mysql.jdbc.Driver");
		    return DriverManager.getConnection(dbURL, user, password);
	}

}
