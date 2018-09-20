package com.ferdano.alzangsample;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.testng.annotations.Test;

import com.ferdano.pagebjects.HomePage;
import com.ferdano.pagebjects.LoginPage;
import com.ferdano.pagebjects.RegistrationPage;
import com.ferdano.utilities.Log;
import com.ferdano.utilities.TestListener;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners({ TestListener.class })
//allure annotations
@Epic("Alza.cz example tests.")
@Feature("Registration tests.")

public class RegistrationTest {
	private static WebDriver driver;
	// Pages declaration
	static RegistrationPage registrationPage;
	static HomePage homePage;
	static LoginPage loginPage; 
	
	
	// DataProvider - parameterizes the test - email, password, phone combinations
	// Can be moved to separate class
	@DataProvider
	public Object[][] dp() {
		return new Object[][] { 
			new Object[] { "test@ferdan.eu", "heslo1", "heslo1", "123456789" },
			new Object[] { "test@ferdan.eu", "heslo2", "heslo2", "123456789" }, 
		};
	}

	@BeforeClass
	public void beforeClass() {
		//Used for Maven - auto downloads latest webdriver binaries
		//WebDriverManager.firefoxdriver().setup(); //Maven
		driver = new FirefoxDriver(); // instance
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit wait
		driver.manage().window().maximize(); //maximize browser window
		
		//instantiate Pages
		homePage = new HomePage(driver);
		registrationPage = new RegistrationPage(driver); //vytvoreni instance - konstruktor akceptuje driver
		loginPage = new LoginPage(driver); //vytvoreni instance - konstruktor akceptuje driver	
	}

	@Test (priority=0, description="Registering with different credentials.", dataProvider = "dp")
	@Description("Registering with different credentials according to DataProvider.")
	@Story("Registering.")
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
	
	@AfterClass
	public void afterClass() {
		Log.info("Quitting driver.");
		driver.quit();
	}

}
