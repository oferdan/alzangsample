package com.ferdano.alzangsample;

import com.ferdano.pagebjects.*;

import org.testng.annotations.Test;

import com.ferdano.pagebjects.RegistrationPageFluent;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class RegistrationTestFluent {
	/*
	 * Chain of Invocation
	 */

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { 
			new Object[] { "test@ferdan.eu", "heslo", "heslo", 123456789 },
			new Object[] { 2, "b" }, 
		};
	}

	@BeforeClass
	public void beforeClass() {
		//WebDriver driver;
		//driver = new FirefoxDriver(); // instance
	}

	@Test(dataProvider = "dp")
	public void newRegistrationTest(String email, String password, String passwordConfirm, int phone) {
		//RegistrationPageFluent.using(driver); //driver).setEmailLogin(email);
	}

	@AfterClass
	public void afterClass() {
	}

}
