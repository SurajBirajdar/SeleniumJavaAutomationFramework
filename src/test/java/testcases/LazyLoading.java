package testcases;

import basepackage.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class LazyLoading extends TestBase {

    @Test
    public void lazyLoadingHandle() throws InterruptedException {
        WebElement location = driver.findElement(By.id("location"));
        waitUntilElementVisible(location, 10);
        enterValue(location, "Pune");
        Thread.sleep(2000);
        WebElement exactLocation = driver.findElement(By.xpath("//span[@class='_2W-T9' and text()='Pune, Maharashtra, India']"));
        waitUntilElementVisible(exactLocation, 10);
        click(exactLocation);
        Thread.sleep(8000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String last_height = js.executeScript("return document.body.scrollHeight").toString();
        List<WebElement> resultList = null;
        while(true) {
            resultList = driver.findElements(By.xpath("//div[@class='nA6kb']//ancestor::a"));
            resultList.stream().forEach(e -> System.out.println(e.getText()));
            scrollPageDown();
            Thread.sleep(1500);
//            String new_height = js.executeScript("return document.body.scrollHeight").toString();
//            if(new_height.equals(last_height)) {
//                break;
//            }
//            last_height = new_height;
        }

        }

    public static void scrollPageDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //97543
    }

    @Test
    public void lazyLoadOnMediumApp() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String last_height = js.executeScript("return document.body.scrollHeight").toString();
        List<WebElement> resultList = null;
        while(true) {
            resultList = driver.findElements(By.xpath("//h2[contains(@class,'by')]"));
            resultList.stream().forEach(e -> System.out.println(e.getText()));
            scrollPageDown();
            Thread.sleep(1500);
            String new_height = js.executeScript("return document.body.scrollHeight").toString();
            if(new_height.equals(last_height)) {
                break;
            }
            last_height = new_height;
        }
    }

}
