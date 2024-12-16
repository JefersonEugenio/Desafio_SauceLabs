package appObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginApp {

    private final WebDriver driver;

    public LoginApp (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginEmailField() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getLoginPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    public WebElement getMessageError() {
        return driver.findElement(By.cssSelector("#login_button_container > div > form > h3"));
    }
}