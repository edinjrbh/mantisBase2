package pageObjects;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By ; 
import org.openqa.selenium.WebDriver ; 
import org.openqa.selenium.WebElement ;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testes.ExecutarTestes;


public class pesquisarBugPagina {
	
	private static WebElement element = null;

	public static void textoResumo (String validar) {
		WebDriverWait wait = new WebDriverWait(ExecutarTestes.getDriver(), 2);
	    try {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@class='login-info-left']")));
	    	Assert.assertEquals(ExecutarTestes.getDriver().findElement(By.xpath("//td[@class='login-info-left']")).getText(), validar);
		} catch (Exception e) {
			System.out.println("Erro no Login");
		}
	}
	
	public static WebElement responsavel_lnk (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.id("reporter_id_filter"));
		return   element ;
	}
	public static WebElement gravidade_lnk (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.id("show_severity_filter"));
		return   element ;
	}
	public static WebElement prioridade_lnk (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.id("show_priority_filter"));
		return   element ;
	}

	public static void responsavel_drop (String login_responsavel) {
		Select responsavelDrop = new Select(ExecutarTestes.getDriver().findElement(By.name("reporter_id[]")));
		responsavelDrop.selectByVisibleText(login_responsavel);
	}
	
	public static String gravidade_drop () {
		Select gravidadeDrop = new Select(ExecutarTestes.getDriver().findElement(By.name("show_severity[]")));
		String[] grav = {"feature","trivial","text","tweak","minor","major","crash","block"};
        Random gerador = new Random();
		String gravidade = grav[gerador.nextInt(7)];
		gravidadeDrop.selectByVisibleText(gravidade);
		return gravidade;
	}

	public static String prioridade_drop () {
		Select prioridadeDrop = new Select(ExecutarTestes.getDriver().findElement(By.name("show_priority[]")));
		String[] prio = {"none", "low", "normal", "high", "urgent", "immediate"};
		Random gerador = new Random();
		String prioridade = prio[gerador.nextInt(5)];
		prioridadeDrop.selectByVisibleText(prioridade);
		return prioridade;
	}

	public static WebElement aplicar_btn (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.xpath("//input[@value='Apply Filter']"));
		return element ; 
	}
}