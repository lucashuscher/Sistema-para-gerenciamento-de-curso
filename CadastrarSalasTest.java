package salas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Cadastros.CadastrarSalas;
import imp.Sala;
import interfaces.ISala;

public class CadastrarSalasTest {
	/*
	 * Testa inserção de uma Sala
	 */
	@Test
	public void cadastrarSalas01() {
		ISala Sala = novaSala("Nome1", 10);
		CadastrarSalas Salas = new CadastrarSalas();
		Salas.addSala(Sala);
		assertEquals(1, Salas.getTotalSalas().size());
		assertEquals("Nome1", Salas.getTotalSalas().get(0).getSala());
		assertEquals(10, Salas.getTotalSalas().get(0).getCapacidade());
	}

	/*
	 * Testa inserção de 10 Salas
	 */
	@Test
	public void cadastrarSalas02() {
		ISala Sala;
		CadastrarSalas Salas = new CadastrarSalas();
		for (int i = 0; i < 10; i++) {
			Sala = novaSala(String.format("nome%d", i), i);
			Salas.addSala(Sala);
		}
		assertEquals(10, Salas.getTotalSalas().size());
		for (int i = 0; i < 10; i++) {
			String nomeEsperado = String.format("nome%d", i);
			ISala resultado = Salas.getSalaPorIndice(i);
			assertEquals(nomeEsperado, resultado.getSala());
			assertEquals(i, resultado.getCapacidade());
		}
	}

	/*
	 * Testa remoção de uma Sala
	 */
	@Test
	public void cadastrarSalas03() {
		ISala Sala = novaSala("Nome1", 10);
		CadastrarSalas Salas = new CadastrarSalas();
		Salas.addSala(Sala);
		assertEquals(1, Salas.getTotalSalas().size());
		assertEquals("Nome1", Salas.getTotalSalas().get(0).getSala());
		assertEquals(10, Salas.getTotalSalas().get(0).getCapacidade());
		Salas.deletarSala(Sala);

		assertEquals(0, Salas.getTotalSalas().size());
	}
	
	/*
	 * Testa remoção da Sala 5 
	 */
	@Test
	public void cadastrarSalas04() {
		ISala Sala;
		CadastrarSalas Salas = new CadastrarSalas();
		for (int i = 0; i < 10; i++) {
			Sala = novaSala(String.format("nome%d", i), i);
			Salas.addSala(Sala);
		}
		assertEquals(10, Salas.getTotalSalas().size());
		assertEquals("nome5", Salas.getSalaPorIndice(5).getSala());
		assertEquals(5, Salas.getSalaPorIndice(5).getCapacidade());
		for (int i = 0; i < 10; i++) {
			if(i == 5) {
				Sala = novaSala(String.format("nome%d", i), i);
				Salas.deletarSala(Sala);
			}
		}
		assertEquals(9, Salas.getTotalSalas().size());
		assertEquals("nome6", Salas.getSalaPorIndice(5).getSala());
		assertEquals(6, Salas.getSalaPorIndice(5).getCapacidade());
	}
	
	/*
	 * Testa Alteracao do sobrenome da Sala
	 */
	@Test
	public void cadastrarSalas05() {
		ISala Sala = novaSala("Nome1", 10);
		CadastrarSalas Salas = new CadastrarSalas();
		Salas.addSala(Sala);
		assertEquals(1, Salas.getTotalSalas().size());
		assertEquals("Nome1", Salas.getTotalSalas().get(0).getSala());
		assertEquals(10, Salas.getTotalSalas().get(0).getCapacidade());
		Salas.atualizarSala(Sala, "Nome1", 20);

		assertEquals("Nome1", Salas.getTotalSalas().get(0).getSala());
		assertEquals(20, Salas.getTotalSalas().get(0).getCapacidade());
	}
	
	/*
	 * Testa Alteracao do nome da Sala
	 */
	@Test
	public void cadastrarSalas06() {
		ISala Sala = novaSala("Nome1", 10);
		CadastrarSalas Salas = new CadastrarSalas();
		Salas.addSala(Sala);
		assertEquals(1, Salas.getTotalSalas().size());
		assertEquals("Nome1", Salas.getTotalSalas().get(0).getSala());
		assertEquals(10, Salas.getTotalSalas().get(0).getCapacidade());
		Salas.atualizarSala(Sala, "teste", 10);

		assertEquals("teste", Salas.getTotalSalas().get(0).getSala());
		assertEquals(10, Salas.getTotalSalas().get(0).getCapacidade());
	}
	

	private ISala novaSala(String nome, int capacidade) {
		ISala pessoa = new Sala();
		pessoa.setSala(nome);
		pessoa.setCapacidade(capacidade);
		return pessoa;
	}
}
