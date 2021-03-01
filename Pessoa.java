package imp;

import interfaces.IPessoa;

public class Pessoa implements IPessoa {

	String nome;
	String sobrenome;
	
	public void setName(String nome) {
		this.nome = nome;
	}

	public void setSobrenone(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getName() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

}
