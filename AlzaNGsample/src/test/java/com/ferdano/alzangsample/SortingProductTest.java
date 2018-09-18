package com.ferdano.alzangsample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ferdano.pagebjects.HomePage;
import com.ferdano.pagebjects.ProductListingPage;
import com.ferdano.pagebjects.ProductPage;
import com.ferdano.utilities.Log;
import com.ferdano.utilities.TestListener;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

//allure anotations
@Listeners({ TestListener.class })
@Epic("Epic nazev testu v Allure")
@Feature("Sorting deascend and ascend test.")

public class SortingProductTest {
	private static WebDriver driver;
	// Pages declarations
	static HomePage homePage;
	static ProductListingPage productListingPage;
	static ProductPage productPage;

	@BeforeClass
	public void beforeClass() {
		// Log.startLog(this.getClass().getSimpleName()); //log start of class
		driver = new FirefoxDriver(); // instance
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit wait
		driver.manage().window().maximize(); // maximalize okno

		// instantiate Pages
		homePage = new HomePage(driver);
		productListingPage = new ProductListingPage(driver);
		productPage = new ProductPage(driver);
	}

	@Test
	public void sortingDescendProductTest() throws InterruptedException {
		//navigation
		Log.info("Opening home page.");
		homePage.goToHomePage();
		Log.info("Opening televisions.");
		homePage.goToTelevisionsPage();
		
		//sorting
		Log.info("Sorting products.");
		productListingPage.sortDescend();
		//wait for sorting to be done
		//TODO better approach: https://www.swtestacademy.com/selenium-wait-javascript-angular-ajax/ 
		//Thread.sleep(2000); // moved to method
		Log.info("Checking if products are sorted descending.");
		Assert.assertTrue(productListingPage.isPriceOfFistBiggerThanSecondProduct());
	}
	
	@Test
	public void sortingAscendProductTest() throws InterruptedException {
		//navigation
		Log.info("Opening home page.");
		homePage.goToHomePage();
		Log.info("Opening televisions.");
		homePage.goToTelevisionsPage();
		
		//sorting
		Log.info("Sorting products.");
		productListingPage.sortAscend();
		//wait for sorting to be done
		//TODO better approach: https://www.swtestacademy.com/selenium-wait-javascript-angular-ajax/ 
		//Thread.sleep(2000); // moved to method
		Log.info("Checking if products are sorted ascending.");
		Assert.assertFalse(productListingPage.isPriceOfFistBiggerThanSecondProduct());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
