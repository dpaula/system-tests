package br.com.dpaula.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetalhesDoLeilaoPage {

	private ChromeDriver driver;

	public DetalhesDoLeilaoPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public void lance(String usuario, double valor) {
		Select cbUsuario = new Select(driver.findElement(By.name("lance.usuario.id")));
		cbUsuario.selectByVisibleText(usuario);

		driver.findElement(By.name("lance.valor")).sendKeys(String.valueOf(valor));

		driver.findElement(By.id("btnDarLance")).click();

	}

	public boolean existeLance(String usuario, double valor) {

		// Como o campo de carregamento dos lances � um campo Ajax (com carregamento
		// dinamico)
		// foi utilizado o WebDriverWait para esperar 10 segundos para o campo
		// "lancesDados" que � a tabela onde vai carregar o usuario do lance
		// se ap�s esses 10 segundos ele retornar false, � pq este usuario n�o foi
		// carregado
		Boolean temUsuario = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.textToBePresentInElementLocated(By.id("lancesDados"), usuario));

		// se achou o usuario ent�o retorna se tem o valor do leil�o conforme
		// cadastrado, sen�o retorna false
		return temUsuario ? driver.getPageSource().contains(String.valueOf(valor)) : false;
	}

}
