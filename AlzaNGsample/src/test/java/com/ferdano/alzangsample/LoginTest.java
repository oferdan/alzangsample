package com.ferdano.alzangsample;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ferdano.pagebjects.HomePage;
import com.ferdano.pagebjects.LoginPage;
import com.ferdano.utilities.Log;
import com.ferdano.utilities.TestListener;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

//allure anotations
@Listeners({ TestListener.class })
@Epic("Epic nazev testu v Allure")
@Feature("Log in with credentials test.")

public class LoginTest{
	
	private static WebDriver driver;
	static LoginPage loginPage; //deklarace
	static HomePage homePage; 

	@BeforeClass
	public void beforeClass() {
		Log.startLog(this.getClass().getSimpleName()); //log start
		
		//WebDriverManager.firefoxdriver().setup(); //pro automaticke stazeni driveru bez nastavovani cesty
		driver = new FirefoxDriver(); // instance
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit wait
		driver.manage().window().maximize(); //maximalizuj okno
		
		//instantiate Pages
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver); //vytvoreni instance - konstruktor akceptuje driver	
	}

	@Test
	public void validLoginTest(Method method) throws InterruptedException {
		Log.startMethodLog(method.getName()); //log method start
		
		//navigation
		Log.info("Opening home page.");
		homePage.goToHomePage();
		homePage.goToLoginPage();

		//fill forms
		Log.info("Filling forms.");
		loginPage.setEmailLogin("oferdantest@gmail.com");
		loginPage.setPassword("ondrajepan");
		//click login
		Log.info("Clicking login.");
		loginPage.clickLoginButton();
		
		Log.endMethodLog(method.getName());  //log method end
	}

	@Test
	public void invalidUsernameTest(Method method) throws InterruptedException {
		Log.startMethodLog(method.getName());
		
		//navigation
		Log.info("Opening home page.");
		homePage.goToHomePage();
		homePage.goToLoginPage();

		//fill forms
		Log.info("Filling forms.");
		loginPage.setEmailLogin("oferdantest@gmail.com");
		loginPage.setPassword("ondrajepan");
		//click login
		Log.info("Clicking login.");
		loginPage.clickLoginButton();
		//verify error text
		Log.info("Verifying error text.");
		loginPage.vefifyErrorText("Kombinace zadaného emailu a hesla neexistuje.");
		
		Log.endMethodLog(method.getName()); //log method end
	}
	
	@AfterClass
	public void afterClass() {
		Log.endLog(this.getClass().getSimpleName()); //log end
		driver.quit();
	}

}
