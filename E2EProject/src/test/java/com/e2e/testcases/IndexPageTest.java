/**
 * 
 */
package com.e2e.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.e2e.pageobject.HomePage;
import com.e2e.pageobject.IndexPage;
import com.e2e.pageobject.LoginPage;
import com.e2e.testbase.BaseClass;

/**
 * @author sakth
 *
 */
public class IndexPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod (groups= {"Smoke", "Sanity", "Regression"}) 
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test (groups = "Smoke")
	public void verifyLogo() throws Throwable {
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test (groups = "Smoke")
	public void verifyTitle() throws Throwable {
		String actTitle = indexPage.getStoreTitle();
		Assert.assertEquals(actTitle, "Online Clothes Shopping - Shop Latest Fashion – Matalan");
	}
	
	



}
