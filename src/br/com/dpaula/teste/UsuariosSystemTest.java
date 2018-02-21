package br.com.dpaula.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Testa comportamentos das telas do sistema de leiloes utilizando selenium
 * 
 * @author ferna
 *
 */
public class UsuariosSystemTest {

	// driver do chrome necessário para utilizar o navegador
	ChromeDriver driver;
	// Page Object criado para representar a tela de listagem de usuarios
	// http://localhost:8080/usuarios
	UsuariosPage usuarios;

	/**
	 * Inicia antes dos testes para carregar as configurções para o uso do selenium
	 */
	@Before
	public void carregaDriverSelenium() {
		// seta nas propriedades do sistema a localização necessária do driver do chrome
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		// instancia driver do chrome
		driver = new ChromeDriver();
		usuarios = new UsuariosPage(driver);
	}

	// fecha o driver do chrome após a execução dos testes
	@After
	public void fechaDriverSelenium() {
		driver.get("http://localhost:8080/apenas-teste/limpa");
		driver.close();
	}

	/**
	 * Teste que verifica a inclusão de um usua´rio novo no sistema
	 */
	@Test
	public void deveAdicionarUmUsuarioTest() {

		String nome = "Carla Weitzel";
		String email = "carla@google.com";

		usuarios.visita();
		usuarios.novo().cadastra(nome, email);

		assertTrue(usuarios.existeNaListagem(nome, email));

	}

	/**
	 * Teste que verifica se o sistema valida caso um novo usuario for criado sem
	 * nome
	 */
	@Test
	public void inserindoUsuarioSemNomeTest() {
		String email = "carla@google.com";

		usuarios.visita();
		usuarios.novo().cadastra("", email);

		assertTrue(usuarios.validaNomeObrigatorio());

	}

	/**
	 * Valida mensagens caso usuario tentar criar um novo usuario sem informar nome
	 * e email
	 */
	@Test
	public void inserindoUsuarioSemNomeESemEmailTest() {
		usuarios.visita();
		usuarios.novo().cadastra("", "");

		assertTrue(usuarios.validaNomeEEmailObrigatorios());
	}

	/**
	 * Testa o link para um novo usuario, na pagina de listagem dos usuarios
	 */
	@Test
	public void linkNovoUsuarioTest() {

		usuarios.visita();
		usuarios.novo();

		assertTrue(usuarios.validaPaginaCadasdro());
	}

	/**
	 * Teste que verifica a inclusão de um usua´rio novo no sistema
	 */
	@Test
	public void validaExclusaoUsuarioTest() {

		String nome = "Ana excluir";
		String email = "AnaExcluir@google.com";

		usuarios.visita();
		usuarios.novo().cadastra(nome, email);

		assertTrue(usuarios.existeNaListagem(nome, email));

		usuarios.excluir(1);

		assertFalse(usuarios.existeNaListagem(nome, email));

	}

	/**
	 * Teste a alteração de um usuário. cadastra um usuário, clica em Editar, altera
	 * os valores e submete o formulário.
	 */
	@Test
	public void validaEdicaoUsuarioTest() {

		String nome = "Ana alterar";
		String email = "AnaAlterar@google.com";

		usuarios.visita();
		usuarios.novo().cadastra(nome, email);

		assertTrue(usuarios.existeNaListagem(nome, email));

		usuarios.alterar().altera(nome + "Feito", email);

		assertTrue(usuarios.existeNaListagem(nome + "Feito", email));

	}

}
