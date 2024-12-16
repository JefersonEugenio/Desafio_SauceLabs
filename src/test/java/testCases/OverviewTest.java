package testCases;

import framework.supports.BaseTest;
import framework.webDrivers.DriverManager;
import org.junit.jupiter.api.Test;
import tasks.OverviewTask;

public class OverviewTest extends BaseTest {

    private final CheckoutTest checkoutTest = new CheckoutTest();
    private final OverviewTask overviewTask = new OverviewTask(DriverManager.getDriver());

    @Test
    public void finishBuyProduct() throws IllegalAccessException {
        checkoutTest.fillCompleteValid();
        overviewTask.finishWithProductCart();
    }

    @Test
    public void cancelBuyProduct() throws IllegalAccessException {
        checkoutTest.fillCompleteValid();
        overviewTask.cancelBuyProductCart();
    }

    @Test
    public void finishBuyWithoutProduct() throws IllegalAccessException {
        checkoutTest.withoutProductFillCompleteValid();
        overviewTask.finishWithoutProductCart();

    }
}