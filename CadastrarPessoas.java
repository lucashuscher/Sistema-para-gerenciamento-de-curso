package Cadastros;

import java.util.ArrayList;
import java.util.List;

import interfaces.IPessoa;

public class CadastrarPessoas {

	ArrayList<IPessoa> pessoas = new ArrayList<IPessoa>();

	public CadastrarPessoas() {
	}

	public void addPessoa(IPessoa pessoa) {
		pessoas.add(pessoa);
	}

	public void atualizarPessoa(IPessoa pessoa, String nome, String sobronome) {
		for (IPessoa p : pessoas) {
			if (p.getName().equals(pessoa.getName()) && p.getSobrenome().equals(pessoa.getSobrenome())) {
				p.setName(nome);
				p.setSobrenone(sobronome);
			}
		}
	}

	public void deletarPessoa(IPessoa pessoa) {
		for (IPessoa p : pessoas) {
			if (p.getName().equals(pessoa.getName()) && p.getSobrenome().equals(pessoa.getSobrenome())) {
				pessoas.remove(p);
				break;
			}
		}
	}

	public IPessoa getPessoaPorIndice(int indice) {
		return pessoas.get(indice);
	}

	public int getIndice(IPessoa pessoa) {
		return pessoas.indexOf(pessoa);
	}

	public List<IPessoa> getTotalPessoas() {
		return pessoas;
	}
}
