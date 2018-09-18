package com.ferdano.pagebjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

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
	@FindBy(xpath="//div[@class='obuttons crossbuttons crossTopbuttons']//a[@class='btnx normal green arrowedRight floatRight toOrder1']")
	WebElement goToBasketButtonElem;
	
	// Go back to product listing
	@FindBy(xpath="//div[@class='obuttons crossbuttons crossTopbuttons']//a[@class='btnx normal grey arrowedLeft floatLeft']")
	WebElement goBackToProductPageButtonElem;
	

	
	// Methods
	// ========
	@Step("Go to basket step.")
	public void goToBasket() {
		goToBasketButtonElem.click();
	}
	
	@Step("Go back to product page step.")
	public void goBackToProductPage() {
		goBackToProductPageButtonElem.click();
	}
	

}
