package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By ; 
import org.openqa.selenium.WebDriver ; 
import org.openqa.selenium.WebElement ;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testes.ExecutarTestes;

public class principalPagina {

	private static WebElement element = null; 
	
	public static void textoLogin (String validar) {
		WebDriverWait wait = new WebDriverWait(ExecutarTestes.getDriver(), 2);
	    try {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@class='login-info-left']")));
	    	Assert.assertEquals(ExecutarTestes.getDriver().findElement(By.xpath("//td[@class='login-info-left']")).getText(), validar);
		} catch (Exception e) {
			System.out.println("Erro ao Logar");
		}
	}
	
	public static WebElement reportar_lnk (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.xpath("//a[@href='/bug_report_page.php']"));
		return   element ;
	} 
	public static WebElement verBugs_lnk (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.xpath("//a[@href='/view_all_bug_page.php']"));
		return   element ;
	}
	public static WebElement gerenciarConta_lnk (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.xpath("//a[@href='/account_page.php']"));
		return   element ;
	}
}