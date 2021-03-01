package Cadastros;

import java.util.ArrayList;
import java.util.List;

import interfaces.IHoraCafe;

public class CadastrarHoraCafe {

	ArrayList<IHoraCafe> salas = new ArrayList<IHoraCafe>();

	public CadastrarHoraCafe() {
	}

	public void addSala(IHoraCafe sala) {
		salas.add(sala);
	}

	public void atualizarSala(IHoraCafe sala, String nome, int qtdParticipantes) {
		for (IHoraCafe s : salas) {
			if (s.getSala().equals(sala.getSala())) {
				s.setSala(nome);
				s.setCapacidade(qtdParticipantes);
			}
		}
	}

	public void deletarSala(IHoraCafe sala) {
		for (IHoraCafe s : salas) {
			if (s.getSala().equals(sala.getSala())) {
				salas.remove(s);
				break;
			}
		}
	}

	public IHoraCafe getSalaPorIndice(int indice) {
		return salas.get(indice);
	}

	public int getIndice(IHoraCafe sala) {
		return salas.indexOf(sala);
	}

	public List<IHoraCafe> getTotalSalas() {
		return salas;
	}
}
