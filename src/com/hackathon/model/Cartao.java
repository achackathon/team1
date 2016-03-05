package com.hackathon.model;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Cartao {
	@Id 
	@GeneratedValue
	private int idCartao;
	
	private int idUsuario;
	private Tipo tipo;
	private String nome;
	public List<Vacina> vacinas;
	
	public void tomarVacina(int idCartao, Vacina vacina){
		//busca cartao no banco
		Cartao cartao = new Cartao(1, 1, Tipo.Humano, "Marco");
		cartao.vacinas.add(vacina);
	}

	public Cartao(int idCartao, int idUsuario, Tipo tipo, String nome) {
		super();
		this.idCartao = idCartao;
		this.idUsuario = idUsuario;
		this.tipo = tipo;
		this.nome = nome;
	}

	public int getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(int idCartao) {
		this.idCartao = idCartao;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Vacina> getVacinas() {
		return vacinas;
	}

	public void setVacinas(List<Vacina> vacinas) {
		this.vacinas = vacinas;
	}
}
