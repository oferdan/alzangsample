package com.ferdano.pagebjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPaymentPage {
	WebDriver driver;
	public WebDriverWait wait;

	// constructor
	public ShippingPaymentPage(WebDriver driver) {
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
	// Confirm order
	@FindBy(id="confirmOrder2Button")
	WebElement confirmOrderElem;
	
	// Go back to product listing
	@FindBy(xpath="//div[@id='backToOrder1ButtonContainer']//a[@href='/Order1.htm']")
	WebElement goBackToBasket;
	
	// Methods
	// ========
	public void confirmOrder() {
		confirmOrderElem.click();
	}
}
