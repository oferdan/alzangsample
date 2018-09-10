/*
 * Author: Ondrej Ferdan
 * 
 * Abstarct: RegistrationPage class is using Selenium Page Object Model pattern and Selenium Page Factory implementation. 
 * Fluent Interface - method chaining is used for better readability and easier understanding of code - https://martinfowler.com/bliki/FluentInterface.html 
 * 
 * Inspiration: http://www.testautomationguru.com/selenium-webdriver-how-to-design-page-objects-in-fluent-style/
 * 
 * Rika se tomu taky Chain of Invocation
 */

package com.ferdano.pagebjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPageFluent {

	WebDriver driver;

	// registration - required forms
	@FindBy(id = "edth1EmailLogin")
	WebElement emailLogin;

	@FindBy(id = "edth1Password")
	WebElement password;

	@FindBy(id = "edth1PasswordConfirm")
	WebElement passwordConfirm;

	@FindBy(id = "edth2PhonePrefix")
	WebElement phonePrefix;

	@FindBy(id = "edth2Phone")
	WebElement phone;

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

	//constructor - passing driver instance
	private RegistrationPageFluent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* ================================================ */
	/* 
	 * Methods will be use in Test Classes, thats why they are public
	 */
	/* ================================================ */
	
	//na co je tohle? to je stejny jak RegistrationPage reg = new RegistrationPage(driver) ?
	//normlani metoda s nazvem Using
	public static RegistrationPageFluent using(WebDriver driver) {
		return new RegistrationPageFluent(driver);
	}
	
	//Load Alza.cz home page
    public RegistrationPageFluent goToRegPage() {
        driver.get("https://www.alza.cz/Registration.htm");
        return this;
    }
    
    //fill forms
    public RegistrationPageFluent setEmailLogin(String email) {
        this.emailLogin.sendKeys(email);
        return this;
    }
    
    public RegistrationPageFluent setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }
    
    public RegistrationPageFluent setPasswordConfirm(String password) {
        this.passwordConfirm.sendKeys(password);
        return this;
    }
    
    public RegistrationPageFluent setPhone(String phone) {
        this.phone.sendKeys(phone);
        return this;
    }
}
