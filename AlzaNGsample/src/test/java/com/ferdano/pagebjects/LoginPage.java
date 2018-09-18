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
	@Step("Fill email login form step.")
    public void setEmailLogin(String email) throws InterruptedException {
    	emailLogin.sendKeys(Keys.DELETE); //cleans text form, because @ remains before appended text
    	emailLogin.clear(); //cleans text form, because @ remains before appended text
        emailLogin.sendKeys(email);
    }
    
	@Step("Fill passwprd form step.")
    public void setPassword(String password) {
    	passwordElem.sendKeys(Keys.DELETE); //cleans text form, because @ remains before appended text
    	passwordElem.clear(); //cleans text form, because @ remains before appended text
        passwordElem.sendKeys(password);
    }
   
	@Step("Click login step.")
    public void clickLoginButton() {
    	btnLogIn.click();
    }
    
	@Step("Verify error text step.")
    public void vefifyErrorText(String errorTextString) {
    	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("errorBlock")));
    	 wait = new WebDriverWait(driver,5);
    	 wait.until(ExpectedConditions.visibilityOf(errorTextElem));
    	 Assert.assertEquals(errorTextElem.getText(), errorTextString);
    }
}
