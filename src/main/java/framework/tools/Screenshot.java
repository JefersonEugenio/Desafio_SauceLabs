package framework.tools;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.openqa.selenium.*;

public class Screenshot {

    public static Media screenshotBase64(WebDriver driver) throws IllegalAccessException {
        if (driver == null) {
            throw new IllegalAccessException("WebDriver não pode ser null");
        }
        String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        return MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build();
    }

    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static Media screenshotElement(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        String base64Screenshot = element.getScreenshotAs(OutputType.BASE64);
        return MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build();
    }

}