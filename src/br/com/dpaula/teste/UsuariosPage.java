package br.com.dpaula.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuariosPage {

	private ChromeDriver driver;

	public UsuariosPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		driver.get("http://localhost:8080/usuarios");
	}

	public NovoUsuarioPage novo() {
		driver.findElement(By.linkText("Novo Usuário")).click();
		return new NovoUsuarioPage(driver);
	}

	public boolean existeNaListagem(String nome, String email) {
		return driver.getPageSource().contains(nome) && driver.getPageSource().contains(email);
	}

	public boolean validaNomeObrigatorio() {
		return driver.getPageSource().contains("Nome obrigatorio!");
	}

	public boolean validaNomeEEmailObrigatorios() {
		return driver.getPageSource().contains("Nome obrigatorio!")
				&& driver.getPageSource().contains("E-mail obrigatorio!");
	}

	public boolean validaPaginaCadasdro() {
		return driver.getPageSource().contains("Nome:");
	}

}
