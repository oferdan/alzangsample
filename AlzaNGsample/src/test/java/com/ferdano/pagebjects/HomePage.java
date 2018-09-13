package com.ferdano.pagebjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	public WebDriverWait wait;
	
	//constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Header elems
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
	
	// Methods
	// ========
	//Load Alza.cz home page
    public void goToHomePage() {
        driver.get("https://www.alza.cz/");
    }
    
    public void goToTelevisionsPage() {
    	televisionsElem.click();
    }
    
    public void goToBasketPage() {
    	basketElem.click();
    }
}
