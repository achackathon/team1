package com.hackathon.dao;

import java.util.ArrayList;
import java.util.List;

import com.hackathon.model.Vacina;

public class VacinaDAO {

	private List<Vacina> vacinas = new ArrayList<Vacina>();

    public void add(Vacina vacina) {
        vacinas.add(vacina);
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public Vacina find(int id) {
        for (Vacina vacina : vacinas) {
            if(vacina.getIdVacina() == id) return vacina;
        }
        return null;
    }

    public void delete(Vacina vacina) {
        vacinas.remove(find(vacina.getIdVacina()));
    }

    public boolean update(Vacina vacina) {
        find(vacina.getIdVacina());
        for (Vacina vac : vacinas) {
            if(vacina.getIdVacina() == vac.getIdVacina()){
            	vac = vacina;
                return true;
            }
        }
        return false;
    }
}
