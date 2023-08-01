package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProdcutInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {
	
	WebDriver driver ;
	protected Properties prop;
	protected LoginPage loginPage;
	protected AccountPage accPage;
	protected SearchResultsPage searchResultPage;
	protected ProdcutInfoPage productInfoPage;
	protected RegisterPage regPage;
	DriverFactory df;

	protected SoftAssert softAssert;

	
	@BeforeTest
	public void setUp ()
	{
		df = new DriverFactory();
		prop = df.initProp();
		
		driver = df.inItDriver(prop);
		loginPage = new LoginPage(driver);
				
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
