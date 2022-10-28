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
public class orderPage extends BaseClass {

	// static WebElement unitPrice = addToCartPage.unitPrice; //access the
	// webelement from addToCartPage

	@FindBy(xpath = "//dd[@data-ui = 'bag-linecount__total']")
	WebElement totalPrice;

	@FindBy(xpath = "//a[contains(text(), 'Checkout')]")
	WebElement checkOut;

	public orderPage() {
		PageFactory.initElements(driver, this);
	}

	public double getTotalPrice() {

		String TotalPrice1 = totalPrice.getText();
		// replace the pound symbol to null
		String total = TotalPrice1.replaceAll("[^a-zA-Z0-9]", ""); // convert to null or eliminate the special symbol
																// like pound, dollar
		System.out.println(TotalPrice1);
		double finalTotalPrice = Double.parseDouble(total);
		return finalTotalPrice / 100;
	}

	

}
