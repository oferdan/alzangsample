package com.ferdano.pagebjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class HomePage {
	WebDriver driver;
	public WebDriverWait wait;
	
	//constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Header elems
	// ============
	@FindBy(id="lblMujUcet")
	WebElement myAlzaElem;
	
	@FindBy(id="lblLogin")
	WebElement loginElem;
	
	// Main function elems
	@FindBy(id="edtSearch")
	WebElement seachBarElem;
	
	@FindBy(id="basketLink")
	WebElement basketElem;
	
	// Top bar - Product categories elems

	
	// Side bar - Product categories elems
	@FindBy(xpath="//div[@id='left']//div[@class='bx']//a[contains(@title, 'Televize')]")
	WebElement televisionsElem;
	
	@FindBy(xpath="//div[@id='left']//div[@class='bx']//a[contains(@title, 'Mobilní telefony')]")
	WebElement mobilePhonesElem;
	
	// popup
	// ======
	@FindBy(xpath="//div[@id='alzaDialog']//div[@class='close']")
	WebElement popupCloseElem;
	
	// Methods
	// ========
	//Load Alza.cz home page
	@Step("Load Alza HomePage step.")
    public void goToHomePage() {
        driver.get("https://www.alza.cz/");
    }
    
	//go to login page
	@Step("Go to login page step.")
    public void goToLoginPage() {
    	loginElem.click();
    }
    
	// go to televisions page
	@Step("Go to Televisions Page step.")
    public void goToTelevisionsPage() {
    	televisionsElem.click();
    }
    
	// go to basket page
	@Step("Go to basket page step.")
    public void goToBasketPage() {
    	basketElem.click();
    }
    
	// close home page popup window
	@Step("Close home page popup window step.")
    public void popupClose() {
    	new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(popupCloseElem));
    	popupCloseElem.click();
    }
}
