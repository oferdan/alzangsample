package com.ferdano.alzangsample;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;

import com.ferdano.pagebjects.RegistrationPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class RegistrationTest {
	
	private static WebDriver driver;
	static RegistrationPage registrationPage; //deklarace
	
	

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { 
			new Object[] { "test@ferdan.eu", "heslo1", "heslo1", "123456789" },
			new Object[] { "test@ferdan.eu", "heslo2", "heslo2", "123456789" }, 
		};
	}

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup(); //pro automaticke stazeni driveru bez nastavovani cesty
		driver = new FirefoxDriver(); // instance
		registrationPage = new RegistrationPage(driver); //vytvoreni instance - konstruktor akceptuje driver
	}

	@Test(dataProvider = "dp")
	public void newRegistrationTest(String email, String password, String passwordConfirm, String phone) {
		registrationPage.goToRegPage();
		registrationPage.setEmailLogin(email);
		registrationPage.setPassword(password);
		registrationPage.setPassword(passwordConfirm);
		registrationPage.setPhone(phone);
		//registrationPage.clickNext();
	}

	/*
	@Test
	public void newRegistrationTest() {
		System.out.println("gogogogog");
		registrationPage.goToRegPage();
	}
	*/
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
