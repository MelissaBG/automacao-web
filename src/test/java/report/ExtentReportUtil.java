package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportUtil {

    private static ExtentReports extent;
    private static ExtentTest test;

    // Inicializa o ExtentReports com o caminho para o relatório
    public static void initializeReport(String reportPath) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    // Cria um novo teste no relatório
    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    // Obtém o teste atual
    public static ExtentTest getTest() {
        return test;
    }

    // Finaliza o relatório
    public static void closeReport() {
        if (extent != null) {
            extent.flush(); // Gera o relatório final
        }
    }
}


