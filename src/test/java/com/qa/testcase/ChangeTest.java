package com.qa.testcase;

import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.page.ChangePasswordPage;
import com.qa.page.Homepage;
import com.qa.page.LoginPage;
import com.qa.utill.ExcelUtil1;

public class ChangeTest extends BaseTest {

	LoginPage loginP;
	Homepage Homep;
	
	ChangePasswordPage change_password;

	public ChangeTest() {
		super();
	}
	

	@BeforeMethod
	public void setup() {
		init();
		loginP = new LoginPage();
		Homep = loginP.verifylogin("admin", "Admin123");
		
	}
	
	@DataProvider(name = "change")
    public Object[][] getRegisterData() throws Exception {

        String path = System.getProperty("user.dir") 
                + "\\src\\main\\java\\com\\qa\\testdata\\PasswordChange.xlsx";
        return ExcelUtil1.getExcelData(path, "Sheet1");
    }
	
	@Test(dataProvider = "change")
	public void TestChange_Pass(String old_pass,String New_pass,String Confirm_pass) throws InterruptedException {
		
		
		Actions act = new Actions(driver);
		WebElement clickadminbutton = driver.findElement(By.xpath("//li[@class='nav-item identifier']"));

		WebElement clickMyAccount = driver.findElement(By.xpath("//a[normalize-space()='My Account']"));
		act.moveToElement(clickadminbutton).moveToElement(clickMyAccount).click().perform();

		//click on changepassword menu
		driver.findElement(By.xpath("//a[@href='/openmrs/adminui/myaccount/changePassword.page']")).click();
		
		change_password = new ChangePasswordPage(driver);
		
		change_password.verifychangepassword(old_pass, New_pass, Confirm_pass);
		
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
