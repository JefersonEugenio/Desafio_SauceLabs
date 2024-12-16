package testCases;

import com.aventstack.extentreports.Status;
import framework.supports.BaseTest;
import framework.webDrivers.DriverManager;
import org.junit.jupiter.api.Test;
import tasks.CheckoutTask;

import static framework.tools.Report.extentTest;

public class CheckoutTest extends BaseTest {

    private final YourCartTest yourCartTest = new YourCartTest();
    private final CheckoutTask checkoutTask = new CheckoutTask(DriverManager.getDriver());

    @Test
    public void fillCompleteValid() throws IllegalAccessException {
        yourCartTest.checkoutProductCart();
        extentTest.log(Status.INFO, "Preenche completo informação");
        checkoutTask.fillComplete();
    }

    @Test
    public void withoutProductFillCompleteValid() throws IllegalAccessException {
        yourCartTest.checkoutWithoutProductCart();
        extentTest.log(Status.INFO, "Preenche completo informação");
        checkoutTask.fillComplete();
    }

    @Test
    public void firstNameNullField() throws IllegalAccessException {
        yourCartTest.checkoutProductCart();
        extentTest.log(Status.INFO, "Campo 'First Name' em branco");
        checkoutTask.nullFirstName();
    }

    @Test
    public void lastNameNullField() throws IllegalAccessException {
        yourCartTest.checkoutProductCart();
        extentTest.log(Status.INFO, "Campo 'Last Name' em branco");
        checkoutTask.nullLastName();
    }

    @Test
    public void postalCodeNullField() throws IllegalAccessException {
        yourCartTest.checkoutProductCart();
        extentTest.log(Status.INFO, "Campo 'Postal Code' em branco");
        checkoutTask.nullZipPostal();
    }

    @Test
    public void allNullField() throws IllegalAccessException {
        yourCartTest.checkoutProductCart();
        extentTest.log(Status.INFO, "Todos os campos em branco");
        checkoutTask.nullAllField();
    }

    @Test
    public void cancelButton() throws IllegalAccessException {
        yourCartTest.checkoutProductCart();
        extentTest.log(Status.INFO, "Clicar no botão 'CANCEL");
        checkoutTask.clickCancelButton();
    }
}
