package com.ferdano.alzangsample;

import org.testng.annotations.Test;

import com.ferdano.pagebjects.AddedToBasketPage;
import com.ferdano.pagebjects.BasketPage;
import com.ferdano.pagebjects.HomePage;
import com.ferdano.pagebjects.ProductListingPage;
import com.ferdano.pagebjects.ProductPage;
import com.ferdano.pagebjects.ShippingPaymentPage;
import com.ferdano.pagebjects.TVlistingPage;
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

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;


@Listeners({ TestListener.class })
//allure annotations
@Epic("Alza.cz example tests.")
@Feature("Poduct listin page tests.")

public class ProductListingPageTest {
	private static WebDriver driver;
	// Pages declaration
	static HomePage homePage;
	static ProductListingPage productListingPage;
	static ProductPage productPage;
	static AddedToBasketPage addedToBasketPage;
	static BasketPage basketPage;
	static ShippingPaymentPage shippingPaymentPage;
	static TVlistingPage tvlistingPage;

	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@BeforeClass
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
		tvlistingPage = new TVlistingPage(driver);
	}

	@Test (priority = 0, description="Set filtering parameters.")
	//allure annotations
	@Severity (SeverityLevel.CRITICAL)
	@Description ("Set filtering parameters.")
	@Story ("Filtering.")
	public void setSliderTest() {
		//navigation
		Log.info("Opening home page.");
		homePage.goToHomePage();
		Log.info("Opening televisions.");
		homePage.goToTelevisionsPage();
		
		Log.info("Setting screenSizeSliderLeftElem slider horizontally.");
		tvlistingPage.setSliderValue(tvlistingPage.screenSizeSliderLeftElem, 30, 0);
		Log.info("Setting filter - brand=Sansung");
		tvlistingPage.setBrand(tvlistingPage.brandSamsungElem);
		//js.executeScript("arguments[0].scrollIntoView(true);", tvlistingPage.brandSamsungElem);
		//js.executeScript("arguments[0].click();", tvlistingPage.brandSamsungElem);
	}
	
	

	@AfterClass
	public void afterClass() {
		//Log.info("Quitting driver.");
		//driver.quit();
	}

}
