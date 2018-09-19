/*
 * Author: Ondrej Ferdan
 * 
 * Abstarct: RegistrationPage class is using Selenium Page Object Model pattern and Selenium Page Factory implementation. 
 * Fluent Interface - method chaining is used for better readability and easier understanding of code - https://martinfowler.com/bliki/FluentInterface.html 
 * 
 * Inspiration: http://www.testautomationguru.com/selenium-webdriver-how-to-design-page-objects-in-fluent-style/
 */

package com.ferdano.pagebjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;

public class LoginPage{
	WebDriver driver;
	public WebDriverWait wait;
	
	
	//constructor - passing driver instance
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// new reg elem
	@FindBy(xpath="//div[@class='link']//a[@class='reg']")
	WebElement regElem;
	
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
	
	//go to new reg page
	@Step("Go to new registration step.")
    public void goToRegPage() {
    	regElem.click();
    }
    
    //fill forms
	@Step("Fill email login form with \"{0}\" step.")
    public void setEmailLogin(String email) throws InterruptedException {
		//cleans text form, because @ remains before appended text
		emailLogin.sendKeys(Keys.CONTROL + "a");
    	emailLogin.sendKeys(Keys.DELETE); 
    	emailLogin.clear(); //not enough
        emailLogin.sendKeys(email);
    }
    
	@Step("Fill password form with: \"{0}\" step.")
    public void setPassword(String password) {
		//cleans text form, because @ remains before appended text
		emailLogin.sendKeys(Keys.CONTROL + "a");
    	passwordElem.sendKeys(Keys.DELETE);
    	passwordElem.clear(); //not enough
        passwordElem.sendKeys(password);
    }
   
	@Step("Click login step.")
    public void clickLoginButton() {
    	btnLogIn.click();
    }
    
	@Step("Verifies if error text is: \"{0}\" step.")
    public void verifyErrorText(String errorTextString) {
    	 wait = new WebDriverWait(driver,5);
    	 wait.until(ExpectedConditions.visibilityOf(errorTextElem));
    	 Assert.assertEquals(errorTextElem.getText(), errorTextString);
    }
}
