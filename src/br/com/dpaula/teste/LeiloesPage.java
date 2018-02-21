package br.com.dpaula.teste;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesPage {

	private ChromeDriver driver;

	public LeiloesPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		driver.get(URLDaAplicacao.URL_BASE + "/leiloes");
	}

	public NovoLeilaoPage novo() {
		driver.findElement(By.linkText("Novo Leilão")).click();
		return new NovoLeilaoPage(driver);
	}

	public boolean existe(String leilao, double valor, String usuario, boolean usado) {
		return driver.getPageSource().contains(leilao) && driver.getPageSource().contains(String.valueOf(valor))
				&& driver.getPageSource().contains(usuario) && driver.getPageSource().contains((usado ? "Sim" : "Não"));
	}

	public DetalhesDoLeilaoPage detalhes() {

		List<WebElement> leiloes = driver.findElements(By.linkText("exibir"));
		leiloes.get(leiloes.size() - 1).click();

		return new DetalhesDoLeilaoPage(driver);
	}
}
