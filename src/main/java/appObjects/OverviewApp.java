package appObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewApp {

    private final WebDriver driver;

    public OverviewApp (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTitleText() {
        return driver.findElement(By.cssSelector(".subheader"));
    }

    public WebElement getProductsDisplayed() {
        return driver.findElement(By.cssSelector(".cart_item"));
    }

    public WebElement getPriceProductText() {
        return driver.findElement(By.cssSelector(".inventory_item_price"));
    }

    public WebElement getInfoImageTxt() {
        return driver.findElement(By.cssSelector(".summary_info"));
    }
    public WebElement getItemTotalText() {
        return driver.findElement(By.cssSelector(".summary_subtotal_label"));
    }

    public WebElement getTaxText() {
        return driver.findElement(By.cssSelector(".summary_tax_label"));
    }

    public WebElement getTotalText() {
        return driver.findElement(By.cssSelector(".summary_total_label"));
    }

    public WebElement getCancelButton() {
        return driver.findElement(By.cssSelector(".btn_secondary"));
    }

    public WebElement getFinishButton() {
        return driver.findElement(By.cssSelector(".btn_action"));
    }

    public WebElement getThankYouText(){
        return driver.findElement(By.cssSelector(".complete-header"));
    }

}