package pages;

import java.util.concurrent.TimeUnit;

import basepackage.ActionBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExtentReport;
import utilities.PropertyFileReader;

import static utilities.ScreenshotUtil.captureSnapshot;
import static utilities.JavascriptExecutorUtil.highLighter;

public class LoginPage extends ActionBase {

	@FindBy(id="username")
	public WebElement username;

	@FindBy(id="password")
	public WebElement password;

	@FindBy(id="Login")
	public WebElement loginBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public Homepage login() {
		try {
			enterValue(username, PropertyFileReader.getPropertyValue("username", "configProperties.properties") );
			highLighter(username);
			enterValue(password, PropertyFileReader.getPropertyValue("password", "configProperties.properties") );
			highLighter(password);
			captureSnapshot();
		//	click(loginBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Homepage();
	}


	public static void main(String[] args) {
		 /*ChromeOptions co=new ChromeOptions();
		 co.addArguments("--disable-notifications");
		 co.addArguments("--remote-allow-origins=*");
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver(co);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.get("https://login.salesforce.com");
		 driver.findElement(By.id("username")).sendKeys("Test");
		 driver.findElement(By.id("password")).sendKeys("Test@123");
		 driver.findElement(By.id("Login")).click();
		 driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		 driver.findElement(By.xpath("//button[text()='View All']")).click();
		 driver.findElement(By.xpath("//p[text()='Sales']")).click();
		 WebElement ele=driver.findElement(By.xpath("//a[@title='Accounts']//span[text()='Accounts']"));
		 driver.executeScript("arguments[0].click();",ele);
		 String name="KISHORE";
		 WebElement inputBox=driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']"));
		 inputBox.sendKeys(name);
		 inputBox.sendKeys(Keys.ENTER);
	//	 driver.findElement(By.xpath("//span[text()='Show Actions']/preceding-sibling::span//*[name()='svg']")).click();

		// driver.findElement(By.xpath("//li[@role='presentation']//following-sibling::div[@title='Edit']")).click();
		 driver.findElement(By.xpath("//*[local-name()='svg' and @class='slds-button__icon' and @data-key='settings']")).click();
		 
		 
		 try {
			 ExtentReport.extentLog("Pass", "Pass");
			 
		 } catch(Exception e) {
			 String message = " failed";
			 ExtentReport.extentLog("Fail", message);
		 }
		 */
	}



}


