package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Calendar;
import java.util.List;

public class DatePicker {
    // Select future date and old dates
    public static void selectDate(WebDriver driver, String dateToSelect, String monthToSelect, String yearToSelect) throws InterruptedException
    {
        boolean status = false;

        while (!status)
        {
            String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if(Integer.parseInt(dateToSelect)>31)
            {
                System.out.println("Not valid date");
                break;
            }

            if(Integer.parseInt(yearToSelect)< Calendar.getInstance().get(Calendar.YEAR))
            {

                Thread.sleep(100);

                if (month.contains(monthToSelect) && year.contains(yearToSelect))
                {
                    status = true;
                    driver.findElement(By.xpath("//a[text()='"+dateToSelect+"']")).click();
                    break;

                }
                else {
                    driver.findElement(By.xpath("//span[text()='Prev']")).click();
                }

            }
            else
            {
                if (month.contains(monthToSelect) && year.contains(yearToSelect))
                {
                    status = true;
                    driver.findElement(By.xpath("//a[text()='"+dateToSelect+"']")).click();
                    break;

                }else
                {
                    System.out.println("Click Next");
                    driver.findElement(By.xpath("//span[text()='Next']")).click();
                    Thread.sleep(100);
                }
            }



        }
    }


    // Select single value, multiple value, all values
    public static void selectValues(WebDriver driver,By locator,String... a)
    {

        boolean status=false;

        List<WebElement> allValues=driver.findElements(locator);

        if(a[0].equalsIgnoreCase("all"))
        {
            System.out.println("Selecting all values ");

            for(WebElement ele:allValues)
            {
                try
                {
                    ele.click();
                    status=true;
                } catch (Exception e)
                {
                }
            }
        }
        else
        {
            for(String data:a)
            {
                for(WebElement ele:allValues)
                {
                    if(ele.getText().equalsIgnoreCase(data))
                    {
                        ele.click();
                        status=true;
                        break;
                    }
                }
            }
        }
        if(!status)
        {
            System.out.println("Invalid Selection");
        }

    }


    // Clicks till last product
    public static boolean isMoreItemPresent(WebDriver driver,String headerSection) throws InterruptedException {



        boolean status=false;

        while(!status)
        {

            By locator=By.xpath("//h3[text()='"+headerSection+"']//parent::div//parent::div//div[contains(@class,'custom-navigation')]");

            String value=driver.findElement(locator).getAttribute("class");

            if(value.contains("disabled"))
            {
                status=true;
                break;
            }

            driver.findElement(locator).click();

            Thread.sleep(2000);

        }


        return status;
    }

    // Select product based on header
    public static boolean isMoreItemPresent(WebDriver driver,String headerSection,String itemToClick) throws InterruptedException {

        boolean status=false;

        By product=By.xpath("//h3[text()='Recommended for you']//parent::div//parent::div//div[contains(@title,'"+itemToClick+"')]");

        while(!status)
        {
            if(driver.findElements(product).size()>0)
            {
                driver.findElement(product).click();
                break;

            }
            else
            {
                By locator=By.xpath("//h3[text()='"+headerSection+"']//parent::div//parent::div//div[contains(@class,'custom-navigation')]");

                String value=driver.findElement(locator).getAttribute("class");

                if(value.contains("disabled"))
                {
                    status=true;

                }

                driver.findElement(locator).click();
                Thread.sleep(2000);
            }
        }

        return status;
    }
}
