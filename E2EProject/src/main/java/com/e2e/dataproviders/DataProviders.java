package com.e2e.dataproviders;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.e2e.utility.NewExcelLibrary;

public class DataProviders {

	NewExcelLibrary obj = new NewExcelLibrary();

	// Class --> LoginPageTest

	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {

		// total row count
		int rows = obj.getRowCount("Credentials");
		// total column count
		int column = obj.getColumnCount("Credentials");
		int actRows = rows - 1;
		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i + 2);
			}
		}

		return data;
	}

	// Class --> AccountCreationPage Test Case--> verifyCreateAccountPageTest

	@DataProvider(name = "email")
	public Object[][] getEmail() {
		// Total row count
		int rows = obj.getRowCount("Email");
		// total column count
		int column = obj.getColumnCount("Email");
		int actRows = rows - 1;
		Object data[][] = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Email", j, i + 2);
			}
		}

		return data;

	}

	// Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
	@DataProvider(name = "searchProduct")
	public Object[][] getProductPrice() {
		// Totals rows count
		int rows = obj.getRowCount("SearchProduct");
		// Total Columns
		int column = obj.getColumnCount("SearchProduct");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("SearchProduct", j, i + 2);
			}
		}
		return data;
	}

	@DataProvider(name = "EndToEndData") 
	  public Object[][] allDetailsdata() { 
		  //total row count 
	  int rows = obj.getRowCount("AllDetails");
	  // total column  count
	  int column = obj.getColumnCount("AllDetails"); 
	  int actRows = rows - 1;
	  Object[][] data = new Object[actRows][column];
	  
	  for (int i = 0; i < actRows; i++) {
		  for (int j = 0; j < column; j++) {
	  data[i][j] = obj.getCellData("AllDetails", j, i + 2);
	  } }
	  
	  return data; 
	  }

	@DataProvider(name = "newAccountDetailsData")
	public Object[][] accountCreation() {

		// Totals rows count
		int rows = obj.getRowCount("AccountCreationData");
				// Total Columns
		int column = obj.getColumnCount("AccountCreationData");
		int actRows = rows - 1;
		// Created an object of array to store data
		Object[][] data = new Object[actRows][1];

		for (int i = 0; i < actRows; i++) {
			Map<String, String> hashMap1 = new HashMap<String, String>();
			for (int j = 0; j < column; j++) {
				hashMap1.put(obj.getCellData("AccountCreationData", j, 1),
						obj.getCellData("AccountCreationData", j, i+2));
			}
			data[i][0] = hashMap1;
		}

		return data;
	}

}
