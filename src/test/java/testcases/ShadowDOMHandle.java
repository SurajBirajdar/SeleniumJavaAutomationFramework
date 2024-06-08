package testcases;

import basepackage.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ShadowDOMHandle extends TestBase {

    @Test
    public void handleShadow() throws InterruptedException {

        SearchContext host = driver.findElement(By.xpath("//div[@id='userName']")).getShadowRoot();
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        Thread.sleep(5000);
//        SearchContext shadowDom = (SearchContext) js.executeScript("return arguments[0].shadowRoot", host);
        host.findElement(By.cssSelector("#kills")).sendKeys("kills");

    }

}
