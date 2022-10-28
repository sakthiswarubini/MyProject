/**
 * 
 */
package com.e2e.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.e2e.actiondriver.Action;
import com.e2e.testbase.BaseClass;

/**
 * @author sakth
 *
 */
public class AccountCreationPage extends BaseClass {

	@FindBy(xpath = "//h3[contains(text(), 'Create your account')]")
	WebElement formTitle;

	@FindBy(xpath = "//input[@placeholder='First name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement email1;

	@FindBy(xpath = "//input[@placeholder='Confirm email address']")
	WebElement emailConfirm;

	@FindBy(xpath = "//input[@placeholder='Enter new password']")
	WebElement password;

	@FindBy(xpath = "//input[@data-validation='password-confirm']")
	WebElement pwdConfirm;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;

	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}

	public void createAccount(String fName, String lName, String email2, String confirmemail, String pwd,
			String confirmpwd) throws Throwable {

		Action.type(firstName, fName);
		Action.type(lastName, lName);
		Action.type(email1, email2);
		Action.type(emailConfirm, confirmemail);
		Action.type(password, pwd);
		Action.type(pwdConfirm, confirmpwd);
		//Thread.sleep(1000);
		//Action.click(driver, submit);

	}
	
	public HomePage validateRegistration() throws Throwable {
		Action.click(driver, submit);
		return new HomePage();
	}

	public boolean validateAcctCreationPage() throws Throwable {
		return Action.isDisplayed(driver, formTitle);
	}

}