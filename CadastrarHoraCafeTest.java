package horaCafe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Cadastros.CadastrarHoraCafe;
import imp.HoraCafe;
import imp.Sala;
import interfaces.IHoraCafe;

public class CadastrarHoraCafeTest {
	/*
	 * Testa inserção de uma Sala
	 */
	@Test
	public void CadastrarHoraCafe01() {
		IHoraCafe Sala = novaSala("Nome1", 10);
		CadastrarHoraCafe Salas = new CadastrarHoraCafe();
		Salas.addSala(Sala);
		assertEquals(1, Salas.getTotalSalas().size());
		assertEquals("Nome1", Salas.getTotalSalas().get(0).getSala());
		assertEquals(10, Salas.getTotalSalas().get(0).getCapacidade());
	}

	/*
	 * Testa inserção de 10 Salas
	 */
	@Test
	public void CadastrarHoraCafe02() {
		IHoraCafe Sala;
		CadastrarHoraCafe Salas = new CadastrarHoraCafe();
		for (int i = 0; i < 10; i++) {
			Sala = novaSala(String.format("nome%d", i), i);
			Salas.addSala(Sala);
		}
		assertEquals(10, Salas.getTotalSalas().size());
		for (int i = 0; i < 10; i++) {
			String nomeEsperado = String.format("nome%d", i);
			IHoraCafe resultado = Salas.getSalaPorIndice(i);
			assertEquals(nomeEsperado, resultado.getSala());
			assertEquals(i, resultado.getCapacidade());
		}
	}

	/*
	 * Testa remoção de uma Sala
	 */
	@Test
	public void CadastrarHoraCafe03() {
		IHoraCafe Sala = novaSala("Nome1", 10);
		CadastrarHoraCafe Salas = new CadastrarHoraCafe();
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
	public void CadastrarHoraCafe04() {
		IHoraCafe Sala;
		CadastrarHoraCafe Salas = new CadastrarHoraCafe();
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
	public void CadastrarHoraCafe05() {
		IHoraCafe Sala = novaSala("Nome1", 10);
		CadastrarHoraCafe Salas = new CadastrarHoraCafe();
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
	public void CadastrarHoraCafe06() {
		IHoraCafe Sala = novaSala("Nome1", 10);
		CadastrarHoraCafe Salas = new CadastrarHoraCafe();
		Salas.addSala(Sala);
		assertEquals(1, Salas.getTotalSalas().size());
		assertEquals("Nome1", Salas.getTotalSalas().get(0).getSala());
		assertEquals(10, Salas.getTotalSalas().get(0).getCapacidade());
		Salas.atualizarSala(Sala, "teste", 10);

		assertEquals("teste", Salas.getTotalSalas().get(0).getSala());
		assertEquals(10, Salas.getTotalSalas().get(0).getCapacidade());
	}
	

	private IHoraCafe novaSala(String nome, int capacidade) {
		IHoraCafe pessoa = new HoraCafe();
		pessoa.setSala(nome);
		pessoa.setCapacidade(capacidade);
		return pessoa;
	}
}
