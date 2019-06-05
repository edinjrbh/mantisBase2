package testes;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

// Import package pageObject.*
import pageObjects.logarPagina;
import pageObjects.principalPagina;
import utils.utils;

public class logarMantis {

private static WebDriver driver;

	public static void logar(String login, String senha, String texto) throws IOException {
		// Usando pageObject
		logarPagina.username_txt(driver).sendKeys(login);
		logarPagina.password_txt(driver).sendKeys(senha);
		logarPagina.lembrar_password_ck(driver).click();
		utils.takeScreenshot("login_");
		
		logarPagina.botao_Login(driver).click();
		// screenShot depois
		principalPagina.textoLogin(texto);
		utils.takeScreenshot("logado_");
		System.out.println("Login efetuado com sucesso");
	}
}

