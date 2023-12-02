package com.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPag  extends BasePage{

	public RegisterPag(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	JavascriptExecutor js=(JavascriptExecutor) driver;
	
	@FindBy (xpath = "//input[@id='input-firstname']")
	WebElement reg_firstName;
	
	@FindBy(xpath ="//input[@id='input-lastname']")
	WebElement reg_lastName;
	
	@FindBy(xpath ="//input[@id='input-email']")
	WebElement reg_email;
	
	@FindBy (xpath="//input[@id='input-password']")
	WebElement reg_password;
	
	@FindBy (xpath="//input[@name='agree']")
	WebElement reg_privacy;
	@FindBy (xpath="//button[text()='Continue']")
	WebElement reg_continue;
	@FindBy (xpath="//input[@name='newsletter']")
	WebElement sub;
	@FindBy (xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement MSG;
	public void setFirstName(String firstName) {
		reg_firstName.sendKeys(firstName);
	}
	public void setLastName(String lastName) {
		reg_lastName.sendKeys(lastName);
	}
	public void setEmail(String email) {
		reg_email.sendKeys(email);
	}
	public void setPassword(String password) {
		reg_password.sendKeys(password);
	}
	public void agreePrivacy() {
	        // Now the element should be in view and you can interact with it
		js.executeScript("arguments[0].click();", reg_privacy);
	}
	public void clickRegister() {
		js.executeScript("arguments[0].click();", reg_continue);
	}
	public String confirmationMsg() {
		try {
			return (MSG.getText());
			
		}catch (Exception e) {
			// TODO: handle exception
			return (e.getMessage());
		}
	}

}
