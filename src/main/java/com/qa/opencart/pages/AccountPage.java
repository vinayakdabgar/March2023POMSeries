package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtils;

public class AccountPage {

	
	private WebDriver driver;
	private ElementUtils eleUtil;
	
	private By logoutLink = By.xpath("//a[text()='Logout']");
	private By accHeader = By.xpath("//div[@id='content']/h2");
	private By search = By.name("search");
	private By SearchIcon = By.xpath("//div[@id='search']//button[@type='button']");
	
	
	
	public AccountPage(WebDriver driver)
	{
		this.driver = driver ;
		eleUtil = new ElementUtils(driver);
		
	}
	
	
	public String getAccPagetitle()
	{
		return eleUtil.waitForTitleIs(AppConstant.ACCOUNTS_PAGE_TITLE, AppConstant.SHORT_TIME_OUT);
	}

	
	public boolean isLogoutLinkExist()
	{
		return eleUtil.waitForElementPresence(logoutLink, AppConstant.MEDIUM_TIME_OUT).isDisplayed();
	}
	
	public List<String> getAccountPageHeader()
	{
		List<WebElement> headerList = eleUtil.waitForElementsPresence(accHeader, AppConstant.MEDIUM_TIME_OUT);
		List<String> headerValuesList = new ArrayList<String>();
		
		
		for (WebElement e :headerList )
		{
			String header = e.getText();
			headerValuesList.add(header);
		}return headerValuesList;
	}
	
	public int getAccountPageHeaderCount()
	{
		return eleUtil.waitForElementsPresence(accHeader, AppConstant.MEDIUM_TIME_OUT).size();
		 
	}
	
	public SearchResultsPage doSearch(String SerchKey)
	{
		WebElement searchField = eleUtil.waitForElementVisible(search, AppConstant.MEDIUM_TIME_OUT);
		searchField.clear();
		searchField.sendKeys(SerchKey);
		eleUtil.doClick(SearchIcon);
		return new SearchResultsPage(driver);
	}
}
