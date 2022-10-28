package com.e2e.pageobject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.e2e.actiondriver.Action;
import com.e2e.testbase.BaseClass;

public class addToCartPage extends BaseClass {

	@FindBy(xpath = "//select[@id='item_variant_select_811213']")
	WebElement selectSize;

	@FindBy(xpath = "//form[@id='new_line_item']/div[3]/div/div/div/a/span[2]")
	WebElement selectQty;

	@FindBy(id = "gtm-add")
	WebElement addToCartBtn;

	@FindBy(xpath = "//a[contains(text(), 'Checkout')]")
	WebElement checkOut;

	//@FindBy(xpath = "//h2[normalize-space()='£27.00']")
	@FindBy(xpath = "/html[1]/body[1]/div[10]/div[1]/div[3]/div[1]/div[2]/h2[1]")
	public static WebElement unitPrice;
	
	// driver.findElement(By.cssSelector("h2.o-product-detail__title.u-mar-t-small.u-font-wb"));
	// by adding global static variable use this webelement in orderPage class

	public addToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterSize(String siz) throws Throwable {
		Select s1 = new Select(selectSize);
		s1.selectByValue(siz);
		Thread.sleep(1000);

	}

	public void enterQuantity(String quantity) throws Throwable {
		Action.selectByVisibleText(quantity, selectQty);
	}

	public Double getUnitPrice() {

		String unitPrice1 = unitPrice.getText();
		System.out.println(unitPrice1);
		// replace the pound symbol to null
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice / 100;

	}

	public void clickAddToCartBtn() throws InterruptedException {
		Action.click(driver, addToCartBtn);
		Thread.sleep(2000);
		System.out.println("item added");
	}

	public LoginPage clickCheckOutBtn() throws InterruptedException {

		Action.click(driver, checkOut);
		// Action.fluentWait(driver, checkOut, 10);
		System.out.println("Checkout completed");
		return new LoginPage();

	}
	
	
}
