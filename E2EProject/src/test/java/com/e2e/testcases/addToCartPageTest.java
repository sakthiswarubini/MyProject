/**
 * 
 */
package com.e2e.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.e2e.dataproviders.DataProviders;
import com.e2e.pageobject.IndexPage;
import com.e2e.pageobject.SearchResultPage;
import com.e2e.pageobject.addToCartPage;
import com.e2e.testbase.BaseClass;

/**
 * @author sakth
 *
 */
public class addToCartPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	addToCartPage addToCartpage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "searchProduct", dataProviderClass = DataProviders.class,groups = {"Regression", "Sanity"})
	public void addToCartTest(String productName) throws Throwable {
		indexPage = new IndexPage();
		//searchResultPage = indexPage.searchProduct("Green Folk Print V-Neck Mini Dress");
		searchResultPage = indexPage.searchProduct(productName);
		addToCartpage = searchResultPage.clickOnProduct();
		//addToCartpage.enterSize("Size 8");
		//addToCartpage.enterQuantity("2");
		addToCartpage.clickAddToCartBtn();
		addToCartpage.clickCheckOutBtn();
		
	}
}
