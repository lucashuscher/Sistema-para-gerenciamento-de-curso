package imp;

import interfaces.IHoraCafe;

public class HoraCafe implements IHoraCafe {

	String nome;
	int capacidade;
	
	public void setSala(String nome) {
		this.nome = nome;		
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getSala() {
		return nome;
	}

	public int getCapacidade() {
		return capacidade;
	}
	
}
