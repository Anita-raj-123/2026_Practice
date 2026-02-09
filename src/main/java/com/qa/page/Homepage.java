package com.qa.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BaseTest;

public class Homepage extends BaseTest {

	@FindBy(xpath = "//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']")
	WebElement findpatient;

	@FindBy(xpath = "//input[@id='patient-search']")
	WebElement searchpatient;

	@FindBy(xpath = "//a[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']")
	WebElement registerpatient;

	@FindBy(xpath = "//input[@name='givenName']")
	WebElement Patientname;

	@FindBy(xpath = "//input[@name='familyName']")
	WebElement Familyname;

	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	public void clickfindpatientmenu() {
		findpatient.click();
	}

	public void searchpatient() throws InterruptedException {
		searchpatient.sendKeys("Donald");
		Thread.sleep(2000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-sm dataTable']/tbody/tr"));
		int rowcount = rows.size();
		System.out.println(rowcount);

		String beforexpath = "//table[@class='table table-sm dataTable']/tbody/tr";
		String Afterxpath = "/td[1]";

		for (int i = 1; i <= rowcount; i++) {
			String actualxpath = beforexpath + Afterxpath;
			WebElement element = driver.findElement(By.xpath(actualxpath));
			System.out.println(element.getText());
			if (element.getText().equalsIgnoreCase("100HRU")) {
				System.out.println("Identifier" + element.getText() + "is found" + "at position" + (i - 1));
				break;
			}
		}

		System.out.println("Printing the Row of the WebTable**************************\n");
		for (WebElement e : rows) {

			System.out.println(e.getText());

		}

	}
	
	public void clickregisterpatient() {
		registerpatient.click();
	}

	public void registerpatient() {
		
		driver.findElement(By.xpath("//fieldset[@id='demographics-name']"));
		
		//driver.findElement(By.xpath("//input[@name='givenName']")).sendKeys("ANita");

		Patientname.sendKeys("Test");
		Familyname.sendKeys("Raj");
		driver.findElement(By.xpath("//button[@id='next-button']")).click();

		// select dropdown

		WebElement selectgender = driver.findElement(By.id("gender-field"));

		Select op = new Select(selectgender);
		op.selectByValue("F");
		//op.selectByContainsVisibleText("Female");
		driver.findElement(By.xpath("//button[@id='next-button']")).click();

		driver.findElement(By.xpath("//input[@id='birthdateDay-field']")).sendKeys("14");

		WebElement selectmonthdob = driver.findElement(By.id("birthdateMonth-field"));

		Select op1 = new Select(selectmonthdob);
		op1.selectByValue("1");
		//op1.selectByContainsVisibleText("January");

		driver.findElement(By.xpath("//input[@id='birthdateYear-field']")).sendKeys("1997");
		driver.findElement(By.xpath("//button[@id='next-button']")).click();

		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Ghaziabad, U.P, 201001");
		driver.findElement(By.xpath("//button[@id='next-button']")).click();

		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9080706050");
		driver.findElement(By.xpath("//button[@id='next-button']")).click();

		WebElement selectRelation = driver.findElement(By.xpath("//select[@id='relationship_type']"));

		Select op2 = new Select(selectRelation);

		op2.selectByValue("8d919b58-c2cc-11de-8d13-0010c6dffd0f-A");
		driver.findElement(By.xpath("//input[@placeholder='Person Name']")).sendKeys("Ani");
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
		
		
		driver.findElement(By.xpath("//input[@id='submit']")).click();
		

	}
}
