import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * vantagens de termos testes de sistema automatizado:
 * 
 * O teste automatizado é muito mais rápido do que um ser humano. A partir do
 * momento que você escreveu o teste, você poderá executá-lo infinitas vezes a
 * um custo baixíssimo. Mais produtividade, afinal, você gastará menos tempo
 * testando (escrever um teste automatizado gasta menos tempo do que testar
 * manualmente diversas vezes a mesma funcionalidade) e mais tempo
 * desenvolvendo. Bugs encontrados mais rápido pois, já que sua bateria de
 * testes roda rápido, você a executará a todo instante, encontrando possíveis
 * partes do sistema que deixaram de funcionar devido a novas implementações. O
 * Selenium é uma excelente ferramenta para automatizar os testes. Sua API é bem
 * clara e fácil de usar, além da grande quantidade de documentação que pode ser
 * encontrada na internet.
 * 
 * @author ferna
 *
 */
public class TesteAutomatizado {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// driver.get("http://www.google.com.br");
		//
		// WebElement campoTexto = driver.findElement(By.name("q"));
		// campoTexto.sendKeys("Caelum");
		//
		// campoTexto.submit();
		driver.get("http://www.bing.com");

		WebElement campoTexto = driver.findElement(By.name("q"));
		campoTexto.sendKeys("Caelum");

		campoTexto.submit();

	}

}
