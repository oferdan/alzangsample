package com.ferdano.pagebjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage{
    public WebDriver driver;
    public WebDriverWait wait;
 
    //Constructor
    public BasePage(WebDriver driver, WebDriverWait wait) {
    	 this.driver = driver;
         this.wait = wait;
         LoginPageBase loginPage = new LoginPageBase(driver,wait);
    }
    
    /*
     * Nepouzivam, protoze pouzivam WebElement a je lepsi primo v Page
     */
     
    /* 
     * By type
     * 
    //Click Method
    public void click (By elementLocation) {
        driver.findElement(elementLocation).click();
    }
 
    //Write Text
    public void writeText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }
 
    //Read Text
    public String readText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
	*/
    
    /*
     * By WebElement
    //Click Method
    public void click (WebElement element) {
    	element.click();
    }
 
    //Write Text
    public void writeText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }
    
    //Read Text WebElement
    public String readText (WebElement element) {
        return element.getText();
    }
	*/
}
