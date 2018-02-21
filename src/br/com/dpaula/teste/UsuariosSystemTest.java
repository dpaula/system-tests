package br.com.dpaula.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuariosSystemTest {

	@Test
	public void deveAdicionarUmUsuarioTest() {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/usuarios/new");

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

		driver.close();
	}

}
