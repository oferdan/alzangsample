/*
 * Author: Ondrej Ferdan
 * 
 * Abstarct: RegistrationPage class is using Selenium Page Object Model pattern and Selenium Page Factory implementation. 
 * Fluent Interface - method chaining is used for better readability and easier understanding of code - https://martinfowler.com/bliki/FluentInterface.html 
 * 
 * Inspiration: http://www.testautomationguru.com/selenium-webdriver-how-to-design-page-objects-in-fluent-style/
 */

package com.ferdano.pagebjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPageBase extends BasePage{
	

    //*********Constructor*********
    public LoginPageBase(WebDriver driver, WebDriverWait  wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this); //init WebElementy
    }

    
	// login - required forms
	@FindBy(id = "i_name")
	WebElement emailLogin;

	@FindBy(id = "i_psw")
	WebElement passwordElem;
	
	//error 
	@FindBy(className = "errorBlock")
	WebElement errorTextElem;

	//btn
	//TODO
	@FindBy(id = "btnLogin")
	WebElement btnLogIn;

	/* ================================================ */
	/* 
	 * Methods will be use in Test Classes, thats why they are public
	 */
	/* ================================================ */
	
	//Load Alza.cz home page
    public void goToHomePage() {
        driver.get("https://www.alza.cz/");
    }
    
    //fill forms
    public void setEmailLogin(String email) {
        emailLogin.sendKeys(email);
    }
    
    public void setPassword(String password) {
        passwordElem.sendKeys(password);
    }
   
    public void clickLogin() {
    	btnLogIn.click();
    }
    
    public void vefifyErrorText(String errorTextString) {
    	 Assert.assertEquals(errorTextElem.getText(), errorTextString);
    }
}
