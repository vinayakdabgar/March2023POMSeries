package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoTest extends BaseTest {

	@BeforeClass
	public void prodInfoSetup()
	{
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] productTestData()
	{
		return new Object[][] {
			
			{"macbook","MacBook Air"},
			{"macbook","MacBook Pro"},
			{"iMac","iMac"},
			{"samsung","Samsung SyncMaster 941BW"},
			{"samsung","Samsung Galaxy Tab 10.1"}

		};
	
	}
	
	@DataProvider
	public Object[][] productData()
	{
		return new Object[][] {
			
			{"macbook","MacBook Air", 4},
			{"macbook","MacBook Pro", 4},
			{"iMac","iMac",3},
			{"samsung","Samsung SyncMaster 941BW",1},
			{"samsung","Samsung Galaxy Tab 10.1",7}

		};
	
	}
	
	@Test (dataProvider = "productTestData")
	public void productHeaderTest(String searchKey, String productName)
	{
		searchResultPage = accPage.doSearch(searchKey);
		productInfoPage = searchResultPage.selectProduct(productName);
		String actProductHeader = productInfoPage.getProdutHeaderValue();
		Assert.assertEquals(actProductHeader, productName);
	}
	
	
	@Test (dataProvider = "productData")
	public void productImageCountTest(String searchkey , String productName , int expProductImageCount)
	{
		searchResultPage = accPage.doSearch(searchkey);
		productInfoPage = searchResultPage.selectProduct(productName);
		int actProductImgCount = productInfoPage.getProdutImagesCount();
		Assert.assertEquals(actProductImgCount, expProductImageCount);
	}
	
	//AAA
	@Test
	public void productInfoTest() {
		searchResultPage = accPage.doSearch("macbook");
		productInfoPage = searchResultPage.selectProduct("MacBook Pro");
		Map<String, String> productActualData = productInfoPage.getProductData();
		System.out.println(productActualData);
		softAssert.assertEquals(productActualData.get("Brand"), "Apple");
		softAssert.assertEquals(productActualData.get("Availability"), "In Stock");
		softAssert.assertEquals(productActualData.get("productheader"), "MacBook Pro");
		softAssert.assertEquals(productActualData.get("price"), "$2,000.00");
		softAssert.assertEquals(productActualData.get("Reward Points"), "800");
		softAssert.assertAll();
	}
	
}
