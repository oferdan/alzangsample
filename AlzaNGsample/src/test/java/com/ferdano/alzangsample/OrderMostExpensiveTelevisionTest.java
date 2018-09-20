package com.ferdano.alzangsample;

import org.testng.annotations.Test;

import com.ferdano.pagebjects.HomePage;
import com.ferdano.pagebjects.ProductListingPage;
import com.ferdano.pagebjects.ProductPage;
import com.ferdano.pagebjects.ShippingPaymentPage;
import com.ferdano.pagebjects.AddedToBasketPage;
import com.ferdano.pagebjects.BasketPage;
import com.ferdano.utilities.Log;
import com.ferdano.utilities.TestListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({ TestListener.class })
//allure annotations
@Epic("Alza.cz example tests.")
@Feature("Ordering tests.")

public class OrderMostExpensiveTelevisionTest {
	private static WebDriver driver;
	//Pages declaration
	static HomePage homePage; 
	static ProductListingPage productListingPage; 
	static ProductPage productPage;
	static AddedToBasketPage addedToBasketPage; 
	static BasketPage basketPage;
	static ShippingPaymentPage shippingPaymentPage;

	@BeforeClass (description="Class Level Setup Allure")
	public void beforeClass() {
		//Used for Maven - auto downloads latest webdriver binaries
		//WebDriverManager.firefoxdriver().setup(); //Maven
		driver = new FirefoxDriver(); // instance
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit wait
		driver.manage().window().maximize(); //maximize browser window
		
		// instantiate Pages
		homePage = new HomePage(driver);	
		productListingPage = new ProductListingPage(driver);
		productPage = new ProductPage(driver); 
		addedToBasketPage = new AddedToBasketPage(driver); 
		basketPage = new BasketPage(driver);
		shippingPaymentPage = new ShippingPaymentPage(driver);
	}

	@Test (priority = 0, description="Ordering most expensive TV")
	//allure annotations
	@Severity (SeverityLevel.CRITICAL)
	@Description ("Searches for most expensive televison, adds it to basket and finishes order.")
	@Story ("Ordering.")
	public void orderMostExpensiveTelevisionTest() throws InterruptedException {
		//Log.startMethodLog(method.getName()); // log start of the method
		
		//navigation
		Log.info("Opening home page.");
		homePage.goToHomePage();
		Log.info("Opening televisions.");
		homePage.goToTelevisionsPage();
		
		//sorting
		Log.info("Sorting products.");
		productListingPage.sortDescend();
		//open product
		Log.info("Opening product.");
		productListingPage.openProductOnPosition(1);
		//add product to basket
		Log.info("Adding product to basket.");
		productPage.addToBasket();
		
		/*
		//go back to product listing
		addedToBasketPage.goBackToProductPage();
		//add second product to basket
		homePage.goToHomePage();
		//popup handling - one time popup handler, better one - http://www.testautomationguru.com/selenium-webdriver-how-to-handle-annoying-random-popup-alerts/
		homePage.popupClose();
		homePage.goToTelevisionsPage();
		productListingPage.sortDescent();
		productListingPage.openProductOnPosition(2);
		productPage.addToBasket();
		*/
		
		//go to basket - from added to basket page
		Log.info("Continuing to basket.");
		addedToBasketPage.goToBasket();
		//checkout if everyting is in stock - if not shows popup
		Log.info("Continuing to shipping and payments page.");
		basketPage.basketContinue();
		//handle not in stock warning
		Log.info("Handling not in stock warning.");
		basketPage.notInStockPopupContinue();
		//delivery method
		Log.info("Setting delivery method.");
		shippingPaymentPage.setDeliveryToPrg7();
		Log.info("Setting dispatching.");
		shippingPaymentPage.dispatchConfirm();
		
		//Thread.sleep(3000);
		Log.info("Setting payment method.");
		shippingPaymentPage.paymentSetCash();
		Log.info("Continuing to order confirmation.");
		shippingPaymentPage.goToAdress();
		
		
		//Log.endMethodLog(method.getName()); //log end of the methods - if method fails its not logged
	}

	@AfterClass (description="Class Level Teardown")
	public void afterClass() {
		//Log.endLog(this.getClass().getSimpleName()); //log end of class
		Log.info("Quitting driver.");
		driver.quit();
	}

}
