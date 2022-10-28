/**
 * 
 */
package com.e2e.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.e2e.dataproviders.DataProviders;
import com.e2e.pageobject.BillAddressPage;
import com.e2e.pageobject.CheckOutPage;
import com.e2e.pageobject.DelAddressPage;
import com.e2e.pageobject.IndexPage;
import com.e2e.pageobject.LoginPage;
import com.e2e.pageobject.PaymentPage;
import com.e2e.pageobject.SearchResultPage;
import com.e2e.pageobject.addToCartPage;
import com.e2e.pageobject.orderPage;
import com.e2e.testbase.BaseClass;

/**
 * @author sakth
 *
 */
public class EndToEndTest extends BaseClass {

	IndexPage indexPage;
	LoginPage loginpage;
	SearchResultPage searchResultPage;
	addToCartPage addToCartpage;
	CheckOutPage checkoutPage;
	orderPage orderpage;
	DelAddressPage deladdresspage;
	BillAddressPage billaddresspage;
	PaymentPage paymentpage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "EndToEndData", dataProviderClass = DataProviders.class, groups = "Regression")
	public void endToEndTest(String mnumber, String address) throws Throwable {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("Et Vous Green Floral");
		addToCartpage = searchResultPage.clickOnProduct();
		addToCartpage.enterSize("811213");
		// addToCartpage.enterQuantity("2");
		Double unitPrice138 = addToCartpage.getUnitPrice();
		addToCartpage.clickAddToCartBtn();
		loginpage = addToCartpage.clickCheckOutBtn();
		deladdresspage = loginpage.login2(prop.getProperty("username"), prop.getProperty("password"));
		billaddresspage = deladdresspage.enterDelvAddress(mnumber, address);
		billaddresspage.newAddr();
		billaddresspage.addressDetails();
		billaddresspage.selectAddress();
		paymentpage = billaddresspage.continuePayment();
		String actualPage = paymentpage.verifyPage();
		assertTrue("3".equals(actualPage));
		Double TotalPrice = paymentpage.verifytotalAmount();
		Double totalExpectedPrice = (unitPrice138 * 2);
		Assert.assertEquals(TotalPrice, totalExpectedPrice);

	}
}
