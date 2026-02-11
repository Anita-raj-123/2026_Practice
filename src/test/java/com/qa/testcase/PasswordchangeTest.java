package com.qa.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.page.Homepage;
import com.qa.page.LoginPage;
import com.qa.utill.Excelutil;

public class PasswordchangeTest extends BaseTest {

	LoginPage loginP;
	Homepage Homep;

	public PasswordchangeTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		init();
		loginP = new LoginPage();
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin123");
//		driver.findElement(By.xpath("//li[@id='Registration Desk']")).click();
//		driver.findElement(By.xpath("//input[@id='loginButton']")).click();
	}

	@DataProvider(name = "changepassword")
	public Object[][] getdata() throws IOException {
		String path = "C:\\Users\\anshu\\eclipse-workspace_A5\\2026_InterviewPractice\\src\\main\\java\\com\\qa\\testdata\\PasswordChange.xlsx";
		return Excelutil.getExcelData(path, "Sheet1");
	}

	@Test(dataProvider = "changepassword")
	public void TestPasswordChange(String Ols_pas, String New_pass, String Confir_pass) {
		
		Homep = loginP.verifylogin("admin", "Admin123");

		Actions act = new Actions(driver);
		WebElement clickadminbutton = driver.findElement(By.xpath("//li[@class='nav-item identifier']"));

		WebElement clickMyAccount = driver.findElement(By.xpath("//a[normalize-space()='My Account']"));
		act.moveToElement(clickadminbutton).moveToElement(clickMyAccount).click().perform();

		//click on changepassword menu
		driver.findElement(By.xpath("//a[@href='/openmrs/adminui/myaccount/changePassword.page']")).click();
		
		
		driver.findElement(By.xpath("//input[@id='oldPassword-field']")).sendKeys(Ols_pas);
		driver.findElement(By.xpath("//input[@id='newPassword-field']")).sendKeys(New_pass);
		driver.findElement(By.xpath("//input[@id='newPassword-field']")).sendKeys(Confir_pass);
		

		driver.findElement(By.xpath("//input[@id='save-button']")).click();

	}

	@AfterMethod
	public void teardown() {
		driver.close();

	}

}
