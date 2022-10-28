package com.e2e.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.e2e.actiondriver.Action;
import com.e2e.testbase.BaseClass;

public class IndexPage extends BaseClass {

	// page factory method
	@FindBy(xpath = "//a[contains(text(),'My Account')]")
	WebElement signInBtn;

	@FindBy(xpath = "//a[@class = 'o-header__brand__logo']")     
	WebElement myStoreLogo;

	@FindBy(xpath = "//input[@placeholder='Enter Keyword or Product Code']")    
	WebElement searchBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(driver, this); // this keyword initialize all the pageobjects from this class, whenever
												// we call different methods from this class by creating object for
												// IndexPage by calling the constructor, all the objects will be
												// initialized the 
	}

	//user action method
	public LoginPage clickOnSignIn() throws Throwable {
		Action.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo()throws Throwable {
		return Action.isDisplayed(driver, myStoreLogo);
	}
	
	public String getStoreTitle() {
		String storeTitle = driver.getTitle();
		return storeTitle;
	}
	
	public SearchResultPage searchProduct(String ProductName) {
		Action.type(searchBox, ProductName );
		Action.click(driver, searchButton);
		return new SearchResultPage();
	}
	 
	
}