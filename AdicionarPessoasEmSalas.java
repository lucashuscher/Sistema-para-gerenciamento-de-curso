package Cadastros;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import interfaces.IPessoa;
import interfaces.ISala;

public class AdicionarPessoasEmSalas {

	HashMap<ISala, HashSet<IPessoa>> vinculos = new HashMap<ISala, HashSet<IPessoa>>();
	
	public AdicionarPessoasEmSalas() {
	}

	public boolean addPessoa(ISala sala, IPessoa pessoa) {
		for(Entry<ISala, HashSet<IPessoa>> entry : vinculos.entrySet()) {
			ISala s = entry.getKey();
			if(s.getSala().equals(sala.getSala())) {
				if(s.getCapacidade() < entry.getValue().size()) {
					entry.getValue().add(pessoa);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean removePessoa(ISala sala, IPessoa pessoa) {
		for(Entry<ISala, HashSet<IPessoa>> entry : vinculos.entrySet()) {
			ISala s = entry.getKey();
			if(s.getSala().equals(sala.getSala())) {
				if(s.getCapacidade() < entry.getValue().size()) {
					entry.getValue().remove(pessoa);
					return true;
				}
			}
		}
		return false;
	}
}
