/*
 * Author: Ondrej Ferdan
 * 
 * Abstarct: RegistrationPage class is using Selenium Page Object Model pattern and Selenium Page Factory implementation. 
 * Fluent Interface - method chaining is used for better readability and easier understanding of code - https://martinfowler.com/bliki/FluentInterface.html 
 * 
 * Inspiration: http://www.testautomationguru.com/selenium-webdriver-how-to-design-page-objects-in-fluent-style/
 */

package com.ferdano.pagebjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage{
	WebDriver driver;
	public WebDriverWait wait;
	
	
	//constructor - passing driver instance
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
    
	// login - required forms
	@FindBy(id = "lblLogin")
	WebElement loginPage;
	
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
    
    // click login
    public void clickLoginPage() {
    	loginPage.click();
    }
    
    //fill forms
    public void setEmailLogin(String email) throws InterruptedException {
    	emailLogin.sendKeys(Keys.DELETE); //cleans text form, because @ remains before appended text
    	emailLogin.clear(); //cleans text form, because @ remains before appended text
        emailLogin.sendKeys(email);
    }
    
    public void setPassword(String password) {
    	passwordElem.sendKeys(Keys.DELETE); //cleans text form, because @ remains before appended text
    	passwordElem.clear(); //cleans text form, because @ remains before appended text
        passwordElem.sendKeys(password);
    }
   
    public void clickLoginButton() {
    	btnLogIn.click();
    }
    
    public void vefifyErrorText(String errorTextString) {
    	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("errorBlock")));
    	 wait = new WebDriverWait(driver,5);
    	 wait.until(ExpectedConditions.visibilityOf(errorTextElem));
    	 Assert.assertEquals(errorTextElem.getText(), errorTextString);
    }
}
