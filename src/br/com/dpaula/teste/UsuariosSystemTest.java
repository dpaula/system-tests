package br.com.dpaula.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuariosSystemTest {

	ChromeDriver driver;

	@Before
	public void carregaDriverSelenium() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void fechaDriverSelenium() {
		driver.close();
	}

	@Test
	public void deveAdicionarUmUsuarioTest() {

		inicializaTelaCadastroUsuario();

		// busca na pagina aberta no get, o elemento pelo nome
		WebElement campoUsuario = driver.findElement(By.name("usuario.nome"));
		String nome = "Carla Weitzel";
		// seta nome no campo
		campoUsuario.sendKeys(nome);

		WebElement campoEmail = driver.findElement(By.name("usuario.email"));
		String email = "carla@google.com";
		campoEmail.sendKeys(email);

		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();

		// busca a pagina atual posicionada
		String paginaAtual = driver.getPageSource();

		boolean achouNome = paginaAtual.contains(nome);
		boolean achouEmail = paginaAtual.contains(email);

		assertTrue(achouNome);
		assertTrue(achouEmail);

	}

	@Test
	public void inserindoUsuarioSemNomeTest() {

		inicializaTelaCadastroUsuario();

		WebElement campoEmail = driver.findElement(By.name("usuario.email"));
		String email = "carla@google.com";
		campoEmail.sendKeys(email);

		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();

		// busca a pagina atual posicionada
		String paginaAtual = driver.getPageSource();

		assertTrue(paginaAtual.contains("Nome obrigatorio!"));

	}

	@Test
	public void inserindoUsuarioSemNomeESemEmailTest() {

		inicializaTelaCadastroUsuario();

		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();

		// busca a pagina atual posicionada
		String paginaAtual = driver.getPageSource();

		assertTrue(paginaAtual.contains("Nome obrigatorio!"));
		assertTrue(paginaAtual.contains("E-mail obrigatorio!"));

	}

	@Test
	public void linkNovoUsuarioTest() {

		inicializaTelaListagemUsuarios();

		// clicando em um link
		WebElement linkNovoUsuario = driver.findElement(By.linkText("Novo Usuário"));
		linkNovoUsuario.click();

		// busca a pagina atual posicionada
		String paginaAtual = driver.getPageSource();

		assertTrue(paginaAtual.contains("Nome:"));

	}

	/**
	 * 
	 */
	private void inicializaTelaCadastroUsuario() {
		driver.get("http://localhost:8080/usuarios/new");
	}

	private void inicializaTelaListagemUsuarios() {
		driver.get("http://localhost:8080/usuarios");
	}

}
