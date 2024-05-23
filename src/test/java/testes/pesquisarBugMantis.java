package testes;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import pageObjects.pesquisarBugPagina;
import pageObjects.principalPagina;
import utils.utils;

public class pesquisarBugMantis {

private static WebDriver driver;

	public static void pesquisar(String login_responsavel) throws IOException {
		// Usando pageObject
		principalPagina.verBugs_lnk(driver).click();
		pesquisarBugPagina.responsavel_lnk(driver).click();
		pesquisarBugPagina.responsavel_drop(login_responsavel);
		
		pesquisarBugPagina.gravidade_lnk(driver).click();
		String gravidade= pesquisarBugPagina.gravidade_drop();
		
		pesquisarBugPagina.prioridade_lnk(driver).click();
		String prioridade = pesquisarBugPagina.prioridade_drop();
		utils.takeScreenshot("pesquisar_");
		
		pesquisarBugPagina.aplicar_btn(driver).click();
		System.out.println("Pesquisa pelo Responsavel: "+login_responsavel+", Gravidade: "+ gravidade+" e Prioridade: "+prioridade);
		utils.takeScreenshot("resultadoPesquisar_");
	}
	
}

