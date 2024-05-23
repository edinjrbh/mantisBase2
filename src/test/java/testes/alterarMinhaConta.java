package testes;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

// Import package pageObject.*
import pageObjects.minhaContaPagina;
import pageObjects.principalPagina;
import utils.utils;

public class alterarMinhaConta {

	private static WebDriver driver;

	public static void alterarConta(String login, String senha, String alteraSenha, String email) throws IOException {
		// Usando pageObject
		principalPagina.gerenciarConta_lnk(driver, login).click();
		minhaContaPagina.password_Actual(driver).clear();
		minhaContaPagina.password_Actual(driver).sendKeys(senha);
		minhaContaPagina.password_New(driver).clear();
		minhaContaPagina.password_New(driver).sendKeys(alteraSenha);
		minhaContaPagina.passwordConfirm_New(driver).clear();
		minhaContaPagina.passwordConfirm_New(driver).sendKeys(alteraSenha);
		minhaContaPagina.email_txt(driver).clear();
		minhaContaPagina.email_txt(driver).sendKeys(email);
		utils.takeScreenshot("alterarSenha_");
		minhaContaPagina.alterar_btn(driver).click();
		minhaContaPagina.validarAlteracaoConta(driver);
		utils.takeScreenshot("senhaAlterada_");
	}
}