package testcases;

import basepackage.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends TestBase {

    @Test
    public void actionTest() {
      //  WebElement searchElement = driver.findElement(By.id("APjFqb"));
        Actions act = new Actions(driver);
//        act.keyDown(searchElement, Keys.SHIFT).sendKeys("Selenium").keyUp(Keys.SHIFT).build().perform();

        WebElement frame = driver.findElement(By.className("demo-frame"));

        driver.switchTo().frame(frame);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        //act.dragAndDrop(draggable, droppable).build().perform();

        act.clickAndHold(draggable).release(droppable).build().perform();
    }

    @Test
    public void sliderConceptUsingActions() {
        Actions act = new Actions(driver);
        WebElement slider = driver.findElement(By.xpath("//div[@id='js-rangeslider-0']//div[2]"));
        WebElement output = driver.findElement(By.xpath("//output[@id='js-output']"));
        System.out.println("Output before sliding:" + output.getText());
        act.dragAndDropBy(slider,-100,0).build().perform();
        System.out.println("after: " + output.getText());

    }

    @Test
    public void conTextClickConcept() {
        Actions act = new Actions(driver);
        WebElement rightClickBtn = driver.findElement(By.xpath("//span[text()='right click me']"));


    }




}
