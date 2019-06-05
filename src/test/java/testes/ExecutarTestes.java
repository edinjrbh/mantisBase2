package testes;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
		/*
		System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver.exe");
		setDriver(new FirefoxDriver());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().get("https://mantis-prova.base2.com.br/");
		*/
		
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		setDriver (new ChromeDriver());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().get("https://mantis-prova.base2.com.br/");
	}
	@Test
	public void dadosMantis(@Param(name="login") String login, @Param(name="senha") String senha, @Param(name="texto") String texto,
		@Param(name="categoria") String categoria,	@Param(name="resumo") String resumo, @Param(name="descricao") String descricao,
		@Param(name="alteraSenha") String alteraSenha, @Param(name="email1") String email1, @Param(name="email2") String email2) throws IOException{
		logarMantis.logar(login, senha, texto);
		reportarBugMantis.reportar(categoria, login, resumo, descricao);
		reportarBugMantis.reportar(categoria, login, resumo, descricao);
		reportarBugMantis.reportar(categoria, login, resumo, descricao);
		pesquisarBugMantis.pesquisar(login);
		alterarMinhaConta.alterarConta(login, senha, alteraSenha, email1, email2, texto);
		pesquisarBugMantis.pesquisar(login);
	}
	
    @After
    public void tearDown(){
        //Fechar o navegador
    driver.quit();
    }
}