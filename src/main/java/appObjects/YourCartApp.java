package appObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCartApp {

    private final WebDriver driver;

    public YourCartApp(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTitleText() {
        return driver.findElement(By.cssSelector(".subheader"));
    }

    public WebElement getRemoveButton() {
        return driver.findElement(By.cssSelector(".item_pricebar button"));
    }

    public WebElement getContinueShoppingButton() {
        return driver.findElement(By.cssSelector(".cart_footer .btn_secondary"));
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(By.cssSelector(".cart_footer .btn_action"));
    }
}
