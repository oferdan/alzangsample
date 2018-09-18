package com.ferdano.alzangsample;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

import org.testng.annotations.Test;

import com.ferdano.pagebjects.HomePage;
import com.ferdano.pagebjects.LoginPage;
import com.ferdano.pagebjects.RegistrationPage;
import com.ferdano.utilities.TestListener;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

//allure anotations
@Listeners({ TestListener.class })
@Epic("Epic nazev testu v Allure")
@Feature("Registrating with different credentials test.")

public class RegistrationTest {
	
	private static WebDriver driver;
	static RegistrationPage registrationPage; //deklarace
	static HomePage homePage;
	static LoginPage loginPage; 
	
	

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
		
		//instantiate Pages
		homePage = new HomePage(driver);
		registrationPage = new RegistrationPage(driver); //vytvoreni instance - konstruktor akceptuje driver
		loginPage = new LoginPage(driver); //vytvoreni instance - konstruktor akceptuje driver	
	}

	@Test(dataProvider = "dp")
	public void newRegistrationTest(String email, String password, String passwordConfirm, String phone) {
		homePage.goToHomePage();
		homePage.goToLoginPage();
		loginPage.goToRegPage();

		//fill forms
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
