package testCases;

import framework.supports.BaseTest;
import framework.webDrivers.DriverManager;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import tasks.ProductsTask;
import tasks.YourCartTask;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class YourCartTest extends BaseTest {

    private final ProductTest productTest = new ProductTest();
    private final ProductsTask productsTask = new ProductsTask(DriverManager.getDriver());
    private final YourCartTask yourCartTask = new YourCartTask(DriverManager.getDriver());

    @Test
    @Order(1)
    public void removeProductCart() throws IllegalAccessException {
        productTest.addProductToCart();
        productsTask.clickIconeCartButton();
        yourCartTask.removeProductCart();
    }

    @Test
    @Order(2)
    public void continueShoppingCart() throws IllegalAccessException {
        productTest.addProductToCart();
        productsTask.clickIconeCartButton();
        yourCartTask.continueShoppingCart();
    }

    @Test
    @Order(3)
    public void checkoutProductCart() throws IllegalAccessException {
        productTest.addProductToCart();
        productsTask.clickIconeCartButton();
        yourCartTask.checkoutCart();
    }

    @Test
    public void checkoutWithoutProductCart() throws IllegalAccessException {
        productTest.withoutProductAddtoCart();
        yourCartTask.checkoutCart();
    }
}
