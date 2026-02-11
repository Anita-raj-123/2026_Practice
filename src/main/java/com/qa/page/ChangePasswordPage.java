package com.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;

public class ChangePasswordPage extends BaseTest{
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='oldPassword-field']")
	WebElement  old;
	
	@FindBy(xpath = "//input[@id='newPassword-field']")
	WebElement New;
	
	@FindBy(xpath = "//input[@id='confirmPassword-field']")
	WebElement confirm;
	
	@FindBy(xpath = "//input[@id='save-button']")
	WebElement submit;
	
	public ChangePasswordPage(WebDriver driver) {
	//	 this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	public void verifychangepassword(String old_pass, String New_pass, String Confirm_pass) throws InterruptedException {
		old.sendKeys(old_pass);
		New.sendKeys(New_pass);
		confirm.sendKeys(Confirm_pass);
		Thread.sleep(1000);
		submit.click();
		
	}
	
	

}
