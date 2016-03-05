package com.hackathon.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id 
	@GeneratedValue
	private int idUsuario;
	
	private String nome;
	private Date dataNasc;
	private String email;
	private char sexo;
	private String senha;
	public List<Vacina> vacinas;
	
	public void tomarVacina(int idUsuario, Vacina vacina){
		//busca usuario no banco
		Usuario usuario = new Usuario(1, "Marco", "marco@email.com", 'M', "senha");
		usuario.vacinas.add(vacina);
	}
	
	public Usuario(int idUsuario, String nome, String email, char sexo, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
		this.senha = senha;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
