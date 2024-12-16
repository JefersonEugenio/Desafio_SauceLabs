package tasks;

import appObjects.LoginApp;
import appObjects.ProductsApp;
import com.aventstack.extentreports.Status;
import framework.supports.Validate;
import org.openqa.selenium.WebDriver;

import static framework.tools.Report.extentTest;

import static org.hamcrest.MatcherAssert.assertThat;


public class LoginTask {

    private final WebDriver driver;
    private final LoginApp loginApp;
    private final ProductsApp productsApp;
    private final ProductsTask productsTask;
    private final Validate validate;

    public LoginTask (WebDriver driver) {
        this.driver = driver;
        loginApp = new LoginApp(driver);
        productsApp = new ProductsApp (driver);
        productsTask = new ProductsTask(driver);
        validate = new Validate(driver);
    }

    public void accessLoginValidate(String user, String password) throws IllegalAccessException {
        loginApp.getLoginEmailField().sendKeys(user);
        extentTest.log(Status.INFO, "Preenche do usuário: " + user);
        loginApp.getLoginPasswordField().sendKeys(password);
        extentTest.log(Status.INFO, "Preenche do senha");
        loginApp.getLoginButton().click();
        extentTest.log(Status.INFO, "Clicar no botão 'LOGIN'");
        validate.validateProducts();
    }

    public void accessLoginInvalidateNullUserPassword() {
        extentTest.log(Status.INFO, "Deixar em branco no campo do usuário");
        extentTest.log(Status.INFO, "Deixar em branco no campo do senha");
        loginApp.getLoginButton().click();
        extentTest.log(Status.INFO, "Clicar no botão 'LOGIN'");
        validate.validarMessageUsername();
    }

    public void accessLoginInvalidateNullPassword(String user) {
        loginApp.getLoginEmailField().sendKeys(user);
        extentTest.log(Status.INFO, "Preenche do usuário: " + user);
        extentTest.log(Status.INFO, "Deixar em branco no campo do senha");
        loginApp.getLoginButton().click();
        extentTest.log(Status.INFO, "Clicar no botão 'LOGIN'");
        validate.validarMessagePassword();
    }

    public void accessLoginInvalidateNullUser(String password) {
        extentTest.log(Status.INFO, "Deixar em branco no campo do usuário");
        loginApp.getLoginPasswordField().sendKeys(password);
        extentTest.log(Status.INFO, "Preenche do senha");
        loginApp.getLoginButton().click();
        extentTest.log(Status.INFO, "Clicar no botão 'LOGIN'");
        validate.validarMessageUsername();
    }

    public void accessLoginIncorrectUser(String user, String password) {
        loginApp.getLoginEmailField().sendKeys(user);
        extentTest.log(Status.INFO, "Preenche incorreto no campo do usuário: " + user);
        loginApp.getLoginPasswordField().sendKeys(password);
        extentTest.log(Status.INFO, "Preenche do senha");
        loginApp.getLoginButton().click();
        extentTest.log(Status.INFO, "Clicar no botão 'LOGIN'");
        validate.validateUserPasswordField();
    }

    public void accessLoginIncorrectPassword(String user, String password) {
        loginApp.getLoginEmailField().sendKeys(user);
        extentTest.log(Status.INFO, "Preenche no campo do usuário: " + user);
        loginApp.getLoginPasswordField().sendKeys(password);
        extentTest.log(Status.INFO, "Preenche incorreto no campo do senha: " + password);
        loginApp.getLoginButton().click();
        extentTest.log(Status.INFO, "Clicar no botão 'LOGIN'");
        validate.validateUserPasswordField();
    }

    public void accessLoginIncorrectUserIncorrectPassword(String user, String password) {
        loginApp.getLoginEmailField().sendKeys(user);
        extentTest.log(Status.INFO, "Preenche incorreto no campo do usuário: " + user);
        loginApp.getLoginPasswordField().sendKeys(password);
        extentTest.log(Status.INFO, "Preenche incorreto no campo do senha: " + password);
        loginApp.getLoginButton().click();
        extentTest.log(Status.INFO, "Clicar no botão 'LOGIN'");
        validate.validateUserPasswordField();
    }

    public void accessLoginUserLocked(String user, String password) {
        loginApp.getLoginEmailField().sendKeys(user);
        extentTest.log(Status.INFO, "Preenche do usuário: " + user);
        loginApp.getLoginPasswordField().sendKeys(password);
        extentTest.log(Status.INFO, "Preenche do senha");
        loginApp.getLoginButton().click();
        extentTest.log(Status.INFO, "Clicar no botão 'LOGIN'");
        validate.validateUserLocked();
    }

    public void accessLoginUserProblem(String user, String password) throws IllegalAccessException {
        loginApp.getLoginEmailField().sendKeys(user);
        extentTest.log(Status.INFO, "Preenche do usuário: " + user);
        loginApp.getLoginPasswordField().sendKeys(password);
        extentTest.log(Status.INFO, "Preenche do senha");
        loginApp.getLoginButton().click();
        extentTest.log(Status.INFO, "Clicar no botão 'LOGIN'");
        validate.validateProducts();
    }

}