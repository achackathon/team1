package com.hackathon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;

import com.hackathon.model.Vacina;

public class VacinaDAO {
	
	private Connection conn;
	private Statement stmt;	
	
	public VacinaDAO() throws SQLException {
	    try {
			conn = getConnection("jdbc:mysql://localhost:3306/webgotinha", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    stmt = conn.createStatement();
		
	}
	
    public boolean add(Vacina vacina) throws SQLException {
		boolean result = stmt.execute("insert into Vacina values (" + vacina.getNome() + 
				", " + vacina.getDose() + ");");
		return result;
    }

    public List<Vacina> getVacinas() throws SQLException {
    	@SuppressWarnings("unchecked")
		List<Vacina> vacinas = (List<Vacina>)stmt.executeQuery("select * from Vacina");
        return vacinas;
    }

    public Vacina find(int id) throws SQLException {
    	Vacina vacina = (Vacina)stmt.executeQuery("select * from Vacina where idVacina = " + id + ";");
		return vacina;
    }

    public boolean delete(Vacina vacina) throws SQLException {
    	boolean result = stmt.execute("delete from Vacina where idVacina = " + vacina.getIdVacina() + ";");
        return result;
    }

    public boolean update(Vacina vacina) throws SQLException {
        boolean result = stmt.execute("update Usuario set (nome = " + vacina.getNome() + 
				", dose = " + vacina.getDose() + ") where idVacina = " + vacina.getIdVacina() + ";");
        return result;
    }
	
	public static Connection getConnection(String dbURL, String user, String password)
		      throws SQLException, ClassNotFoundException {
		    Class.forName("com.mysql.jdbc.Driver");
		    return DriverManager.getConnection(dbURL, user, password);
	}
}
