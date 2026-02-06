package com.qa.testcase;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.BaseTest;
import com.qa.dbConnection.db;
import com.qa.page.Homepage;
import com.qa.page.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class HomeTestCase  extends BaseTest{

	Homepage  Homep;
	
	LoginPage loginP;
	
	public static com.relevantcodes.extentreports.ExtentReports reports;
	public static com.relevantcodes.extentreports.ExtentTest test;
	
	
	public HomeTestCase() {
		super();
	}
	
	
	@BeforeMethod
	public void init1() {
		init();
		reports = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\anshu\\eclipse-workspace_A5\\2026_InterviewPractice\\ExtendReport\\report1.html", true);
		test = reports.startTest("Extent report demo");
		loginP = new LoginPage();
			}
	
	
	@Test
	public void TestHomePage() throws InterruptedException, IOException {
		test.log(LogStatus.INFO, "Test Home Page Will Pass");
		
		Map<String, String> user = db.getLoginUser();
		String username = user.get("username");
        String password = user.get("password");
        Homep =  loginP.verifylogin(username, password);
        Homep.clickfindpatientmenu();
        Homep.searchpatient();
		test.log(LogStatus.PASS,test.addScreenCapture(ss(driver)) + "FIRST TEST CASE");
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
		reports.endTest(test);
		reports.flush();
	}
	
	
	public static String ss(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Destination = new File("C:\\Users\\anshu\\eclipse-workspace_A5\\2026_InterviewPractice\\ScreenShot\\Img" + System.currentTimeMillis() + ".png");
		String s = Destination.getAbsolutePath();
		FileUtils.copyFile(src,Destination);
		return s;
	}
	
	

}
