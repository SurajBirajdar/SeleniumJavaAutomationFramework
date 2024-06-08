package testcases;

import basepackage.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PopupWindowHandle extends TestBase {

    @Test
    public void popUpHandle() {
        driver.findElement(By.id("newWindowBtn")).click();

    }
}
