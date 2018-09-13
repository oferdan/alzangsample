package com.ferdano.alzangsample;

import org.testng.annotations.Test;

import com.ferdano.pagebjects.HomePage;
import com.ferdano.pagebjects.ProductListingPage;
import com.ferdano.pagebjects.ProductPage;
import com.ferdano.pagebjects.AddedToBasketPage;
import com.ferdano.pagebjects.BasketPage;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class OrderMostExpensiveTelevisionTest {
	private static WebDriver driver;
	static HomePage homePage; //deklarace
	static ProductListingPage productListingPage; //deklarace
	static ProductPage productPage; //deklarace
	static AddedToBasketPage addedToBasketPage; //deklarace
	static BasketPage basketPage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver(); // instance
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit wait
		driver.manage().window().maximize(); //maximalizuj okno
		
		// instance Page stranek
		homePage = new HomePage(driver);	
		productListingPage = new ProductListingPage(driver);
		productPage = new ProductPage(driver); 
		addedToBasketPage = new AddedToBasketPage(driver); 
		basketPage = new BasketPage(driver);
	}

	@Test
	public void orderMostExpensiveTelevisionTest() throws InterruptedException {
		//navigation
		homePage.goToHomePage();
		homePage.goToTelevisionsPage();
		
		//sorting
		productListingPage.sortDescent();
		//open product
		productListingPage.openProductOnPosition(1);
		//add product to basket
		productPage.addToBasket();
		//go back to product listing
		addedToBasketPage.goBackToProductListing();
		
		//add second product to basket
		productListingPage.openProductOnPosition(2);
		productPage.addToBasket();
		//go to basket - from added to basket page
		addedToBasketPage.goToBasket();
		
		//checkout
		basketPage.basketContinue();
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
