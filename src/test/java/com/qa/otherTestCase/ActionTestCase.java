package com.qa.otherTestCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionTestCase {

	WebDriver driver;
	
	static ExtentReports report;
	static ExtentTest test;

	@BeforeMethod
	public void Launch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://ultimateqa.com/automation");
		report = new ExtentReports("C:\\Users\\anshu\\eclipse-workspace_A5\\2026_InterviewPractice\\ExtendReport\\R1.html",true);
        test = report.startTest("@nd Test Case");
	}
	
	@Test
	public void Action_testCase() throws InterruptedException, IOException {
		test.log(LogStatus.INFO, "Action Test Case");
		Actions act = new Actions(driver);
		WebElement click_Edu = driver.findElement(By.xpath("//ul[@id='menu-main-menu']//li[@id='menu-item-218225']//a[@href='#'][normalize-space()='Education']"));
		WebElement click_freecource = driver.findElement(By.xpath("//ul[@id='menu-main-menu']//li[@id='menu-item-217933']"));
		act.moveToElement(click_Edu).build().perform();
		act.moveToElement(click_freecource).click().perform();
		
		Thread.sleep(2000);
		String title = driver.findElement(By.xpath("//h2[normalize-space()='Products']")).getText();
		System.out.println(title);
		test.log(LogStatus.PASS,test.addScreenCapture(ss1(driver)) + "Test Case Passed");
	}

	public static String ss1(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Desti = new File ("C:\\Users\\anshu\\eclipse-workspace_A5\\2026_InterviewPractice\\ScreenShot\\S1"+ System.currentTimeMillis() + ".png");
		String absolute_path = Desti.getAbsolutePath();
		FileUtils.copyFile(src, Desti);
		return absolute_path ;
	}
	@AfterMethod
	public void teardown() {
		driver.close();
		report.endTest(test);
		report.flush();
	}

}
