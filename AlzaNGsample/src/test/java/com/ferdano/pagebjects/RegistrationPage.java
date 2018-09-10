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

public class RegistrationPage {

	WebDriver driver;
	
	//constructor - passing driver instance
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// registration - required forms
	@FindBy(id = "edth1EmailLogin")
	WebElement emailLogin;

	@FindBy(id = "edth1Password")
	WebElement passwordElem;

	@FindBy(id = "edth1PasswordConfirm")
	WebElement passwordConfirm;

	@FindBy(id = "edth2PhonePrefix")
	WebElement phonePrefix;

	@FindBy(id = "edth2Phone")
	WebElement phoneElem;

	// billing - optional
	@FindBy(id = "edth2Name")
	WebElement billName;

	@FindBy(id = "edth2Street")
	WebElement billStreet;

	@FindBy(id = "edth2City")
	WebElement billCity;

	@FindBy(id = "edth2Zip")
	WebElement billZip;

	// delivery - optional
	@FindBy(id = "edth4Name")
	WebElement deliveryName;

	@FindBy(id = "edth4Firm")
	WebElement deliveryCompany;

	@FindBy(id = "edth4Street")
	WebElement deliveryStreet;

	@FindBy(id = "edth4City")
	WebElement deliveryCity;

	@FindBy(id = "edth4Zip")
	WebElement deliveryZip;

	@FindBy(id = "edth4Note")
	WebElement deliveryNote;

	@FindBy(id = "edth43PhonePrefix")
	WebElement deliveryPhonePrefix;

	@FindBy(id = "edth43Phone")
	WebElement deliveryPhone;

	// corporate - optional
	@FindBy(id = "edth3Ico")
	WebElement corporateIco;

	@FindBy(id = "edth3Dic")
	WebElement corporateDic;

	@FindBy(id = "edth3BankAccount")
	WebElement deliveryBankAccount;

	@FindBy(id = "edth3BankCode")
	WebElement deliveryBankCode;

	@FindBy(id = "edth3SpecificSymbol")
	WebElement deliverySpecificSymbol;

	// student
	@FindBy(id = "lblIsicName")
	WebElement studentIsicName;

	@FindBy(id = "edtIsic")
	WebElement studentIsicNumber;
	
	//TODO
	@FindBy(xpath = "TODO")
	WebElement btnVerifyisic;
	
	//btn
	//TODO
	@FindBy(xpath = "TODO")
	WebElement btnNext;


	/* ================================================ */
	/* 
	 * Methods will be use in Test Classes, thats why they are public
	 */
	/* ================================================ */
	
	//Load Alza.cz home page
    public void goToRegPage() {
        driver.get("https://www.alza.cz/Registration.htm");
    }
    
    //fill forms
    public void setEmailLogin(String email) {
        emailLogin.sendKeys(email);
    }
    
    public void setPassword(String password) {
        passwordElem.sendKeys(password);
    }
    
    public void setPasswordConfirm(String password) {
        passwordConfirm.sendKeys(password);
    }
    
    public void setPhone(String phone) {
        phoneElem.sendKeys(phone);
    }
    
    public void clickNext() {
    	btnNext.click();
    }
}
