/**
 * 
 */
package com.e2e.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.e2e.dataproviders.DataProviders;
import com.e2e.pageobject.AccountCreationPage;
import com.e2e.pageobject.HomePage;
import com.e2e.pageobject.IndexPage;
import com.e2e.pageobject.LoginPage;
import com.e2e.testbase.BaseClass;

/**
 * @author sakth
 *
 */
public class AccountCreationPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountcreationpage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	
	  @Test(dataProvider = "email", dataProviderClass = DataProviders.class, groups="Sanity")
	   
	  public void verifyCreateAccountPageTest(String email) throws Throwable { 
		  indexPage = 	  new IndexPage();
		  loginPage = indexPage.clickOnSignIn(); 
		  accountcreationpage = loginPage.createNewAccount(email); 
		  boolean result   = accountcreationpage.validateAcctCreationPage(); 
		  Assert.assertTrue(result);
	  }
	 
	
	@Test(dataProvider = "newAccountDetailsData",dataProviderClass = DataProviders.class, groups="Regression") 
	public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
		
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountcreationpage=loginPage.createNewAccount(hashMapValue.get("Email"));
		accountcreationpage.createAccount(
				
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("Email"),
				hashMapValue.get("ConfirmEmail"),
				hashMapValue.get("Password"),
				hashMapValue.get("ConfirmPassword")
				);
		homePage=accountcreationpage.validateRegistration();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", homePage.getCurrURL());
		
	}


}
