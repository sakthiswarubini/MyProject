package com.e2e.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.e2e.testbase.BaseClass;

public class PaymentPage extends BaseClass {
	
	@FindBy(xpath="//span[@class='c-donut active']")
	WebElement paymentPage1;
	
	@FindBy(xpath= "//dd[@data-ui = 'bag-linecount__total']")
	WebElement totalPrice;


public PaymentPage() {
	PageFactory.initElements(driver, this);
}

public String verifyPage() throws InterruptedException {
	return paymentPage1.getText();
	
}

public double verifytotalAmount() {
	String TotalPrice1 = totalPrice.getText();
	// replace the pound symbol to null
	String total = TotalPrice1.replaceAll("[^a-zA-Z0-9]", ""); // convert to null or eliminate the special symbol
															// like pound, dollar
	System.out.println(TotalPrice1);
	double finalTotalPrice = Double.parseDouble(total);
	return finalTotalPrice / 100;
}
}