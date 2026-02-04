package com.qa.testcase;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.dbConnection.db;
import com.qa.page.Homepage;
import com.qa.page.LoginPage;

public class HomeTestCase  extends BaseTest{

	Homepage  Homep;
	
	LoginPage loginP;
	
	public HomeTestCase() {
		super();
	}
	
	
	@BeforeMethod
	public void init1() {
		init();
		loginP = new LoginPage();
	}
	
	
	@Test
	public void TestHomePage() throws InterruptedException {
		
		Map<String, String> user = db.getLoginUser();
		String username = user.get("username");
        String password = user.get("password");
        Homep =  loginP.verifylogin(username, password);
        Homep.clickfindpatientmenu();
        Homep.searchpatient();
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
