package br.com.dpaula.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlteraUsuarioPage {

	private ChromeDriver driver;

	public AlteraUsuarioPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public void altera(String nome, String email) {
		driver.findElement(By.name("usuario.nome")).sendKeys(nome);
		driver.findElement(By.name("usuario.email")).sendKeys(email);

		driver.findElement(By.id("btnSalvar")).click();

	}
}
