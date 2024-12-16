package tasks;

import appObjects.ProductsApp;
import com.aventstack.extentreports.Status;
import framework.data.Storage;
import framework.tools.Screenshot;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static framework.tools.Report.extentTest;

public class ProductsTask {

    private final WebDriver driver;
    private final ProductsApp productsApp;

    int i = 1;

    public ProductsTask (WebDriver driver) {
        this.driver = driver;
        productsApp = new ProductsApp(driver);
    }

    public void clickIconeCartButton() {
        productsApp.getIconeCartButton().click();
        extentTest.log(Status.PASS, "Clicou icone 'CARRINHO'");
    }

    public void addToCartProduct() throws IllegalAccessException {
        productsApp.getProductBikeLightButton().click();
        extentTest.log(Status.INFO, "Clicar no botão 'ADD TO CART' do produto ");
        Assertions.assertEquals("REMOVE", productsApp.getProductBikeLightButton().getText());
        extentTest.log(Status.PASS, "Verificado nome no botão para 'REMOVE'", Screenshot.screenshotBase64(driver));
        Assertions.assertEquals(Integer.toString(i), productsApp.getNumberCartText().getText());
        extentTest.log(Status.INFO, "Notificação no carrinho: " + productsApp.getNumberCartText().getText());
        i++;
    }

    public void removeProduct() {
        String teste = productsApp.getNameProductBikeLightText().getText();
        System.out.println(teste);
        productsApp.getProductBikeLightButton().click();
        extentTest.log(Status.INFO, "Clicar no botão 'ADD TO CART' produto do " + productsApp.getNameProductBikeLightText().getText());
        Assertions.assertEquals("REMOVE", productsApp.getProductBikeLightButton().getText());
        extentTest.log(Status.PASS, "Verificado nome no botão para 'REMOVE'");
        productsApp.getProductBikeLightButton().click();
        extentTest.log(Status.INFO, "Clicar no botão 'REMOVE' produto do " + productsApp.getNameProductBikeLightText().getText());
        Assertions.assertEquals("ADD TO CART", productsApp.getProductBikeLightButton().getText());
        extentTest.log(Status.PASS, "Verificado nome no botão para 'ADD TO CART'");
        productsApp.getNumberCartText();
    }

    public void allNamesProducts() {
        List<String> productNames = new ArrayList<>();

        for (WebElement element : productsApp.getAllNameProductsText()) {
            productNames.add(element.getText());
        }

        System.out.println(productNames);
        for (String nameProduto : productNames) {
            if (nameProduto.equals("Sauce")) {
                System.out.println("passou");

            }
        }
    }

    public void allPriceProducts() {
        List<String> productPrice = new ArrayList<>();

        for (WebElement element : productsApp.getAllPriceProductsText()) {
            productPrice.add(element.getText());
        }

        System.out.println(productPrice);
    }

    public void allButtonProduct() {
        int i = 0;
        for (WebElement button : productsApp.getAllButton()) {
            if (button.isDisplayed()) {
                button.click();
                extentTest.log(Status.INFO, "Clicar no botão 'ADD TO CART'");
                Assertions.assertEquals("REMOVE", productsApp.getButton().getText());
                i++;
            }
        }
        Assertions.assertEquals(Integer.toString(i), productsApp.getNumberCartText().getText());
    }

    public void pageRemoveProduct() {
        productsApp.getProductBikeLightButton().click();
        extentTest.log(Status.INFO, "Clicar no botão 'ADD TO CART' produto do " + productsApp.getNameProductBikeLightText().getText());
        productsApp.getNameProductBikeLightText().click();
        productsApp.getButton().click();
        extentTest.log(Status.INFO, "Clicar no botão 'REMOVE'");
        Assertions.assertEquals("ADD TO CART", productsApp.getButton().getText());
        productsApp.getBackButton().click();
        Assertions.assertEquals("ADD TO CART", productsApp.getProductBikeLightButton().getText());
        productsApp.getNumberCartText();
    }

    public void filterZtoA() {
        productsApp.getFilterSelect().selectByValue("za");
        extentTest.log(Status.INFO, "Clicou no filtro para ordenar de Z a A");
    }

    public void filterPriceLowToHigh() {
        productsApp.getFilterSelect().selectByValue("lohi");
        extentTest.log(Status.INFO, "Clicou no filtro para ordenar os preços do menor para o maior");
    }

    public void filterPriceHighToLow() {
        productsApp.getFilterSelect().selectByValue("hilo");
        extentTest.log(Status.INFO, "Clicou no filtro para ordenar os preços do maior para o menor");
    }

    public void menuAllItems() {
        productsApp.getMenu().click();
        extentTest.log(Status.INFO, "Clicou no menu e aparece uma lista");
        productsApp.getMenuAllItems().click();
        extentTest.log(Status.INFO, "Clicou no 'All Items' e mostrou os produtos na página");
    }

    public void menuAbout() {
        productsApp.getMenu().click();
        extentTest.log(Status.INFO, "Clicou no menu e aparece uma lista");
        productsApp.getMenuAbout().click();
        extentTest.log(Status.INFO, "Clicou no 'About' e redirecionar para site de 'SauceLabs'");
    }

    public void menuLogout() {
        productsApp.getMenu().click();
        extentTest.log(Status.INFO, "Clicou no menu e aparece uma lista");
        productsApp.getMenuLogout().click();
        extentTest.log(Status.INFO, "Clicou no 'Logout' e redirecionar para a tela de login, deslogando o usuário");
    }

    public void menuReset() {
        productsApp.getProductBikeLightButton().click();
        extentTest.log(Status.INFO, "Clicar no botão 'ADD TO CART' produto do " + productsApp.getNameProductBikeLightText().getText());
        Assertions.assertEquals("REMOVE", productsApp.getProductBikeLightButton().getText());
        extentTest.log(Status.PASS, "Verificado nome no botão para 'REMOVE'");
        Assertions.assertEquals("1", productsApp.getNumberCartText().getText());
        extentTest.log(Status.INFO, "Notificação no carrinho: " + productsApp.getNumberCartText().getText());
        productsApp.getMenu().click();
        extentTest.log(Status.INFO, "Clicou no menu e aparece uma lista");
        productsApp.getMenuResetAppState().click();
        extentTest.log(Status.INFO, "Clicou no 'Reset App State'");
        productsApp.getNumberCartText();
        Assertions.assertEquals("ADD TO CART", productsApp.getProductBikeLightButton().getText());
    }

    public void menuClose() {
        productsApp.getMenu().click();
        extentTest.log(Status.INFO, "Clicou no menu e aparece uma lista");
        productsApp.getMenuX().click();
        extentTest.log(Status.INFO, "Clicou no 'X' e menu fechar");
    }

}
