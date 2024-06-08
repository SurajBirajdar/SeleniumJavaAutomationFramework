package basepackage;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import utilities.ExcelUtil;
import utilities.PropertyFileReader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestBase extends ActionBase {
	
	public static String testMethodName;
	
	public static ExcelUtil data;
	public static XWPFDocument doc;
	public static XWPFRun run;
	public static FileOutputStream fos;


	
	@BeforeMethod
	public void beforeMethod(ITestResult result) {
		testMethodName = result.getMethod().getMethodName();
		System.setProperty("testMethodName", testMethodName);
		initializeDriver();
		maximizeWindow();
		getUrl(PropertyFileReader.getPropertyValue("url","configProperties.properties"));
		doc = new XWPFDocument();
		run = doc.createParagraph().createRun();
		run.setText("----------------------------------------------------------");
		run.setText("\n");
		try {
			fos = new FileOutputStream(System.getProperty("user.dir") + "//screenshots//" + testMethodName + ".docx");
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}

	}

	@AfterMethod
	public static void afterMethod() {
		try {
			doc.write(fos);
			fos.flush();
			fos.close();
			doc.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
//		quitbrowser();
	}

}
