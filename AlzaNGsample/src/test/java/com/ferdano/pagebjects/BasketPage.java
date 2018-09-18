package com.ferdano.pagebjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

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
	@FindBy(xpath="//div[@class='obuttons']//a[@class='btnx normal green arrowedRight floatRight order2']")
	WebElement basketContinueElem;
	
	// Go back to product listing
	@FindBy(xpath="//div[@class='obuttons']//a[@class='btnx normal grey arrowedLeft floatLeft']")
	WebElement goBackToProductButtonElem;
	
	//popup
	@FindBy(xpath="//div[@id='infodialog']//div[@class='closei close']")
	WebElement notInStockPopupCloseElem;
	
	@FindBy(xpath="//div[@id='infodialog']//a[@class='dbtnx btn green col-1 ok']")
	WebElement notInStockPopupContinueElem;
	
	// Methods
	// ========
	@Step("Continue to basket step.")
	public void basketContinue() {
		basketContinueElem.click();
	}
	
	@Step("Close not in stock popup step.")
	public void notInStockPopupClose() {
		notInStockPopupCloseElem.click();
	}
	
	@Step("Not in stock continue step.")
	public void notInStockPopupContinue() {
		notInStockPopupContinueElem.click();
	}
}
