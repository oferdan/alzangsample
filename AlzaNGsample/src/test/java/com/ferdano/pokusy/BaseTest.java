package com.ferdano.alzangsample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class BaseTest {
	/*
	 * https://www.swtestacademy.com/page-object-model-java/
	 */
	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		//vytvoreni driveru - budou ho pouzivat vsechny page tridy a testy
		WebDriverManager.firefoxdriver().setup(); // pro automaticke stazeni driveru bez nastavovani cesty
		driver = new FirefoxDriver(); // instance
		
		//wait-  budou ho pouzivat vsechny page tridy a testy
		wait = new WebDriverWait(driver,15);
		
		//Maximalizuj okno
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.quit(); //zavre prohlizec
	}

}
