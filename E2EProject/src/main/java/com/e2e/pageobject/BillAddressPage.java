/**
 * 
 */
package com.e2e.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.e2e.actiondriver.Action;
import com.e2e.testbase.BaseClass;

/**
 * @author sakth
 *
 */
public class BillAddressPage extends BaseClass {
	
	@FindBy(xpath="//div[contains(text(), 'Enter a new address')]")
	WebElement newAddress;

	@FindBy(xpath = "//input[@placeholder = 'First name']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@placeholder = 'Last name']")
	WebElement LastName;

	@FindBy(xpath = "//input[@placeholder = 'Postcode']")
	WebElement postcode;

	@FindBy(xpath = "//button[contains(text(),'Find Address')]")
	WebElement findAddress;

	@FindBy(xpath = "//select[@data-app = 'pa-address-select']")
	WebElement addressSelect; // option[contains(text(),'Please Select:')]"
	
	//select[@data-app = 'pa-address-select']

	// @FindBy(xpath="//div[@class='o-form__input-contain
	// c-address-form__address-select populateAddresses']")
	// WebElement addressSelect;

	@FindBy(xpath = "//input[@value = 'Continue to Payment']")
	WebElement Payment;

	public BillAddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void newAddr() {
		Action.click(driver, newAddress);
	}

	public void addressDetails() throws Throwable {
		Action.type(FirstName, "Test");
		Action.type(LastName, "User");
		Action.type(postcode, "CH65 9HD");
		Action.click(driver, findAddress);
		// Action.click(driver, addressSelect);
		Thread.sleep(1000);

	}

	public void selectAddress() throws Throwable {
		Select addrselec = new Select(addressSelect);
		List<WebElement> addrselect = addrselec.getOptions();
		System.out.println(addrselect.size());
		Thread.sleep(1000);
		for (int i = 0; i < addrselect.size(); i++) {
			//WebElement ele = addrselect.get(i);
			//System.out.println(addrselect.get(i).getText());
			if (addrselect.get(i).getText().contains("8A, Llys Road, Oswestry, SY11 2XD")) {
				addrselect.get(i).click();
				System.out.println("Address selected");
				Thread.sleep(1000);
				break;
			}
		}

	}

	public PaymentPage continuePayment() throws InterruptedException {
		Action.click(driver, Payment);
		Thread.sleep(2000);
		return new PaymentPage();

	}

}
