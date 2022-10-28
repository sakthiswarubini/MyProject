/**
 * 
 */
package com.e2e.testcases;


import org.openqa.selenium.By;
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
public class HomePageTest extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	HomePage orderDetailPage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}

	@Test(groups = "Smoke")
	public void validateAccountDetailsTest() throws Throwable {

		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();

		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.validateAccountDetails();
		String expectedEmailAddress = driver.findElement(By.xpath("//span[@class = 'u-font-wn']")).getText();

		String actualEmailAddress = prop.getProperty("username");

		Assert.assertEquals(expectedEmailAddress, actualEmailAddress);
	}

	@Test(groups = "Smoke")
	public void orderHistoryDetailsTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		boolean result = homePage.verifyOrderHistory();

		Assert.assertTrue(result);
	}

}
