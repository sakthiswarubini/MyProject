package com.e2e.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.e2e.actiondriver.Action;
import com.e2e.testbase.BaseClass;

public class CheckOutPage extends BaseClass{
	
		
	@FindBy(xpath = "//input[@placeholder= 'Enter email address']")
	WebElement confirmEmail;
	
	@FindBy(xpath = "//button[@data-behavior='continue_button']")
	WebElement confirmBtn;
	
	@FindBy(xpath = "//input[@id = 'account_password']")
	WebElement confirmPwd;
	
	@FindBy(xpath = "//button[@data-behavior='login_button']")
	WebElement loginBtn;
	
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public orderPage confirmEmailAddress(String uName, String pwd1) {
		Action.type(confirmEmail, uName);
		Action.click(driver, confirmBtn);
		Action.type(confirmPwd, pwd1);
		Action.click(driver, loginBtn);
		return new orderPage();
	}
	
	
	
	
}
