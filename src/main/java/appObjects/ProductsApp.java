package appObjects;

import com.aventstack.extentreports.Status;
import framework.data.DataHolder;
import framework.data.Storage;
import framework.supports.Wait;
import framework.utils.FileOperationsAndProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

import static framework.tools.Report.extentTest;

public class ProductsApp {

    private final WebDriver driver;
    private final Storage storage;
    private final Wait wait;
    int i = 1;

    public ProductsApp (WebDriver driver) {
        this.driver = driver;
        this.storage = new Storage();
        wait = new Wait(driver);
    }

    public WebElement getTitleText() {
        return driver.findElement(By.cssSelector("#inventory_filter_container > div"));
    }

    public List<WebElement> getAllNameProductsText() {
        List<WebElement> namesProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
        return namesProducts;
    }

    public List<WebElement> getAllPriceProductsText() {
        List<WebElement> priceProducts = driver.findElements(By.cssSelector(".inventory_item_price"));
        return priceProducts;
    }

    public WebElement getNameProductBikeLightText() {
        return driver.findElement(By.id("item_0_title_link"));
    }

    public WebElement getNameProduct(String name) {
        WebElement product = driver.findElement(By.xpath("//div[contains(@class, 'inventory_item_name') and text()='"+name+"']"));
        storage.addProduct(product.getText());

        WebElement price = product.findElement(By.xpath("ancestor::div[contains(@class, 'inventory_item_label')]/following-sibling::div[contains(@class, 'pricebar')]/div"));
        storage.addProduct(price.getText());

        WebElement addToCartButton = product.findElement(By.xpath("ancestor::div[contains(@class, 'inventory_item_label')]/following-sibling::div[contains(@class, 'pricebar')]/button"));

        return addToCartButton;
    }

    public void getPrintProduct () {
        storage.printProducts();
    }

    public WebElement getProductBackpackButton() {
        return driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.pricebar > button"));
    }

    public WebElement getProductBikeLightButton() {
        return driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(2) > div.pricebar > button"));
    }

    public WebElement getProductBoltT_ShirtButton() {
        return driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(3) > div.pricebar > button"));
    }

    public WebElement getProductFleeceJacketButton() {
        return driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(4) > div.pricebar > button"));
    }

    public WebElement getProductOnesieButton() {
        return driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(5) > div.pricebar > button"));
    }

    public WebElement getProductTestTheThingsButton() {
        return driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(6) > div.pricebar > button"));
    }

    public WebElement getNumberCartText() {
        List<WebElement> elements = driver.findElements(By.cssSelector("#shopping_cart_container > a > span"));
        if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
            return driver.findElement(By.cssSelector("#shopping_cart_container > a > span"));
        } else {
            extentTest.log(Status.INFO, "Não aparece notificação no carrinho");
            return null;
        }
    }

    public List<WebElement> getAllButton() {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn_inventory"));
        return buttons;
    }

    public WebElement getButton() {
        return driver.findElement(By.cssSelector(".btn_inventory"));
    }

    public WebElement getBackButton() {
        return driver.findElement(By.cssSelector(".inventory_details_back_button"));
    }

    public Select getFilterSelect() {
        return new Select(driver.findElement(By.cssSelector(".product_sort_container")));
    }

    public WebElement getMenu() {
        return driver.findElement(By.cssSelector(".bm-burger-button"));
    }

    public WebElement getMenuAllItems() {
        wait.waitVisibilityElement(By.id("inventory_sidebar_link"));
        return driver.findElement(By.id("inventory_sidebar_link"));
    }

    public WebElement getMenuAbout() {
        wait.waitVisibilityElement(By.id("about_sidebar_link"));
        return driver.findElement(By.id("about_sidebar_link"));
    }

    public WebElement getMenuLogout() {
        wait.waitVisibilityElement(By.id("logout_sidebar_link"));
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    public WebElement getMenuResetAppState() {
        wait.waitVisibilityElement(By.id("reset_sidebar_link"));
        return driver.findElement(By.id("reset_sidebar_link"));
    }

    public WebElement getMenuX() {
        wait.waitVisibilityElement(By.id("reset_sidebar_link"));
        return driver.findElement(By.cssSelector(".bm-cross-button"));
    }

    public WebElement getIconeCartButton() {
        return driver.findElement(By.id("shopping_cart_container"));
    }
}