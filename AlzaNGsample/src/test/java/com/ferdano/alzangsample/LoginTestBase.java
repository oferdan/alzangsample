package com.ferdano.alzangsample;

import org.testng.annotations.Test;

import com.ferdano.pagebjects.LoginPageBase;

public class LoginTestBase extends BaseTest {
	
	
	@Test
	public void validLoginTest() {
		//page instance
		LoginPageBase loginPage = new LoginPageBase(driver,wait);
		
		loginPage.goToHomePage();
		loginPage.setEmailLogin("oferdantest@gmail.com");
		loginPage.setPassword("ondrajepan");
	}
	
	@Test
	public void invalidUsernameTest() {
		//page instance
		LoginPageBase loginPage = new LoginPageBase(driver,wait);
		
		loginPage.goToHomePage();
		loginPage.setEmailLogin("oferdantest@gmail.com");
		loginPage.setPassword("ondrajepan");
		loginPage.vefifyErrorText("Wrong username.");
		loginPage.clickLogin();
	}
}
