package Cadastros;

import java.util.ArrayList;
import java.util.List;

import interfaces.ISala;

public class CadastrarSalas {

	ArrayList<ISala> salas = new ArrayList<ISala>();

	public CadastrarSalas() {
	}

	public void addSala(ISala sala) {
		salas.add(sala);
	}

	public void atualizarSala(ISala sala, String nome, int qtdParticipantes) {
		for (ISala s : salas) {
			if (s.getSala().equals(sala.getSala())) {
				s.setSala(nome);
				s.setCapacidade(qtdParticipantes);
			}
		}
	}

	public void deletarSala(ISala sala) {
		for (ISala s : salas) {
			if (s.getSala().equals(sala.getSala())) {
				salas.remove(s);
				break;
			}
		}
	}

	public ISala getSalaPorIndice(int indice) {
		return salas.get(indice);
	}

	public int getIndice(ISala sala) {
		return salas.indexOf(sala);
	}

	public List<ISala> getTotalSalas() {
		return salas;
	}
}
