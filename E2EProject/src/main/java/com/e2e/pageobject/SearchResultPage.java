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
public class SearchResultPage extends BaseClass {
	
	@FindBy(xpath= "//div[contains(text(),'Et Vous Green Floral Puff Sleeve Midi Dress')]")
	WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean isProductAvailable() throws Throwable{
		return Action.isDisplayed(driver, productResult);
	}

	public addToCartPage clickOnProduct() throws Throwable{
		Action.click(driver, productResult);
		Thread.sleep(2000);
		return new addToCartPage();
	}
}
