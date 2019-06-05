package pageObjects;

import  org.openqa.selenium.By ; 
import  org.openqa.selenium.WebDriver ; 
import  org.openqa.selenium.WebElement ;
import testes.ExecutarTestes;


public class logarPagina {
	
	private static WebElement element = null;

	public static WebElement username_txt (WebDriver  driver) {
		element = ExecutarTestes.getDriver().findElement(By.name("username"));
		return   element ; 
	}
	public static WebElement password_txt (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.name("password"));
		return   element ; 
	} 
	public static WebElement lembrar_password_ck (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.name("perm_login"));
		return   element ; 
	}
	public static WebElement botao_Login (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.xpath("//input[@value='Login']"));
		return   element ; 
	}
	public static WebElement esqueci_Senha (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.xpath("//a[@href='lost_pwd_page.php']"));
		return   element ; 
	}
}