package testcases;

import basepackage.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class SVGHandle extends TestBase {

    @Test
    public void handleSVG() throws InterruptedException {

        Thread.sleep(10000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,400)");

//        List<WebElement> graphList =driver.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='g']//*[name()='path']"));
        List<WebElement> graphList =driver.findElements(By.xpath("//*[local-name()='svg']"));
        System.out.println(graphList.size());
        for(WebElement e : graphList) {
            System.out.println("start");
            String name = e.getAttribute("name");
            System.out.println(name);
        }
    }
}
