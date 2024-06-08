package basepackage;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.ExtentReport;

public class Listener implements ITestListener, ISuiteListener{

	public void onStart(ISuite suite) {
		ExtentReport.iniReports();
	}

	public void onFinish(ISuite suite) {
		ExtentReport.flushReport();
	}

	public void onTestStart(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		ExtentReport.createTest(testMethodName);
		System.out.println("Test is starting");
	}

	public void onTestSuccess(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		ExtentReport.passLog(testMethodName + " is passed");
		System.out.println("this methid is passed");
	}

	public void onTestFailure(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		ExtentReport.failLog(testMethodName + " is failed");
	}

	public void onTestSkipped(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		ExtentReport.skipLog(testMethodName + " is skipped");
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}
	
	
	
	

}
