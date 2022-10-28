/**
 * 
 */
package com.e2e.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.e2e.actiondriver.Action;
import com.e2e.testbase.BaseClass;

/**
 * @author sakth
 *
 */
public class HomePage extends BaseClass {

	@FindBy(xpath = "//a[@role='tab'][contains(text(),'Account ')]")
	WebElement accountDetails;

	@FindBy(xpath = "//a[contains(@href, '#myAccEmail')]")
	WebElement emailAccount;

	@FindBy(xpath = "//a[@role='tab'][contains(text(),'Order ')]")
	WebElement orderHistory;

	@FindBy(xpath = "//a[@role='tab'][contains(text(),'Address ')]")
	WebElement addressBook;

	// String expectedEmailAddress = driver.findElement(By.xpath("//span[@class=
	// 'u-font-wn']")).getText();
	// String actualEmailAddress = prop.getProperty("username");

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void validateAccountDetails() throws Throwable {
		Action.click(driver, accountDetails);
		Action.click(driver, emailAccount);
		

	}
	
	public boolean verifyOrderHistory() throws Throwable {
		
		Action.click(driver, orderHistory);
		return Action.isDisplayed(driver,  orderHistory);
		
	}

	

	public boolean validateAddressBook() throws Throwable {
		return Action.isDisplayed(driver, addressBook);
	}

	public String getCurrURL() {
		String homePageURL = driver.getCurrentUrl();
		return homePageURL;
	}

	 
	}


