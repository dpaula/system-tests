package br.com.dpaula.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class LanceSystemTest {

	// driver do chrome necessário para utilizar o navegador
	ChromeDriver driver;
	// http://localhost:8080/usuarios
	LeiloesPage leiloes;
	private String usuarioLeilao;
	private String usuarioLance;

	/**
	 * Inicia antes dos testes para carregar as configurções para o uso do selenium
	 */
	@Before
	public void carregaDriverSelenium() {
		// seta nas propriedades do sistema a localização necessária do driver do chrome
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		leiloes = new LeiloesPage(driver);

		usuarioLeilao = criaNovoUsuario("Usuario Leilao");
		usuarioLance = criaNovoUsuario("Usuario Lance");
		criaLeilao();
	}

	// fecha o driver do chrome após a execução dos testes E limpa a base
	@After
	public void fechaDriverSelenium() {
		driver.get("http://localhost:8080/apenas-teste/limpa");
		driver.close();
	}

	@Test
	public void validaDandoLanceTest() {
		DetalhesDoLeilaoPage lances = leiloes.detalhes();

		double valor = 150;
		lances.lance(usuarioLance, valor);

		assertTrue(lances.existeLance(usuarioLance, valor));
	}

	private String criaNovoUsuario(String usuario) {

		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra(usuario, usuario.trim().replace(" ", "").toLowerCase());
		usuarios.existeNaListagem(usuario, usuario.trim().replace(" ", "").toLowerCase());
		return usuario;
	}

	private void criaLeilao() {

		String leilao = "Geladeira";
		int valor = 123;
		boolean usado = true;

		leiloes.visita();
		leiloes.novo().cadastra(leilao, valor, usuarioLeilao, usado);
		leiloes.existe(leilao, valor, usuarioLeilao, usado);

	}
}
