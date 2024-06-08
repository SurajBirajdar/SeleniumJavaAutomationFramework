package testcases;

import basepackage.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTableHandle extends TestBase {

    @Test
    public void webtableHandle() throws InterruptedException {

        while(true) {
            if(driver.findElements(By.xpath("//td[text()='Hong Kong']")).size() > 0) {
                selectCountry("Hong Kong");
                break;
            }
            else {
                WebElement next = driver.findElement(By.linkText("Next"));
                if(next.getAttribute("class").contains("disable")) {
                    System.out.println("pagination is over...country not found");
                    break;
                }
                Thread.sleep(1000);
                next.click();
            }
        }

    }

    public static void selectCountry(String countryName) {
        driver.findElement(By.xpath("//td[text()='"+countryName+"']/preceding-sibling::td/child::input[@type='checkbox']"))
                .click();

    }
}


