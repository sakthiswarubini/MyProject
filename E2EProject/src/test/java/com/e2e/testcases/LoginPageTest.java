/**
 * 
 */
package com.e2e.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.e2e.dataproviders.DataProviders;
import com.e2e.pageobject.HomePage;
import com.e2e.pageobject.IndexPage;
import com.e2e.pageobject.LoginPage;
import com.e2e.testbase.BaseClass;

/**
 * @author sakth
 *
 */
public class LoginPageTest extends BaseClass{
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
	
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke", "Sanity"})
	public void loginTest(String uname, String pswd) throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(uname,pswd);
		String actualURL = homePage.getCurrURL();
		String expectedURL = "https://www.matalan.co.uk/account/edit";
		Assert.assertEquals(actualURL, expectedURL );
	}
	
	/*
	 * public void verifyTitle() { String actTitle = indexPage.getStoreTitle(); }
	 */
	
	

}
