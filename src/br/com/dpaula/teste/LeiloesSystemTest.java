package br.com.dpaula.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesSystemTest {

	// driver do chrome necessário para utilizar o navegador
	ChromeDriver driver;
	// Page Object criado para representar a tela de listagem de usuarios
	// http://localhost:8080/usuarios
	LeiloesPage leiloes;

	/**
	 * Inicia antes dos testes para carregar as configurções para o uso do selenium
	 */
	@Before
	public void carregaDriverSelenium() {
		// seta nas propriedades do sistema a localização necessária do driver do chrome
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		// instancia driver do chrome
		driver = new ChromeDriver();
		leiloes = new LeiloesPage(driver);
	}

	// fecha o driver do chrome após a execução dos testes
	@After
	public void fechaDriverSelenium() {
		driver.close();
	}

	@Test
	public void validaNovoLeilaoTest() {

		String leilao = "Geladeira";
		int valor = 123;
		boolean usado = true;

		String usuario = criaUsuario();

		leiloes.visita();
		leiloes.novo().cadastra(leilao, valor, usuario, usado);
		leiloes.existe(leilao, valor, usuario, usado);

	}

	@Test
	public void validaMensagensUsuarioSemNomeOuValorTest() {

		String leilao = "";
		int valor = 0;
		boolean usado = true;

		String usuario = criaUsuario();

		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.cadastra(leilao, valor, usuario, usado);

		assertTrue(novoLeilao.validaMensagemLeilaoSemNomeProduto());
		assertTrue(novoLeilao.validaMensagemLeilaoValorInicia());

	}

	/**
	 * @return
	 */
	private String criaUsuario() {
		String usuario = "Paulo Henrique";
		String email = "paulo.henrique@google.com";

		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra(usuario, email);
		usuarios.existeNaListagem(usuario, email);
		return usuario;
	}

}
