import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * vantagens de termos testes de sistema automatizado:
 * 
 * O teste automatizado � muito mais r�pido do que um ser humano. A partir do
 * momento que voc� escreveu o teste, voc� poder� execut�-lo infinitas vezes a
 * um custo baix�ssimo. Mais produtividade, afinal, voc� gastar� menos tempo
 * testando (escrever um teste automatizado gasta menos tempo do que testar
 * manualmente diversas vezes a mesma funcionalidade) e mais tempo
 * desenvolvendo. Bugs encontrados mais r�pido pois, j� que sua bateria de
 * testes roda r�pido, voc� a executar� a todo instante, encontrando poss�veis
 * partes do sistema que deixaram de funcionar devido a novas implementa��es. O
 * Selenium � uma excelente ferramenta para automatizar os testes. Sua API � bem
 * clara e f�cil de usar, al�m da grande quantidade de documenta��o que pode ser
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
