package com.ferdano.pagebjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage {
	WebDriver driver;
	public WebDriverWait wait;

	// constructor
	public BasketPage(WebDriver driver) {
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
	@FindBy(xpath="//div[@class='obuttons']//a[@href='#']")
	WebElement basketContinueElem;
	
	// Go back to product listing
	@FindBy(xpath="//div[@class='obuttons']//a[@class='btnx normal grey arrowedLeft floatLeft']")
	WebElement goBackToProductButtonElem;
	
	// Methods
	// ========
	public void basketContinue() {
		basketContinueElem.click();
	}
}
