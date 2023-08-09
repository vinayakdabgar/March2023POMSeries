package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtils;

public class LoginPage {
	
	private WebDriver driver ;
	private ElementUtils eleUtil;
	
	
	// 1. Private By Locators 
	
	private By emailID = By.id("input-email");
	private By passwrd = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By loginLink = By.linkText("Login");
	private By home = By.linkText("Home1");



	// 2. Public Constructor
	
	 public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtils(driver);
		
	}
	
	//3. Public Functions/Methods
	

	public String getLoginPageTitle()
	{
		
		String title = eleUtil.waitForTitleContains(AppConstant.LOGIN_PAGE_TITLE, AppConstant.SHORT_TIME_OUT);
		System.out.println("Login page title is " + title);
		return title;
		
	}
	
	
	public String getLoginPageUrl()
	{
		
		String url = eleUtil.waitForURLContains(AppConstant.LOGIN_PAGE_URL_FRACTION, AppConstant.SHORT_TIME_OUT);
		System.out.println("Login page title is " + url);
		return url;
		
	}
	
	public boolean isForgotPwdLinkExist()
	{
		return eleUtil.waitForElementVisible(forgotPwdLink, AppConstant.MEDIUM_TIME_OUT).isDisplayed();

	}
	
	
	public AccountPage doLogin(String userName , String password)
	{
		System.out.println("Login page cred is as : "+userName +" " + password);
		eleUtil.waitForElementVisible(emailID, AppConstant.MEDIUM_TIME_OUT).sendKeys(userName);
		eleUtil.doSendKeys(passwrd, password);
		eleUtil.doClick(loginBtn);
		//return eleUtil.waitForTitleIs(AppConstant.ACCOUNTS_PAGE_TITLE, AppConstant.SHORT_TIME_OUT);
		return new AccountPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		eleUtil.waitForElementVisible(registerLink, AppConstant.SHORT_TIME_OUT).click();
		return new RegisterPage(driver);
	}
	
	

}
