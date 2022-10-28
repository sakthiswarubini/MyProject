package com.e2e.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.e2e.utility.ExtentManager;

//import com.e2e.actiondriver.Action;
import com.e2e.utility.TestUtilWait;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })

	public void loadConfig() {

		ExtentManager.setExtent();
		try {
			prop = new Properties();
			System.out.println("Super constructor invoked");
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\sakth\\git\\E2E\\E2EProject\\Configuration\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void launchApp(String browserName) {
		// String browserName = prop.getProperty("browser");

		if (browserName.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.contentEquals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.contains("IE")) {
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtilWait.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtilWait.IMPLICIT_WAIT));

		driver.get(prop.getProperty("url"));

	}

	
	@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
