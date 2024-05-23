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
		element = ExecutarTestes.getDriver().findElement(By.xpath("//label[@for='remember-login']"));
		return   element ; 
	}
	public static WebElement permitir_ip (WebDriver  driver) {
		element = ExecutarTestes.getDriver().findElement(By.xpath("//label[@for='secure-session']"));
		return   element ;
	}
	public static WebElement botao_Entrar (WebDriver  driver) {
		element = ExecutarTestes.getDriver().findElement(By.xpath("//input[@value='Entrar']"));
		return   element ;
	}
}