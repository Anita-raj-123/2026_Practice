package com.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.page.Homepage;
import com.qa.page.LoginPage;

public class RegisterPatientTestCase extends BaseTest {

	Homepage Homep;
	LoginPage loginP;

	public RegisterPatientTestCase() {
		super();
	}

	@BeforeMethod
	public void init1() {
		init();
		loginP = new LoginPage();
	}

	
	@Test
	public void Test_Register_patient_TestCase() {
		Homep = loginP.verifylogin("admin", "Admin123");
		Homep.clickregisterpatient();
		Homep.registerpatient();
		}
	
	@AfterMethod
	public void teardown() {
		driver.close();

	}

}
