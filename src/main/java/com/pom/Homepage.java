package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	@FindBy(xpath="(//div[@class='inventory_item_name'])[1]")
	private WebElement backPack;
	
	
	
	
	public Homepage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}
	
	

	public void clickOnBackPackTab() {

		backPack.click();
	}
	
	


}
