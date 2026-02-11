package com.qa.testcase;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.dbConnection.db;
import com.qa.page.Homepage;
import com.qa.page.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestLoginWithDataProvider1 extends BaseTest{
	
	
	
	LoginPage loginP;
	Homepage  Homep;
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeMethod
	public void setup() {
		init();
		loginP = new LoginPage();
		reports = new ExtentReports("C:\\Users\\anshu\\eclipse-workspace_A5\\2026_InterviewPractice\\ExtendReport\\R2.html");
		test = reports.startTest("Testing the Login With DataProvider");
	}
	
	@DataProvider(name = "loginData")
	public Object[][] getData() {

	    return new Object[][] {
	        {"admin", "Admin123"},
	        {"user1", "user123"},
	        
	    };
	}
	
	@Test(dataProvider = "loginData")
	public void loginTest(String username1, String password1) throws IOException {

		test.log(LogStatus.INFO,"Testing the Login");
	    driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username1);
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password1);
	    driver.findElement(By.xpath("//li[@id='Registration Desk']")).click();
	    driver.findElement(By.xpath("//input[@id='loginButton']")).click();
	    test.log(LogStatus.PASS,test.addScreenCapture(ss1(driver)), "Login Pass");
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
		reports.endTest(test);
		reports.flush();
	}

	public static String ss1(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Desti = new File("C:\\Users\\anshu\\eclipse-workspace_A5\\2026_InterviewPractice\\ScreenShot\\S1" + System.currentTimeMillis() +".png");
		String auth = Desti.getAbsolutePath();
		FileUtils.copyFile(src,Desti);
		return auth;
	}
}
