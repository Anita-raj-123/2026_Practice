package com.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;

public class LoginPage extends BaseTest{

	
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//li[@id='Registration Desk']")
	WebElement registration;
	
	@FindBy(xpath = "//input[@id='loginButton']")
	WebElement loginbutton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Homepage verifylogin(String un, String pas) {
		username.sendKeys(un);
		password.sendKeys(pas);
		registration.click();
		loginbutton.click();
		return new Homepage();
		
	}
	
	

}
