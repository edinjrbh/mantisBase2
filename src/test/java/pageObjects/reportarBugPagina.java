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
	
	public static void categoria_drop () {
		Select categoriaDrop = new Select(ExecutarTestes.getDriver().findElement(By.name("category_id")));
		categoriaDrop.selectByVisibleText("[Todos os Projetos] nova categoria");
	}
	public static void reproduzido_drop () {
		Select reproduzidoDrop = new Select(ExecutarTestes.getDriver().findElement(By.name("reproducibility")));
		String[] rep = {"sempre", "às vezes", "aleatório", "não se tentou", "incapaz de reproduzir", "N/D"};
        Random gerador = new Random();
		String reproduzido = rep[gerador.nextInt(5)];
		reproduzidoDrop.selectByVisibleText(reproduzido);
	}
	public static void gravidade_drop () {
		Select gravidadeDrop = new Select(ExecutarTestes.getDriver().findElement(By.name("severity")));
		String[] grav = {"recurso","trivial","texto","mínimo","pequeno","grande","travamento","obstáculo"};
        Random gerador = new Random();
		String gravidade = grav[gerador.nextInt(7)];
		gravidadeDrop.selectByVisibleText(gravidade);
	}
	public static void prioridade_drop () {
		Select prioridadeDrop = new Select(ExecutarTestes.getDriver().findElement(By.name("priority")));
		String[] prio = {"nenhuma", "baixa", "normal", "alta", "urgente", "imediato"};
		Random gerador = new Random();
		String prioridade = prio[gerador.nextInt(5)];
		prioridadeDrop.selectByVisibleText(prioridade);
	}
	public static void perfil_drop (String perfil) {
		Select perfilDrop = new Select(ExecutarTestes.getDriver().findElement(By.name("profile_id")));
		perfilDrop.selectByVisibleText(perfil);
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
		element = ExecutarTestes.getDriver().findElement(By.xpath("//input[@value='Criar Nova Tarefa']"));
		return element ; 
	}
	
	public static String numero_bug(WebDriver  driver){
		element = ExecutarTestes.getDriver().findElement(By.xpath("//a[starts-with(@href, 'view.php?id=')]"));
		String numero_bug = element.getText().substring(26,element.getText().length());
		utils.takeScreenshot("bug_"+numero_bug+"_reportado");
		return numero_bug;
	}
}