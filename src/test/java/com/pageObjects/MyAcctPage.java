package com.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAcctPage extends BasePage {

	public MyAcctPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy (xpath="//h2[text()='My Account']")
	WebElement myact_MSG;
	
	@FindBy (xpath="//a[text() ='Logout']")
	WebElement logout;
	
	
	public boolean isMyAccountExist() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		try {
			
			return (myact_MSG.isDisplayed());
			
		}catch (Exception e) {
			// TODO: handle exception
			return (false);
		}
	}
	public void clickLogout() {
		logout.click();
		
	}
}
