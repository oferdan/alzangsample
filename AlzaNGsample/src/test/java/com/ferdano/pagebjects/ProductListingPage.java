package com.ferdano.pagebjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductListingPage {
	WebDriver driver;
	public WebDriverWait wait;

	// constructor
	public ProductListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Main function elems
	// =====================
	// Search bar
	@FindBy(id = "edtSearch")
	WebElement seachBarElem;

	// Basket
	@FindBy(id = "basketLink")
	WebElement basketElem;

	// Sorting
	// ========
	// Price Desc elem
	@FindBy(xpath = "//div[@id='tabs']//a[@href='#cenadesc']")
	WebElement priceDescElem;

	// Product list results
	// =====================
	// First product
	@FindBy(xpath = "//div[@id='boxes']//div[@class='box browsingitem canBuy otherAvailability first firstRow']//a[@class='name browsinglink']")
	WebElement firstProductElem;

	// Second product
	@FindBy(xpath = "//div[@id='boxes']//div[@class='box browsingitem canBuy otherAvailability firstRow'][position()=1]//a[@class='name browsinglink']")
	WebElement secondProductElem;

	
	// Methods
	// ========

	// sort descent
	public void sortDescent() {
		priceDescElem.click();
	}
	
	// TODO refactoring - slo by bjednavat podle pozice? - otevrit produkt - nova ProductPage - kliknout na objednat

	// TODO zmena z public pro zamezeni pouzivani jine funkce nez orderProductOnPosition v testu
	public void openFirstProduct() {
		firstProductElem.click();
	}
	
	public void openSecondProduct() {
		secondProductElem.click();
	}
	
	public void openProductOnPosition(Integer position) {
		switch (position) {
		case 1: openFirstProduct();
		break;
		case 2: openSecondProduct();
		break;
		default: System.out.println("Error - didnt choose option on switch");
		break;
		}

	}
}
