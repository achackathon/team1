package com.hackathon.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vacina {
	
	@Id 
	@GeneratedValue
	private int idVacina;
	private String nome;
	private String dose;
	
	public Vacina(int idVacina, String nome, String dose) {
		super();
		this.idVacina = idVacina;
		this.nome = nome;
		this.dose = dose;
	}
	
	public int getIdVacina() {
		return idVacina;
	}
	public void setIdVacina(int idVacina) {
		this.idVacina = idVacina;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDose() {
		return dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	
	

}
