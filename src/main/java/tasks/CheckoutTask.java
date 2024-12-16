package tasks;

import appObjects.CheckoutApp;
import com.aventstack.extentreports.Status;
import framework.supports.Fakers;
import org.openqa.selenium.WebDriver;

import static framework.tools.Report.extentTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CheckoutTask {

    private final WebDriver driver;
    private final CheckoutApp checkoutApp;
    private final YourCartTask yourCartTask;
    private final Fakers fakers;

    public CheckoutTask (WebDriver driver) {
        this.driver = driver;
        checkoutApp = new CheckoutApp(driver);
        yourCartTask = new YourCartTask(driver);
        fakers = new Fakers();
    }

    public void fillComplete() {
        checkoutApp.getFirstNameFiledText().sendKeys(fakers.getNome());
        extentTest.log(Status.INFO, "Preenche campo do nome");
        checkoutApp.getLastNameFieldText().sendKeys(fakers.getSobrenome());
        extentTest.log(Status.INFO, "Preenche campo do sobrenome");
        checkoutApp.getPostalCodeFieldText().sendKeys(fakers.getPostalCode());
        extentTest.log(Status.INFO, "Preenche campo do CEP");
        checkoutApp.getContinueButton().click();
        extentTest.log(Status.INFO, "Clicou no botão 'CONTINUE'");
    }

    public void nullFirstName() {
        extentTest.log(Status.INFO, "Não preenche campo do nome");
        checkoutApp.getLastNameFieldText().sendKeys(fakers.getSobrenome());
        extentTest.log(Status.INFO, "Preenche campo do sobrenome");
        checkoutApp.getPostalCodeFieldText().sendKeys(fakers.getPostalCode());
        extentTest.log(Status.INFO, "Preenche campo do CEP");
        checkoutApp.getContinueButton().click();
        extentTest.log(Status.INFO, "Clicou no botão 'CONTINUE'");
        assertThat(checkoutApp.getErrorMessageText().getText(), containsString("First Name"));
        extentTest.log(Status.PASS, "Verificou validar 'Error: First Name is required'");
    }

    public void nullLastName() {
        checkoutApp.getFirstNameFiledText().sendKeys(fakers.getNome());
        extentTest.log(Status.INFO, "Preenche campo do nome");
        extentTest.log(Status.INFO, "Não preenche campo do sobrenome");
        checkoutApp.getPostalCodeFieldText().sendKeys(fakers.getPostalCode());
        extentTest.log(Status.INFO, "Preenche campo do CEP");
        checkoutApp.getContinueButton().click();
        extentTest.log(Status.INFO, "Clicou no botão 'CONTINUE'");
        assertThat(checkoutApp.getErrorMessageText().getText(), containsString("Last Name"));
        extentTest.log(Status.PASS, "Verificou validar 'Error: Last Name is required'");
    }

    public void nullZipPostal() {
        checkoutApp.getFirstNameFiledText().sendKeys(fakers.getNome());
        extentTest.log(Status.INFO, "Preenche campo do nome");
        checkoutApp.getLastNameFieldText().sendKeys(fakers.getSobrenome());
        extentTest.log(Status.INFO, "Preenche campo do sobrenome");
        extentTest.log(Status.INFO, "Não preenche campo do CEP");
        checkoutApp.getContinueButton().click();
        extentTest.log(Status.INFO, "Clicou no botão 'CONTINUE'");
        assertThat(checkoutApp.getErrorMessageText().getText(), containsString("Postal Code"));
        extentTest.log(Status.PASS, "Verificou validar 'Error: Postal Code is required'");
    }

    public void nullAllField() {
        extentTest.log(Status.INFO, "Não preenche campo do nome");
        extentTest.log(Status.INFO, "Não preenche campo do sobrenome");
        extentTest.log(Status.INFO, "Não preenche campo do CEP");
        checkoutApp.getContinueButton().click();
        extentTest.log(Status.INFO, "Clicou no botão 'CONTINUE'");
        assertThat(checkoutApp.getErrorMessageText().getText(), containsString("First Name"));
        extentTest.log(Status.PASS, "Verificou validar 'Error: First Name is required'");
    }

    public void clickCancelButton() {
        checkoutApp.getCancelButton().click();
        extentTest.log(Status.INFO, "Clicou no botão 'CANCEL'");
        yourCartTask.titleYourCart();
    }
}
