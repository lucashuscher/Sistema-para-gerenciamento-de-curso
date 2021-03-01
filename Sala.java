package imp;

import interfaces.ISala;

public class Sala implements ISala {

	String nome;
	int qtdParticipantes;
	
	public void setSala(String nome) {
		this.nome = nome;		
	}

	public void setCapacidade(int qtdParticipantes) {
		this.qtdParticipantes = qtdParticipantes;
	}

	public String getSala() {
		return nome;
	}

	public int getCapacidade() {
		return qtdParticipantes;
	}

}
