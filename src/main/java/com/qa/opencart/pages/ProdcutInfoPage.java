package com.qa.opencart.pages;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtils;

public class ProdcutInfoPage {
	
	private WebDriver driver;
	private ElementUtils eleutil;
	
	private By productHeader = By.xpath("//div[@id='content']//h1");
	private By productImages = By.xpath("//ul[@class='thumbnails']//img");
	private By quanitity = By.name("quantity");
	private By addToCartBtn = By.id("button-cart");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");


	private Map<String, String> productMap;
	
	
	public ProdcutInfoPage(WebDriver driver) {
		
		this.driver = driver;
		eleutil = new ElementUtils(driver);
		}
	
	public String getProdutHeaderValue()
	{
		return eleutil.doElementGetText(productHeader);
	}
	
	
	public int getProdutImagesCount()
	{
		int actProductImg = eleutil.waitForElementsVisible(productImages, AppConstant.MEDIUM_TIME_OUT).size();
		System.out.println("Total Product images for " +getProdutHeaderValue() +"::" +actProductImg);
		return actProductImg;
	}
	
	//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: In Stock
	private void getProductMetaData() {
		List<WebElement> metaList = eleutil.waitForElementsVisible(productMetaData, AppConstant.MEDIUM_TIME_OUT);
		//Map<String, String> metaMap = new HashMap<String, String>();
		for(WebElement e : metaList) {
			String metaText = e.getText();
			String key = metaText.split(":")[0].trim();
			String value = metaText.split(":")[1].trim();
			productMap.put(key, value);
		}
		//return metaMap;
	}
	
//	$2,000.00 //0
//	Ex Tax: $2,000.00 //1
	private void getProductPriceData() {
		List<WebElement> priceList = eleutil.waitForElementsVisible(productPriceData, AppConstant.MEDIUM_TIME_OUT);
		//Map<String, String> priceMap = new HashMap<String, String>();
		
		String actPrice = priceList.get(0).getText().trim();
		String exTax = priceList.get(1).getText().split(":")[0].trim();
		String exTaxValue = priceList.get(1).getText().split(":")[1].trim();

		productMap.put("price", actPrice);
		productMap.put(exTax, exTaxValue);
		
		//return priceMap;
	}
	
	
	public Map<String, String> getProductData() {
		//productMap = new HashMap<String, String>();
		//productMap = new LinkedHashMap<String, String>();
		productMap = new TreeMap<String, String>();

		productMap.put("productheader", getProdutHeaderValue());
		productMap.put("productImages", String.valueOf(getProdutImagesCount()));
		getProductMetaData();
		getProductPriceData();
		
		return productMap;
	}

}
