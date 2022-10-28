package com.e2e.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.e2e.actiondriver.Action;
import com.e2e.testbase.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id = "account_email")
	WebElement userName;

	@FindBy(id = "account_password")
	WebElement passWord;

	@FindBy(xpath = "//button[@data-behavior='continue_button']")
	WebElement confirmBtn;

	@FindBy(xpath = "//button[@data-behavior='login_button']")
	WebElement loginBtn;

	/*
	 * @FindBy (id = "recaptcha-anchor") WebElement robotCheckin;
	 */

	@FindBy(xpath = "//button[@id='recaptcha_disabled_btn']")
	WebElement signInBtn;

	@FindBy(xpath = "//button[@data-behavior = 'save_button']")
	WebElement createBtn;

	@FindBy(id = "account_form_email")
	WebElement createNewAccount;

	// @FindBy (xpath = "//span[contains(text(),'Continue Securely')][2]" )
	// WebElement createAcctBtn;

	

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String uname, String password) throws InterruptedException {
		Action.type(userName, uname);
		Action.type(passWord, password);
		Thread.sleep(7000);
		Action.click(driver, signInBtn);
		return new HomePage();

	}

	public orderPage login1(String uname, String password) throws InterruptedException {
		Action.type(userName, uname);
		Action.click(driver, confirmBtn);
		Action.type(passWord, password);
		Action.click(driver, loginBtn);
		Thread.sleep(2000);
		return new orderPage();

	}
	
	public DelAddressPage login2(String uname, String password) throws InterruptedException {
		Action.type(userName, uname);
		Action.click(driver, confirmBtn);
		Action.type(passWord, password);
		Action.click(driver, loginBtn);
		Thread.sleep(2000);
		return new DelAddressPage();

	}

	public AccountCreationPage createNewAccount(String NewEmail) {
		Action.type(createNewAccount, NewEmail);
		Action.click(driver, createBtn);
		return new AccountCreationPage();
	}

}
