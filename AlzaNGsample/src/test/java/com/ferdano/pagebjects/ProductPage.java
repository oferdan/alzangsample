package com.ferdano.pagebjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class ProductPage {
	WebDriver driver;
	public WebDriverWait wait;

	// constructor
	public ProductPage(WebDriver driver) {
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
	// Add to basket button
	@FindBy(className="btnx normal green buy single")
	WebElement addToBasketButtonElem;
	
	// Methods
	// ========
	@Step("Add product to basket step.")
	public void addToBasket() {
		addToBasketButtonElem.click();
	}
	
}
