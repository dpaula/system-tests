package br.com.dpaula.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NovoLeilaoPage {

	private ChromeDriver driver;

	public NovoLeilaoPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public void cadastra(String nome, double valor, String usuario, boolean usado) {
		WebElement txtNome = driver.findElement(By.name("leilao.nome"));
		txtNome.sendKeys(nome);
		driver.findElement(By.name("leilao.valorInicial")).sendKeys(String.valueOf(valor));

		Select cbUsuario = new Select(driver.findElement(By.name("leilao.usuario.id")));
		cbUsuario.selectByVisibleText(usuario);

		if (usado) {
			driver.findElement(By.name("leilao.usado")).click();
		}

		txtNome.submit();
	}

	public boolean validaMensagemLeilaoSemNomeProduto() {
		return driver.getPageSource().contains("Nome obrigatorio!");
	}

	public boolean validaMensagemLeilaoValorInicia() {
		return driver.getPageSource().contains("Valor inicial deve ser maior que zero!");
	}

}
