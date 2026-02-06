package com.qa.otherTestCase;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertTestCase {
	
	WebDriver driver;
	
	@BeforeMethod
	public void Launch1() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoqa.com/alerts");
		
	}
	
	@Test
	public void Alert_TestCase() throws InterruptedException {
		
		
		WebElement WebEle = driver.findElement(By.xpath("//button[@id='alertButton']"));
		WebEle.click();
		
		Thread.sleep(2000);
		Alert obj = driver.switchTo().alert();
		
		String getText1 = obj.getText();
	    System.out.println(getText1);
	    Thread.sleep(2000);
	    
        obj.accept();
	   
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
