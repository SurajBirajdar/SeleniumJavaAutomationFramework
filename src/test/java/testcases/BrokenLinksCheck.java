package testcases;

import basepackage.ActionBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.TreeSet;

public class BrokenLinksCheck extends ActionBase  {

    @Test
    public void brokenLinksCheck() {
        initializeDriver();
        driver.get("https://www.hyrtutorials.com/");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> links = driver.findElements(By.tagName("a"));
        TreeSet<String> brokenLinks = new TreeSet<>();
        for(WebElement link : links) {
            String linkURL = link.getAttribute("href");
            try {
                URL url = new URL(linkURL);
                URLConnection openConnection = url.openConnection();
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if(responseCode != 200 || responseCode != 201) {
                    brokenLinks.add(linkURL);
                }
                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(String brokenLink : brokenLinks) {
            System.out.println(brokenLink);
        }

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
