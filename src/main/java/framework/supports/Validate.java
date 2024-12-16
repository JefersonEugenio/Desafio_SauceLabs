package framework.supports;

import appObjects.LoginApp;
import appObjects.ProductsApp;
import com.aventstack.extentreports.Status;
import framework.tools.Screenshot;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static framework.tools.Report.extentTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class Validate {

    private final WebDriver driver;
    private final LoginApp loginApp;
    private final ProductsApp productsApp;

    public Validate(WebDriver driver) {
        this.driver = driver;
        loginApp = new LoginApp(driver);
        productsApp = new ProductsApp (driver);
    }

    public void validateProducts() throws IllegalAccessException {
        String expectedTitle = "Products";
        String actualTitle = productsApp.getTitleText().getText();
        Assertions.assertEquals(expectedTitle, actualTitle);
        extentTest.log(Status.PASS, "Acessou de login", Screenshot.screenshotBase64(driver));
    }

    public void validarMessageUsername() {
        String expectedMessagemErro = "Username is required";
        String actualMessagemErro = loginApp.getMessageError().getText();
        try {
            assertThat(actualMessagemErro, containsString(expectedMessagemErro));
            extentTest.log(Status.PASS, "Não acessou de login e mensagem 'Epic sadface: Username is required'");
        } catch (AssertionError e) {
            throw e;
        }
    }

    public void validarMessagePassword() {
        String expectedMessagemErro = "Password is required";
        String actualMessagemErro = loginApp.getMessageError().getText();
        try {
            assertThat(actualMessagemErro, containsString(expectedMessagemErro));
            extentTest.log(Status.PASS, "Não acessou de login e mensagem 'Epic sadface: Password is required'");
        } catch (AssertionError e) {
            throw e;
        }
    }

    public void validateUserPasswordField() {
        String expectedMessagemErro = "Username and password do not match any user in this service";
        String actualMessagemErro = loginApp.getMessageError().getText();
        try {
            assertThat(actualMessagemErro, containsString(expectedMessagemErro));
            extentTest.log(Status.PASS, "Não acessou de login e mensagem 'Username and password do not match any user in this service'");
        } catch (AssertionError e) {
            throw e;
        }
    }

    public void validateUserLocked() {
        String expectedMessagemErro = "Sorry, this user has been locked out.";
        String actualMessagemErro = loginApp.getMessageError().getText();
        try {
            assertThat(actualMessagemErro, containsString(expectedMessagemErro));
            extentTest.log(Status.PASS, "Não acessou de login e mensagem 'Sorry, this user has been locked out.'");
        } catch (AssertionError e) {
            throw e;
        }
    }

}