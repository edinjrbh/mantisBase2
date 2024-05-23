package testes;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.google.gson.JsonObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 */
@SuppressWarnings("unused")
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InfLoginDD.csv")

public class ExecutarTestes {

	private static WebDriver driver;
	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		ExecutarTestes.driver = driver;
	}

	@Before
	public void setUp(){	

		System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver.exe");
		setDriver(new FirefoxDriver());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().get("https://mantis-prova.base2.com.br/");

/*		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		setDriver (new ChromeDriver());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().get("https://mantis-prova.base2.com.br/");
*/	}
	@Test
	public void dadosMantis(@Param(name="login") String login,
							@Param(name="senha") String senha,
							@Param(name="alteraSenha") String alteraSenha,
							@Param(name="resumo") String resumo,
							@Param(name="descricao") String descricao,
							@Param(name="email1") String email1,
							@Param(name="email2") String email2) throws IOException{
		//Executa Login na Aplicação
		logarMantis.logar(login, senha);
		//Faz o reporte de um BUG com dados aleatórios(gravidade, reprodução, etc.
		reportarBugMantis.reportar(login, resumo, descricao);
		//reportarBugMantis.reportar(categoria, login, resumo, descricao);
		//reportarBugMantis.reportar(categoria, login, resumo, descricao);

		//Faz a pesquisa de um BUG, com filtros aleatórios
		pesquisarBugMantis.pesquisar(login);
		pesquisarBugMantis.pesquisar(login);

		//Faz a Alteração do e-mail e senha e loga novamente confirmando a alteração
		alterarMinhaConta.alterarConta(login, senha, alteraSenha, email2);
		logarMantis.logar(login, alteraSenha);

		//Faz a Alteração do e-mail e senha, para o Original e loga novamente confirmando a alteração
		alterarMinhaConta.alterarConta(login, alteraSenha, senha, email1);
		logarMantis.logar(login, senha);

		//Faz nova pesquisa de um BUG, após alteração de senha com filtros aleatórios
		pesquisarBugMantis.pesquisar(login);
	}


    @After
    public void tearDown(){
        //Fechar o navegador
    driver.quit();
    }
}