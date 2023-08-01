package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtils;

public class SearchResultsPage {
	
	private WebDriver driver;
	private ElementUtils eleutil;
	
	
	private By productResults = By.xpath("//div[contains(@class , 'product-layout')]");
		

	public SearchResultsPage(WebDriver driver) {
		
	this.driver = driver;
	eleutil = new ElementUtils(driver);
	}
	
	public int getSearchProductResultCount()
	{
		return eleutil.waitForElementsVisible(productResults, AppConstant.MEDIUM_TIME_OUT).size();
	}
	
	public ProdcutInfoPage selectProduct(String productName)
	{
		eleutil.clickElementWhenReady(By.linkText(productName), AppConstant.MEDIUM_TIME_OUT);
		return new ProdcutInfoPage(driver);
	}
	
	
	
	

}
