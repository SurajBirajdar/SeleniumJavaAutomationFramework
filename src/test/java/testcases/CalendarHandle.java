package testcases;

import basepackage.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.DatePicker;

public class CalendarHandle extends TestBase {

    @Test
    public void calendarHandle() throws InterruptedException {

        driver.findElement(By.id("datepicker")).click();

        // not valid date
        //DatePicker.selectDate(driver, "32", "March", "2021");

        // Future date
        //DatePicker.selectDate(driver, "10", "March", "2024");

        // Prevous date
        DatePicker.selectDate(driver, "10", "April", "2020");

        Thread.sleep(5000);
    }
}
