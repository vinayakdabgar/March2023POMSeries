package com.qa.opencart.tests;

import java.util.List;

import org.checkerframework.checker.fenum.qual.AwtColorSpace;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtils;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accSetUp()
	{
		accPage = loginPage.doLogin("janautomation@gmail.com", "Selenium@12345");
	}
	
	
	@Test
	public void accountPateTest()
	{
		String actAccPageTitle = accPage.getAccPagetitle();
		Assert.assertEquals(actAccPageTitle, AppConstant.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test
	public void isLogoutLinkExistTest()
	{
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	@Test
	public void accPageheaderCountTest()
	{
		int actAccPageHeaderCount = accPage.getAccountPageHeaderCount();
		System.out.println("Account page header count is : "+actAccPageHeaderCount );
		Assert.assertEquals(actAccPageHeaderCount, AppConstant.ACCOUNTS_PAGE_HEADER_COUNT);
	}
	
	
	@Test
	public void accPageheaderTest()
	{
		List<String> accHeaderPageList = accPage.getAccountPageHeader();
		Assert.assertEquals(accHeaderPageList, AppConstant.EXPECTED_ACC_PAGE_HEADER_LIST);
	}
	
	@DataProvider
	public Object[][] getSearchKey()
	{
		return new Object[][] {
			
			{"macbook",3},
			{"imac",1},
			{"samsung",2}
		};
	
	}
	
	
	
	@Test(dataProvider = "getSearchKey")
	public void doSearchTest(String searchKey, int prodCount)
	{
		
		searchResultPage = accPage.doSearch(searchKey);
		int actResultCount = searchResultPage.getSearchProductResultCount();
		Assert.assertEquals(actResultCount, prodCount);
	}
	
	
	

}
