package pageObjects;

import  org.openqa.selenium.By ; 
import  org.openqa.selenium.WebDriver ; 
import  org.openqa.selenium.WebElement ;
import org.openqa.selenium.support.ui.Select;

import testes.ExecutarTestes;

public class minhaContaPagina {

	private static WebElement element = null; 
	
	public static void perfil_drop (String perfil) {
		Select perfilDrop = new Select(ExecutarTestes.getDriver().findElement(By.name("profile_id")));
		perfilDrop.selectByVisibleText(perfil);
	}
	public static WebElement password_txt (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.name("password"));
		return element; 
	}
	public static WebElement passwordConfirm_txt (WebDriver  driver) { 
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
		element = ExecutarTestes.getDriver().findElement(By.xpath("//input[@value='Update User']"));
		return element ; 
	}
	
	public static String numero_bug(WebDriver  driver){
		element = ExecutarTestes.getDriver().findElement(By.xpath("//a[starts-with(@href, 'view.php?id=')]"));
		String numero_bug = element.getText().substring(20,element.getText().length());
		return numero_bug;
	}
}