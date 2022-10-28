/**
 * 
 */
package com.e2e.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.e2e.pageobject.CheckOutPage;
import com.e2e.pageobject.DelAddressPage;
import com.e2e.pageobject.IndexPage;
import com.e2e.pageobject.LoginPage;
import com.e2e.pageobject.SearchResultPage;
import com.e2e.pageobject.addToCartPage;
import com.e2e.pageobject.orderPage;
import com.e2e.testbase.BaseClass;

/**
 * @author sakth
 *
 */
public class OrderPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	addToCartPage addToCartpage;
	CheckOutPage checkoutPage;
	LoginPage loginpage;
	orderPage orderpage;
	DelAddressPage deladdresspage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}

	@Test(groups = "Regression")
	public void verifyTotalPrice() throws Throwable {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("Et Vous Green Floral");
		addToCartpage = searchResultPage.clickOnProduct();
		// addToCartpage.enterSize("Size 8");
		// addToCartpage.enterQuantity("2");
		Double unitPrice138 = addToCartpage.getUnitPrice();
		addToCartpage.clickAddToCartBtn();
		// orderpage = addToCartpage.clickCheckOutBtn();
		loginpage = addToCartpage.clickCheckOutBtn();
		orderpage = loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));

		Double TotalPrice = orderpage.getTotalPrice();
		Double totalExpectedPrice = (unitPrice138 * 2);
		Assert.assertEquals(TotalPrice, totalExpectedPrice);

	}
}
