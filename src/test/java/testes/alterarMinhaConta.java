package testes;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

// Import package pageObject.*
import pageObjects.minhaContaPagina;
import pageObjects.principalPagina;

public class alterarMinhaConta {

	private static WebDriver driver;

	public static void alterarConta(String login, String senha, String alteraSenha, String email1, String email2, String texto) throws IOException {
		// Usando pageObject
		principalPagina.gerenciarConta_lnk(driver).click();
		minhaContaPagina.password_txt(driver).clear();
		minhaContaPagina.password_txt(driver).sendKeys(alteraSenha);
		minhaContaPagina.passwordConfirm_txt(driver).clear();
		minhaContaPagina.passwordConfirm_txt(driver).sendKeys(alteraSenha);
		minhaContaPagina.email_txt(driver).clear();
		minhaContaPagina.email_txt(driver).sendKeys(email2);
		minhaContaPagina.alterar_btn(driver).click();
		logarMantis.logar(login, alteraSenha, texto);

		principalPagina.gerenciarConta_lnk(driver).click();
		minhaContaPagina.password_txt(driver).clear();
		minhaContaPagina.password_txt(driver).sendKeys(senha);
		minhaContaPagina.passwordConfirm_txt(driver).clear();
		minhaContaPagina.passwordConfirm_txt(driver).sendKeys(senha);
		minhaContaPagina.email_txt(driver).clear();
		minhaContaPagina.email_txt(driver).sendKeys(email1);
		minhaContaPagina.alterar_btn(driver).click();
		logarMantis.logar(login, senha, texto);
	}
}