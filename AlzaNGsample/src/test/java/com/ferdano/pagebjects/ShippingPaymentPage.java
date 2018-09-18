package com.ferdano.pagebjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class ShippingPaymentPage {
	WebDriver driver;
	public WebDriverWait wait;

	/*
	 * private static JavascriptExecutor js; js = (JavascriptExecutor) driver;
	 */
	JavascriptExecutor js = (JavascriptExecutor) driver;

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

	// ===================
	// Product page elems
	// ===================
	// Confirm order
	@FindBy(id = "confirmOrder2Button")
	WebElement confirmOrderElem;

	// Go back to product listing
	@FindBy(xpath = "//div[@id='backToOrder1ButtonContainer']//a[@href='/Order1.htm']")
	WebElement goBackToBasket;

	// go to adress form page
	@FindBy(id = "confirmOrder2ButtonContainer")
	WebElement goToAdressElem;

	// Shipping Methods
	// ---------------
	// @FindBy(id="deliveryContainer-595-17118806")
	@FindBy(xpath = "//div[@id='order2Delivery']//div[@data-deliveryid='595']")
	WebElement deliveryPrg7Elem;

	// shipping checkbox
	@FindBy(id = "deliveryCheckbox-595")
	WebElement shippingPrg7CheckBoxElem;

	// dispatch popup
	// --------------
	@FindBy(xpath = "//div[@id='personalCentralDeliveriesContainer']//input[@data-deliveryid='595']")
	WebElement dispatchStandardElem;

	// dispatch popup confirm button
	@FindBy(xpath = "//div[@class='alzaDialogBody']//a[@class='btnx normal green dialogButton confirmDialog']")
	WebElement dispatchConfirmElem;

	// payments
	// --------
	@FindBy(xpath = "//div[@id='order2Payment']//div[@data-paymentid='101']")
	WebElement paymentCashElem;

	// payments checkbox
	@FindBy(id = "paymentCheckbox-101")
	WebElement paymentCashCheckBoxElem;

	// delivery
	// --------
	@FindBy(name = "personalCentralDelivery")
	WebElement deliveryStandardElem;

	// ========
	// Methods
	// ========
	@Step("Confirm order step.")
	public void confirmOrder() {
		confirmOrderElem.click();
	}

	@Step("Set delivery to Prague 7 step.")
	public void setDeliveryToPrg7() throws InterruptedException {
		//if (shippingPrg7CheckBoxElem.isSelected()) { //
		if (shippingPrg7CheckBoxElem.getAttribute("checked") != null) { 
		} else {
			deliveryPrg7Elem.click();
		}
		// js.executeScript("arguments[0].click();", deliveryPrg7Elem);
		Thread.sleep(4000);
	}

	@Step("Confirm dispatching step.")
	public void dispatchConfirm() {
		dispatchConfirmElem.click();
	}

	//TODO not working
	@Step("Set payment to cash.")
	public void paymentSetCash() throws InterruptedException {
		//if (paymentCashCheckBoxElem.isSelected()) {
		if (paymentCashCheckBoxElem.getAttribute("checked") != null) {

		} else {
			paymentCashElem.click();
		}
		Thread.sleep(2000);
	}

	@Step("Continue to address form step.")
	public void goToAdress() {
		goToAdressElem.click();
	}

	@Step("Set standard delivery step.")
	public void deliveryStandard() {
		deliveryStandardElem.click();
	}
}
