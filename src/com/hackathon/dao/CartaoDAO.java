package com.hackathon.dao;

import java.util.ArrayList;
import java.util.List;

import com.hackathon.model.Cartao;

public class CartaoDAO {
	
	private List<Cartao> cartoes = new ArrayList<Cartao>();

    public void add(Cartao cartao) {
        cartoes.add(cartao);
    }

    public List<Cartao> getVacinas() {
        return cartoes;
    }

    public Cartao find(int id) {
        for (Cartao cartao : cartoes) {
            if(cartao.getIdCartao() == id) return cartao;
        }
        return null;
    }

    public void delete(Cartao cartao) {
        cartoes.remove(find(cartao.getIdCartao()));
    }

    public boolean update(Cartao cartao) {
        find(cartao.getIdCartao());
        for (Cartao car : cartoes) {
            if(cartao.getIdCartao() == car.getIdCartao()){
            	car = cartao;
                return true;
            }
        }
        return false;
    }

}
