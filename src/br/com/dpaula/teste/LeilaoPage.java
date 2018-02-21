package br.com.dpaula.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeilaoPage {

	private ChromeDriver driver;

	public LeilaoPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		driver.get("http://localhost:8080/leiloes");
	}

	public NovoLeilaoPage novo() {
		driver.findElement(By.linkText("Novo Leilão")).click();
		return new NovoLeilaoPage(driver);
	}

	public boolean existe(String leilao, double valor, String usuario, boolean usado) {
		return driver.getPageSource().contains(leilao) && driver.getPageSource().contains(String.valueOf(valor))
				&& driver.getPageSource().contains(usuario) && driver.getPageSource().contains((usado ? "Sim" : "Não"));
	}
}
