package com.hackathon.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexao {
  public static void main(String[] args) throws Exception {
    Connection conn = null;

    conn = getConnection("jdbc:mysql://localhost:3306/webgotinha", "root", "");
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM TESTE");
    while(rs.next()){
    System.out.println(rs.getString("name"));
    
    }
    conn.close();
  }

  public static Connection getConnection(String dbURL, String user, String password)
      throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");
    return DriverManager.getConnection(dbURL, user, password);
  }

}