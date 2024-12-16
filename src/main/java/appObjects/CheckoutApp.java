package appObjects;

import framework.supports.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutApp {

    private final WebDriver driver;
    private final Wait wait;

    public CheckoutApp (WebDriver driver) {
        this.driver = driver;
        wait = new Wait(driver);
    }

    public WebElement getFirstNameFiledText() {
        wait.waitVisibilityElement(By.id("first-name"));
        return driver.findElement(By.id("first-name"));
    }

    public WebElement getLastNameFieldText() {
        return driver.findElement(By.id("last-name"));
    }

    public WebElement getPostalCodeFieldText() {
        return driver.findElement(By.id("postal-code"));
    }

    public WebElement getCancelButton() {
        return driver.findElement(By.cssSelector(".btn_secondary"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.cssSelector(".cart_button"));
    }

    public WebElement getErrorMessageText() {
        return driver.findElement(By.cssSelector("form h3"));
    }
}
