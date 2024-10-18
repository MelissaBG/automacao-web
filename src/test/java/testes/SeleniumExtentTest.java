package testes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import report.ExtentReportUtil;

public class SeleniumExtentTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Inicializa o driver do Selenium (Chrome neste exemplo)
        System.setProperty("webdriver.chrome.driver", "caminho/para/chromedriver.exe");
        driver = new ChromeDriver();

        // Inicializa o relatório Extent
        ExtentReportUtil.initializeReport("target/relatorios/selenium-relatorio.html");
    }

    @Test
    public void exemploDeTesteSelenium() {
        // Cria um novo teste no relatório
        ExtentReportUtil.createTest("exemploDeTesteSelenium");

        // Teste simples de navegação com Selenium
        driver.get("https://www.google.com");

        // Adiciona informações ao relatório
        if (driver.getTitle().contains("Google")) {
            ExtentReportUtil.getTest().pass("A página do Google foi aberta com sucesso!");
        } else {
            ExtentReportUtil.getTest().fail("Falha ao abrir a página do Google.");
        }
    }

    @AfterClass
    public void tearDown() {
        // Fecha o navegador
        driver.quit();

        // Finaliza o relatório
        ExtentReportUtil.closeReport();
    }
}

