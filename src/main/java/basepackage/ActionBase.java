package basepackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.ExtentReport;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ActionBase {

    public static WebDriver driver;
    public static  WebDriverWait wait;
    public static int waitInSec = 10;

    public static void initializeDriver() {
        try {
            WebDriverManager.chromiumdriver().setup();
            driver = new ChromeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static void getUrl(String url) {
        driver.get(url);
    }

    public static void waitUntilElementVisible(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitInSec));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void enterValue(WebElement element, String value) {
        try {
            element.sendKeys(value);
            ExtentReport.passLog("Entered value '" + value + "' in field '" + element + "' successfully\n");
        } catch (Exception e) {
            ExtentReport.failLog("Failed ! Unable to entered value '" + value + "' in field '" + element + "' successfully");
            e.printStackTrace();
            Assert.fail("Not able to find/interact with element \n" + e.getClass().getName());
        }
    }

    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void quitbrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();" , element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Scroll Into view till webelement can be viewed
    public static void scrollIntoView(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }







}
