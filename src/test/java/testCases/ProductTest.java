package testCases;

import com.aventstack.extentreports.Status;
import framework.data.Storage;
import framework.supports.BaseTest;
import framework.webDrivers.DriverManager;
import org.junit.jupiter.api.*;
import tasks.ProductsTask;

import static framework.tools.Report.extentTest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductTest extends BaseTest {

    private final LoginTest loginTest = new LoginTest();
    private final ProductsTask productsTask = new ProductsTask(DriverManager.getDriver());

    @Test
    public void showAllNamesProducts() throws IllegalAccessException {
        loginTest.loginSuccessWithUserPassword();
        productsTask.allNamesProducts();
    }

    @Test
    public void showAllPriceProducts() throws IllegalAccessException {
        loginTest.loginSuccessWithUserPassword();
        productsTask.allPriceProducts();
    }

    @Test
    @Order(2)
    public void addProductToCart() throws IllegalAccessException {
        extentTest.log(Status.INFO, "Adicionar um produto para carrinho");
        loginTest.loginSuccessWithUserPassword();
        productsTask.addToCartProduct();
    }

    @Test
    public void withoutProductAddtoCart() throws IllegalAccessException {
        extentTest.log(Status.INFO, "Sem adicionar um produto para carrinho");
        loginTest.loginSuccessWithUserPassword();
        productsTask.clickIconeCartButton();

    }

    @Test
    @Order(1)
    public void removeProduct() throws IllegalAccessException {
        extentTest.log(Status.INFO, "O produto remove carrinho");
        loginTest.loginSuccessWithUserPassword();
        productsTask.removeProduct();
    }

    @Test
    @Order(3)
    public void addAllProductToCart() throws IllegalAccessException {
        extentTest.log(Status.INFO, "Adicionar todos os produtos para carrinho");
        loginTest.loginSuccessWithUserPassword();
        productsTask.allButtonProduct();
    }

    @Test
    @Tag("bug")
    public void pageProductRemoveButton() throws IllegalAccessException {
        extentTest.log(Status.INFO, "Adicionar um produto na pagina, acessa os detalhes do produto e clica no botão 'remove' para removê-lo");
        loginTest.loginSuccessWithUserPassword();
        productsTask.pageRemoveProduct();
    }

    @Test
    @Tag("filter")
    public void selectFilterProduct() throws IllegalAccessException {
        extentTest.log(Status.INFO, "Ordenar de Z para A, preço do menor para o maior e do maior para o menor");
        loginTest.loginSuccessWithUserPassword();
        productsTask.filterZtoA();
        productsTask.filterPriceLowToHigh();
        productsTask.filterPriceHighToLow();
    }

    @Test
    @Tag("menu")
    public void menuAllItems() throws IllegalAccessException {
        extentTest.log(Status.INFO, "O menu 'All Items'");
        loginTest.loginSuccessWithUserPassword();
        productsTask.menuAllItems();
    }

    @Test
    @Tag("menu")
    @Tag("about")
    public void menuAbout() throws IllegalAccessException {
        extentTest.log(Status.INFO, "O menu 'About'");
        loginTest.loginSuccessWithUserPassword();
        productsTask.menuAbout();
    }

    @Test
    @Tag("menu")
    @Tag("logout")
    public void menuLogout() throws IllegalAccessException {
        extentTest.log(Status.INFO, "O menu 'Logout'");
        loginTest.loginSuccessWithUserPassword();
        productsTask.menuLogout();
    }

    @Test
    @Tag("menu")
    @Tag("bug")
    public void menuReset() throws IllegalAccessException {
        extentTest.log(Status.INFO, "O menu 'Reset App State'");
        loginTest.loginSuccessWithUserPassword();
        productsTask.menuReset();
    }

    @Test
    @Tag("menu")
    public void menuX() throws IllegalAccessException {
        extentTest.log(Status.INFO, "O menu 'X'");
        loginTest.loginSuccessWithUserPassword();
        productsTask.menuClose();
    }

}