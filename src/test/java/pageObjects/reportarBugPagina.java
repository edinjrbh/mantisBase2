package pageObjects;

import java.util.Random;

import  org.openqa.selenium.By ; 
import  org.openqa.selenium.WebDriver ; 
import  org.openqa.selenium.WebElement ;
import org.openqa.selenium.support.ui.Select;

import testes.ExecutarTestes;
import utils.utils;

public class reportarBugPagina {

	private static WebElement element = null; 
	
	public static void categoria_drop (String categoria) {
		Select categoriaDrop = new Select(ExecutarTestes.getDriver().findElement(By.name("category_id")));
		categoriaDrop.selectByVisibleText(categoria);
	}
	public static void reproduzido_drop () {
		Select reproduzidoDrop = new Select(ExecutarTestes.getDriver().findElement(By.name("reproducibility")));
		String[] rep = {"always", "sometimes", "random", "have not tried", "unable to reproduce", "N/A"};
        Random gerador = new Random();
		String reproduzido = rep[gerador.nextInt(5)];
		reproduzidoDrop.selectByVisibleText(reproduzido);
	}
	public static void gravidade_drop () {
		Select gravidadeDrop = new Select(ExecutarTestes.getDriver().findElement(By.name("severity")));
		String[] grav = {"feature","trivial","text","tweak","minor","major","crash","block"};
        Random gerador = new Random();
		String gravidade = grav[gerador.nextInt(7)];
		gravidadeDrop.selectByVisibleText(gravidade);
	}
	public static void prioridade_drop () {
		Select prioridadeDrop = new Select(ExecutarTestes.getDriver().findElement(By.name("priority")));
		String[] prio = {"none", "low", "normal", "high", "urgent", "immediate"};
		Random gerador = new Random();
		String prioridade = prio[gerador.nextInt(5)];
		prioridadeDrop.selectByVisibleText(prioridade);
	}
	public static void perfil_drop (String perfil) {
		Select perfilDrop = new Select(ExecutarTestes.getDriver().findElement(By.name("profile_id")));
		perfilDrop.selectByVisibleText(perfil);
	}
	public static void responsavel_drop (String responsavel) {
		Select responsavelDrop = new Select(ExecutarTestes.getDriver().findElement(By.name("handler_id")));
		responsavelDrop.selectByVisibleText(responsavel);
	}
	public static WebElement resumo_txt (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.name("summary"));
		return element; 
	}
	public static WebElement descricao_txt (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.name("description"));
		return element ; 
	}
	public static WebElement gravar_btn (WebDriver  driver) { 
		element = ExecutarTestes.getDriver().findElement(By.xpath("//input[@value='Submit Report']"));
		return element ; 
	}
	
	public static String numero_bug(WebDriver  driver){
		element = ExecutarTestes.getDriver().findElement(By.xpath("//a[starts-with(@href, 'view.php?id=')]"));
		String numero_bug = element.getText().substring(20,element.getText().length());
		utils.takeScreenshot("bug_"+numero_bug+"_");
		return numero_bug;
	}
}