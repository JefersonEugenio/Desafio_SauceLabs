package testCases;

import com.aventstack.extentreports.Status;
import framework.supports.BaseTest;
import framework.utils.FileOperationsAndProperties;
import framework.webDrivers.DriverManager;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tasks.LoginTask;

import static framework.tools.Report.extentTest;

public class LoginTest extends BaseTest {

    private final LoginTask loginTask = new LoginTask(DriverManager.getDriver());

    protected String user = FileOperationsAndProperties.getPropertiesData("dados", "user");
    protected String userLocked = FileOperationsAndProperties.getPropertiesData("dados", "userLocked");
    protected String userProblem = FileOperationsAndProperties.getPropertiesData("dados", "userProblem");
    protected String password = FileOperationsAndProperties.getPropertiesData("dados", "password");

    @Test
    @Tag("user")
    public void loginSuccessWithUserPassword() throws IllegalAccessException {
        extentTest.log(Status.INFO, "Login autenticado no sistema");
        loginTask.accessLoginValidate(user, password);
    }

    @Test
    @Tag("error")
    public void loginFailureNullUserPassword() {
        extentTest.log(Status.INFO, "Login: Os campos 'user' e 'password' deixar em branco");
        loginTask.accessLoginInvalidateNullUserPassword();
    }

    @Test
    @Tag("error")
    public void loginFailureNullPassword() {
        extentTest.log(Status.INFO, "Login: O campo 'password' deixar em branco");
        loginTask.accessLoginInvalidateNullPassword(user);
    }

    @Test
    @Tag("error")
    public void loginFailureNullUser() {
        extentTest.log(Status.INFO, "Login: O campo 'user' deixar em branco");
        loginTask.accessLoginInvalidateNullUser(password);
    }

    @Test
    @Tag("error")
    public void loginFailureIncorrectUserCorrectPassword() {
        extentTest.log(Status.INFO, "Login: O campo 'user' preencher incorreto e o 'password' preencher correto");
        loginTask.accessLoginIncorrectUser("qwert", password);
    }

    @Test
    @Tag("error")
    public void loginFailureCorrectUserIncorrectPassword() {
        extentTest.log(Status.INFO, "Login: O campo 'user' preencher correto e o 'password' preencher incorreto");
        loginTask.accessLoginIncorrectPassword(user, "1234567890");
    }

    @Test
    @Tag("error")
    public void loginFailureIncorrectUserIncorrectPassword() {
        extentTest.log(Status.INFO, "Login: O campo 'user' preencher incorreto e o 'password' preencher incorreto");
        loginTask.accessLoginIncorrectUserIncorrectPassword("qwert", "1234567890");
    }

    @Test
    @Tag("user")
    public void loginLockedUser() {
        extentTest.log(Status.INFO, "Login: O usuário bloqueado");
        loginTask.accessLoginUserLocked(userLocked, password);
    }

    @Test
    @Tag("user")
    public void loginProblemUser() throws IllegalAccessException {
        extentTest.log(Status.INFO, "Login: O usuário problematico");
        loginTask.accessLoginUserProblem(userProblem, password);
    }
}