package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	@FindBy(id = "user-name")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement passWord;

	@FindBy(id = "login-button")
	private WebElement loginTab;

	public Loginpage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void clickOnUserNameTab(String username) {
		
		userName.sendKeys(username);

	}

	public void clickOnPasswordTab(String password) {
		
		passWord.sendKeys(password);
	}

	public void clickOnLoginTab() {
		loginTab.click();
	}

	
}
