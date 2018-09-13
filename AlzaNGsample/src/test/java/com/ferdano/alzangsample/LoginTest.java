package com.ferdano.alzangsample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ferdano.pagebjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest{
	
	private static WebDriver driver;
	static LoginPage loginPage; //deklarace

	@BeforeClass
	public void beforeClass() {
		//WebDriverManager.firefoxdriver().setup(); // pro automaticke stazeni driveru bez nastavovani cesty
		driver = new FirefoxDriver(); // instance
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit wait
		driver.manage().window().maximize(); //maximalizuj okno
		loginPage = new LoginPage(driver); // vytvoreni instance - konstruktor akceptuje driver	
	}

	@Test
	public void validLoginTest() throws InterruptedException {

		loginPage.goToHomePage();
		loginPage.clickLoginPage();
		loginPage.setEmailLogin("oferdantest@gmail.com");
		loginPage.setPassword("ondrajepan");
	}

	@Test
	public void invalidUsernameTest() throws InterruptedException {

		loginPage.goToHomePage();
		loginPage.clickLoginPage();
		loginPage.setEmailLogin("oferdantest@gmail.com");
		loginPage.setPassword("ondrajepan");
		loginPage.clickLoginButton();
		loginPage.vefifyErrorText("Kombinace zadaného emailu a hesla neexistuje.");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
