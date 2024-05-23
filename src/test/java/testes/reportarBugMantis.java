package testes;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

// Import package pageObject.*
import pageObjects.principalPagina;
import pageObjects.reportarBugPagina;
import utils.utils;

public class reportarBugMantis {

private static WebDriver driver;

	public static void reportar(String responsavel, String resumo, String descricao) throws IOException {
		// Usando pageObject
		principalPagina.reportar_lnk(driver).click();
		reportarBugPagina.categoria_drop();
		reportarBugPagina.reproduzido_drop();
		reportarBugPagina.gravidade_drop();
		reportarBugPagina.prioridade_drop();
		utils.takeScreenshot("reportarCombos_");
		reportarBugPagina.resumo_txt(driver).sendKeys(resumo);
		reportarBugPagina.descricao_txt(driver).sendKeys(descricao);
		
		utils.takeScreenshot("reportarTextos_");
		reportarBugPagina.gravar_btn(driver).click();
		reportarBugPagina.numero_bug(driver);
		System.out.println("BUG "+reportarBugPagina.numero_bug(driver)+" reportado com sucesso!");
	}
}

