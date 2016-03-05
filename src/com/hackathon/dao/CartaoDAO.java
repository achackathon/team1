package com.hackathon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import com.hackathon.model.Cartao;
import com.hackathon.model.Vacina;


public class CartaoDAO {
	
	private Connection conn;
	private Statement stmt;	
	
	public CartaoDAO() throws SQLException {
	    try {
			conn = getConnection("jdbc:mysql://localhost:3306/webgotinha", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    stmt = conn.createStatement();
		
	}
	
    public boolean add(Cartao cartao) throws SQLException {
    	boolean result = stmt.execute("insert into Cartao values (" + cartao.getIdUsuario() + 
				", " + cartao.getTipo() +
				", " + cartao.getNome() + ");");
		return result;
    }

    public List<Cartao> getCartoes() throws SQLException {
    	@SuppressWarnings("unchecked")
		List<Cartao> cartoes = (List<Cartao>)stmt.executeQuery("select * from Cartao");
        return cartoes;
    }

    public Cartao find(int id) throws SQLException {
    	Cartao cartao = (Cartao)stmt.executeQuery("select * from Cartao where idCartao = " + id + ";");
		return cartao;
    }

    public boolean delete(Cartao cartao) throws SQLException {
    	boolean result = stmt.execute("delete from Cartao where idCartao = " + cartao.getIdCartao() + ";");
        return result;
    }

    public boolean update(Cartao cartao) throws SQLException {
        boolean result = stmt.execute("update Cartao set (idUsuario = " + cartao.getIdUsuario() + 
				", tipo = " + cartao.getTipo() + ", nome = " + cartao.getNome() + 
        		") where idCartao = " + cartao.getIdCartao() + ";");
        return result;
    }
	
    public boolean addVacinaCartao(Cartao cartao, Vacina vacina) throws SQLException {
    	Date data = new Date();
    	//DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
    	//String output = outputFormatter.format(data);
    	boolean result = stmt.execute("insert into VacinaCartao values (" + data + 
				", " + cartao.getIdCartao() +
				", " + vacina.getIdVacina() + ");");
		return result;
    }
    
	public static Connection getConnection(String dbURL, String user, String password)
		      throws SQLException, ClassNotFoundException {
		    Class.forName("com.mysql.jdbc.Driver");
		    return DriverManager.getConnection(dbURL, user, password);
	}
}
