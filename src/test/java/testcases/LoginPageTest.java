package testcases;

import org.testng.annotations.*;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basepackage.TestBase;
import pages.LoginPage;
import utilities.ExcelUtil;

public class LoginPageTest extends TestBase {

	@BeforeClass
	public void beforeClass() throws Exception {
		data = new ExcelUtil("testData", "Sheet1");

	}

	@Test
	public void check() {
//		String value = data.getData("RunFlag");
		System.out.println("check on listener and extent report");

		//	data.setCellData("Number", "Num");
	}

	@Test
	public void loginTest() {
		LoginPage logpage = new LoginPage();
		logpage.login();
	}

}