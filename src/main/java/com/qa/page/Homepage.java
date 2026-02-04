package com.qa.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BaseTest;

public class Homepage extends BaseTest {
	
	
	@FindBy(xpath =  "//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']")
    WebElement findpatient;
	
	@FindBy(xpath = "//input[@id='patient-search']")
	WebElement searchpatient;
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickfindpatientmenu() {
		findpatient.click();
	}
	
	public void searchpatient() throws InterruptedException {
		searchpatient.sendKeys("VICO");
		Thread.sleep(2000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		
		List<WebElement> rows =   driver.findElements(By.xpath("//table[@class='table table-sm dataTable']/tbody/tr"));
        int rowcount = rows.size();
        System.out.println(rowcount);
        
        String beforexpath = "//table[@class='table table-sm dataTable']/tbody/tr";
        String Afterxpath = "/td[1]";
        
        
        for(int i =1 ; i <=rowcount ; i++) {
        	String actualxpath = beforexpath + Afterxpath;
        	WebElement element = driver.findElement(By.xpath(actualxpath));
        	System.out.println(element.getText());
        	if(element.getText().equalsIgnoreCase("100HRU")) {
        		System.out.println("Identifier" + element.getText() + "is found" + "at position" + (i-1));
        		break;
        	}
        }
        
        
        System.out.println("Printing the Firt Row of the WebTable**************************\n");
        for(WebElement e : rows) {
        	
        	System.out.println(e.getText());
        	
        }
        
        
		
		
		
	}
}
