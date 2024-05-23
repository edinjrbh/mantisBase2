package pageObjects;

import org.junit.Assert;
import  org.openqa.selenium.By ;
import  org.openqa.selenium.WebDriver ; 
import  org.openqa.selenium.WebElement ;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
import testes.ExecutarTestes;

import static org.hamcrest.CoreMatchers.containsString;

public class minhaContaPagina {

	private static WebElement element = null; 

	public static WebElement password_Actual (WebDriver  driver) {
		element = ExecutarTestes.getDriver().findElement(By.name("password_current"));
		return element; 
	}
	public static WebElement password_New (WebDriver  driver) {
		element = ExecutarTestes.getDriver().findElement(By.name("password"));
		return element;
	}
	public static WebElement passwordConfirm_New (WebDriver  driver) {
		element = ExecutarTestes.getDriver().findElement(By.name("password_confirm"));
		return element ; 
	}
	public static WebElement email_txt (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.name("email"));
		return element ; 
	}
	public static WebElement nome_txt (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.name("realname"));
		return element ; 
	}
	
	public static WebElement alterar_btn (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.xpath("//input[@value='Atualizar Usuário']"));
		return element ; 
	}

	public static void validarAlteracaoConta (WebDriver  driver) {
		WebDriverWait wait = new WebDriverWait(ExecutarTestes.getDriver(), 2);
		Assert.assertThat(ExecutarTestes.getDriver().findElement(By.xpath("//div[@class='alert alert-success center']")).getText(), containsString("com sucesso"));
	}
}

