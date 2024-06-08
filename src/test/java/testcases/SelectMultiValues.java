package testcases;

import basepackage.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.DatePicker;

public class SelectMultiValues extends TestBase {

    @Test
    public void selectMultiValues() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();

        //DatePicker.selectValues(driver, By.xpath("//span[@class='comboTreeItemTitle']"), "All");

        //DatePicker.selectValues(driver, By.xpath("//span[@class='comboTreeItemTitle']"), "SelectAll");

        //DatePicker.selectValues(driver, By.xpath("//span[@class='comboTreeItemTitle']"), "choice 1");

        DatePicker.selectValues(driver, By.xpath("//span[@class='comboTreeItemTitle']"), "choice 1","choice 2","choice 2 2");


        Thread.sleep(2000);
    }
}
