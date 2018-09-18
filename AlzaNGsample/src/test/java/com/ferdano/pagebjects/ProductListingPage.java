package com.ferdano.pagebjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ferdano.utilities.Log;

import io.qameta.allure.Step;

public class ProductListingPage {
	WebDriver driver;
	public WebDriverWait wait;

	// constructor
	public ProductListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// =====================
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
	// Price Desc (nejdrazsi) elem
	@FindBy(xpath = "//div[@id='tabs']//li[contains(@class, 'ui-tabs-tab ui-corner-top')][position()=3]")
	WebElement priceDescElem;
	
	// Price Asc (nejlevnejsu) elem
	@FindBy(xpath = "//div[@id='tabs']//li[contains(@class, 'ui-tabs-tab ui-corner-top')][position()=4]")
	WebElement priceAscElem;

	// Product listing results
	// ========================
	// change [position()=1] to match position in list
	// product page links
	//--------------------
	// First product - universal locator
	@FindBy(xpath = "//div[@id='boxes']//div[contains(@class, 'box browsingitem')][position()=1]//a[@class='name browsinglink']")
	WebElement firstProductElem;

	// Second product - universal locator
	@FindBy(xpath = "//div[@id='boxes']//div[contains(@class, 'box browsingitem')][position()=2]//a[@class='name browsinglink']")
	WebElement secondProductElem;
	
	// product prices
	//---------------------
	// first product price  - universal locator
	@FindBy(xpath="//div[@id='boxes']//div[contains(@class, 'box browsingitem')][position()=1]//div[contains(@class, 'price')]//span[@class='c2']")
	WebElement firstProductPriceElem;

	// Second product price  - universal locator
	@FindBy(xpath = "//div[@id='boxes']//div[contains(@class, 'box browsingitem')][position()=2]//div[contains(@class, 'price')]//span[@class='c2']")
	WebElement secondProductPriceElem;
	
	
	// ========
	// Methods
	// ========

	// sort descend
	@Step("Sort product descend step.")
	public void sortDescend() throws InterruptedException {
		priceDescElem.click();
		Thread.sleep(2000);
	}
	
	// sort ascend
	@Step("Sort product ascend step.")
	public void sortAscend() throws InterruptedException {
		priceAscElem.click();
		Thread.sleep(2000);
	}

	// TODO zmena z public pro zamezeni pouzivani jine funkce nez orderProductOnPosition v testu
	@Step("Open product page of first product in list step.")
	public void openFirstProduct() {
		firstProductElem.click();
	}
	
	@Step("Open second product page step.")
	public void openSecondProduct() {
		secondProductElem.click();
	}
	
	@Step("Open product page of product on position X step.")
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
	
	@Step("Get first product price step.")
	public String getFirstProductPrice() {
		return firstProductPriceElem.getText();
	}
	
	@Step("Get first product price step.")
	public String getSecondProductPrice() {
		return secondProductPriceElem.getText();
	}
	
	// get price of first and second product in product listing in String, replace all but numbers, convert to Integer, compare values
	//TODO WARNING: not working for floating prices - especially excl.VAT and EUR prices with cents
	// ALSO CZ/SK (,) and English (.) floating point separators are different!
	// For prices in Koruna - remove last two chars ",-" for floating excl.VAT or EUR convert "1,1" to float
	// Price in Koruna excl.VAT example: "13,215,-"
	// Price in EUR English example: "€8.90"
	// Price in EUR Slovak example: "€77,90"
	@Step("Check by comparing prices that sorting works step.")
	public boolean isPriceOfFistBiggerThanSecondProduct() {
		int firstProductPrice=Integer.parseInt(getFirstProductPrice().replaceAll("[^0-9]", "")); 
		System.out.println("cena prvniho float: "+firstProductPrice);

		int secondProductPrice=Integer.parseInt(getSecondProductPrice().replaceAll("[^0-9]", ""));
		System.out.println("cena druhyho float: "+secondProductPrice);
		
		if(firstProductPrice>secondProductPrice) 
			return true;	
		else 
			return false;
	}
}
