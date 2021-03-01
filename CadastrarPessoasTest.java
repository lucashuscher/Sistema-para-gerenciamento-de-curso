package pessoas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Cadastros.CadastrarPessoas;
import imp.Pessoa;
import interfaces.IPessoa;

public class CadastrarPessoasTest {

	/*
	 * Testa inserção de uma pessoa
	 */
	@Test
	public void cadastrarPessoas01() {
		IPessoa pessoa = novaPessoa("Nome1", "Sobrenome1");
		CadastrarPessoas pessoas = new CadastrarPessoas();
		pessoas.addPessoa(pessoa);
		assertEquals(1, pessoas.getTotalPessoas().size());
		assertEquals("Nome1", pessoas.getTotalPessoas().get(0).getName());
		assertEquals("Sobrenome1", pessoas.getTotalPessoas().get(0).getSobrenome());
	}

	/*
	 * Testa inserção de 10 pessoas
	 */
	@Test
	public void cadastrarPessoas02() {
		IPessoa pessoa;
		CadastrarPessoas pessoas = new CadastrarPessoas();
		for (int i = 0; i < 10; i++) {
			pessoa = novaPessoa(String.format("nome%d", i), String.format("sobrenome%d", i));
			pessoas.addPessoa(pessoa);
		}
		assertEquals(10, pessoas.getTotalPessoas().size());
		for (int i = 0; i < 10; i++) {
			String nomeEsperado = String.format("nome%d", i);
			String sobrenomeEsperado = String.format("sobrenome%d", i);
			IPessoa resultado = pessoas.getPessoaPorIndice(i);
			assertEquals(nomeEsperado, resultado.getName());
			assertEquals(sobrenomeEsperado, resultado.getSobrenome());
		}
	}

	/*
	 * Testa remoção de uma pessoa
	 */
	@Test
	public void cadastrarPessoas03() {
		IPessoa pessoa = novaPessoa("Nome1", "Sobrenome1");
		CadastrarPessoas pessoas = new CadastrarPessoas();
		pessoas.addPessoa(pessoa);
		assertEquals(1, pessoas.getTotalPessoas().size());
		assertEquals("Nome1", pessoas.getTotalPessoas().get(0).getName());
		assertEquals("Sobrenome1", pessoas.getTotalPessoas().get(0).getSobrenome());
		pessoas.deletarPessoa(pessoa);

		assertEquals(0, pessoas.getTotalPessoas().size());
	}
	
	/*
	 * Testa remoção da pessoa 5 
	 */
	@Test
	public void cadastrarPessoas04() {
		IPessoa pessoa;
		CadastrarPessoas pessoas = new CadastrarPessoas();
		for (int i = 0; i < 10; i++) {
			pessoa = novaPessoa(String.format("nome%d", i), String.format("sobrenome%d", i));
			pessoas.addPessoa(pessoa);
		}
		assertEquals(10, pessoas.getTotalPessoas().size());
		assertEquals("nome5", pessoas.getPessoaPorIndice(5).getName());
		assertEquals("sobrenome5", pessoas.getPessoaPorIndice(5).getSobrenome());
		for (int i = 0; i < 10; i++) {
			if(i == 5) {
				pessoa = novaPessoa(String.format("nome%d", i), String.format("sobrenome%d", i));
				pessoas.deletarPessoa(pessoa);
			}
		}
		assertEquals(9, pessoas.getTotalPessoas().size());
		assertEquals("nome6", pessoas.getPessoaPorIndice(5).getName());
		assertEquals("sobrenome6", pessoas.getPessoaPorIndice(5).getSobrenome());
	}
	
	/*
	 * Testa Alteracao do sobrenome da pessoa
	 */
	@Test
	public void cadastrarPessoas05() {
		IPessoa pessoa = novaPessoa("Nome1", "Sobrenome1");
		CadastrarPessoas pessoas = new CadastrarPessoas();
		pessoas.addPessoa(pessoa);
		assertEquals(1, pessoas.getTotalPessoas().size());
		assertEquals("Nome1", pessoas.getTotalPessoas().get(0).getName());
		assertEquals("Sobrenome1", pessoas.getTotalPessoas().get(0).getSobrenome());
		pessoas.atualizarPessoa(pessoa, "Nome1", "novo sobrenome");

		assertEquals("Nome1", pessoas.getTotalPessoas().get(0).getName());
		assertEquals("novo sobrenome", pessoas.getTotalPessoas().get(0).getSobrenome());
	}
	
	/*
	 * Testa Alteracao do nome da pessoa
	 */
	@Test
	public void cadastrarPessoas06() {
		IPessoa pessoa = novaPessoa("Nome1", "Sobrenome1");
		CadastrarPessoas pessoas = new CadastrarPessoas();
		pessoas.addPessoa(pessoa);
		assertEquals(1, pessoas.getTotalPessoas().size());
		assertEquals("Nome1", pessoas.getTotalPessoas().get(0).getName());
		assertEquals("Sobrenome1", pessoas.getTotalPessoas().get(0).getSobrenome());
		pessoas.atualizarPessoa(pessoa, "teste", "Sobrenome1");

		assertEquals("teste", pessoas.getTotalPessoas().get(0).getName());
		assertEquals("Sobrenome1", pessoas.getTotalPessoas().get(0).getSobrenome());
	}
	

	private IPessoa novaPessoa(String nome, String sobrenome) {
		IPessoa pessoa = new Pessoa();
		pessoa.setName(nome);
		pessoa.setSobrenone(sobrenome);
		return pessoa;
	}
}
