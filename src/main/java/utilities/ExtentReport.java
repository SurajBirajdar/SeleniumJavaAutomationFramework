package utilities;

import java.util.Objects;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {
	
	private ExtentReport() {}
	
	public static ExtentReports extent;
	public static ExtentTest test; 
	
	public static void iniReports() {
		
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("spark.html");
			extent.attachReporter(spark);
		}
	}
	
	public static void createTest(String testCaseName) {
		test = extent.createTest(testCaseName);
	}
	
	public static void passLog(String message) {
		test.pass(message);
	}
	
	public static void failLog(String message) {
		test.fail(message);
	}
	
	public static void skipLog(String message) {
		test.skip(message);
	}
	
	public static void flushReport() {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
	}
	
	public static void extentLog(String status, String message) {
		if ( status.equals("Pass")) {
			ExtentReport.passLog(message);
		}
		else if(status.equals("Fail")) {
			ExtentReport.failLog(message);
		}
		
		
	}
	
	
	
	
	
	

}
