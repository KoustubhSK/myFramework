package com.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base;
import com.pom.Homepage;
import com.pom.Loginpage;
import com.utility.Utility;

public class MainTest extends Base {

	WebDriver driver;
	Loginpage loginpage;
	Homepage homepage;

	@BeforeTest
	@Parameters("Browser")
	public void launchBrowser(String Browser ) throws InterruptedException {

		if(Browser.equals("Chrome")) {
			
		driver = Base.openChromeBrowser();
		
		}
		
		
		else if(Browser.equals("Edge")) {
			
			driver = Base.openEdgeBrowser();
		}
		
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

		Thread.sleep(2000);
	}
	
	

	@BeforeMethod
	public void verifyLoginPage() throws InterruptedException, EncryptedDocumentException, IOException {

		loginpage = new Loginpage(driver);

		String data = Utility.getdatafromexcel(0, 0);

		loginpage.clickOnUserNameTab(data);

		String data1 = Utility.getdatafromexcel(1, 0);

		loginpage.clickOnPasswordTab(data1);

		loginpage.clickOnLoginTab();

		Thread.sleep(2000);
	}

	@Test
	public void verifyBackPackTab() throws InterruptedException {

		homepage = new Homepage(driver);

		homepage.clickOnBackPackTab();

		String url = driver.getCurrentUrl();

		Assert.assertEquals("https://www.saucedemo.com/inventory-item.html?id=4", url);
		Thread.sleep(2000);
	}

	@AfterMethod
	public void verifylogoutpage(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {

			Utility.getscreenshot(driver);

		}

	}

	@AfterTest
	public void closebrowser() {
		driver.quit();
	}
}
