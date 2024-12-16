package tasks;

import appObjects.OverviewApp;
import appObjects.ProductsApp;
import com.aventstack.extentreports.Status;
import framework.data.DataHolder;
import framework.data.Storage;
import framework.supports.Calcule;
import framework.tools.Screenshot;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static framework.tools.Report.extentTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class OverviewTask {

    private final WebDriver driver;
    private final ProductsApp productsApp;
    private final OverviewApp overviewApp;
    private final Calcule calcule;

    public OverviewTask (WebDriver driver) {
        this.driver = driver;
        this.calcule = new Calcule();
        productsApp = new ProductsApp(driver);
        overviewApp = new OverviewApp(driver);
    }

    public void finishWithProductCart() throws IllegalAccessException {
        Assertions.assertEquals("Checkout: Overview", overviewApp.getTitleText().getText());
        extentTest.log(Status.PASS, "Verificou a página está 'Overview'");
        boolean element = overviewApp.getProductsDisplayed().isDisplayed();
        Assertions.assertTrue(element);
        extentTest.log(Status.PASS, "Existe o produto na página", Screenshot.screenshotBase64(driver));
        Assertions.assertEquals("$9.99", overviewApp.getPriceProductText().getText());
        String totalValor = calcule.calculeTotal(overviewApp.getItemTotalText().getText(), overviewApp.getTaxText().getText());
        assertThat(overviewApp.getTotalText().getText(), containsString(calcule.calculeTotal(overviewApp.getItemTotalText().getText(), overviewApp.getTaxText().getText())));
        extentTest.log(Status.PASS, "O valor do total está correto: " + totalValor, Screenshot.screenshotElement(overviewApp.getInfoImageTxt(), driver));
        overviewApp.getFinishButton().click();
        extentTest.log(Status.INFO, "Clicou no botão 'FINISH'");
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", overviewApp.getThankYouText().getText());
        extentTest.log(Status.PASS, "Finalizado de comprar", Screenshot.screenshotBase64(driver));
    }

    public void finishWithoutProductCart() throws IllegalAccessException {
        Assertions.assertEquals("Checkout: Overview", overviewApp.getTitleText().getText());
        extentTest.log(Status.PASS, "Verificou a página está 'Overview'");
        overviewApp.getFinishButton().click();
        extentTest.log(Status.INFO, "Clicou no botão 'FINISH'");
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", overviewApp.getThankYouText().getText());
        extentTest.log(Status.FAIL, "Finalizado de comprar SEM PRODUTO", Screenshot.screenshotBase64(driver));
    }

    public void cancelBuyProductCart() throws IllegalAccessException {
        Assertions.assertEquals("Checkout: Overview", overviewApp.getTitleText().getText());
        extentTest.log(Status.PASS, "Verificou a página está 'Overview'");
        boolean element = overviewApp.getProductsDisplayed().isDisplayed();
        Assertions.assertTrue(element);
        extentTest.log(Status.PASS, "Existe o produto na página", Screenshot.screenshotBase64(driver));
        Assertions.assertEquals("$9.99", overviewApp.getPriceProductText().getText());
        String totalValor = calcule.calculeTotal(overviewApp.getItemTotalText().getText(), overviewApp.getTaxText().getText());
        assertThat(overviewApp.getTotalText().getText(), containsString(calcule.calculeTotal(overviewApp.getItemTotalText().getText(), overviewApp.getTaxText().getText())));
        extentTest.log(Status.PASS, "O valor do total está correto: " + totalValor, Screenshot.screenshotElement(overviewApp.getInfoImageTxt(), driver));
        overviewApp.getCancelButton().click();
        extentTest.log(Status.INFO, "Clicou no botão 'CANCEL'");
        Assertions.assertEquals("Products", productsApp.getTitleText().getText());
        extentTest.log(Status.PASS, "Redirecionar para a tela principal com a lista de produtos", Screenshot.screenshotBase64(driver));
    }
}
