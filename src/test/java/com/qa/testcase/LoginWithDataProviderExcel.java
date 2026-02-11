package com.qa.testcase;

import java.io.IOException;

import org.apache.poi.hwpf.model.ListData;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.page.Homepage;
import com.qa.page.LoginPage;
import com.qa.utill.Excelutil;

public class LoginWithDataProviderExcel extends BaseTest {

	LoginPage loginP;
	Homepage Homep;

	public LoginWithDataProviderExcel() {
		super();
	}

	@BeforeMethod
	public void setup1() {

		init();
		loginP = new LoginPage();

	}

	@DataProvider(name = "loginData")
	public Object[][] getlogindata() throws IOException {
		String path = "C:\\Users\\anshu\\eclipse-workspace_A5\\2026_InterviewPractice\\src\\main\\java\\com\\qa\\testdata\\New XLSX Worksheet.xlsx";
		return Excelutil.getExcelData(path, "Sheet1");
	}

	@Test(dataProvider = "loginData")
	
	//, dataProviderClass = DataProviderClass.class
	public void TestExcel(String username, String password) {

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//li[@id='Registration Desk']")).click();
		driver.findElement(By.xpath("//input[@id='loginButton']")).click();

		// body

	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
