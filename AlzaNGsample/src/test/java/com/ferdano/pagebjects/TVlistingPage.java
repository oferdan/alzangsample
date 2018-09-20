package com.ferdano.pagebjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Story;

public class TVlistingPage extends ProductListingPage {

	public TVlistingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Actions action = new Actions(driver);
	
	// =====================
	// TV Specific Elements
	// =====================
	// can be moved to parent class?
	@FindBy(xpath="//div[@class='specifyPriceContainer']//a[@class='ui-slider-handle ui-state-default ui-corner-all first']")
	public	WebElement priceSliderLeftElem;
	
	@FindBy(xpath="//div[@id='producers']//label[@for='chb-producer-1299']")
	public WebElement brandSamsungElem;
	
	@FindBy(xpath="//div[@id='topped-parameter-445']//a[@class='ui-slider-handle ui-state-default ui-corner-all'][position()=1]")
	public	WebElement screenSizeSliderLeftElem;
	
	@FindBy(xpath="//div[@id='topped-parameter-445']//div[@class='rangeValue minValue']")
	WebElement screenSizeSliderValueElem;
	
	
	// =====================
	// TV Specific Methods
	// =====================
	
	@Story("Set slider: \"{0}\" to x: \"{1}\" y: \"{2}\" step.")
	public void setSliderValue(WebElement slider, int x, int y) {
		action.dragAndDropBy(slider, x, y).perform(); 
	}
	
	@Story("Get size value of slider: \"{0}\" step.")
	public String getSliderValue(WebElement slider) {
		return slider.getText();
	}
	
	@Story("Check if slider: \"{0}\" to x: \"{1}\" y: \"{2}\" works step.")
	public boolean checkIfSliderWorks(WebElement slider, int x, int y) {
		String oldValue = getSliderValue(slider);
		setSliderValue(slider, x, y);
		String newValue = getSliderValue(slider);
		
		System.out.println(oldValue);
		System.out.println(newValue);
		
		if(oldValue != newValue)
			return true;
		else return false;
	}
	
	public void setBrand(WebElement brand) {
		brand.click();
	}
}
