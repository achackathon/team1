package com.hackathon.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id 
	@GeneratedValue
	private int idUsuario;
	
	private String nome;
	private Calendar dataNasc;
	private String email;
	private String sexo;
	private String senha;
<<<<<<< 4b9b136efcc56c4c3fc8a1ba3badb651ddbdd6c3
=======
	public List<Vacina> vacinas;
	
	public void tomarVacina(int idUsuario, Vacina vacina){
		//busca usuario no banco
		Usuario usuario = new Usuario(1, "Marco", "marco@email.com", "M", "senha");
		usuario.vacinas.add(vacina);
	}
>>>>>>> Altera os DAO's
	
	public Usuario() {
		super();
	}

	public Usuario(int idUsuario, String nome, String email, String sexo, String senha) {
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
	
	public Calendar getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	public List<Vacina> getVacinas() {
		return vacinas;
	}

	public void setVacinas(List<Vacina> vacinas) {
		this.vacinas = vacinas;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
