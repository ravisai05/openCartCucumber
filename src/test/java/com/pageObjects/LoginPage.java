package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath = "//input[@name='email']")
	WebElement lg_email;
	
	@FindBy (xpath = "//input[@name='password']")
	WebElement lg_password;
	
	@FindBy (xpath="//button[text()='Login']")
	WebElement lg_btn;
	
	public void setEmail(String email) {
	lg_email.sendKeys(email);	
	}
	public void setPassword(String password) {
		lg_password.sendKeys(password);
	}
	public void clickLogin() {
		lg_btn.click();
		
	}
	
	
}
