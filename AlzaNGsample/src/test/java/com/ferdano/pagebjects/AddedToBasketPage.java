package com.ferdano.pagebjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddedToBasketPage {
	WebDriver driver;
	public WebDriverWait wait;

	// constructor
	public AddedToBasketPage(WebDriver driver) {
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
	
	// Product page elems
	// ===================
	// Go to basket button
	@FindBy(xpath="//div[@class='obuttons crossbuttons crossTopbuttons']//a[@href='/Order1.htm']")
	WebElement goToBasketButtonElem;
	
	// Go back to product listing
	@FindBy(xpath="//div[@class='obuttons crossbuttons crossTopbuttons']//a[@href='javascript:history.back()']")
	WebElement goBackToProductListingButtonElem;
	
	// Methods
	// ========
	public void goToBasket() {
		goToBasketButtonElem.click();
	}
	
	public void goBackToProductListing() {
		goBackToProductListingButtonElem.click();
	}
}
