package framework.supports;

import com.aventstack.extentreports.Status;
import framework.tools.Report;
import framework.webDrivers.DriverFactory;
import framework.webDrivers.DriverManager;
import framework.webDrivers.Drivers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static framework.tools.Report.extentTest;

public class BaseTest extends DriverFactory {

    @BeforeAll
    public static void setUp() {
        DriverManager.setDriver(getBrowser(Drivers.CHROME));
        Report.configurarExtentReport();
        Report.createTest("Sauce Labs");
        extentTest.log(Status.INFO, "Iniciado de teste");
    }

    @BeforeEach
    public void setUpEach() {
        DriverManager.getDriver().get("https://www.saucedemo.com/v1/index.html");
        extentTest.log(Status.INFO, "Acessou site do Sauce Labs");
    }

    @AfterEach
    public void tearDownEach() {
        extentTest.log(Status.INFO, "Encerrou a sessão!");
    }

    @AfterAll
    public static void tearDown() {
        extentTest.log(Status.INFO, "Finalizado de teste");
        Report.closeReport();
        DriverManager.quit();
    }
}
