package testes;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

// Import package pageObject.*
import pageObjects.logarPagina;
import pageObjects.principalPagina;
import utils.utils;

public class logarMantis {
private static WebDriver driver;

	public static void logar(String login, String senha) throws IOException {

		logarPagina.username_txt(driver).sendKeys(login);
		logarPagina.botao_Entrar(driver).click();
		logarPagina.password_txt(driver).sendKeys(senha);
		logarPagina.lembrar_password_ck(driver).click();
		logarPagina.permitir_ip(driver).click();
		utils.takeScreenshot("login_");
		logarPagina.botao_Entrar(driver).click();
		principalPagina.usuarioLogado();
		utils.takeScreenshot("logado_");
	}
}

