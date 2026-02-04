package com.qa.testcase;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.dbConnection.db;
import com.qa.page.Homepage;
import com.qa.page.LoginPage;

public class LoginTestCase  extends BaseTest{
	
	
	
	LoginPage loginP;
	Homepage  Homep;
	
	@BeforeMethod
	public void setup() {
		init();
		loginP = new LoginPage();
	}
	
	@Test
	public void logiTestCase() {
		Map<String, String> user = db.getLoginUser();
		String username = user.get("username");
        String password = user.get("password");

        // 2️⃣ Login via POM
        Homep =  loginP.verifylogin(username, password);
        

        // 3️⃣ Validate login success
        Assert.assertFalse(
            driver.getCurrentUrl().contains("dashboard"),
            "Login failed!" );
		
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
