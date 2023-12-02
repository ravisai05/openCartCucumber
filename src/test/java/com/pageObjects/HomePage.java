package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath = "//span[text()='My Account']")
	WebElement hm_myAcct;
	
	@FindBy (xpath ="//a[text()='Register']")
	WebElement hm_Register;
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement hm_Login;
	public void clickMyAcct() {
		hm_myAcct.click();
	}
	public void clickRegister() {
		hm_Register.click();
	}
	public void clickLogin() {
		hm_Login.click();
	}
	

}
