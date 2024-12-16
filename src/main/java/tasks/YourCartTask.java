package tasks;

import appObjects.YourCartApp;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static framework.tools.Report.extentTest;

public class YourCartTask {

    private final WebDriver driver;
    private final YourCartApp yourCartApp;

    public YourCartTask (WebDriver driver) {
        this.driver = driver;
        yourCartApp = new YourCartApp(driver);
    }

    public void titleYourCart() {
        Assertions.assertEquals("Your Cart", yourCartApp.getTitleText().getText());
        extentTest.log(Status.PASS, "'Your Cart' está a página");
    }

    public void removeProductCart() {
        yourCartApp.getRemoveButton().click();
        extentTest.log(Status.PASS, "Clicou botão 'REMOVE'");
    }

    public void continueShoppingCart() {
        yourCartApp.getContinueShoppingButton().click();
        extentTest.log(Status.PASS, "Clicou botão 'CONTINUE SHOPPING'");
    }

    public void checkoutCart() {
        yourCartApp.getCheckoutButton().click();
        extentTest.log(Status.PASS, "Clicou botão 'CHECKOUT'");
    }
}
