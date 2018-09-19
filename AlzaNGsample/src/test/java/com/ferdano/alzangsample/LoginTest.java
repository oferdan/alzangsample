package com.ferdano.alzangsample;

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

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import io.github.bonigarcia.wdm.WebDriverManager;

//allure annotations
@Listeners({ TestListener.class })
@Epic("Alza.cz example tests.")
@Feature("Log in tests.")

public class LoginTest{
	private static WebDriver driver;
	// Pages declaration
	static LoginPage loginPage;
	static HomePage homePage; 

	@BeforeClass
	public void beforeClass() {
		//Log.startLog(this.getClass().getSimpleName()); //log start - moved do Listener
		
		//Used for Maven - auto downloads latest webdriver binaries
		//WebDriverManager.firefoxdriver().setup(); //Maven
		driver = new FirefoxDriver(); // instance
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit wait
		driver.manage().window().maximize(); //maximize browser window
		
		//instantiate Pages
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver); 	
	}

	@Test (priority=0, description="Log in with valid credentials.")
	@Description("Log in with valid credentials.")
	@Story("Logging in with different credentials.")
	public void validLoginTest() throws InterruptedException {
		//Log.startMethodLog(method.getName()); //log method start - moved do Listener
		
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
		
		//Log.endMethodLog(method.getName());  //log method end  - moved do Listener
	}

	@Test (priority=0, description="Log in with invalid credentials.")
	@Description("Log in with invalid credentials.")
	@Story("Logging in with different credentials.")
	public void invalidUsernameTest() throws InterruptedException {
		//Log.startMethodLog(method.getName()); //- moved do Listener
		
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
		loginPage.verifyErrorText("Kombinace zadaného emailu a hesla neexistuje.");
		
		//Log.endMethodLog(method.getName()); //log method end - moved do Listener
	}
	
	@AfterClass
	public void afterClass() {
		//Log.endLog(this.getClass().getSimpleName()); //log end - moved do Listener
		Log.info("Quitting driver");
		driver.quit();
	}

}
