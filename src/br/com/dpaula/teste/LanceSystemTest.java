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
	private String usuarioLeilao = "Usuario Leilao";
	private String usuarioLance = "Usuario Lance";

	/**
	 * Inicia antes dos testes para carregar as configurções para o uso do selenium
	 */
	@Before
	public void carregaDriverSelenium() {
		// seta nas propriedades do sistema a localização necessária do driver do chrome
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		leiloes = new LeiloesPage(driver);

		criaNovosUsuariosELeilao();
	}

	// fecha o driver do chrome após a execução dos testes E limpa a base
	@After
	public void fechaDriverSelenium() {
		driver.get(URLDaAplicacao.URL_BASE + "/apenas-teste/limpa");
		driver.close();
	}

	@Test
	public void validaDandoLanceTest() {
		DetalhesDoLeilaoPage lances = leiloes.detalhes();

		double valor = 150;
		lances.lance(usuarioLance, valor);

		assertTrue(lances.existeLance(usuarioLance, valor));
	}

	private void criaNovosUsuariosELeilao() {

		new CriadorDeCenarios(driver)/**/
				.umUsuario(usuarioLeilao, usuarioLeilao.trim().replace(" ", "").toLowerCase())/**/
				.umUsuario(usuarioLance, usuarioLance.trim().replace(" ", "").toLowerCase())/**/
				.umLeilao(usuarioLeilao, "Geladeira", 123, true);

	}

}
