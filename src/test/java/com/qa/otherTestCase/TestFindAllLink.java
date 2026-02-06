package com.qa.otherTestCase;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindAllLink {

	WebDriver driver;

	@BeforeMethod
	public void Launch2() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://club.ministryoftesting.com");

	}

	@Test
	public void findAllLink_TestCase() {
		java.util.List<WebElement> linklist1 = driver.findElements(By.tagName("a"));
		System.out.println("Total Link is :" + " " + linklist1.size());

		for (WebElement e : linklist1) {

			String alllinkPrint = e.getText();
			System.out.println(alllinkPrint);

		}

	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
