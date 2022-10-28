package com.e2e.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.e2e.actiondriver.Action;
import com.e2e.testbase.BaseClass;

public class DelAddressPage extends BaseClass {
	
	@FindBy(xpath = "//input[@value='Next Step']")
	WebElement nextStep;
	
	@FindBy(xpath = "//input[@placeholder = 'Mobile number']")
	WebElement mobileNumber;
	
	@FindBy(id = "addressEntry")
	WebElement enterAddress;
	
	@FindBy(id = "findStore")
	WebElement storeFind;
	
	@FindBy(xpath = "//div[contains(text(), 'Select this store')][1]")   //hardcode the store number
	WebElement storeSelect;
	
		
	public DelAddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public BillAddressPage enterDelvAddress(String mnumber, String addr) throws Exception {
		Action.click(driver, nextStep);
		Thread.sleep(1000);
		Action.type(mobileNumber, mnumber);
		Thread.sleep(1000);
		Action.type(enterAddress, addr);
		Thread.sleep(2000);
		Action.click(driver, storeFind);
		Thread.sleep(2000);
		Action.JSClick(driver, storeSelect);
		Thread.sleep(3000);
		Action.click(driver, nextStep);
		return new BillAddressPage();
	}

}
